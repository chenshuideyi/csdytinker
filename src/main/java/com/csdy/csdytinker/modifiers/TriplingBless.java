package com.csdy.csdytinker.modifiers;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class TriplingBless extends Modifier{

    @Override
    public void addToolStats(ToolRebuildContext context,int level,ModifierStatsBuilder builder){
       if (level >= 3) {
           ToolStats.DRAW_SPEED.multiply(builder, 1 * 0.6 * level);
           ToolStats.MINING_SPEED.multiply(builder, 1 * 0.6 * level);
           ToolStats.DURABILITY.multiply(builder, 1 * 0.6 * level);
           ToolStats.ATTACK_SPEED.multiply(builder, 1 * 0.6 * level);
           ToolStats.ATTACK_DAMAGE.multiply(builder, 1 * 0.6 * level);
           ToolStats.VELOCITY.multiply(builder, 1 * 0.6 * level);
           ToolStats.ACCURACY.multiply(builder, 1 * 0.6 * level);
           ToolStats.PROJECTILE_DAMAGE.multiply(builder, 1 * 0.6 * level);
           ToolStats.ARMOR.multiply(builder, 1 * 0.6 * level);
           ToolStats.ARMOR_TOUGHNESS.multiply(builder, 1 * 0.6 * level);
       }
        else
            ToolStats.DRAW_SPEED.multiply(builder, 1 * 0.3 * level);
            ToolStats.MINING_SPEED.multiply(builder, 1 * 0.3 * level);
            ToolStats.DURABILITY.multiply(builder, 1 * 0.3 * level);
            ToolStats.ATTACK_SPEED.multiply(builder, 1 * 0.3 * level);
            ToolStats.ATTACK_DAMAGE.multiply(builder, 1 * 0.3 * level);
            ToolStats.VELOCITY.multiply(builder, 1 * 0.3 * level);
            ToolStats.ACCURACY.multiply(builder, 1 * 0.3 * level);
            ToolStats.PROJECTILE_DAMAGE.multiply(builder, 1 * 0.3 * level);
            ToolStats.ARMOR.multiply(builder, 1 * 0.3 * level);
            ToolStats.ARMOR_TOUGHNESS.multiply(builder, 1 * 0.3 * level);
    }
}
