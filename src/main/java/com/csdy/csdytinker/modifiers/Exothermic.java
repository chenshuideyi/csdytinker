package com.csdy.csdytinker.modifiers;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
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


public class Exothermic extends NoLevelsModifier implements ProjectileHitModifierHook {
    //导热
    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        if (target != null) {
            Level world = target.getLevel();
            BlockPos pos = target.blockPosition();
            Biome biome = world.getBiome(pos).value();
            if(biome.getBaseTemperature() >= 1.0){
                target.setSecondsOnFire((int) damage/10);
            }
            return damage;
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
            BlockPos pos = target.blockPosition();
            Biome biome = world.getBiome(pos).value();
            if(biome.getBaseTemperature() >= 1.0){
                target.setSecondsOnFire((int)arrow.getBaseDamage()/10);
            }
            arrow.setBaseDamage(arrow.getBaseDamage());
        }
        return false;
    }

}