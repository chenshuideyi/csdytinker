package com.csdy.csdytinker.modifiers;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

import java.util.Timer;
import java.util.TimerTask;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;
import static com.csdy.csdytinker.effects.EffectsRegister.DISCONTINUOUSNESS;

public class TikTok extends Modifier {
   // boolean tiktok = false;


    //int i = 0;

    public TikTok() {
    }

    public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        if (holder instanceof Player player) {
            if (player.getMainHandItem() == stack && !tool.isBroken()) {

                tool.setDamage(tool.getDamage() + level*5);

            }
        }

    }
}
