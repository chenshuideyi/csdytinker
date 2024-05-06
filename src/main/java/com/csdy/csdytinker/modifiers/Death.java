package com.csdy.csdytinker.modifiers;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
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

public class Death extends NoLevelsModifier implements ProjectileHitModifierHook {
    Random random = new Random();


    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        if (target != null) {
            if (target.getHealth() == target.getMaxHealth()) {
                int randomNumber = random.nextInt(4); // 生成0到3的随机数
                if (randomNumber == 0) {
                    target.invulnerableTime = 0;
                    target.hurt(DamageSource.OUT_OF_WORLD,target.getMaxHealth()*0.75f);
                    target.invulnerableTime = 0;
                }

            }

        }
        return damage;
    }

    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.PROJECTILE_HIT);
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        if (projectile instanceof AbstractArrow arrow && target != null) {
            if (target.getHealth() == target.getMaxHealth()) {
                int randomNumber = random.nextInt(4); // 生成0到3的随机数
                if (randomNumber == 0) {
                    target.invulnerableTime = 0;
                    target.hurt(DamageSource.OUT_OF_WORLD,target.getMaxHealth()*0.75f);
                    target.invulnerableTime = 0;

                }
                arrow.setBaseDamage(arrow.getBaseDamage());
                arrow.setRemoved(Entity.RemovalReason.KILLED);
            }

        }
        return false;
    }
}
