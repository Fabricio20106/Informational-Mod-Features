package com.sophicreeper.backmath.mixin.packet;

import com.sophicreeper.backmath.util.tag.BMItemTags;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketThreadUtil;
import net.minecraft.network.play.IServerPlayNetHandler;
import net.minecraft.network.play.ServerPlayNetHandler;
import net.minecraft.network.play.client.CUseEntityPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ForgeMod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(ServerPlayNetHandler.class)
public abstract class BMServerPlayNetHandlerMixin implements IServerPlayNetHandler {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    public ServerPlayerEntity player;
    @Shadow
    public abstract void disconnect(ITextComponent message);

    @Inject(method = "handleInteract", at = @At("HEAD"), cancellable = true)
    public void handleInteract(CUseEntityPacket packet, CallbackInfo ci) {
        ci.cancel();
        PacketThreadUtil.ensureRunningOnSameThread(packet, this, this.player.getLevel());
        ServerWorld world = this.player.getLevel();
        Entity target = packet.getTarget(world);
        this.player.resetLastActionTime();
        this.player.setShiftKeyDown(packet.isUsingSecondaryAction());
        if (target != null) {
            boolean extendedReach = this.player != null && packet.getHand() != null && this.player.getItemInHand(packet.getHand()).getItem().is(BMItemTags.EXTENDED_ENTITY_REACH);
            double maxDistance = 36 - this.player.getAttribute(ForgeMod.REACH_DISTANCE.get()).getValue() - (extendedReach ? 5 : 0);

            LogManager.getLogger().debug("distance to target: {}, max distance: {}", this.player.distanceToSqr(target), maxDistance);
            if (this.player.distanceToSqr(target) < maxDistance) {
                Hand hand = packet.getHand();
                ItemStack handStack = hand != null ? this.player.getItemInHand(hand).copy() : ItemStack.EMPTY;
                Optional<ActionResultType> result = Optional.empty();

                if (packet.getAction() == CUseEntityPacket.Action.INTERACT) {
                    result = Optional.of(this.player.interactOn(target, hand));
                } else if (packet.getAction() == CUseEntityPacket.Action.INTERACT_AT) {
                    if (ForgeHooks.onInteractEntityAt(this.player, target, packet.getLocation(), hand) != null) return;
                    result = Optional.of(target.interactAt(this.player, packet.getLocation(), hand));
                } else if (packet.getAction() == CUseEntityPacket.Action.ATTACK) {
                    if (target instanceof ItemEntity || target instanceof ExperienceOrbEntity || target instanceof AbstractArrowEntity || target == this.player) {
                        this.disconnect(new TranslationTextComponent("multiplayer.disconnect.invalid_entity_attacked"));
                        LOGGER.warn("Player {} tried to attack an invalid entity", this.player.getName().getString());
                        return;
                    }

                    this.player.attack(target);
                }

                if (result.isPresent() && result.get().consumesAction()) {
                    CriteriaTriggers.PLAYER_INTERACTED_WITH_ENTITY.trigger(this.player, handStack, target);
                    if (result.get().shouldSwing()) this.player.swing(hand, true);
                }
            }
        }
    }
}
