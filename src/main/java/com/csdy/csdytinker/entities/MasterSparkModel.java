package com.csdy.csdytinker.entities;

import com.csdy.csdytinker.CsdyTinker;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MasterSparkModel extends AnimatedGeoModel<MasterSpark> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(CsdyTinker.MOD_ID, "master_spark"), "main");
    private static final ResourceLocation MODEL_RES = new ResourceLocation(CsdyTinker.MOD_ID, "geo/master_spark.geo.json");
    private static final ResourceLocation TEX_RES = new ResourceLocation(CsdyTinker.MOD_ID, "textures/entity/master_spark.png");
    private static final ResourceLocation ANI_RES = new ResourceLocation(CsdyTinker.MOD_ID, "animations/master_spark.animation.json");

    @Override
    public ResourceLocation getModelLocation(MasterSpark masterSpark) {
        return MODEL_RES;
    }

    @Override
    public ResourceLocation getTextureLocation(MasterSpark masterSpark) {
        return TEX_RES;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MasterSpark masterSpark) {
        return ANI_RES;
    }
}
