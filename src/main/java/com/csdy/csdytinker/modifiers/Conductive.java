package com.csdy.csdytinker.modifiers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
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

public class Conductive extends NoLevelsModifier implements ProjectileHitModifierHook {
    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        if (target != null) {
            Level world = target.getLevel();
            if (world.isThundering()) {
                if (world.getRandom().nextInt(100) >= 30) {
                    LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, world);
                    lightningBolt.moveTo(target.getX(), target.getY(), target.getZ());
                    world.addFreshEntity(lightningBolt);
                }
            }

        }
        return 0;
    }
    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.PROJECTILE_HIT);
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        int level = modifier.getLevel();
        if (projectile instanceof AbstractArrow arrow && target != null) {
            Level world = target.getLevel();
            if (world.getRandom().nextInt(100) >= 30) {
                LightningBolt lightningBolt = new LightningBolt(EntityType.LIGHTNING_BOLT, world);
                lightningBolt.moveTo(target.getX(), target.getY(), target.getZ());
                world.addFreshEntity(lightningBolt);
            }
            arrow.setBaseDamage(arrow.getBaseDamage());
            arrow.setRemoved(Entity.RemovalReason.KILLED);
        }
        return false;
    }

}
