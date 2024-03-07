package com.csdy.csdytinker.entities;

import com.csdy.csdytinker.CsdyTinker;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MasterSparkModel extends AnimatedGeoModel<MasterSpark> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(CsdyTinker.MOD_ID, "master_spark"), "main");
    @Override
    public ResourceLocation getModelLocation(MasterSpark masterSpark) {
        return new ResourceLocation(CsdyTinker.MOD_ID, "geo/master_spark.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(MasterSpark masterSpark) {
        return new ResourceLocation(CsdyTinker.MOD_ID, "textures/entity/master_spark.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MasterSpark masterSpark) {
        return new ResourceLocation(CsdyTinker.MOD_ID, "animations/master_spark.animation.json");
    }
}
