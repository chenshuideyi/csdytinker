package com.csdy.csdytinker.modifiers;

import com.csdy.csdytinker.modifiers.method.CsdyModifier;
import com.csdy.csdytinker.modifiers.method.GetModifier;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Random;

public class Performhebi extends CsdyModifier {
    public boolean isNoLevels() {
        return true;
    }

    @Override
    public int afterEntityHit(IToolStackView tool, int level, ToolAttackContext context, float damageDealt) {
        Player player = (Player) context.getAttacker();
        LivingEntity target = context.getLivingTarget();
        if (GetModifier.getMainHandModifier(player, this) > 0 && GetModifier.getOffHandLevel(player, this) > 0) {
            if (target != null) {
                Random random = new Random();
                int randomNum = random.nextInt(100) + 1;
                if (randomNum > 25) {
                    target.invulnerableTime = 0;
                    target.hurt(DamageSource.playerAttack(player), damageDealt);
                    if (randomNum > 70) {
                        target.invulnerableTime = 0;
                        target.hurt(DamageSource.playerAttack(player), damageDealt);
                        if (randomNum > 80) {
                            target.invulnerableTime = 0;
                            target.hurt(DamageSource.playerAttack(player), damageDealt);
                        }
                    }
                }

            }
        }
        return 0;
    }
}
