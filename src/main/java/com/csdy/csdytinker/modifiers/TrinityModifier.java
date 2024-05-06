package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.util.C;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.SlotType;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;
import java.util.List;

import static com.csdy.csdytinker.RainbowText.makeColour2;
import static com.csdy.csdytinker.RainbowText.makeColour4;
import static com.google.common.primitives.Floats.max;


public class TrinityModifier extends Modifier {
    //三位一体
    @Override
    public void addToolStats(ToolRebuildContext context, int level, ModifierStatsBuilder builder) {
        if (level == 3) {
            ToolStats.DRAW_SPEED.multiply(builder, 1 + (0.6 * level));
            ToolStats.MINING_SPEED.multiply(builder, 1 + (0.6 * level));
            ToolStats.DURABILITY.multiply(builder, 1 + (0.6 * level));
            ToolStats.ATTACK_SPEED.multiply(builder, 1 + (0.6 * level));
            ToolStats.ATTACK_DAMAGE.multiply(builder, 1 + (0.6 * level));
            ToolStats.VELOCITY.multiply(builder, 1 + (0.6 * level));
            ToolStats.ACCURACY.multiply(builder, 1 + (0.6 * level));
            ToolStats.PROJECTILE_DAMAGE.multiply(builder, 1 + (0.6 * level));
            ToolStats.ARMOR.multiply(builder, 1 + (0.6 * level));
            ToolStats.ARMOR_TOUGHNESS.multiply(builder, 1 + (0.6 * level));
        } else
            ToolStats.DRAW_SPEED.multiply(builder, 1 + (0.3 * level));
        ToolStats.MINING_SPEED.multiply(builder, 1 + (0.3 * level));
        ToolStats.DURABILITY.multiply(builder, 1 + (0.3 * level));
        ToolStats.ATTACK_SPEED.multiply(builder, 1 + (0.3 * level));
        ToolStats.ATTACK_DAMAGE.multiply(builder, 1 + (0.3 * level));
        ToolStats.VELOCITY.multiply(builder, 1 + (0.3 * level));
        ToolStats.ACCURACY.multiply(builder, 1 + (0.3 * level));
        ToolStats.PROJECTILE_DAMAGE.multiply(builder, 1 + (0.3 * level));
        ToolStats.ARMOR.multiply(builder, 1 + (0.3 * level));
        ToolStats.ARMOR_TOUGHNESS.multiply(builder, 1 + (0.3 * level));
    }

    @Override
    public void addInformation(@Nonnull IToolStackView tool, int level, @Nullable Player player, @Nonnull List<Component> tooltip, @Nonnull TooltipKey tooltipKey, @Nonnull TooltipFlag tooltipFlag) {
        if (player != null) {
            if (level == 3) {
                tooltip.add(applyStyle(new TranslatableComponent(makeColour4("我已达顶点，往后只有衰落"))));
            }
        }
    }


    //@Override
    //public void addToolStats(ToolRebuildContext context,int level,ModifierStatsBuilder builder){


    //    double rate = Math.pow(0.4,level);
    //    ToolStats.DRAW_SPEED.multiply(builder, 1 * rate);
    //   ToolStats.MINING_SPEED.multiply(builder, 1 * rate);
    //  ToolStats.DURABILITY.multiply(builder, 1 * rate);
    // ToolStats.ATTACK_SPEED.multiply(builder, 1 * rate);
    //  ToolStats.ATTACK_DAMAGE.multiply(builder, 1 * rate);
    //   ToolStats.VELOCITY.multiply(builder, 1 * rate);
    //   ToolStats.ACCURACY.multiply(builder, 1 * rate);
    //  ToolStats.PROJECTILE_DAMAGE.multiply(builder, 1 * rate);
    // ToolStats.ARMOR.multiply(builder, 1 * rate);
    //  ToolStats.ARMOR_TOUGHNESS.multiply(builder, 1 * rate);

    // }

}
