package com.csdy.csdytinker.modifiers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.hook.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Agent extends NoLevelsModifier implements ProjectileHitModifierHook {
    @Override
    public boolean onProjectileHitBlock(ModifierNBT modifiers, NamespacedNBT persistentData,
                                        ModifierEntry modifier, Projectile projectile, BlockHitResult hit, @Nullable LivingEntity attacker) {
        Minecraft.getInstance().getCurrentServer();

        return true;
    }

    @AllArgsConstructor
    @RequiredArgsConstructor
    @Getter
    static class AgentReadyEvent extends Event {
        private Level level;
        private Vec3 position;
        @Nullable
        private LivingEntity from;
    }

    @SubscribeEvent
    public void OnAgentReady(AgentReadyEvent event) {

    }
}