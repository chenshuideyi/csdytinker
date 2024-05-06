package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.CsdyTinker;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.ConditionalStatModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentChangeContext;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.stat.FloatToolStat;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import static com.csdy.csdytinker.effects.EffectsRegister.KAMUIPLUS;

public class Velkhana extends Modifier implements ProjectileHitModifierHook {
    private final ResourceLocation KEY = new ResourceLocation(CsdyTinker.MOD_ID, "velkhana");
    @Override
    public void onRemoved(IToolStackView tool) {
        tool.getPersistentData().remove(KEY);
    }
    @Override
    public void onUnequip(IToolStackView tool, int level, EquipmentChangeContext context) {
        LivingEntity entity = context.getEntity();
        ModDataNBT persistantData = tool.getPersistentData();
        if (entity instanceof Player player) {
            persistantData.putFloat(KEY, persistantData.getFloat(KEY) * 0f);
        }
    }
    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        ModDataNBT persistantData = tool.getPersistentData();
        if (persistantData.contains(KEY, 10)) {
            float value = persistantData.getFloat(KEY);
            if (target != null) {
                target.invulnerableTime = 0;
                target.hurt(DamageSource.MAGIC, value * 0.1f * level);
                target.invulnerableTime = 0;
                persistantData.putFloat(KEY, persistantData.getFloat(KEY) * 0f);
            }

        }
        return super.getEntityDamage(tool, level, context, baseDamage, damage);
    }
    public void onInventoryTick(IToolStackView tool, int level, Level world, LivingEntity holder, int itemSlot, boolean isSelected, boolean isCorrectSlot, ItemStack stack) {
        ModDataNBT persistantData = tool.getPersistentData();
        if (holder instanceof Player player) {
            if (player.getMainHandItem() == stack && !tool.isBroken()) {
                if (persistantData.getFloat(KEY) <=100*level) persistantData.putFloat(KEY, persistantData.getFloat(KEY) + 0.1f*level);
            }

        }
    }

}
