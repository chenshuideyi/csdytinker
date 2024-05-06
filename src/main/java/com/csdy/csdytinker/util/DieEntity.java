package com.csdy.csdytinker.util;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

import java.util.HashSet;
import java.util.Set;

public class DieEntity
{
    private static final Set<String> player = new HashSet<>();

    public static void addPlayer(Entity entity) {
        if (entity == null)
            return;
        player.add(entity.getClass().getName());
    }

    public static boolean hasPlayer(Entity entity) {
        if (!(entity instanceof Player))
            return false;
        return player.contains(entity.getClass().getName());
    }
}
