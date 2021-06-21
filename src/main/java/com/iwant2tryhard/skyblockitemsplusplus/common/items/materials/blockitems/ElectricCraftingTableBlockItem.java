package com.iwant2tryhard.skyblockitemsplusplus.common.items.materials.blockitems;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ElectricCraftingTableBlockItem extends BlockItem {
    public ElectricCraftingTableBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new StringTextComponent(ColorText.GREEN + "\u00A7l" + "UNCOMMON"));
    }
}
