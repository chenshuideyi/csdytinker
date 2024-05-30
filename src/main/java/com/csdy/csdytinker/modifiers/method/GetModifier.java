package com.csdy.csdytinker.modifiers.method;


import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.List;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GetModifier {
    public static int getMainHandLevel(LivingEntity entity, Modifier modifier) {
        return ModifierUtil.getModifierLevel(entity.getMainHandItem(), modifier.getId());
    }
    public static int getMainHandModifier(LivingEntity entity, Modifier modifier) {
        ToolStack toolStack = ToolStack.from(entity.getMainHandItem());
        if (!toolStack.isBroken()) {
            return toolStack.getModifierLevel(modifier);
        }
        return 0;
    }
    public static int getOffHandLevel(LivingEntity entity, Modifier modifier) {
        if (entity.getOffhandItem().getDamageValue()!= 0) return ModifierUtil.getModifierLevel(entity.getOffhandItem(), modifier.getId());
        return ModifierUtil.getModifierLevel(entity.getOffhandItem(), modifier.getId());
    }
    public static int getOffHandLeveltest(LivingEntity entity, Modifier modifier) {
        for (ItemStack itemStack : entity.getAllSlots()) {
            ToolStack toolStack = ToolStack.from(entity.getOffhandItem());
            if (!toolStack.isBroken()) {
                return ModifierUtil.getModifierLevel(entity.getOffhandItem(), modifier.getId());
            }
        }
        return 0;
    }

    public static int getOffHandModifier(LivingEntity entity, Modifier modifier) {
            ToolStack toolStack = ToolStack.from(entity.getOffhandItem());
            if (!toolStack.isBroken()) {
                return toolStack.getModifierLevel(modifier);
            }
        return 0;
    }
    public static List<ModifierEntry> getModifierEntry(ItemStack itemStack) {
        ToolStack toolStack = ToolStack.from(itemStack);
        return toolStack.getModifierList();
    }
}
