package com.csdy.csdytinker.modifiers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class VilePurge extends Modifier {
    @Override
    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        if (target != null) {
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60 * level, level - 1));
            target.addEffect(new MobEffectInstance(MobEffects.POISON, 60 * level, level - 1));
            target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 60 * level, level - 1));
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60 * level, level - 1));
            return level;
        }
        return 0; //返回值为对工具的额外耐久消耗，整型
    }
}
