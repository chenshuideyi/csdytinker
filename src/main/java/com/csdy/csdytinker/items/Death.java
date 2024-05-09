package com.csdy.csdytinker.items;

import com.csdy.csdytinker.util.KillledPlayerProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import org.jetbrains.annotations.NotNull;

public class Death extends Item {
    public Death() {
        super(new Properties().tab(CsdyTab.CSDYTAB).stacksTo(1).fireResistant().rarity(Rarity.COMMON));
        MinecraftForge.EVENT_BUS.register(this);
    }
    @Override
    public void inventoryTick(@NotNull ItemStack itemstack, @NotNull Level world, @NotNull Entity entity, int slot, boolean selected) {
        super.inventoryTick(itemstack, world, entity, slot, selected);
        KillledPlayerProcedure.execute(entity);
    }
}
