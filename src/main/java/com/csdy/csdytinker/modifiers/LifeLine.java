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
    //灵器

    public boolean isNoLevels() {
        return true;
    }


    @Override
    public void LivingModifierAllDamage(LivingDamageEvent event, float amount) {
        if (event.getEntity() instanceof Player player) {
            ToolStack tool = ToolStack.from(player.getMainHandItem());
            if (GetModifier.getMainHandModifier(player, this) > 0 ) {
                tool.setDamage((int) (tool.getDamage() + event.getAmount() * 10));
                float def = (float) tool.getCurrentDurability() / 500;
                event.setAmount(event.getAmount() * (100 - (max(def, 70))) * 0.01f);
            }
            ToolStack tool2 = ToolStack.from(player.getOffhandItem());
            if (GetModifier.getOffHandModifier(player, this) > 0) {
                tool2.setDamage((int) (tool2.getDamage() + event.getAmount() * 10));
                float def2 = (float) tool2.getCurrentDurability() / 500;
                event.setAmount(event.getAmount() * (100 - (max(def2, 70))) * 0.01f);
            }
        }
    }
}


