# Code Snippets
## `MidTermLongsword` (Back Math)
```java
@Override
public void fillItemCategory(ItemGroup tab, NonNullList<ItemStack> list) {
    ItemStack stack = new ItemStack(this);
    CompoundNBT tag = stack.getOrCreateTag();

    ListNBT attributeList = tag.getList("attributes", TagTypes.LIST);
    for (Attribute attribute : this.attributeModifiers.keySet()) {
        Collection<AttributeModifier> modifiers = this.attributeModifiers.get(attribute);
        for (AttributeModifier modifier : modifiers) attributeList.add(modifier.save());
    }
    tag.put("attributes", attributeList);
    list.add(stack);
}
```

## `BMRegistries` (Back Math)
```java
public static final RegistryKey<Registry<WandererSophieVariant>> WANDERER_SOPHIE_VARIANT = RegistryKey.createRegistryKey(BackMath.resourceLoc("wanderer_sophie_variant"));
```

## `BMConfiguredFeatures` (Back Math)
```java
public static final Feature<BlockStateProvidingFeatureConfig> ALJANSTONE_BOULDER_F = register("aljanstone_boulder", new BMBlockBlobFeature(BlockStateProvidingFeatureConfig.field_236453_a_));

// Aljan Boulders
public static final ConfiguredFeature<?, ?> ALJANSTONE_BOULDER = register("aljanstone_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(
    BMBlocks.ALJANSTONE.get().getDefaultState()))).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(3);

public static final ConfiguredFeature<?, ?> COBBLED_ALJANSTONE_BOULDER = register("cobbled_aljanstone_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(
    BMBlocks.COBBLED_ALJANSTONE.get().getDefaultState()))).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(3);

public static final ConfiguredFeature<?, ?> ALJANSTONE_BOULDER = register("aljanstone_boulder", BMFeatureRegister.ALJANSTONE_BOULDER.get().withConfiguration(new BlockStateProvidingFeatureConfig(
    new WeightedBlockStateProvider().addWeightedBlockstate(BMBlocks.ALJANSTONE.get().getDefaultState(), 7).addWeightedBlockstate(BMBlocks.COBBLED_ALJANSTONE.get()
        .getDefaultState(), 4))).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(3));

public static final ConfiguredFeature<?, ?> SLEEPINGSTONE_BOULDER = register("sleepingstone_boulder", Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(
    BMBlocks.SLEEPINGSTONE.get().getDefaultState()))).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(3);
```

## `JanticOreBlock` (Back Math)
```java
@Override
public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
    if (!world.isRemote && !player.isCreative()) {
        Janticle janticle = new Janticle(world);
        world.addEntity(janticle);
    }
    super.onBlockHarvested(world, pos, state, player);
}
```

## `CrystallizerBlock` (Back Math)
```java
// Crystallizer Recipe code; will probably be turned into RecipeType later.
private ActionResultType makeCrystallizerRecipe(@Nonnull ItemStack mainHandStack, ItemStack offHandStack, ItemStack result, SoundEvent successSound, World world, BlockPos pos, @Nonnull PlayerEntity player) {
    ItemStack mainHand = player.getHeldItem(Hand.MAIN_HAND);
    ItemStack offHand = player.getHeldItem(Hand.OFF_HAND);

    if (!mainHandStack.getItem().isIn(BMTags.Items.CANNOT_USE_AT_CRYSTALLIZER)) {
        if (mainHand == mainHandStack && offHandStack == null) {
            world.playSound(null, pos, successSound, SoundCategory.BLOCKS, 1, 1);
            player.addItemStackToInventory(result);
            mainHand.shrink(1);
            player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            return ActionResultType.SUCCESS;
        } else if (mainHand == mainHandStack && offHand == offHandStack) {
            world.playSound(null, pos, successSound, SoundCategory.BLOCKS, 1, 1);
            player.addItemStackToInventory(result);
            mainHand.shrink(1);
            offHand.shrink(1);
            player.addStat(BMStats.CRAFT_IN_CRYSTALLIZER);
            player.addStat(Stats.ITEM_USED.get(mainHand.getItem()));
            player.addStat(Stats.ITEM_USED.get(offHand.getItem()));
            return ActionResultType.SUCCESS;
        } else {
            world.playSound(null, pos, BMSounds.BLOCK_CRYSTALLIZER_FAIL_CRAFT, SoundCategory.BLOCKS, 1, 1);
            return ActionResultType.FAIL;
        }
    }
    return ActionResultType.FAIL;
}
```

## `MidTermArmorItem` (Back Math)
```java
// For testing purposes, I don't know if the method above works or not yet.
@Override
public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
    LivingEntity livEntity = (LivingEntity) entity;
    stack.damageItem(1, livEntity, livEntity1 -> livEntity1.sendBreakAnimation(EquipmentSlotType.MAINHAND));
    super.inventoryTick(stack, world, entity, slot, selected);
}
```

## `BMStructures` (Back Math)
```java
public static final RegistryObject<Structure<AljanMineshaftConfig>> ALJAN_MINESHAFT = STRUCTURES.register("aljan_mineshaft", AljanMineshaftStructure::new);

setupMapSpacingAndLand(ALJAN_MINESHAFT.get(), new StructureSeparationSettings(20, 15, 882848482), false);

if (Objects.equals(ALJAN_WOODS.get().getRegistryName(), event.getName()) || Objects.equals(ALJAMIC_HIGHLANDS.get().getRegistryName(), event.getName())) {
    event.getGeneration().withStructure(BMStructureFeatures.ALJANWOOD_MINESHAFT);
}
```

## `FabricioHideoutDungeonStructure` (Back Math)
```java
// From structure code.
LogManager.getLogger().log(Level.DEBUG, "Back Math: Fabricio's Hideout Dungeon located at: /tp @s " +
    this.components.get(0).getBoundingBox().minX + " " +
    this.components.get(0).getBoundingBox().minY + " " +
    this.components.get(0).getBoundingBox().minZ);
```

## `AxolotlTest` (Back Math)
```java
public static final RegistryObject<Item> GOLDEN_PLATED = ITEMS.register("peitoraldeouro", () -> new Item(new Item.Properties().group(BMWeaponryTab.TAB)));
```

## `BMEvents` (Back Math)
```java
LOGGER.warn("Back Math: Did not find the expected vanilla baked model(s) for insomnian_tulip in registry");
LogManager.getLogger().error("Back Math: Was unable to check if " + serverWorld.getDimensionKey().getLocation() + " is using Terraforged's ChunkGenerator.");
```

## `ToddyItem` (Back Math)
```java
// Why does a Toddy need a fluid bucket wrapper? - June 12/04/24
@Override
public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT tag) {
    return new FluidBucketWrapper(stack);
}
```

## Part of `data/backmath/loot_tables/blocks/jabuticaba_leaves.json` (Back Math)
```json
{
  "type": "minecraft:item",
  "conditions": [
    {
      "condition": "minecraft:survives_explosion"
    },
    {
      "condition": "minecraft:table_bonus",
      "enchantment": "minecraft:fortune",
      "chances": [
        0.05,
        0.0625,
        0.083333336,
        0.1
      ]
    }
  ],
  "name": "backmath:jabuticaba_sapling"
}
```