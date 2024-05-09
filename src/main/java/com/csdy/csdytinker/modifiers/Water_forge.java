package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.CsdyTinker;
import com.csdy.csdytinker.util.C;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import javax.annotation.Nonnull;
import java.util.List;

import static com.csdy.csdytinker.RainbowText.makeColour6;

public class Water_forge extends Modifier implements ConditionalStatModifierHook {
    //水成
    private final ResourceLocation KEY = new ResourceLocation(CsdyTinker.MOD_ID, "water_forge");
    @Override
    public void onRemoved(IToolStackView tool) {
        if(tool.getModifierLevel(this.getId()) == 0) {
            tool.getPersistentData().remove(KEY);
        }
    }

    @Override
    public void onInventoryTick(@Nonnull IToolStackView tool, int level, @Nonnull Level world, @Nonnull LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        ModDataNBT persistantData = tool.getPersistentData();
        float value = persistantData.getFloat(KEY);
        if (holder instanceof Player player) {
            if (player.isEyeInFluid(FluidTags.WATER) && !player.isOnGround() && value < 5 * level)
                persistantData.putFloat(KEY, persistantData.getFloat(KEY) + 0.001f);
            player.heal(0.0025F * value);
        }

    }

    @Override
    public float modifyStat(IToolStackView tool, ModifierEntry modifier, LivingEntity living, FloatToolStat stat, float baseValue, float multiplier) {
        ModDataNBT persistantData = tool.getPersistentData();
        float value = persistantData.getFloat(KEY);
        if (persistantData.contains(KEY, 5)) {
            if (stat == ToolStats.VELOCITY) {
                return baseValue * (1 + 0.1f * value);
            }
            if (stat == ToolStats.DRAW_SPEED) {
                return baseValue * (1 + 0.1f * value);
            }

        }return baseValue;
    }

    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.CONDITIONAL_STAT);
    }

    @Override
    public void addInformation(@Nonnull IToolStackView tool, int level, @Nullable Player player, @Nonnull List<Component> tooltip, @Nonnull TooltipKey tooltipKey, @Nonnull TooltipFlag tooltipFlag) {
        if (player != null) {
            ModDataNBT persistantData = tool.getPersistentData();
            float value = persistantData.getFloat(KEY);
            tooltip.add(applyStyle(new TranslatableComponent(makeColour6("潮汐")).append(makeColour6(value + ""))));
        }
    }
}
