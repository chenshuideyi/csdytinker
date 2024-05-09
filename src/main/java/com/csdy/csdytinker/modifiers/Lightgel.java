package com.csdy.csdytinker.modifiers;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.interaction.GeneralInteractionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InteractionSource;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.tools.TinkerModifiers;
import slimeknights.tconstruct.tools.modifiers.slotless.OverslimeModifier;

public class Lightgel extends Modifier implements GeneralInteractionModifierHook {
    //荧光胶冻
    public Lightgel() {
    }

    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.CHARGEABLE_INTERACT);
    }

    public InteractionResult onToolUse(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand hand, InteractionSource source) {
        if (source == InteractionSource.RIGHT_CLICK && !tool.isBroken() && player.canEat(false)) {
            ModifierUtil.startUsingItem(tool, modifier.getId(), player, hand);
            return InteractionResult.CONSUME;
        } else {
            return InteractionResult.PASS;
        }
    }

    public boolean onFinishUsing(IToolStackView tool, ModifierEntry modifier, LivingEntity entity) {
        ModDataNBT persistentData = tool.getPersistentData();
        if (!tool.isBroken() && entity instanceof Player player) {
            if (player.canEat(false)) {
                int level = modifier.getLevel();
                Level world = entity.getLevel();
                player.getFoodData().eat(1, (float) level * 0.1F);
                player.awardStat(Stats.ITEM_USED.get(tool.getItem()));
                world.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.GENERIC_EAT, SoundSource.NEUTRAL, 1.0F, 1.0F + (world.random.nextFloat() - world.random.nextFloat()) * 0.4F);
                world.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_BURP, SoundSource.NEUTRAL, 0.5F, world.random.nextFloat() * 0.1F + 0.9F);
                OverslimeModifier overslimeModifier = (OverslimeModifier) TinkerModifiers.overslime.get();
                overslimeModifier.setOverslime(tool, overslimeModifier.getOverslime(tool) - 15 * level);
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200 + level * 1200, 1));
                return true;
            }
        }

        return false;
    }

    public UseAnim getUseAction(IToolStackView tool, ModifierEntry modifier) {
        return UseAnim.EAT;
    }

    public int getUseDuration(IToolStackView tool, ModifierEntry modifier) {
        return 16;
    }

}
