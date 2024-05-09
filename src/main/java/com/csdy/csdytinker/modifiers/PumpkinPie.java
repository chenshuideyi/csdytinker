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
import java.util.Random;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class PumpkinPie extends NoLevelsModifier implements ProjectileHitModifierHook {
    //南瓜派
    String[] array = {
            "有人是新手就要照顾新手？",
            "为什么不加格雷科技？",
            "深暗之园本来就没有什么东西",
            "gtnh是我叠",
            "搓出无尽只需要打凋零和末影龙",
            "不是冯玉琳柜头我不用",
            "卧槽有这么牛逼的？",
            "水槽就水槽了怎么还不让别人说",
            "籽岷鬼图是这个整合包的精华部分",
            "不要无条件帮助别人",
            "马哥黄鸡",
            "我要重置任务线，所有的",
            "要么实装南瓜派合金要么加入子民工艺",
            "我用盲肠人做个子民工艺",
            "降噪是我星怒",
            "打凋零前必须打末影龙",
            "你不介绍世界观？",
            "就聊gt就聊gt",
            "子民合金",
            "格雷之星"
    };
    Random random = new Random();

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        LivingEntity getAttacker = context.getAttacker();
        int randomIndex = random.nextInt(array.length);
        if (target != null) {
            for (var player : getAttacker.getServer().getPlayerList().getPlayers()) {

                    player.connection.send(new ClientboundSetTitleTextPacket(new TextComponent((array[randomIndex]))));
                    player.connection.send(new ClientboundSetTitlesAnimationPacket(5, 5, 10));
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
            int randomIndex = random.nextInt(array.length);
            for (var player : attacker.getServer().getPlayerList().getPlayers()) {
                player.connection.send(new ClientboundSetTitleTextPacket(new TextComponent((array[randomIndex]))));
                player.connection.send(new ClientboundSetTitlesAnimationPacket(5, 5, 10));
                arrow.setRemoved(Entity.RemovalReason.KILLED);
            }
        }
        return false;

    }
}
