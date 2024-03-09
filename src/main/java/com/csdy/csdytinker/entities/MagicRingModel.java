package com.csdy.csdytinker.entities;

import com.csdy.csdytinker.CsdyTinker;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MagicRingModel extends AnimatedGeoModel<MagicRing> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(CsdyTinker.MOD_ID, "magic_ring"), "main");
    private static final ResourceLocation MODEL_RES = new ResourceLocation(CsdyTinker.MOD_ID, "geo/magic_ring.geo.json");
    private static final ResourceLocation TEX_RES = new ResourceLocation(CsdyTinker.MOD_ID, "textures/entity/master_spark.png");
    private static final ResourceLocation ANI_RES = new ResourceLocation(CsdyTinker.MOD_ID, "animations/master_spark.animation.json");

    @Override
    public ResourceLocation getModelLocation(MagicRing magicRing) {
        return MODEL_RES;
    }

    @Override
    public ResourceLocation getTextureLocation(MagicRing magicRing) {
        return TEX_RES;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(MagicRing magicRing) {
        return ANI_RES;
    }

}
