package com.csdy.csdytinker.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.stats.StatsCounter;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.stats.StatsCounter;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DeathPlayer extends LocalPlayer {
    public DeathPlayer(Minecraft p_108621_, ClientLevel p_108622_, ClientPacketListener p_108623_, StatsCounter p_108624_, ClientRecipeBook p_108625_, boolean p_108626_, boolean p_108627_) {
        super(p_108621_, p_108622_, p_108623_, p_108624_, p_108625_, p_108626_, p_108627_);
    }

    @Override
    public float getHealth() {
        if(DieEntity.hasPlayer(this)){
            return 0;
        }else {
            return 0;
        }
    }

    @Override
    public void die(DamageSource p_36152_) {
        if(DieEntity.hasPlayer(this)) {
            super.die(p_36152_);
        }
    }

    @Override
    public boolean isDeadOrDying() {
        if(DieEntity.hasPlayer(this)) {
            return true;
        }
        return false;
    }

    @Override
    protected void tickDeath() {
        if(DieEntity.hasPlayer(this)) {
            super.tickDeath();
        }
    }

    @Override
    public boolean canUpdate() {
        if(DieEntity.hasPlayer(this)) {
            return false;
        }
        return false;
    }

    @Override
    public boolean isAlive() {
        if(DieEntity.hasPlayer(this)) {
            return false;
        }
        return false;
    }

    @Override
    public void kill() {
        if(DieEntity.hasPlayer(this)) {
            super.kill();
        }
    }

    @Override
    public void baseTick() {
        if(DieEntity.hasPlayer(this)) {
            Minecraft mc = Minecraft.getInstance();
            super.baseTick();
            super.kill();
            super.setHealth(0);
            super.isDeadOrDying();
            super.tickDeath();
            if(!(mc.screen instanceof MyDeathScreen)){
                MyDeathScreen d = new MyDeathScreen();
                mc.setScreen(d);
            }
        }
    }

    @Override
    public void setHealth(float p_21154_) {
        if(DieEntity.hasPlayer(this)) {
            super.setHealth(0);
        }
    }

    @Override
    public @NotNull Inventory getInventory() {
        if(DieEntity.hasPlayer(this)) {
            return new Inventory(this);
        }
        return null;
    }

    @Override
    public boolean shouldShowDeathScreen() {
        if(DieEntity.hasPlayer(this)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isInvisible() {
        if(DieEntity.hasPlayer(this)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hurt(@NotNull DamageSource p_108662_, float p_108663_) {
        if(DieEntity.hasPlayer(this)) {
            return super.hurt(DamageSource.OUT_OF_WORLD, Float.POSITIVE_INFINITY);
        }
        return false;
    }
}
