package com.csdy.csdytinker.modifiers;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.Random;

import static com.csdy.csdytinker.effects.EffectsRegister.MUTATION;

public class SunBless extends Modifier implements ProjectileHitModifierHook {

    Random random = new Random();

    @Override
    public int afterEntityHit(@NotNull IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        Player attacker = context.getPlayerAttacker();
        int randomNum = random.nextInt(100);
        if (target != null) {
            if (attacker != null) {
                if (level > 2) {
                    level = 2;
                }
                if (randomNum >= 10) {
                    attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60 * level, level - 1));
                    if (randomNum >= 30) {
                        attacker.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 60 * level, level - 1));
                        if (randomNum >= 40) {
                            attacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60 * level, level - 1));
                            if (randomNum >= 50) {
                                attacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60 * level, level - 1));
                                if (randomNum >= 60) {
                                    attacker.addEffect(new MobEffectInstance(MobEffects.HEAL, 60 * level, level - 1));
                                    if (randomNum >= 70) {
                                        attacker.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 60 * level, level - 1));
                                        if (randomNum >= 90) {
                                            attacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60 * level, level - 1));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                attacker.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60 * level, level - 1));
            }
        }


        return level;
    }


    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.PROJECTILE_HIT);
    }

    public Component getDisplayName(@Nonnull IToolStackView tool, int level) {
        if (level > 2)
            return getDisplayName(2);
        return getDisplayName(level);
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        if (projectile instanceof AbstractArrow arrow && target != null) {
            if (attacker != null) {
                int level = modifier.getLevel();
                if (level > 2) {
                    level = 2;
                }
                int randomNum = random.nextInt(100);
                if (randomNum >= 10) {
                    attacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60 * level, level - 1));
                    if (randomNum >= 30) {
                        attacker.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 60 * level, level - 1));
                        if (randomNum >= 40) {
                            attacker.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60 * level, level - 1));
                            if (randomNum >= 50) {
                                attacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60 * level, level - 1));
                                if (randomNum >= 60) {
                                    attacker.addEffect(new MobEffectInstance(MobEffects.HEAL, 60 * level, level - 1));
                                    if (randomNum >= 70) {
                                        attacker.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 60 * level, level - 1));
                                        if (randomNum >= 90) {
                                            attacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60 * level, level - 1));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                attacker.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60 * level, level - 1));
            }
            arrow.setRemoved(Entity.RemovalReason.KILLED);
        }
        return false;
    }
}

