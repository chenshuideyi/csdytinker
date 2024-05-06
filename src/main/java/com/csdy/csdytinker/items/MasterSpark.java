package com.csdy.csdytinker.items;

import com.csdy.csdytinker.RainbowText;
import com.csdy.csdytinker.util.C;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.jetbrains.annotations.NotNull;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.DeathScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import java.util.*;

import static com.csdy.csdytinker.RainbowText.*;

public class MasterSpark extends Item {
    public MasterSpark() {
        super(new Properties().tab(CsdyTab.CSDYTAB).stacksTo(1).fireResistant().rarity(Rarity.COMMON));
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public boolean isFoil(@NotNull ItemStack itemstack) {
        return true;
    }
    private static final Set<String> name = new HashSet();
    private static boolean isName(Entity entity) {
        return name.contains(entity.getName());
    }
    public static Set<String> getName() {
        return Collections.singleton(RainbowText.makeColour("终极棱镜"));
    }//我也不知道这是啥意思,删了完全不影响。不知道我之战怎么设计的

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onRender(RenderTooltipEvent.Color event){
        if (event.getItemStack().getItem().equals(ItemsRegister.MASTERSPARK.get())) {
            event.setBackgroundStart(new Random().nextInt());
            event.setBackgroundEnd(new Random().nextInt());
            event.setBorderStart(new Random().nextInt());
            event.setBorderEnd(new Random().nextInt());
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack itemstack, Level world, @NotNull List<Component> list, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);
        list.add(new TextComponent(makeColour("发射分束生命彩虹")));
        list.add(new TextComponent(C.GetColor("但这里不是泰拉瑞亚")));
        list.add(new TextComponent(makeColour2("by csdy")));
    }

    private static long milliTime() {
        return System.nanoTime() / 10000000L;
    }
    @Override
    public boolean isBarVisible(@NotNull ItemStack itemStack) {
        return true;
    }

    @Override
    public int getBarWidth(@NotNull ItemStack p_150900_) {
        return 13;
    }

    @Override
    public int getBarColor(@NotNull ItemStack p_150901_) {
        Random random = new Random(milliTime());
        return random.nextInt();
    }

    @Override
    public Item asItem() {
        return ItemsRegister.MASTERSPARK.get();
    }
    public void inventoryTick(ItemStack p_41404_, Level p_41405_, Entity p_41406_, int p_41407_, boolean p_41408_) {
        super.inventoryTick(p_41404_, p_41405_, p_41406_, p_41407_, p_41408_);
        p_41404_.setHoverName(new TextComponent(makeColour5("最终棱镜")));

    }
}
