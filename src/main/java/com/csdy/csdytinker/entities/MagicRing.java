package com.csdy.csdytinker.entities;

import com.ibm.icu.text.CaseMap;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.server.commands.TitleCommand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
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

public class MagicRing extends Entity implements IAnimatable {

    public MagicRing(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Nullable
    @Getter
    @Setter
    private Entity from = null;

    @Override
    public void tick() {
        if (getLevel().isClientSide) clientTick();
        else serverTick();
    }

    private void clientTick() {

    }

    private void serverTick() {

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

    @Override
    public boolean touchingUnloadedChunk() {
        return false;
    }

    //IAnimatable

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        //AnimationBuilder animation = new AnimationBuilder();
        //↑重写记得
        //event.getController().setAnimation(animation);
        return PlayState.CONTINUE;
    }

    private final AnimationFactory animationFactory = GeckoLibUtil.createFactory(this);

    @Override
    public void registerControllers(AnimationData data) {
        AnimationController<MagicRing> controller = new AnimationController<>(this, "controller", 0, this::predicate);
        data.addAnimationController(controller);
    }

    @Override
    public AnimationFactory getFactory() {
        return animationFactory;
    }
}
