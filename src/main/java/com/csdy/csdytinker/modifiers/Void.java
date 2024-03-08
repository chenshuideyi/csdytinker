package com.csdy.csdytinker.modifiers;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;

import javax.annotation.Nullable;


    public class Void extends Modifier implements ProjectileHitModifierHook {
        //超魔法
        @Override
        public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {

            LivingEntity target = context.getLivingTarget();
            if (target != null) {

                target.invulnerableTime = 0;
                target.hurt(DamageSource.OUT_OF_WORLD, damageDealt * 0.2f * level);

            }
            return 0;
        }

        @Override
        protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
            hookBuilder.addHook(this, TinkerHooks.PROJECTILE_HIT);
        }

        @Override
        public boolean onProjectileHitEntity(ModifierNBT modifiers,
                                             NamespacedNBT persistentData,
                                             ModifierEntry modifier, Projectile projectile,
                                             EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {

            if (projectile instanceof AbstractArrow arrow)
                if (target != null) {
                    target.invulnerableTime = 0;
                    target.hurt(DamageSource.OUT_OF_WORLD, (float) (arrow.getBaseDamage() * modifier.getLevel()));

                }
            return false;}
    }
