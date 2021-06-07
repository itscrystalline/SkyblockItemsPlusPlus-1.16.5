package com.iwant2tryhard.skyblockitemsplusplus.common.items;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class RefinedNetheriteBlockItem extends BlockItem {
    public RefinedNetheriteBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("\u00A7c" + "\u00A7o" + "Wow!, If you have obtained this item legitimately in survival"));
        tooltip.add(new TranslationTextComponent("\u00A7c" + "\u00A7o" + "Then I applaud your dedication towards getting this item."));
        tooltip.add(new TranslationTextComponent("\u00A7c" + "\u00A7o" + "Now, I challenge you to make a full refined netherite beacon!"));
        tooltip.add(new TranslationTextComponent("\u00A7c" + "\u00A7o" + "-IWant2TryHard"));
        tooltip.add(new TranslationTextComponent("\u00A7c" + "\u00A7l" + "SUPREME"));
    }
}
