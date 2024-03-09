package com.csdy.csdytinker.entities;

import com.csdy.csdytinker.FlexibleDamageSource;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.util.ArrayList;
import java.util.List;

public class MasterSpark extends Entity implements IAnimatable {

    public MasterSpark(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    private static final int ATK = 50000;

    @Nullable
    @Getter
    @Setter
    private Entity target = null;
    @Nullable
    @Getter
    @Setter
    private Entity from = null;

    private final List<Entity> hurtEntities = new ArrayList<>();

    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(MasterSpark.class, EntityDataSerializers.INT);

    @Override
    public void tick() {
        super.tick();
        if (getLevel().isClientSide) clientTick();
        else serverTick();
    }

    private void serverTick() {
        switch (this.tickCount) {
            case 40:
            case 100:
                var state = entityData.get(STATE);
                entityData.set(STATE, state + 1);
                break;
            case 48:
                getBoundingBox().deflate(1, 0, 1);
                break;
        }
        switch (entityData.get(STATE)) {
            case 0:
                if (target != null && target.getLevel() == this.level)
                    this.setPos(target.position());
                break;
            case 1:
                shotTick();
                break;
            case 2:
                this.discard();
                break;
        }
    }

    private void clientTick() {

    }

    private void shotTick() {
        var entities = getLevel().getEntities(this, getBoundingBox());
        for (var entity : entities) {
            if (!hurtEntities.contains(entity)) {
                hurtEntities.add(entity);
                DamageSource damageSource = new FlexibleDamageSource("master_spark", this.from).bypassArmor().bypassInvul().bypassMagic();
                entity.hurt(damageSource, ATK);
            }
        }
        var blocks = BlockPos.betweenClosedStream(this.getBoundingBox());
        blocks.forEach((block) -> level.setBlockAndUpdate(block, Blocks.AIR.defaultBlockState()));
    }

    //Entity
    @Override
    protected void defineSynchedData() {
        this.entityData.define(STATE, 0);
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
    protected static final AnimationBuilder ANIM_PRESHOT = new AnimationBuilder().addAnimation("animation.spark.preshot");
    protected static final AnimationBuilder ANIM_SHOT = new AnimationBuilder().addAnimation("animation.spark.shot");
    protected static final AnimationBuilder ANIM_IDLE = new AnimationBuilder().addAnimation("animation.spark.idle");

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        AnimationBuilder animation = switch (entityData.get(STATE)) {
            case 0 -> ANIM_PRESHOT;
            case 1 -> ANIM_SHOT;
            default -> ANIM_IDLE;
        };
        event.getController().setAnimation(animation);
        return PlayState.CONTINUE;
    }

    private final AnimationFactory animationFactory = GeckoLibUtil.createFactory(this);

    @Override
    public void registerControllers(AnimationData data) {
//        ICustomInstructionListener<MasterSpark> listener = (event) -> {
//            int s = entityData.get(STATE);
//            this.entityData.set(STATE, s + 1);
//        };
        AnimationController<MasterSpark> controller = new AnimationController<>(this, "controller", 0, this::predicate);
//        controller.registerCustomInstructionListener(listener);
        data.addAnimationController(controller);

    }

    @Override
    public AnimationFactory getFactory() {
        return animationFactory;
    }
}
