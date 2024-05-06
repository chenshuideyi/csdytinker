package com.csdy.csdytinker.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;
public class EffectsRegister {

    public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MOD_ID);


    public static final RegistryObject<MobEffect>MUTATION = EFFECT.register("mutation",Mutation::new);
    public static final RegistryObject<MobEffect>FACEME = EFFECT.register("faceme",FaceMe::new);
    public static final RegistryObject<MobEffect>DISCONTINUOUSNESS = EFFECT.register("discontinuousness",Discontinuousness::new);
    public static final RegistryObject<MobEffect>KAMUI = EFFECT.register("kamui",Kamui::new);
    public static final RegistryObject<MobEffect>KAMUIPLUS = EFFECT.register("kamui_plus",KamuiPlus::new);
}
