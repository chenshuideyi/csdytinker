package com.csdy.csdytinker.modifiers;

import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;


public class TrinityModifier extends Modifier {



    @Override
    public void addToolStats(ToolRebuildContext context,int level,ModifierStatsBuilder builder){
        //三位一体

        double rate = Math.pow(0.4,level);
        ToolStats.DRAW_SPEED.multiply(builder, 1 * rate);
        ToolStats.MINING_SPEED.multiply(builder, 1 * rate);
        ToolStats.DURABILITY.multiply(builder, 1 * rate);
        ToolStats.ATTACK_SPEED.multiply(builder, 1 * rate);
        ToolStats.ATTACK_DAMAGE.multiply(builder, 1 * rate);
        ToolStats.VELOCITY.multiply(builder, 1 * rate);
        ToolStats.ACCURACY.multiply(builder, 1 * rate);
        ToolStats.PROJECTILE_DAMAGE.multiply(builder, 1 * rate);
        ToolStats.ARMOR.multiply(builder, 1 * rate);
        ToolStats.ARMOR_TOUGHNESS.multiply(builder, 1 * rate);

    }

}
