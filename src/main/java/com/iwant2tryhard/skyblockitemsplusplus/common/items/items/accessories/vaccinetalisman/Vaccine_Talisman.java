package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.accessories.vaccinetalisman;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.accessories.main.AccessoryItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Vaccine_Talisman extends AccessoryItem {
    public Vaccine_Talisman(Properties properties, int defenseBoost, int healthBoost, int speedBoost, float manaReductionPercent, int strengthBoost) {
        super(properties, defenseBoost, healthBoost, speedBoost, manaReductionPercent, strengthBoost);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
        if (entityIn instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) entityIn;
            if (player.hasEffect(Effects.POISON))
            {
                player.removeEffect(Effects.POISON);
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> text, ITooltipFlag toolTip) {
        text.add(new StringTextComponent(ColorText.GRAY + "Provides immunity to " + ColorText.BLUE + "Poison"));
        text.add(new StringTextComponent(ColorText.GRAY + "damage when held."));
        text.add(new StringTextComponent(""));
        text.add(new StringTextComponent(ColorText.GRAY + "This item can be reforged!"));
        text.add(new StringTextComponent(ColorText.BOLD.toString() + "COMMON ACCESSORY"));
        super.appendHoverText(stack, world, text, toolTip);
    }
}
