package com.csdy.csdytinker.util;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.ClientRecipeBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.StatsCounter;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import org.jetbrains.annotations.NotNull;

public class DeathSeverPlayer extends ServerPlayer {
    public DeathSeverPlayer(MinecraftServer p_143384_, ServerLevel p_143385_, GameProfile p_143386_) {
        super(p_143384_, p_143385_, p_143386_);
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
}
