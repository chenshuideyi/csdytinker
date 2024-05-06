package com.csdy.csdytinker.modifiers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.EquipmentChangeContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;


import java.util.Timer;
import java.util.TimerTask;



import static com.csdy.csdytinker.effects.EffectsRegister.KAMUIPLUS;

public class KamuiPlus extends NoLevelsModifier {
    public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        if (holder instanceof Player player) {
            if (player.getMainHandItem() == stack && !tool.isBroken()) {

                player.addEffect(new MobEffectInstance(KAMUIPLUS.get(), 6000, 0));

            }

        }
    }
}
