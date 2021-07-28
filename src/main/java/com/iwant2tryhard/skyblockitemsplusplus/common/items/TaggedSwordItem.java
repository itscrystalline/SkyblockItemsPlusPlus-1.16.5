package com.iwant2tryhard.skyblockitemsplusplus.common.items;

import com.iwant2tryhard.skyblockitemsplusplus.common.util.CustomRarity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class TaggedSwordItem extends SwordItem {
    public final CustomRarity rarity;

    public TaggedSwordItem(IItemTier p_i48460_1_, int p_i48460_2_, float p_i48460_3_, Properties p_i48460_4_, CustomRarity rarity) {
        super(p_i48460_1_, p_i48460_2_, p_i48460_3_, p_i48460_4_);
        this.rarity = rarity;
    }


    @Override
    public ITextComponent getName(ItemStack p_200295_1_) {
        return new StringTextComponent(CustomRarity.getColorId(rarity).getString() + super.getName(p_200295_1_).getString());
    }
}
