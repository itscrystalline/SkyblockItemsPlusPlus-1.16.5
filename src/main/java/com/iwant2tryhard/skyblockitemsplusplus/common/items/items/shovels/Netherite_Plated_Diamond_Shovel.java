package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.shovels;

import com.iwant2tryhard.skyblockitemsplusplus.common.util.CustomRarity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Netherite_Plated_Diamond_Shovel extends ShovelItem {
    private final CustomRarity rarity;
    public Netherite_Plated_Diamond_Shovel(IItemTier itemTier, float damage, float attackSpeed, Properties properties, CustomRarity rarity) {
        super(itemTier, damage, attackSpeed, properties);
        this.rarity = rarity;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A77" + "True Damage: " + "\u00A7c" + "+5.5"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new StringTextComponent(rarity + "SHOVEL"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
