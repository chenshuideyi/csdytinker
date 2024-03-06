package com.csdy.csdytinker.modifiers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import static com.csdy.csdytinker.effects.EffectsRegister.MUTATION;

public class Mutation extends Modifier {
    @Override
    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        Player attacker = context.getPlayerAttacker();
        if (target != null) {
            if (attacker != null) {
                if (attacker.hasEffect(MUTATION.get())) {
                    int amplifier = (attacker.getEffect(MUTATION.get()).getAmplifier());
                    attacker.addEffect(new MobEffectInstance(MUTATION.get(), 600, amplifier+level));

                }
                attacker.addEffect(new MobEffectInstance(MUTATION.get(), 600, level));
            }


        }


        return level;
    }


}








