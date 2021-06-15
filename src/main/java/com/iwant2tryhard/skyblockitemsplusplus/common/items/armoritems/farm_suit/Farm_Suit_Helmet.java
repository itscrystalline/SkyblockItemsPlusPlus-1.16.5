package com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.PlayerStats;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Farm_Suit_Helmet extends ArmorItem {
    public Farm_Suit_Helmet(IArmorMaterial armorMaterial, EquipmentSlotType slotType, Properties properties) {
        super(armorMaterial, slotType, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A77" + "Defense: " + ColorText.GREEN.toString() + "+5"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent(ColorText.GOLD.toString() + "Full Set Bonus: Bonus Speed"));
        tooltip.add(new StringTextComponent(ColorText.GRAY.toString() + "Gain " + ColorText.WHITE.toString() + "Speed 3 " + ColorText.GRAY.toString() + "if over crops or farmland."));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new StringTextComponent("\u00A7l" +"COMMON HELMET"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
