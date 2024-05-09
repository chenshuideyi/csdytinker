package com.csdy.csdytinker.modifiers;

import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class Tendon extends NoLevelsModifier {
    //肌腱
    @Override
    public void addToolStats(ToolRebuildContext context, int level, ModifierStatsBuilder builder) {
        FloatToolStat drawSpeed = ToolStats.DRAW_SPEED;
        drawSpeed.add(builder, 0.4);
        FloatToolStat velocity = ToolStats.VELOCITY;
        velocity.add(builder, 0.3);
        ToolStats.DURABILITY.multiply(builder, 1 * 0.65f);
    }
}
