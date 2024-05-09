package com.csdy.csdytinker.modifiers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.hook.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import static com.csdy.csdytinker.effects.EffectsRegister.DISCONTINUOUSNESS;
import static com.csdy.csdytinker.effects.EffectsRegister.MUTATION;

public class Discontinuousness extends NoLevelsModifier implements ProjectileHitModifierHook {
    //不连续存在
    public Discontinuousness() {
    }

    public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        if (holder instanceof Player player) {
            if (player.getMainHandItem() == stack && !tool.isBroken()) {
                player.addEffect(new MobEffectInstance(DISCONTINUOUSNESS.get(), 1, 0));
            }
            if (player.getOffhandItem() == stack && !tool.isBroken()) {
                player.addEffect(new MobEffectInstance(DISCONTINUOUSNESS.get(), 1, 0));
            }
        }

    }
}
