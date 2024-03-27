package com.csdy.csdytinker.modifiers;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

import static com.google.common.primitives.Floats.max;

public class Pulverize extends NoLevelsModifier {
    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        LivingEntity getAttacker = context.getAttacker();
        if (target != null) {
            if (target.getHealth() - getAttacker.getMaxHealth() <= 0) {
                target.hurt(DamageSource.playerAttack((Player) context.getAttacker()), Float.MAX_VALUE);
                target.setHealth(0);
            }
        }
        return damage;
    }


}
