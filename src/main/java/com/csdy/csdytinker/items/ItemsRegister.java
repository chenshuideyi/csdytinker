package com.csdy.csdytinker.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.csdy.csdytinker.CsdyTinker;
public class ItemsRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CsdyTinker.MOD_ID);

    public static final RegistryObject<Item> INARONS = ITEMS.register("inarons",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NATA = ITEMS.register("nata",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> FASS = ITEMS.register("fass",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AGENT = ITEMS.register("agent",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SWORDOFHISOU = ITEMS.register("sword_of_hisou", SwordofHisou::new);
    public static final RegistryObject<Item> UCHIHA = ITEMS.register("uchiha", Uchiha::new);
    public static final RegistryObject<Item> MASTERSPARK = ITEMS.register("master_spark", MasterSpark::new);
}

