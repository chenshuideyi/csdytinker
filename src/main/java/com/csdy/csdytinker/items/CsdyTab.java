package com.csdy.csdytinker.items;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CsdyTab {
    public static CreativeModeTab CSDYTAB;

    public static void load() {
        CSDYTAB = new CreativeModeTab("csdy_tab") {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(ItemsRegister.FASS.get());
            }

            @OnlyIn(Dist.CLIENT)
            public boolean hasSearchBar() {
                return false;
            }
        };
    }
}
