package com.csdy.csdytinker.entities;

import com.csdy.csdytinker.CsdyTinker;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntitiesRegister {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, CsdyTinker.MOD_ID);
    public static final RegistryObject<EntityType<MasterSpark>> MASTER_SPARK = ENTITY_TYPES.register("master_spark",
            () -> EntityType.Builder.of(MasterSpark::new, MobCategory.MISC).sized(2.5f, 1024f).setTrackingRange(20)
                    .build(new ResourceLocation(CsdyTinker.MOD_ID, "master_spark").toString()));
    public static final RegistryObject<EntityType<MagicRing>> MAGIC_RING = ENTITY_TYPES.register("magic_ring",
            () -> EntityType.Builder.of(MagicRing::new, MobCategory.MISC).sized(1024f, 0f).setTrackingRange(20)
                    .build(new ResourceLocation(CsdyTinker.MOD_ID, "master_spark").toString()));
}
