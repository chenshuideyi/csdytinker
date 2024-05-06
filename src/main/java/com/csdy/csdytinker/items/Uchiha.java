package com.csdy.csdytinker.items;

import com.csdy.csdytinker.util.C;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

import static com.csdy.csdytinker.RainbowText.makeColour;
import static com.csdy.csdytinker.RainbowText.makeColour2;

public class Uchiha extends Item {
    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.valueOf("SWORD:BLOCK");
    }


    public Uchiha() {
        super(new Properties().tab(CsdyTab.CSDYTAB).stacksTo(1).fireResistant().rarity(Rarity.COMMON));
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(@NotNull ItemStack itemstack) {
        return false;
    }


    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, Level world, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(new TextComponent(C.GetColor("宇智波一族相传的神器")));
        list.add(new TextComponent(makeColour("宇智波一族的人可以用此反弹尾兽玉")));
        list.add(new TextComponent(makeColour2("by csdy")));
    }


    @Override
    public Item asItem() {
        return ItemsRegister.UCHIHA.get();
    }
}
