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
import slimeknights.tconstruct.library.tools.nbt.*;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import net.minecraft.ChatFormatting;
import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import static com.csdy.csdytinker.RainbowText.makeColour;
import static com.csdy.csdytinker.RainbowText.makeColour2;
import static com.google.common.primitives.Floats.max;

public class TriplingCurse extends Modifier {
    //内源之力

    @Override
    public void addVolatileData(ToolRebuildContext context, int level, ModDataNBT volatileData) {
        volatileData.addSlots(SlotType.UPGRADE, +level);
        volatileData.addSlots(SlotType.ABILITY, +level);
        volatileData.addSlots(SlotType.DEFENSE, +level);

    }


    @Override
    public void addToolStats(ToolRebuildContext context, int level, ModifierStatsBuilder builder) {

        int number = context.getVolatileData().getSlots(SlotType.UPGRADE)
                + context.getVolatileData().getSlots(SlotType.ABILITY)
                + context.getVolatileData().getSlots(SlotType.DEFENSE)
                +4;//初始四个槽
        double rate = Math.pow(1.31,number);
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

    @Override
    public void addInformation(@Nonnull IToolStackView tool, int level, @Nullable Player player, @Nonnull List<Component> tooltip, @Nonnull TooltipKey tooltipKey, @Nonnull TooltipFlag tooltipFlag) {
        if (player != null) {
            int number = (tool.getVolatileData().getSlots(SlotType.UPGRADE)
                    + tool.getVolatileData().getSlots(SlotType.ABILITY)
                    + tool.getVolatileData().getSlots(SlotType.DEFENSE))
                    +4;//初始四个槽
            if (number >= 18) {
                double rate = Math.pow(1.31,number);
                DecimalFormat df = new DecimalFormat("#.00");
                String formattedValue = df.format(rate);
                tooltip.add(applyStyle(new TranslatableComponent(C.GetColor("新的力量..."))));
                tooltip.add(applyStyle(new TranslatableComponent(makeColour("呵呵...没想到这么强大"))));
                tooltip.add(applyStyle(new TranslatableComponent(C.GetColor("已获得全属性增益"))));
                tooltip.add(applyStyle(new TranslatableComponent(makeColour2(String.valueOf(formattedValue) + "%"))));
            }
            else {
                tooltip.add(applyStyle(new TranslatableComponent("仅凭这样的力量什么都做不到...").withStyle(ChatFormatting.BLACK)));
            }
        }
    }
}





