package com.csdy.csdytinker.effects.Event;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;
import static com.csdy.csdytinker.effects.EffectsRegister.*;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class ELivingEvent {
    @SubscribeEvent
    public static void Mutation(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (player.hasEffect(MUTATION.get())) {
                int Amplifier = (player.getEffect(MUTATION.get()).getAmplifier());
                if (Amplifier >= 15) {
                    if (event.getAmount() > player.getHealth()) {
                        event.setCanceled(true);
                        player.heal(player.getMaxHealth());
                        MobEffectInstance newEffect = new MobEffectInstance(MUTATION.get(), Amplifier * 20, Amplifier - 10);
                        player.removeEffect(MUTATION.get());
                        player.addEffect(newEffect);
                    }
                }

            }
        }
    }

    @SubscribeEvent
    public static void Discontinuousness(LivingAttackEvent event) {
        //不连续存在
        if (event.getEntity() instanceof Player player) {
            if (player.hasEffect(DISCONTINUOUSNESS.get())) {
                Random random = new Random();
                int randomNum = random.nextInt(7);
                if (randomNum == 0) {
                    player.invulnerableTime = 1;
                    event.setCanceled(true);
                }
            }

        }
    }

    @SubscribeEvent
    public static void Kamui(LivingAttackEvent event) {
        //神威
        if (event.getEntity() instanceof Player player) {
            if (player.hasEffect(KAMUI.get())) {
                player.invulnerableTime = 1;
                event.setCanceled(true);

            }

        }
    }

    @SubscribeEvent
    public static void KamuiAttack(AttackEntityEvent event) {
        //攻击退出神威
        if (event.getEntity() instanceof Player player) {
            if (player.hasEffect(KAMUI.get())) {
                player.removeEffect(KAMUI.get());

            }

        }
    }

    @SubscribeEvent
    public static void KamuiArrow(ArrowNockEvent event) {
        //拉弓退出神威
        if (event.getEntity() instanceof Player player) {
            if (player.hasEffect(KAMUI.get())) {
                player.removeEffect(KAMUI.get());

            }

        }
    }
}





