package com.csdy.csdytinker.modifiers;

import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
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


import java.util.Timer;
import java.util.TimerTask;

import static com.google.common.primitives.Floats.max;

public class LastWhisper extends NoLevelsModifier implements ProjectileHitModifierHook {
    //最后的轻语
    private DamageSource playerAttack;
    boolean fuck = false;

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        Player Attacker = (Player) context.getAttacker();
        if (target != null) {
            target.setHealth(max(target.getHealth() - 0.5f * damage, 1));
            target.invulnerableTime = 0;
            if (target.getHealth() - 0.5f * damage <= 0) {
                if (target instanceof Player) {
                    target.hurt(DamageSource.playerAttack(Attacker), Float.MAX_VALUE);
                    target.die((DamageSource.playerAttack(Attacker)));
                    target.setHealth(0);
                    target.isDeadOrDying();
                    target.kill();
                    target.deathTime = 20;
                }
                else {
                    target.hurt(DamageSource.playerAttack(Attacker), Float.MAX_VALUE);
                    target.die((DamageSource.playerAttack(Attacker)));
                    target.isDeadOrDying();
                    target.setHealth(0);
                    target.canUpdate(false);
                    target.hurtMarked = false;
                }
                //我真的不想这么写，但是龙研和蔚蓝就他妈傻逼啊
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
            Player Attacker = (Player) attacker;
            arrow.setBaseDamage(arrow.getBaseDamage());
            target.setHealth(max((float) (target.getHealth() - (100 + 0.2f * arrow.getBaseDamage())), 1));
            if (target.getHealth() - (100 + 0.2f * arrow.getBaseDamage()) <= 0) {
                if (target.getType().getRegistryName().getNamespace().equals("draconicevolution")) {
                    for (var player : attacker.getServer().getPlayerList().getPlayers()) {
                        if (!fuck) {
                            fuck = true;
                            player.connection.send(new ClientboundSetTitleTextPacket(new TextComponent("苟延残喘又不肯认输的样子")));
                            player.connection.send(new ClientboundSetTitlesAnimationPacket(20, 30, 20));
                            TimerTask task = new TimerTask() {
                                @Override
                                public void run() {
                                    player.connection.send(new ClientboundSetTitleTextPacket(new TextComponent("真丑陋啊")));
                                    player.connection.send(new ClientboundSetTitlesAnimationPacket(20, 30, 20));
                                    fuck = false;
                                }

                            };
                            Timer timer = new Timer();
                            timer.schedule(task, 1500);
                        }

                    }
                    target.die((DamageSource.playerAttack(Attacker)));
                    target.setHealth(0);
                    target.isDeadOrDying();
                    target.canUpdate(false);
                    target.hurtMarked = false;
                    arrow.setRemoved(Entity.RemovalReason.KILLED);
                    //.hurt(DamageSource.OUT_OF_WORLD, 100000000) ;
                }
                target.invulnerableTime = 0;
                if (target instanceof Player) {
                    target.hurt(DamageSource.playerAttack(Attacker), Float.MAX_VALUE);
                    target.die((DamageSource.playerAttack((Attacker))));
                    target.setHealth(0);
                    target.isDeadOrDying();
                    target.kill();
                    target.deathTime = 20;
                }
                else {
                    target.hurt(DamageSource.playerAttack(Attacker), Float.MAX_VALUE);
                    target.die((DamageSource.playerAttack(Attacker)));
                    target.isDeadOrDying();
                    target.setHealth(0);
                    target.canUpdate(false);
                    target.hurtMarked = false;
                }
                arrow.setRemoved(Entity.RemovalReason.KILLED);
            } else {
                arrow.setBaseDamage(arrow.getBaseDamage());
                arrow.setRemoved(Entity.RemovalReason.KILLED);
            }
            target.invulnerableTime = 0;
        }
        return false;
    }
}