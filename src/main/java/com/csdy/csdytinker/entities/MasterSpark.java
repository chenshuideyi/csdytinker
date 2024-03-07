package com.csdy.csdytinker.entities;

import com.csdy.csdytinker.CsdyTinker;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.manager.InstancedAnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = CsdyTinker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MasterSpark extends Entity implements IAnimatable {
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public MasterSpark(EntityType<?> entityType, Level level) {
        super(entityType, level);
        executor.schedule(this::nextStage, 1, TimeUnit.SECONDS);
    }

    //魔炮
    private static final int ATK = 50000;
    private int stage = 0;
    @Nullable
    @Getter
    @Setter
    private LivingEntity target = null;

    private void nextStage() {
        stage++;
        executor.schedule(this::nextStage, 2, TimeUnit.SECONDS);
    }

    @Override
    public void tick() {
        if (stage > 2) this.kill();
        super.tick();
    }

    //Entity
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
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    //IAnimatable
    protected static final AnimationBuilder ANIM_READY = new AnimationBuilder().addAnimation("Ready");
    protected static final AnimationBuilder ANIM_SHOT = new AnimationBuilder().addAnimation("Shot");
    protected static final AnimationBuilder ANIM_FINISH = new AnimationBuilder().addAnimation("Finish");
    protected static final AnimationBuilder ANIM_STATIC = new AnimationBuilder().addAnimation("Static");

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        AnimationBuilder animation = switch (this.stage) {
            case 0 -> ANIM_READY;
            case 1 -> ANIM_SHOT;
            case 2 -> ANIM_FINISH;
            default -> ANIM_STATIC;
        };
        event.getController().setAnimation(animation);
        return PlayState.CONTINUE;
    }

    private final AnimationFactory animationFactory = GeckoLibUtil.createFactory(this);

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
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
