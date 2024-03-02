package com.csdy.csdytinker.modifiers;

import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IModDataView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

public class TriplingCurse extends Modifier {
    int number = 0;

    @Override
    public void addVolatileData(ToolRebuildContext context, int level, ModDataNBT volatileData) {
        volatileData.addSlots(SlotType.UPGRADE, +level);
        volatileData.addSlots(SlotType.ABILITY, +level);
        volatileData.addSlots(SlotType.DEFENSE, +level);

    }


    @Override
    public void addToolStats(ToolRebuildContext context, int level, ModifierStatsBuilder builder) {

        IModDataView up = context.getVolatileData();
         int number = context.getVolatileData().getSlots(SlotType.UPGRADE)
                 +context.getVolatileData().getSlots(SlotType.ABILITY)
                 +context.getVolatileData().getSlots(SlotType.DEFENSE);



        ToolStats.DRAW_SPEED.multiply(builder, 1 + 0.13  * number);
            ToolStats.MINING_SPEED.multiply(builder, 1 + 0.13  * number);
            ToolStats.DURABILITY.multiply(builder, 1 + 0.13  * number);
            ToolStats.ATTACK_SPEED.multiply(builder, 1 + 0.13  * number);
            ToolStats.ATTACK_DAMAGE.multiply(builder, 1 + 0.13 * number);
            ToolStats.VELOCITY.multiply(builder, 1 + 0.13  * number);
            ToolStats.ACCURACY.multiply(builder, 1 + 0.13  * number);
            ToolStats.PROJECTILE_DAMAGE.multiply(builder, 1 + 0.13  * number);
            ToolStats.ARMOR.multiply(builder, 1 + 0.13 * number);
            ToolStats.ARMOR_TOUGHNESS.multiply(builder, 1 + 0.13 * number);
        }
    }





