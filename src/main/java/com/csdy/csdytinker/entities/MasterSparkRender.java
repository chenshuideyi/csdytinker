package com.csdy.csdytinker.entities;

import com.csdy.csdytinker.CsdyTinker;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;
import software.bernie.geckolib3.renderers.geo.GeoReplacedEntityRenderer;

public class MasterSparkRender extends GeoProjectilesRenderer<MasterSpark> {
    protected MasterSparkRender(EntityRendererProvider.Context p_174008_) {
        super(p_174008_, new MasterSparkModel());
    }

    @Override
    public ResourceLocation getTextureLocation(MasterSpark masterSpark) {
        return new ResourceLocation(CsdyTinker.MOD_ID, "textures/entity/master_spark.png");
    }
}
