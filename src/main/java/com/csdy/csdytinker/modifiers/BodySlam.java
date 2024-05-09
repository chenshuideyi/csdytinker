package com.csdy.csdytinker.modifiers;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class BodySlam extends NoLevelsModifier {
    //全身撞击
    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        Player Attacker = (Player) context.getAttacker();
        if (target != null) {
            target.invulnerableTime = 0;
            target.hurt(DamageSource.playerAttack(Attacker), Attacker.getArmorValue());
        }
        return damage;
    }
}
