package com.csdy.csdytinker;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("minecraft")
public class CsdySoundEvents {
    public static final SoundEvent TEST = register("test");
    public static final SoundEvent AMATERASU = register("amaterasu");
    public CsdySoundEvents() {
    }
    private static SoundEvent register(String sound) {
        return (SoundEvent) Registry.register(Registry.SOUND_EVENT, sound, new SoundEvent(new ResourceLocation(sound)));
    }

}
