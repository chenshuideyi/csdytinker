package com.csdy.csdytinker.modifiers;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

public class Exhibitionism extends NoLevelsModifier {
    //暴露狂
    @Override
    public float getEntityDamage(IToolStackView tool, int level, ToolAttackContext context, float baseDamage, float damage) {
        Player player = context.getPlayerAttacker();
        float armor = player.getArmorValue();
        if (armor == 0) {
            return damage * (2);
        }
        return damage-4*armor;
    }
}
