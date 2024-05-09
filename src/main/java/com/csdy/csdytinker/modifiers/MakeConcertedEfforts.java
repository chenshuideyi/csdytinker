package com.csdy.csdytinker.modifiers;
import com.csdy.csdytinker.util.C;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IModDataView;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import com.csdy.csdytinker.CsdyTinker;
import net.minecraft.ChatFormatting;

import javax.annotation.Nonnull;
import java.util.List;

public class MakeConcertedEfforts extends NoLevelsModifier {
    //三重咒诅
    @Override
    public void addVolatileData(ToolRebuildContext context, int level, ModDataNBT volatileData) {
        IModDataView persistentData = context.getPersistentData();
        int number = persistentData.getSlots(SlotType.UPGRADE)
                + persistentData.getSlots(SlotType.ABILITY)
                + persistentData.getSlots(SlotType.DEFENSE);
        //volatileData.addSlots(SlotType.UPGRADE, -20000 * number);
        //volatileData.addSlots(SlotType.ABILITY, -20000 * number);
        //volatileData.addSlots(SlotType.DEFENSE, -20000 * number);
        volatileData.setSlots(SlotType.UPGRADE, -10);
        volatileData.setSlots(SlotType.ABILITY, -10);
        volatileData.setSlots(SlotType.DEFENSE, -10);
    }

    @Override
    public void addInformation(@Nonnull IToolStackView tool, int level, @Nullable Player player, @Nonnull List<Component> tooltip, @Nonnull TooltipKey tooltipKey, @Nonnull TooltipFlag tooltipFlag) {
        if (player != null) {
            tooltip.add(applyStyle(new TranslatableComponent("它的高傲抗拒着强化").withStyle(ChatFormatting.DARK_BLUE)));
        }
    }
}


