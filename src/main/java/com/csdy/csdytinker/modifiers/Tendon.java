package com.csdy.csdytinker.modifiers;

import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import static slimeknights.tconstruct.library.tools.stat.ToolStats.*;

public class Tendon extends NoLevelsModifier {
    //肌腱
    @Override
    public void addToolStats(ToolRebuildContext context, int level, ModifierStatsBuilder builder) {
        DRAW_SPEED.add(builder, 0.4);
        VELOCITY.add(builder, 0.3);
        ToolStats.DURABILITY.multiply(builder, 1 * 0.65f);
    }
}
