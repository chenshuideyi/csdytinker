package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.util.DieEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Objects;

import static net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED;

public class CuttingLegs extends NoLevelsModifier {
    //割腿
    @Override
    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        if (target != null) Objects.requireNonNull(target.getAttribute(MOVEMENT_SPEED)).setBaseValue(0);
        return 0;
    }

}
