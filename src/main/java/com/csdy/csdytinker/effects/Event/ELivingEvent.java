package com.csdy.csdytinker.effects.Event;

import com.csdy.csdytinker.modifiers.SptumnCicada;
import com.csdy.csdytinker.modifiers.method.CsdyModifier;
import com.csdy.csdytinker.modifiers.method.GetModifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.Random;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;
import static com.csdy.csdytinker.CsdyTinker.gatherData;
import static com.csdy.csdytinker.effects.EffectsRegister.*;
import static net.minecraft.world.effect.MobEffects.REGENERATION;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class ELivingEvent {
    @SubscribeEvent
    public static void Mutation(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (player.hasEffect(MUTATION.get())) {
                int Amplifier = (player.getEffect(MUTATION.get()).getAmplifier());
                if (Amplifier >= 15) {
                    player.heal(65535);
                    MobEffectInstance newEffect = new MobEffectInstance(MUTATION.get(), Amplifier * 20, Amplifier - 10);
                    player.removeEffect(MUTATION.get());
                    player.addEffect(newEffect);
                    event.setCanceled(true);
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
                int randomNum = random.nextInt(20);
                if (randomNum <= 6) {
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

    @SubscribeEvent
    public static void KamuiPlus(LivingAttackEvent event) {
        //双神威
        if (event.getEntity() instanceof Player player) {
            if (player.hasEffect(KAMUIPLUS.get())) {
                player.invulnerableTime = 1;
                event.setCanceled(true);

            }

        }
    }

    @SubscribeEvent
    public static void FuckYouDraconicEvolution(LivingDeathEvent event) {
        //双神威免死 操他妈的混沌守卫
        if (event.getEntity() instanceof Player player) {
            if (player.hasEffect((KAMUIPLUS.get()))) {
                player.setHealth(player.getMaxHealth());
                event.setCanceled(true);
            }

        }
    }

    @SubscribeEvent
    public static void TheForgeOfDays(TickEvent.PlayerTickEvent event) {
        //白日铸炉
        Player player= event.player;
        if (player.hasEffect(FORGE.get())) {
            if (player.isOnFire()){
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION,1,3));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,1,3));
                player.heal(0.25F);
            }
            else{
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,1,2));
                player.addEffect(new MobEffectInstance(MobEffects.HUNGER,1,2));
                //player.addEffect(new MobEffectInstance(MobEffects.CONFUSION,20,2));
            }
        }
    }


}





