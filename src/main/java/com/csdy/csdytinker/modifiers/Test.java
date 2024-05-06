package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.modifiers.method.GetModifier;
import com.csdy.csdytinker.util.C;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.List;

import static com.csdy.csdytinker.effects.EffectsRegister.MUTATION;
import static com.csdy.csdytinker.modifiers.method.CsdyModifier.modifiers;

public class Test extends Modifier implements ProjectileHitModifierHook {
    //测试用


    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        if (target != null) {
            Level world = target.getLevel();
            //target.setSleepingPos(target.getOnPos());
            target.die(DamageSource.OUT_OF_WORLD);
            target.hurt(DamageSource.playerAttack((Player) context.getAttacker()), Float.MAX_VALUE);
            return 0 * damage;
            //target.hurt(DamageSource.OUT_OF_WORLD, 0.1f * target.getHealth()) ;
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

            target.setHealth(1);//target.getHealth());
            arrow.setBaseDamage(arrow.getBaseDamage() * 10);

        }
        return false;
    }

    public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        if (holder instanceof Player player) {
            if (player.getMainHandItem() == stack && !tool.isBroken()) {
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 20, 2));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20, 3));
            }
        }

    }


    @Override
    public void addToolStats(ToolRebuildContext context, int level, ModifierStatsBuilder builder) {

        int number = context.getModifiers().getLevel(getId());

    }
    @Override
    public void addInformation(@Nonnull IToolStackView tool, int level, @org.jetbrains.annotations.Nullable Player player, @Nonnull List<Component> tooltip, @Nonnull TooltipKey tooltipKey, @Nonnull TooltipFlag tooltipFlag) {
        if (player != null) {
            ItemStack item = player.getMainHandItem();
            ToolStack toolStack = ToolStack.from(item);
            int number =  tool.getModifiers().getLevel(getId());
                    //number = tool.getModifierList();
                    //tool.getModifiers().getLevel(getId());
            tooltip.add(applyStyle(new TranslatableComponent(C.GetColor(String.valueOf(number)))));
        }
    }
}




