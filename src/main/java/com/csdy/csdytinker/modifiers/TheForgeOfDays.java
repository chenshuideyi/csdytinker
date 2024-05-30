package com.csdy.csdytinker.modifiers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import static com.csdy.csdytinker.effects.EffectsRegister.FORGE;

public class TheForgeOfDays extends NoLevelsModifier {
    @Override
    public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        if (holder instanceof Player player && isCorrectSlot) {
            player.addEffect(new MobEffectInstance(FORGE.get(), 200, 0, false, false, false));
        }
    }

}
