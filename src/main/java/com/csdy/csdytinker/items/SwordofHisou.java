package com.csdy.csdytinker.items;

import com.csdy.csdytinker.RainbowText;
import com.csdy.csdytinker.util.C;
import com.csdy.csdytinker.items.ItemsRegister;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.*;

import java.util.List;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;

import static com.csdy.csdytinker.RainbowText.*;

public class SwordofHisou extends Item {
    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.valueOf("SWORD:BLOCK");
    }


    public SwordofHisou() {
        super(new Properties().tab(CsdyTab.CSDYTAB).stacksTo(1).fireResistant().rarity(Rarity.COMMON));
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(@NotNull ItemStack itemstack) {
        return true;
    }


    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, Level world, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(new TextComponent(makeColour3("据说只有能看破灵魂所有的“气质”的比那名家族的天人才能使用")));
        list.add(new TextComponent(makeColour2("by csdy")));
    }

    public static Set<String> getName() {
        return Collections.singleton(RainbowText.makeColour("绯想剑"));
    }
    /**private static long milliTime() {
     //    return System.nanoTime() / 10000000L;
     //}
     @Override public boolean isBarVisible(@NotNull ItemStack itemStack) {
     return true;
     }

     @Override public int getBarWidth(@NotNull ItemStack p_150900_) {
     return 13;
     }

     //@Override
     //public int getBarColor(@NotNull ItemStack p_150901_) {
     //    Random random = new Random(milliTime());
     //    return random.nextInt();
     //}

     @Override public Item asItem() {
     return ItemsRegister.SWORDOFHISOU.get();
     }*/
}
