package com.sophicreeper.backmath.world.structure.custom;

import com.mojang.serialization.Codec;
import com.sophicreeper.backmath.world.structure.config.AljanMineshaftConfig;
import com.sophicreeper.backmath.world.structure.piece.AljanMineshaftPieces;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class AljanMineshaftStructure extends Structure<AljanMineshaftConfig> {
    public AljanMineshaftStructure() {
        super(AljanMineshaftConfig.CODEC);
    }

    protected boolean func_230363_a_(ChunkGenerator generator, BiomeProvider provider, long seed, SharedSeedRandom chunkRand, int chunkX, int chunkZ, Biome biome, ChunkPos chunkPos, AljanMineshaftConfig config) {
        chunkRand.setLargeFeatureSeed(seed, chunkX, chunkZ);
        return chunkRand.nextDouble() < config.probability;
    }

    @Override
    public IStartFactory<AljanMineshaftConfig> getStartFactory() {
        return AljanMineshaftStructure.Start::new;
    }

    public static class Start extends StructureStart<AljanMineshaftConfig> {
        public Start(Structure<AljanMineshaftConfig> structure, int chunkX, int chunkZ, MutableBoundingBox boundingBox, int reference, long seed) {
            super(structure, chunkX, chunkZ, boundingBox, reference, seed);
        }

        public void func_230364_a_(DynamicRegistries registryManager, ChunkGenerator generator, TemplateManager tempManager, int chunkX, int chunkZ, Biome biome, AljanMineshaftConfig config) {
            AljanMineshaftPieces.Room piecesRoom = new AljanMineshaftPieces.Room(0, this.rand, (chunkX << 4) + 2, (chunkZ << 4) + 2, config.type);
            this.components.add(piecesRoom);
            piecesRoom.buildComponent(piecesRoom, this.components, this.rand);
            this.recalculateStructureSize();
            this.func_214628_a(generator.getSeaLevel(), this.rand, 10);
        }
    }

    public enum MineshaftType implements IStringSerializable {
        ALJANWOOD("aljanwood"),
        ALJANCAP("aljancap"),
        INSOMNIAN("insomnian"),
        AVONDALIC_WILLOW("avondalic_willow");

        public static final Codec<MineshaftType> CODEC = IStringSerializable.createEnumCodec(MineshaftType::values, MineshaftType::byName);
        private static final Map<String, MineshaftType> BY_NAME = Arrays.stream(values()).collect(Collectors.toMap(MineshaftType::getName, (type) -> type));
        private final String name;

        MineshaftType(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        private static MineshaftType byName(String type) {
            return BY_NAME.get(type);
        }

        public static MineshaftType byId(int id) {
            return id >= 0 && id < values().length ? values() [id] : ALJANWOOD;
        }

        @Override
        public String getString() {
            return this.name;
        }
    }
}
