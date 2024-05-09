package com.csdy.csdytinker.modifiers;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.protocol.game.ClientboundSetTitleTextPacket;
import net.minecraft.network.protocol.game.ClientboundSetTitlesAnimationPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import javax.annotation.Nonnull;
import java.util.Random;

public class CoupDeGrace extends Modifier {
    //恩赐解脱
    @Override
    public float getEntityDamage(@Nonnull IToolStackView tool, int level, @Nonnull ToolAttackContext context, float baseDamage, float damage) {
        LivingEntity target = context.getLivingTarget();
        Player Attacker = (Player) context.getAttacker();
        if (target != null) {
            Level world = target.getLevel();
            Random random = new Random();
            int randomNum = random.nextInt(100);
            if (randomNum >= 78) {
                if (level > 3) {
                    level = 3;
                }
                target.invulnerableTime = 0;
                target.hurt(DamageSource.playerAttack(Attacker), damage * ((level - 1) * 1.25f) + damage);
                target.invulnerableTime = 0;
                world.playSound(Attacker, Attacker.getX(), Attacker.getY(), Attacker.getZ(), SoundEvents.SHIELD_BREAK, SoundSource.NEUTRAL, 1.0F, 1.0F);
            }
        }
        return damage;
    }

    public Component getDisplayName(@Nonnull IToolStackView tool, int level) {
        if (level >= 3) return getDisplayName(3);
        return getDisplayName(level);
    }
}
