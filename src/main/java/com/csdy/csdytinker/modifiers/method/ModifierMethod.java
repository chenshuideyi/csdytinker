package com.csdy.csdytinker.modifiers.method;


import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.EquipmentChangeContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;


@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModifierMethod {
    @SubscribeEvent
    public static void LivingModifierHurt(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity attacker) {
            for (Modifier modifier : CsdyModifier.modifiers) {
                if (modifier instanceof CsdyModifier csdyModifier) {
                    csdyModifier.LivingModifierHurt(event, event.getEntityLiving(),attacker,event.getAmount());
                }
            }
        }
    }

    @SubscribeEvent
    public static void LivingModifierDamage(LivingDamageEvent event) {
        if (event.getSource().getEntity() != null) {
            for (Modifier modifier : CsdyModifier.modifiers) {
                if (modifier instanceof CsdyModifier csdyModifier) {
                    csdyModifier.LivingModifierDamage(event, event.getEntityLiving(), event.getAmount(), event.getSource());
                }
            }
        }
    }

    @SubscribeEvent
    public static void LivingModifierAttack(LivingAttackEvent event) {
        if (event.getSource().getEntity() != null) {
            for (Modifier modifier : CsdyModifier.modifiers) {
                if (modifier instanceof CsdyModifier csdyModifier) {
                    csdyModifier.LivingModifierAttack(event, event.getEntityLiving(), event.getAmount(), event.getSource());
                }
            }
        }
    }

    @SubscribeEvent
    public static void LivingModifierDeath(LivingDeathEvent event) {
        if (event.getSource().getEntity() != null) {
            for (Modifier modifier : CsdyModifier.modifiers) {
                if (modifier instanceof CsdyModifier csdyModifier) {
                    csdyModifier.LivingModifierDeath(event, event.getEntityLiving(), event.getSource());
                }
            }
        }
    }

    @SubscribeEvent
    public static void LivingModifierAllDeath(LivingDeathEvent event) {
        for (Modifier modifier : CsdyModifier.modifiers) {
            if (modifier instanceof CsdyModifier csdyModifier) {
                csdyModifier.LivingModifierAllDeath(event);
            }
        }

    }

    @SubscribeEvent
    public static void LivingModifierAllDamage(LivingDamageEvent event) {
        for (Modifier modifier : CsdyModifier.modifiers) {
            if (modifier instanceof CsdyModifier csdyModifier) {
                csdyModifier.LivingModifierAllDamage(event, event.getAmount());
            }
        }

    }
    @SubscribeEvent
    public static void LivingModifierAllAttack(LivingAttackEvent event) {
        if (event.getSource().getEntity() != null) {
            for (Modifier modifier : CsdyModifier.modifiers) {
                if (modifier instanceof CsdyModifier csdyModifier) {
                    csdyModifier.LivingModifierAllAttack(event, event.getAmount(), event.getSource());
                }
            }
        }
    }
}
