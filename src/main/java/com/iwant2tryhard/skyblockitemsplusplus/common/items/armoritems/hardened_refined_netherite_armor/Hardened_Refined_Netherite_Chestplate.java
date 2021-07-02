package com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.hardened_refined_netherite_armor;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.util.CustomRarity;
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

public class Hardened_Refined_Netherite_Chestplate extends ArmorItem {
    private final CustomRarity rarity;
    public Hardened_Refined_Netherite_Chestplate(IArmorMaterial armorMaterial, EquipmentSlotType slotType, Properties properties, CustomRarity rarity) {
        super(armorMaterial, slotType, properties);
        this.rarity = rarity;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A77" + "Defense: " + ColorText.GREEN + "+1800"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent(ColorText.GOLD + "Full Set Bonus: Power of The Netherite"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Gain a " + ColorText.RED + " +40% Boost " + ColorText.GRAY + "on ALL netherite items in your inventory."));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent(ColorText.GOLD + "Piece Bonus: Heavy"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Fall damage is added by " + ColorText.BLUE + "+50%" + ColorText.GRAY + " per piece; Max: " + ColorText.BLUE + "+200%"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new StringTextComponent(rarity + "CHESTPLATE"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
    @Override
    public boolean isFoil(ItemStack p_77636_1_) {
        return true;
    }
}
