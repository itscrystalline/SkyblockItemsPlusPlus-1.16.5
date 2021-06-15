package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.pickaxes;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Netherite_Plated_Diamond_Pickaxe extends PickaxeItem {
    public Netherite_Plated_Diamond_Pickaxe(IItemTier itemTier, int damage, float attackSpeed, Properties properties) {
        super(itemTier, damage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A77" + "True Damage: " + "\u00A7c" + "+5"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new StringTextComponent(ColorText.BLUE.toString() + "\u00A7l" + "RARE PICKAXE"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
