package com.sophicreeper.backmath.world.structure.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.sophicreeper.backmath.world.structure.custom.AljanMineshaftStructure;
import net.minecraft.world.gen.feature.IFeatureConfig;

public class AljanMineshaftConfig implements IFeatureConfig {
    public static final Codec<AljanMineshaftConfig> CODEC = RecordCodecBuilder.create((configInstance) ->
            configInstance.group(Codec.floatRange(0, 1).fieldOf("probability").forGetter((config) -> config.probability), AljanMineshaftStructure.MineshaftType.CODEC.fieldOf("type").forGetter((config) ->
                    config.type)).apply(configInstance, AljanMineshaftConfig::new));
    public final float probability;
    public final AljanMineshaftStructure.MineshaftType type;

    public AljanMineshaftConfig(float probability, AljanMineshaftStructure.MineshaftType type) {
        this.probability = probability;
        this.type = type;
    }
}
