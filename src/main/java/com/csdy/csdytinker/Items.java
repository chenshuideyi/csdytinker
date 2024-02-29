package com.csdy.csdytinker;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,CsdyTinker.MOD_ID);

    public static final RegistryObject<Item> inarons = ITEMS.register("inarons",

            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> nata = ITEMS.register("nata",

            ()->new Item(new Item.Properties()));

    public static final RegistryObject<Item> fass = ITEMS.register("fass",

            ()->new Item(new Item.Properties()));

}

