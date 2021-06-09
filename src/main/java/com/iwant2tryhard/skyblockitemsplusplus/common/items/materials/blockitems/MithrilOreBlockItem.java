package com.iwant2tryhard.skyblockitemsplusplus.common.items.materials.blockitems;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MithrilOreBlockItem extends BlockItem {
    public MithrilOreBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("\u00A7a" + "\u00A7l" + "UNCOMMON"));
    }
}
