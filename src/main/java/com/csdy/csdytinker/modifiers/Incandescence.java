package com.csdy.csdytinker.modifiers;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import static slimeknights.tconstruct.tools.modifiers.upgrades.general.ReinforcedModifier.damageReinforced;

public class Incandescence extends Modifier {
    //炽热已极
    @Override
    public void addToolStats(ToolRebuildContext context, int level, ModifierStatsBuilder builder) {
        double number = 1 + 0.5 * level;
        ToolStats.ATTACK_SPEED.multiply(builder, 1 * number);
        ToolStats.ATTACK_DAMAGE.multiply(builder, 1 * number);
    }

    @Override
    public int onDamageTool(IToolStackView tool, int level, int amount, @javax.annotation.Nullable LivingEntity holder) {
        return damageReinforced(amount, (0.1f * level));
    }

}
