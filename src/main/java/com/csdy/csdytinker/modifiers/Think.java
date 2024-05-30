package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.effects.Forge;
import com.csdy.csdytinker.modifiers.method.CsdyModifier;
import com.csdy.csdytinker.modifiers.method.GetModifier;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.context.ToolRebuildContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ToolStats;

import java.util.UUID;

import static com.csdy.csdytinker.effects.EffectsRegister.FORGE;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static slimeknights.tconstruct.library.tools.stat.ToolStats.ATTACK_DAMAGE;

public class Think extends CsdyModifier {
    public boolean isNoLevels() {
        return true;
    }

    @Override
    public void LivingModifierHurt(LivingHurtEvent event, LivingEntity entity, LivingEntity attacker, float amount) {
        if (event.getEntity() instanceof Player player) {
            if (GetModifier.getMainHandModifier(player, this) > 0 || GetModifier.getOffHandLevel(player, this) > 0) {
                ToolStack tool = ToolStack.from(player.getMainHandItem());
                attacker.hurt(DamageSource.playerAttack(player), tool.getStats().get(ToolStats.DURABILITY));
            }
        }
    }
    @Override
    public void LivingModifierAllDamage(LivingDamageEvent event,float amount) {
        if (event.getEntity() instanceof Player player) {
            if (GetModifier.getMainHandModifier(player, this) > 0 || GetModifier.getOffHandModifier(player, this) > 0) {
                event.setAmount(0);
            }
        }
    }
    @Override
    public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        if (tool.isBroken()){
            tool.setDamage(tool.getDamage()-20);
            tool.isBroken();
            if (tool.getCurrentDurability() == tool.getStats().get(ToolStats.DURABILITY)){
                tool.isUnbreakable();
            }
        }
    }
    @Override
    public void addToolStats(ToolRebuildContext context, int level, ModifierStatsBuilder builder) {
        ATTACK_DAMAGE.add(builder, 1110.4);
    }
}






