package com.csdy.csdytinker.modifiers;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.impl.NoLevelsModifier;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;

import java.util.Random;

public class Reliable extends NoLevelsModifier {
    @Override
    public int onDamageTool(IToolStackView tool, int level, int amount, @javax.annotation.Nullable LivingEntity holder) {
        if (holder != null) {
            float health= holder.getHealth();
            float maxhealth = holder.getMaxHealth();
            float percentage =health/maxhealth;
            if (percentage>= 0.9){
                Random random = new Random();
                int randomNum = random.nextInt(10)+1;
                if (randomNum <= 9) return 0;
                else return 4;
            }
            else return 4;
        }
        return 1;
    }
}
