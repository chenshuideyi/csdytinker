package com.csdy.csdytinker.modifiers.method;

import com.csdy.csdytinker.modifiers.event.ModifierEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.modifiers.Modifier;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;


@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class onModifierHurt {
    @SubscribeEvent
    public static void onModifierHurt(LivingAttackEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            for (Modifier modifier : ModifierEvent.modifiers) {
                if (modifier instanceof ModifierEvent modifierEvent) {
                    modifierEvent.onModifierHurt(event, event.getEntityLiving(), attacker);
                }
            }
        }
    }


}
