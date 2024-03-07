package com.csdy.csdytinker.entities;

import com.csdy.csdytinker.CsdyTinker;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.manager.InstancedAnimationFactory;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = CsdyTinker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MasterSpark extends Entity implements IAnimatable {
    public MasterSpark(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    public @NotNull Packet<?> getAddEntityPacket() {
        return null;
    }


    //IAnimatable
    private final AnimationFactory animationFactory = new InstancedAnimationFactory(this);

    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return animationFactory;
    }

    //Event
    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        //添加渲染注册语句
        event.registerEntityRenderer(EntitiesRegister.MASTER_SPARK.get(), MasterSparkRender::new);
    }
}
