package com.iwant2tryhard.skyblockitemsplusplus.common.items;

import com.iwant2tryhard.skyblockitemsplusplus.common.util.CustomRarity;
import net.minecraft.item.BowItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class TaggedBowItem extends BowItem {
    public final CustomRarity rarity;

    public TaggedBowItem(Properties p_i48522_1_, CustomRarity rarity) {
        super(p_i48522_1_);
        this.rarity = rarity;
    }


    @Override
    public ITextComponent getName(ItemStack p_200295_1_) {
        return new StringTextComponent(CustomRarity.getColorId(rarity).getString() + super.getName(p_200295_1_).getString());
    }
}
