package com.csdy.csdytinker.modifiers;

import net.minecraft.client.gui.font.glyphs.BakedGlyph;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;

import static com.csdy.csdytinker.effects.EffectsRegister.MUTATION;
import static net.minecraft.world.effect.MobEffects.DAMAGE_RESISTANCE;

public class Fickle extends Modifier {
    //善变
    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        Player attacker = context.getPlayerAttacker();
        if (target != null) {
            Level world = target.getLevel();
            BlockPos pos = target.blockPosition();
            Biome biome = world.getBiome(pos).value();
            if (biome.getBaseTemperature() >= 1.0) {
                return 0.25f * level + damage;
            }
            if (biome.getBaseTemperature() <= 0.05){
                attacker.addEffect(new MobEffectInstance(DAMAGE_RESISTANCE,20, 1));
                        //(MobEffects.DAMAGE_RESISTANCE,);
            }
        }



        return damage;
    }


}
