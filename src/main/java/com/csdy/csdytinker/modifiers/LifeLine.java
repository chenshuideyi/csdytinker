package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.modifiers.method.CsdyModifier;
import com.csdy.csdytinker.modifiers.method.GetModifier;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class LifeLine extends CsdyModifier {
    public boolean isNoLevels() {
        return true;
    }


    @Override
    public void LivingModifierAllDamage(LivingDamageEvent event, float amount) {
        if (event.getEntity() instanceof Player player) {
            ItemStack item = player.getMainHandItem();
            ToolStack tool = ToolStack.from(item);
            if (GetModifier.getModifier(player, this) > 0) {
                tool.setDamage((int) (tool.getDamage() + event.getAmount() * 30));
                float def = (float) tool.getCurrentDurability() / 500;
                event.setAmount(event.getAmount() * (100 - (max(def, 60)) * 0.01f));

            }
        }
    }
}


