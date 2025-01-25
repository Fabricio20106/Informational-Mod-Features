package com.sophicreeper.backmath.world;

import com.sophicreeper.backmath.BackMath;
import com.sophicreeper.backmath.world.structure.BMStructures;
import com.sophicreeper.backmath.world.structure.config.AljanMineshaftConfig;
import com.sophicreeper.backmath.world.structure.custom.AljanMineshaftStructure.MineshaftType;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;

public class BMStructureFeatures {
    public static final StructureFeature<AljanMineshaftConfig, ? extends Structure<AljanMineshaftConfig>> ALJANWOOD_MINESHAFT = register("aljanwood_mineshaft", BMStructures.ALJAN_MINESHAFT.get().withConfiguration(
            new AljanMineshaftConfig(0.004F, MineshaftType.ALJANWOOD)));
    public static final StructureFeature<AljanMineshaftConfig, ? extends Structure<AljanMineshaftConfig>> ALJANCAP_MINESHAFT = register("aljancap_mineshaft", BMStructures.ALJAN_MINESHAFT.get().withConfiguration(
            new AljanMineshaftConfig(0.004F, MineshaftType.ALJANCAP)));
    public static final StructureFeature<AljanMineshaftConfig, ? extends Structure<AljanMineshaftConfig>> INSOMNIAN_MINESHAFT = register("insomnian_mineshaft", BMStructures.ALJAN_MINESHAFT.get().withConfiguration(
            new AljanMineshaftConfig(0.004F, MineshaftType.INSOMNIAN)));
    public static final StructureFeature<AljanMineshaftConfig, ? extends Structure<AljanMineshaftConfig>> AVONDALIC_WILLOW_MINESHAFT = register("avondalic_willow_mineshaft", BMStructures.ALJAN_MINESHAFT.get().withConfiguration(
            new AljanMineshaftConfig(0.004F, MineshaftType.AVONDALIC_WILLOW)));

    private static <FC extends IFeatureConfig, F extends Structure<FC>> StructureFeature<FC, F> register(String name, StructureFeature<FC, F> structure) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE, BackMath.resourceLoc(name), structure);
    }
}
