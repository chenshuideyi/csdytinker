package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.util.C;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.interaction.GeneralInteractionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.interaction.InteractionSource;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;

import javax.annotation.Nonnull;
import java.util.List;

import static com.csdy.csdytinker.CsdyTinker.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Scarsky extends NoLevelsModifier implements GeneralInteractionModifierHook {

    public Scarsky() {
    }

    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.CHARGEABLE_INTERACT);
    }

    public InteractionResult onToolUse(IToolStackView tool, ModifierEntry modifier, Player player, InteractionHand hand, InteractionSource source) {
        ModifierUtil.startUsingItem(tool, modifier.getId(), player, hand);
        return InteractionResult.CONSUME;
    }

    public boolean onFinishUsing(IToolStackView tool, ModifierEntry modifier, LivingEntity entity) {
        ModDataNBT persistentData = tool.getPersistentData();
        if (!tool.isBroken() && entity instanceof Player player) {
            if (player.canEat(false)) {
                int level = modifier.getLevel();
                Level world = entity.getLevel();
                player.awardStat(Stats.ITEM_USED.get(tool.getItem()));
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 1200 + level * 1200, 1));
                var rot = player.getYRot();
                var pos = player.position();
                Vec3 aa, bb;
                var rot_ = (rot + 405) % 360;
                if (rot_ <= 90) {
                    aa = new Vec3(player.getX() + 64, player.getY() + 128, player.getZ() + 64);
                    bb = new Vec3(player.getX() - 64, player.getY() - 256, player.getZ() - 0);
                } //South
                else if (rot_ <= 180) {
                    aa = new Vec3(player.getX() + 0, player.getY() + 128, player.getZ() + 64);
                    bb = new Vec3(player.getX() - 64, player.getY() - 256, player.getZ() - 64);
                }//West
                else if (rot_ <= 270) {
                    aa = new Vec3(player.getX() - 64, player.getY() + 128, player.getZ() + 0);
                    bb = new Vec3(player.getX() + 64, player.getY() - 256, player.getZ() - 64);
                }//North
                else {
                    aa = new Vec3(player.getX() + 0, player.getY() + 128, player.getZ() + 64);
                    bb = new Vec3(player.getX() + 64, player.getY() - 256, player.getZ() - 64);
                }//East
                var blocks = BlockPos.betweenClosedStream(new AABB(aa, bb));
                blocks.forEach((block) -> world.setBlockAndUpdate(block, Blocks.AIR.defaultBlockState()));
                return true;
            }
        }

        return false;
    }

    public UseAnim getUseAction(IToolStackView tool, ModifierEntry modifier) {
        return UseAnim.BLOCK;
    }

    public int getUseDuration(IToolStackView tool, ModifierEntry modifier) {
        return 16;
    }

    /**@Override
    public void addInformation(@Nonnull IToolStackView tool, int level, @Nullable Player player, @Nonnull List<Component> tooltip, @Nonnull TooltipKey tooltipKey, @Nonnull TooltipFlag tooltipFlag) {
        if (player != null) {
            ModDataNBT toolData = tool.getPersistentData();
            //boolean harvest = tool.hasTag(TinkerTags.Items.HARVEST);
            tooltip.add(applyStyle(new TranslatableComponent(C.GetColor("西伯利亚史蒂夫种植杂交水稻"))));
            tooltip.add(applyStyle(new TranslatableComponent(C.GetColor("马里亚纳海沟卷起冥界风暴"))));
            tooltip.add(applyStyle(new TranslatableComponent(C.GetColor("老奶奶钻电视机降下圣火"))));
            tooltip.add(applyStyle(new TranslatableComponent(C.GetColor("战地医疗包蝉联届短跑冠军"))));
            tooltip.add(applyStyle(new TranslatableComponent(C.GetColor("霍金在萝莉岛观看小鬼僵尸"))));
        }
    }
*/}
