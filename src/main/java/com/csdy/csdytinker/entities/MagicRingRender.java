package com.csdy.csdytinker.entities;

import com.csdy.csdytinker.CsdyTinker;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

@Mod.EventBusSubscriber(modid = CsdyTinker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MagicRingRender extends GeoProjectilesRenderer<MagicRing> {
    protected MagicRingRender(EntityRendererProvider.Context p_174008_) {
        super(p_174008_, new MagicRingModel());
    }

    @Override
    public ResourceLocation getTextureLocation(MagicRing magicRing) {
        return new ResourceLocation(CsdyTinker.MOD_ID, "textures/entity/master_spark.png");
    }

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        //添加渲染注册语句
        event.registerEntityRenderer(EntitiesRegister.MAGIC_RING.get(), MagicRingRender::new);
    }
}
