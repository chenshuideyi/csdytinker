package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.entities.EntitiesRegister;
import com.csdy.csdytinker.entities.MasterSpark;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.commands.SummonCommand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.TinkerHooks;
import slimeknights.tconstruct.library.modifiers.hook.ProjectileHitModifierHook;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierHookMap;
import slimeknights.tconstruct.library.tools.nbt.ModifierNBT;
import slimeknights.tconstruct.library.tools.nbt.NamespacedNBT;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Agent extends NoLevelsModifier implements ProjectileHitModifierHook {
    @Override
    protected void registerHooks(ModifierHookMap.Builder hookBuilder) {
        hookBuilder.addHook(this, TinkerHooks.PROJECTILE_HIT);
    }

    //陨星
    private static void summonSpear(Level level, BlockPos blockPos, Vec3 pos, @Nullable LivingEntity attacker, @Nullable Entity target) {
        MasterSpark spark = new MasterSpark(EntitiesRegister.MASTER_SPARK.get(), level);
        spark.moveTo(pos);
        level.addFreshEntity(spark);
        spark.setFrom(attacker);
        spark.setTarget(target);
    }

    @Override
    public boolean onProjectileHitBlock(ModifierNBT modifiers, NamespacedNBT persistentData,
                                        ModifierEntry modifier, Projectile projectile, BlockHitResult hit,
                                        @Nullable LivingEntity attacker) {
        var pos = projectile.position();
        var blockPos = new BlockPos(pos);
        var level = projectile.getLevel();

        summonSpear(level, blockPos, pos, attacker, null);
        projectile.discard();

        return false;
    }

    @Override
    public boolean onProjectileHitEntity(ModifierNBT modifiers, NamespacedNBT persistentData,
                                         ModifierEntry modifier, Projectile projectile, EntityHitResult hit,
                                         @Nullable LivingEntity attacker, @Nullable LivingEntity target) {
        //test

        var pos = projectile.position();
        var blockPos = new BlockPos(pos);
        var level = projectile.getLevel();

        summonSpear(level, blockPos, pos, attacker, target);
        projectile.discard();

        return false;
    }
}