package com.csdy.csdytinker;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = CsdyTinker.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FinalTypeHurtEventHandler {

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void OnGameStart(ServerStartedEvent event) {
        entitiesMarked = new ArrayList<>();
        tickCount = 0;
        map = HashMultimap.create();
        map.put(Attributes.MAX_HEALTH, new AttributeModifier("FaQ", -Float.MAX_VALUE, AttributeModifier.Operation.ADDITION));
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void OnServerTickStart(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.START) {
            tickCount++;
            perTickStart();
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void OnServerTickEnd(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            perTickEnd();
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void OnFinalTypeAttack(LivingAttackEvent event) {
        DamageSource eventSource = event.getSource();
        boolean cancel = OnEvent(eventSource, event.getEntityLiving(), event.getAmount());
        event.setCanceled(cancel);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void OnFinalTypeHurt(LivingHurtEvent event) {
        DamageSource eventSource = event.getSource();
        boolean cancel = OnEvent(eventSource, event.getEntityLiving(), event.getAmount());
        event.setCanceled(cancel);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void OnFinalTypeDamage(LivingDamageEvent event) {
        DamageSource eventSource = event.getSource();
        boolean cancel = OnEvent(eventSource, event.getEntityLiving(), event.getAmount());
        event.setCanceled(cancel);
    }

    public static boolean OnEvent(DamageSource eventSource, LivingEntity entity, float amount) {
        boolean cancel = false;
        if (eventSource instanceof FlexibleDamageSource source && source.isBypassEverything()) {
            cancel = true;
            if(entity.getHealth() - amount <= 0) entity.kill();
            else{
                entity.setHealth(entity.getHealth() - amount);
            }
            entitiesMarked.add(new RecordItem(entity, entity.getHealth() - amount, tickCount));
        }
        return cancel;
    }

    private static void perTickStart() {
        for (var item : entitiesMarked) {
            var entity = item.entity;
            var targetHealth = item.getTargetHealth();
            var tick = item.getTick();
            if (entity != null && !entity.isRemoved() && !(entity instanceof Player)) {
                if (entity.getHealth() > targetHealth) {
                    var tickOffset = tickCount - tick;
                    if (tickOffset > 1) {
                        if (targetHealth > 0) {
                            entity.setHealth(targetHealth);
                        } else {
                            entity.setRemoved(Entity.RemovalReason.KILLED);
                        }
                    }
                    if (tickOffset == 4) {
                        entity.getMaxHealth();
                        entity.getAttributes().addTransientAttributeModifiers(map);
                    }
                    if (tickOffset > 6) {
                        var vec = new Vec3(Double.MAX_VALUE, -Double.MAX_VALUE, Double.MAX_VALUE);
                        entity.setPos(vec);
                        entity.moveTo(vec);
                        entity.teleportTo(vec.x, vec.y, vec.z);
                    }
                    if (tickOffset > 9) {
                        //entity.changeDimension()
                    }
                }
            } else if (entity instanceof Player player) {
                if (player.getHealth() > targetHealth && !player.isDeadOrDying()) {
                    var tickOffset = tickCount - tick;
                    if (tickOffset < 5) {
                        if (targetHealth > 0) {
                            player.setHealth(targetHealth);
                        } else {
                            player.kill();
                        }
                    } else {
                        player.moveTo(player.position().x, -Double.MAX_VALUE, player.position().z);
                    }
                }
            }
        }
    }

    private static void perTickEnd() {
        for (var item : entitiesMarked) {
            var entity = item.entity;
            var targetHealth = item.getTargetHealth();
            var tick = item.getTick();
            if (entity == null || entity.isRemoved() || (entity instanceof Player player && entity.isDeadOrDying()) || entity.getHealth() <= targetHealth) {
                entitiesMarked.remove(entity);
            }
        }
    }


    private static Multimap<Attribute, AttributeModifier> map;
    private static long tickCount = 0;
    private static List<RecordItem> entitiesMarked = new ArrayList<>();

    @Data
    @AllArgsConstructor
    private static class RecordItem {
        @Nullable
        private LivingEntity entity;
        private Float targetHealth;
        private long tick;
    }
}
