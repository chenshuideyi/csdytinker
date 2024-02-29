package com.csdy.csdytinker.Effect;

import com.csdy.csdytinker.Effect.Mutation;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;
public class EffectsRegister {

    public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MOD_ID);


    public static final RegistryObject<MobEffect>MUTATION = EFFECT.register("mutation",Mutation::new);
}
