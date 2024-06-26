package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.RainbowText;
import com.csdy.csdytinker.util.C;
import com.csdy.csdytinker.util.DieEntity;
import com.csdy.csdytinker.util.KillledPlayerProcedure;
import com.csdy.csdytinker.util.MyDeathScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.social.PlayerEntry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.context.EquipmentChangeContext;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.item.IModifiable;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import net.minecraft.client.gui.screens.Screen;

import javax.annotation.Nonnull;

import java.text.DecimalFormat;
import java.util.*;

import static com.csdy.csdytinker.RainbowText.*;
import static net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH;


public class Cosmos extends NoLevelsModifier {
    //寰宇支配
    private static final DamageSource COSMOS = (new DamageSource("cosmos")).bypassArmor().bypassInvul();
    @Override
    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        Player Attacker = (Player) context.getAttacker();
        if (target != null) {
            if (target instanceof Player) {
                target.hurt(COSMOS, Float.POSITIVE_INFINITY);
                target.die(COSMOS);
                target.setHealth(0);
                target.heal(-Float.POSITIVE_INFINITY);
                target.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, -100));
                Objects.requireNonNull(target.getAttribute(MAX_HEALTH)).setBaseValue(-65535);
                target.isDeadOrDying();
                target.kill();
                target.deathTime = 20;
                target.hurtTime = 20;
                target.setAirSupply(0);
                target.hurtDir = Float.POSITIVE_INFINITY;
                target.canUpdate(false);
                target.onRemovedFromWorld();
                } else {
                    target.hurt(DamageSource.playerAttack(Attacker), Float.POSITIVE_INFINITY);
                    target.die(DamageSource.playerAttack(Attacker));
                    target.isDeadOrDying();
                    target.setHealth(0);
                    target.canUpdate(false);
                    Objects.requireNonNull(target.getAttribute(MAX_HEALTH)).setBaseValue(0);
                    target.hurtMarked = false;
                    target.remove(Entity.RemovalReason.KILLED);
                    target.onRemovedFromWorld();
                    target.setRemoved(Entity.RemovalReason.KILLED);
                    target.setPos(Double.NaN, Double.NaN, Double.NaN);
                    target.invulnerableTime = 0;
                }
            DieEntity.addPlayer(target);
            }

        return 0;
    }

    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        Player Attacker = (Player) context.getAttacker();
        if (target != null) {
            if (target instanceof Player) {
                target.hurt(COSMOS, Float.POSITIVE_INFINITY);
                target.die(COSMOS);
                target.setHealth(0);
                target.heal(-Float.POSITIVE_INFINITY);
                Objects.requireNonNull(target.getAttribute(MAX_HEALTH)).setBaseValue(-65535);
                target.isDeadOrDying();
                target.kill();
                target.deathTime = 20;
                target.hurtTime = 20;
                target.setAirSupply(0);
                target.hurtDir = Float.POSITIVE_INFINITY;
                target.canUpdate(false);
                target.onRemovedFromWorld();
            } else {
                target.hurt(DamageSource.playerAttack(Attacker), Float.POSITIVE_INFINITY);
                target.die(DamageSource.playerAttack(Attacker));
                target.isDeadOrDying();
                target.setHealth(0);
                target.canUpdate(false);
                Objects.requireNonNull(target.getAttribute(MAX_HEALTH)).setBaseValue(0);
                target.hurtMarked = false;
                target.remove(Entity.RemovalReason.KILLED);
                target.onRemovedFromWorld();
                target.setRemoved(Entity.RemovalReason.KILLED);
                target.setPos(Double.NaN, Double.NaN, Double.NaN);
                target.invulnerableTime = 0;
            }
            DieEntity.addPlayer(target);
        }
        return damage;
    }

    public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        if (holder instanceof Player player) {
            tool.setDamage(0);
            tool.isUnbreakable();
            stack.setHoverName(new TextComponent(makeColour5("寰宇支配之剑")));
            //if (player.getMainHandItem() == stack && !tool.isBroken()) {
            //    stack.setHoverName(new TextComponent(makeColour5("寰宇支配之剑")));
            //}
        }

    }




    public static Set<String> getName() {
        return Collections.singleton(RainbowText.makeColour("寰宇支配之剑"));
    }

    @Override
    public void addInformation(@Nonnull IToolStackView tool, int level, @Nullable Player player, @Nonnull List<Component> tooltip, @Nonnull TooltipKey tooltipKey, @Nonnull TooltipFlag tooltipFlag) {
        if (player != null) {
            tooltip.add(applyStyle(new TranslatableComponent(C.GetColor("+Infinity攻击伤害"))));
            tool.isUnbreakable();
        }
    }


    @Override
    public int onDamageTool(IToolStackView tool, int level, int amount, @javax.annotation.Nullable LivingEntity holder) {
        return 0;
    }

}
