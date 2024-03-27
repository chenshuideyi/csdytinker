package com.csdy.csdytinker.modifiers;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;
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

import static com.csdy.csdytinker.effects.EffectsRegister.MUTATION;

public class Mutation extends Modifier implements ProjectileHitModifierHook {
    @Override
    public int afterEntityHit(@NotNull IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        Player attacker = context.getPlayerAttacker();
        if (target != null) {
            if (attacker != null) {
                if (attacker.hasEffect(MUTATION.get())) {
                    int amplifier = (attacker.getEffect(MUTATION.get()).getAmplifier());
                    if (level + amplifier < 256) {
                        attacker.addEffect(new MobEffectInstance(MUTATION.get(), 600, amplifier + level));
                    }
                    else {
                        attacker.addEffect(new MobEffectInstance(MUTATION.get(), 600, 255));
                    }
                }
                attacker.addEffect(new MobEffectInstance(MUTATION.get(), 600, level - 1));
            }


        }


        return level;
    }

    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.PROJECTILE_HIT);
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        if (projectile instanceof AbstractArrow arrow && target != null) {
            if (attacker != null) {
                int level = modifier.getLevel();
                if (attacker.hasEffect(MUTATION.get())) {
                    int amplifier = (attacker.getEffect(MUTATION.get()).getAmplifier());
                    if (level + amplifier < 256) {
                        attacker.addEffect(new MobEffectInstance(MUTATION.get(), 600, amplifier + level));
                    }
                    else {
                        attacker.addEffect(new MobEffectInstance(MUTATION.get(), 600, 255));
                    }

                }
                attacker.addEffect(new MobEffectInstance(MUTATION.get(), 600, level - 1));
            }
            arrow.setRemoved(Entity.RemovalReason.KILLED);
        }
        return false;
    }
}











