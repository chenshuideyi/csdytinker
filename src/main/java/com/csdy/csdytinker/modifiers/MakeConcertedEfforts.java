package com.csdy.csdytinker.modifiers;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IModDataView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import com.csdy.csdytinker.CsdyTinker;
public class MakeConcertedEfforts extends NoLevelsModifier {
    @Override
    public void addVolatileData(ToolRebuildContext context, int level, ModDataNBT volatileData) {
        IModDataView persistentData = context.getPersistentData();
        int number = persistentData.getSlots(SlotType.UPGRADE);
        volatileData.addSlots(SlotType.UPGRADE, -number * 10);
        number = persistentData.getSlots(SlotType.ABILITY);
        volatileData.addSlots(SlotType.ABILITY, -number);
        if (context.hasTag(TinkerTags.Items.ARMOR)) {
            int numberd = persistentData.getSlots(SlotType.DEFENSE);
            volatileData.addSlots(SlotType.DEFENSE, -numberd * 10);
        }
    }
}
