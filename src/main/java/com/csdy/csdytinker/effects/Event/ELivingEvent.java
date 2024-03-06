package com.csdy.csdytinker.effects.Event;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;
import static com.csdy.csdytinker.effects.EffectsRegister.MUTATION;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class ELivingEvent {
    @SubscribeEvent
    public void Mutation(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (player.hasEffect(MUTATION.get())) {
                int Amplifier = (player.getEffect(MUTATION.get()).getAmplifier());
                if (Amplifier >= 15){
                    event.setCanceled(true);
                    player.heal(20);
                    MobEffectInstance newEffect = new MobEffectInstance(MUTATION.get(),  Amplifier*20,  Amplifier-10);
                    player.removeEffect(MUTATION.get());
                    player.addEffect(newEffect);
                }
            }

        }
    }
}




