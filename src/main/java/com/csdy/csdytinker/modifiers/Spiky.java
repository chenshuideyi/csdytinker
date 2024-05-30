package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.modifiers.method.CsdyModifier;
import com.csdy.csdytinker.modifiers.method.GetModifier;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class Spiky extends CsdyModifier {
    public boolean isNoLevels() {
        return true;
    }

    @Override
    public void LivingModifierHurt(LivingHurtEvent event, LivingEntity entity, LivingEntity attacker, float amount) {
        if (event.getEntity() instanceof Player player) {
            if (GetModifier.getMainHandModifier(player, this) > 0 || GetModifier.getOffHandLevel(player, this) > 0) {
                ToolStack tool = ToolStack.from(player.getMainHandItem());
                attacker.hurt(DamageSource.playerAttack(player), tool.getStats().get(ToolStats.ATTACK_DAMAGE));
            }
        }
    }
}
