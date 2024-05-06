package com.csdy.csdytinker.modifiers;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

import static java.lang.Math.min;

public class Infested extends Modifier {
    //infested

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        LivingEntity attacker = context.getAttacker();
        if (target != null && attacker instanceof Player player) {
            Level world = target.getLevel();
            target.invulnerableTime = 0;
            target.hurt(DamageSource.playerAttack((Player) attacker), damage * 0.1f * level);
            world.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ZOMBIE_AMBIENT, SoundSource.NEUTRAL, 1.0F, 1.0F);
            ToolDamageUtil.repair(tool,level*2);
            player.getFoodData().eat(3, (float)level * 0.5F);
            player.heal((min(0.05f*damage*level,2*level)));
            target.invulnerableTime = 0;
        }
        return damage;
    }
}
