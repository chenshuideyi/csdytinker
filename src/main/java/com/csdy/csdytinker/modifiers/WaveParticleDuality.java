package com.csdy.csdytinker.modifiers;

import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class WaveParticleDuality extends Modifier implements ProjectileHitModifierHook {
    Random random = new Random();

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        if (target != null) {
            int randomNumber = random.nextInt(300) + 1;
            do {
                target.invulnerableTime = 0;
                target.hurt(DamageSource.OUT_OF_WORLD, 0.1f * level);
                randomNumber--;
            } while (randomNumber > 0);
            //target.hurt(DamageSource.OUT_OF_WORLD, 0.1f * level * randomNumber);
        }
        return damage * 0;
    }

    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.PROJECTILE_HIT);
    }



    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        int level = modifier.getLevel();
        if (projectile instanceof AbstractArrow arrow && target != null) {
            int randomNumber = random.nextInt(300) + 1;
            do {
                target.invulnerableTime = 0;
                target.hurt(DamageSource.OUT_OF_WORLD, 0.1f * level);
                randomNumber--;
            } while (randomNumber > 0);
            arrow.setBaseDamage(0);
            arrow.setRemoved(Entity.RemovalReason.KILLED);
        }
        return false;
    }
}
