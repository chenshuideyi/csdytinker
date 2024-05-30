package com.csdy.csdytinker.modifiers;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;

public class Behand extends NoLevelsModifier {
    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        if (target != null) {
            ItemStack AirItem = Items.AIR.getDefaultInstance();
            target.setItemInHand(InteractionHand.MAIN_HAND, AirItem);
            target.setItemInHand(InteractionHand.OFF_HAND,AirItem);
        }
        return damage;
    }
}
