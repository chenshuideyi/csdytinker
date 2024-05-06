package com.csdy.csdytinker.modifiers.method;

import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.hook.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;

import java.util.ArrayList;
import java.util.List;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CsdyModifier extends Modifier implements ConditionalStatModifierHook {

    public static List<Modifier> modifiers = new ArrayList<>();
    public boolean isNoLevels() {
        return false;
    }
    public CsdyModifier() {
        modifiers.add(this);
    }


    public void LivingModifierDamage(LivingDamageEvent event, LivingEntity entity, float amount, DamageSource source) {
    }

    public void LivingModifierHurt(LivingHurtEvent event, LivingEntity entity,float amount, DamageSource source) {
    }
    public void LivingModifierAttack(LivingAttackEvent event, LivingEntity entity, float amount, DamageSource source) {
    }
    public void LivingModifierDeath(LivingDeathEvent event,LivingEntity entity, DamageSource source) {
    }
    public void LivingModifierAllDeath(LivingDeathEvent event){
    }
    public void LivingModifierAllDamage(LivingDamageEvent event,float amount) {
    }
    @Override
    public float modifyStat(IToolStackView iToolStackView, ModifierEntry modifierEntry, LivingEntity livingEntity, FloatToolStat floatToolStat, float v, float v1) {
        return 0;
    }
    @Override
    public @NotNull Component getDisplayName(int level) {
        if (isNoLevels()) {
            return super.getDisplayName();
        } else {
            return super.getDisplayName(level);
        }
    }
}
