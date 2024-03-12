package com.csdy.csdytinker.modifiers;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket;
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



import static com.google.common.primitives.Floats.max;

public class Arthur extends NoLevelsModifier implements ProjectileHitModifierHook {

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        if (target != null) {
            if (target.getType().getRegistryName().getNamespace().equals("draconicevolution")) {
                target.setRemoved(Entity.RemovalReason.KILLED);
            }
            target.setHealth(max(target.getHealth() - 0.5f * damage, 1));
            if (target.getHealth() - 0.5f * damage <= 0) {
                return damage * 100000;
            }
        }
        return 0.5f * damage;
    }

    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.PROJECTILE_HIT);
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData, ModifierEntry modifier, Projectile projectile, EntityHitResult hit, @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        if (projectile instanceof AbstractArrow arrow && target != null) {
            arrow.setBaseDamage(arrow.getBaseDamage());
            target.setHealth(max((float) (target.getHealth() - 300f * arrow.getBaseDamage()), 1));
            if (target.getHealth() - 300f * arrow.getBaseDamage() <= 0) {
                if (target.getType().getRegistryName().getNamespace().equals("draconicevolution")) {
                    for (var player : attacker.getServer().getPlayerList().getPlayers()) {
                        player.connection.send(new ClientboundSetTitleTextPacket(new TextComponent("\"一直...都不喜欢你...\"")));
                        player.connection.send(new ClientboundSetTitlesAnimationPacket(20, 30, 20));

                    }
                    target.setHealth(0);
                    //.hurt(DamageSource.OUT_OF_WORLD, 100000000) ;
                }

            }
            arrow.setBaseDamage(arrow.getBaseDamage()*0.8f);
            arrow.setRemoved(Entity.RemovalReason.KILLED);
        }
        return false;
    }
}