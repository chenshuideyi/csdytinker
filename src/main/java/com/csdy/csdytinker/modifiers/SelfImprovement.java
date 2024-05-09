package com.csdy.csdytinker.modifiers;

import net.minecraft.world.entity.Entity;
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
import slimeknights.tconstruct.library.tools.context.ToolHarvestContext;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nullable;

public class SelfImprovement extends Modifier implements ProjectileHitModifierHook {
    //未实装
    int atk = 0;
    int rage = 0;
    int min = 0;

    @Override
    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        if (target != null) {
            if (atk < 10000000 * level) {
                for (int i = 0; i < level; i++) {
                    atk++;
                }
            }
        }
        return 0;
    }

    @Override
    public void afterBlockBreak(IToolStackView tool, int level, ToolHarvestContext context) {
        LivingEntity living = context.getLiving();
        if (min < 10000000 * level) {
            for (int i = 0; i < level; i++) {
                min++;
            }
        }
    }


    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.PROJECTILE_HIT);
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        int level = modifier.getLevel();
        if (projectile instanceof AbstractArrow arrow && target != null) {
            if (rage < 10000000 * level) {
                for (int i = 0; i < level; i++) {
                    rage++;

                }

            }
            arrow.setRemoved(Entity.RemovalReason.KILLED);
        }
        return false;
    }

    @Override
    public void addToolStats(ToolRebuildContext context, int level, ModifierStatsBuilder builder) {
        ToolStats.DRAW_SPEED.multiply(builder, 1 + (0.04 * level * min));
        ToolStats.MINING_SPEED.multiply(builder, 1 + (0.04 * level * min));
        ToolStats.DURABILITY.multiply(builder, 1 + (0.04 * level * ((atk + min + rage) * 0.1f)));
        ToolStats.ATTACK_SPEED.multiply(builder, 1 + (0.04 * level * atk + rage) * 0.02f);
        ToolStats.ATTACK_DAMAGE.multiply(builder, 1 + (10 * level * atk));
        ToolStats.VELOCITY.multiply(builder, 1 + (0.04 * level * rage));
        ToolStats.ACCURACY.multiply(builder, 1 + (0.04 * level * rage));
        ToolStats.PROJECTILE_DAMAGE.multiply(builder, 1 + (0.04 * level * rage));
    }


}
