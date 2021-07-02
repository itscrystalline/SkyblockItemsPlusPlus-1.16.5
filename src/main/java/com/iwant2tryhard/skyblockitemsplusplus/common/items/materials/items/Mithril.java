package com.iwant2tryhard.skyblockitemsplusplus.common.items.materials.items;

import com.iwant2tryhard.skyblockitemsplusplus.common.util.CustomRarity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Mithril extends Item {
    private final CustomRarity rarity;
    public Mithril(Properties properties, CustomRarity rarity) {
        super(properties);
        this.rarity = rarity;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new StringTextComponent("\u00A77" + "\u00A7o" + "The men called it \"true-silver\" while the"));
        tooltip.add(new StringTextComponent("\u00A77" + "\u00A7o" + "Dwarves, that, live deep in the caverns, who"));
        tooltip.add(new StringTextComponent("\u00A77" + "\u00A7o" + "loved it above all other things, had their"));
        tooltip.add(new StringTextComponent("\u00A77" + "\u00A7o" + "own, secret name for it."));
        tooltip.add(new StringTextComponent(rarity.toString()));
    }
}
