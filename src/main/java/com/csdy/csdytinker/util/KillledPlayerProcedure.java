package com.csdy.csdytinker.util;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class KillledPlayerProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity _entity)
            _entity.setHealth(0);
        if (entity instanceof LivingEntity _entity)
            _entity.hurtTime = 20;
        if (entity instanceof LivingEntity _entity)
            _entity.deathTime = -2;
        if (entity instanceof LivingEntity _entity)
            _entity.setAirSupply(0);
        if (entity instanceof LivingEntity _entity)
            _entity.isDeadOrDying();
        entity.kill();
        if (entity instanceof LivingEntity _entity)
            _entity.hurtDir = Float.POSITIVE_INFINITY;
        entity.hurtMarked = true;
        entity.invulnerableTime = 0;
        entity.isInvisible();
        entity.canUpdate(false);
        entity.onRemovedFromWorld();
    }

    public static void executeplayer(Entity entity) {
        Minecraft mc = Minecraft.getInstance();
        if (!(mc.screen instanceof MyDeathScreen)) {
            MyDeathScreen d = new MyDeathScreen();
            mc.setScreen(d);
        }
    }
}
