package com.csdy.csdytinker.modifiers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.hook.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Timer;
import java.util.TimerTask;

import static com.csdy.csdytinker.effects.EffectsRegister.KAMUI;

public class Kamui extends NoLevelsModifier implements ProjectileHitModifierHook {
    //神威
    boolean kamui = false;

    public Kamui() {
    }


    public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        if (holder instanceof Player player) {
            if (player.getMainHandItem() == stack && !tool.isBroken()) {
                if (!player.hasEffect(KAMUI.get())) {
                    if (!kamui) {
                        player.addEffect(new MobEffectInstance(KAMUI.get(), 106, 0));
                        kamui = true;
                        TimerTask task = new TimerTask() {
                            @Override
                            public void run() {
                                kamui = false;
                            }

                        };
                        Timer timer = new Timer();
                        timer.schedule(task, 4995);


                    }


                }

            }

        }
    }
}
