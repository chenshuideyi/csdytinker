package com.csdy.csdytinker;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//自定义死亡文本，默认death.attack.{你设置的伤害类型}，无来源后缀.sourceless，自杀后缀.suicide，凶器有自定义名字时额外后缀.item
//写文本时%1$s-死者，%2$s-伤害来源，%3$s凶器名字
public class FlexibleDamageSource extends DamageSource {

    @Getter
    private boolean bypassEverything = false;

    public FlexibleDamageSource bypassEverything() {
        this.bypassEverything = true;
        return this;
    }

    public FlexibleDamageSource(String msgId) {
        this(msgId, null);
    }

    public FlexibleDamageSource(String msgId, @Nullable Entity source) {
        super(msgId);
        entity = source;
    }

    private final @Nullable Entity entity;


    @Override
    public @Nullable Entity getEntity() {
        return entity;
    }

    @Override
    public @NotNull Component getLocalizedDeathMessage(@NotNull LivingEntity dead) {
        ItemStack item = this.entity instanceof LivingEntity ? ((LivingEntity) this.entity).getMainHandItem() : ItemStack.EMPTY;
        String subType;

        if (entity == null) {
            subType = ".sourceless";
        } else if (entity == dead) {
            subType = ".suicide";
        } else {
            subType = "";
        }
        if (!item.isEmpty() && item.hasCustomHoverName()) {
            subType = subType + ".item";
        }
        String key = "death.attack." + this.msgId + subType;

        Component deadName, sourceName, itemName;
        deadName = dead.getDisplayName();
        sourceName = this.entity != null ? entity.getDisplayName() : new TextComponent("");
        itemName = item.hasCustomHoverName() ? item.getDisplayName() : new TextComponent("");

        return new TranslatableComponent(key, deadName, sourceName, itemName);
    }

    @Override
    public @Nullable Vec3 getSourcePosition() {
        if (entity == null) return null;
        return this.entity.position();
    }

    @Override
    public @NotNull String toString() {
        return "FlexibleDamageSource (" + msgId + (entity == null ? "" : "," + this.entity) + ")";
    }
}
