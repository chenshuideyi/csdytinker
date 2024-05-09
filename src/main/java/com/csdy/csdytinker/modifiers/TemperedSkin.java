package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.modifiers.method.CsdyModifier;
import com.csdy.csdytinker.modifiers.method.GetModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.EquipmentChangeContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;
import static com.csdy.csdytinker.effects.EffectsRegister.KAMUI;
import static java.lang.Math.min;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TemperedSkin extends CsdyModifier {
    //钢化皮肤
    static int Tempered = 0;
    public boolean isNoLevels() {
        return true;
    }

    @Override
    public void onEquip(IToolStackView tool, int level, EquipmentChangeContext context) {
        LivingEntity entity = context.getEntity();
        if (entity instanceof Player player) {
            Tempered++;
        }
    }

    @Override
    public void onUnequip(IToolStackView tool, int level, EquipmentChangeContext context) {
        LivingEntity entity = context.getEntity();
        if (entity instanceof Player player && Tempered>0) {
            Tempered--;
        }
    }

    @Override
    public void LivingModifierAllDamage(LivingDamageEvent event,float amount) {
            if (event.getEntity() instanceof Player player) {
                if (Tempered>0) event.setAmount(event.getAmount() - (min(Tempered,4)));

        }
    }
}
