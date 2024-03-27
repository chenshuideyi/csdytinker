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
