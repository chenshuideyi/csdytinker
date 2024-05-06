package com.csdy.csdytinker.modifiers;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.EquipmentChangeContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import net.minecraft.server.level.ServerLevel;
import net.minecraftforge.event.world.WorldEvent;

public class Dawn extends NoLevelsModifier {
    @Override
    public void onEquip(IToolStackView tool, int level, EquipmentChangeContext context) {
        LivingEntity entity = context.getEntity();
        Level world = entity.getLevel();
        if (entity instanceof Player player) {
            world.isDay();
        }
    }

}
