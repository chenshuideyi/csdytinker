package com.csdy.csdytinker.entities;

import com.csdy.csdytinker.CsdyTinker;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntitiesRegister {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, CsdyTinker.MOD_ID);
    public static RegistryObject<EntityType<MasterSparkEntity>> flyingSwordEntity = ENTITY_TYPES.register("master_spark", () -> {
        return EntityType.Builder.of(MasterSparkEntity::new, MobCategory.MISC).sized(3, 0.5F).build("master_spark");
    });
}
