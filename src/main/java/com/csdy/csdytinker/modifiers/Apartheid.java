package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.effects.FaceMe;
import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import javax.annotation.Nonnull;

import static com.csdy.csdytinker.effects.EffectsRegister.FACEME;

public class Apartheid extends NoLevelsModifier {
    //孤傲
    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        LivingEntity getAttacker = context.getAttacker();
        if (target != null) {
            float value = target.getArmorValue();
            target.addEffect(new MobEffectInstance(FACEME.get(), 30000));
            if (target.getArmorValue() == 0) {
                getAttacker.hurt(DamageSource.playerAttack((Player) context.getAttacker()), value);
            }
        }
        return damage;
    }

}



