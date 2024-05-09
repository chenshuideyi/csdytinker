package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.modifiers.method.CsdyModifier;
import com.csdy.csdytinker.modifiers.method.GetModifier;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import static java.lang.Math.min;

public class SptumnCicada extends CsdyModifier {
    //春秋蝉
    public boolean isNoLevels() {
        return true;
    }

    @Override
    public void LivingModifierAllDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player && player.experienceLevel >= 0) {
            if (GetModifier.getModifier(player, this) > 0 || GetModifier.getOffHandLevel(player, this) > 0) {
                player.experienceLevel = 0;
                player.moveTo(0, 0, 0);
                player.setHealth(5);
                event.setCanceled(true);
            }
        }
    }
}
