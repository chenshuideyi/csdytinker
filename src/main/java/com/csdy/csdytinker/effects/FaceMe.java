package com.csdy.csdytinker.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class FaceMe extends MobEffect {
    public FaceMe(){
        super( MobEffectCategory.BENEFICIAL, 0xff9900);
        this.addAttributeModifier(Attributes.ARMOR, "1-2-3-4-5", -50000000, AttributeModifier.Operation.ADDITION);
        this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "1-2-3-4-5", -50000000, AttributeModifier.Operation.ADDITION);
    }
}
