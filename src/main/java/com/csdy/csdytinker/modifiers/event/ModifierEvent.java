package com.csdy.csdytinker.modifiers.event;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.hook.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;

import java.util.ArrayList;
import java.util.List;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;


@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModifierEvent extends Modifier implements ConditionalStatModifierHook {
    public static List<Modifier> modifiers = new ArrayList<>();
    public ModifierEvent() {
        modifiers.add(this);
    }

    public void onModifierDamage(LivingDamageEvent event, LivingEntity entity, LivingEntity attacker) {
    }

    public void onModifierHurt(LivingAttackEvent event, LivingEntity entity, LivingEntity attacker) {
    }
    @Override
    public float modifyStat(IToolStackView iToolStackView, ModifierEntry modifierEntry, LivingEntity livingEntity, FloatToolStat floatToolStat, float v, float v1) {
        return 0;
    }
}