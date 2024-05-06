package com.csdy.csdytinker.effects.Event;


import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.List;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModifierEvents {
    //@SubscribeEvent
    //public static void onLivingHurt(LivingHurtEvent event) {
    //if (event.getSource().getEntity() instanceof LivingEntity attacker) {
    // for (Modifier modifier : ExModifer.modifiers) {
    // if (modifier instanceof ExModifer xiModifier) {
    //    xiModifier.onModifierHurt(event, event.getEntityLiving(), attacker);
    public static int getModifier(LivingEntity entity, Modifier modifier) {
        for (ItemStack itemStack : entity.getAllSlots()) {
            ToolStack toolStack = ToolStack.from(itemStack);
            if (!toolStack.isBroken()) {
                return toolStack.getModifierLevel(modifier);
            }
        }
        return 0;
    }
    public static List<ModifierEntry> getModifierEntry(ItemStack itemStack) {
        ToolStack toolStack = ToolStack.from(itemStack);
        return toolStack.getModifierList();
    }

}
