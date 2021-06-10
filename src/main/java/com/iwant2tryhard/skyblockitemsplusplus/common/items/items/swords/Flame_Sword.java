package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.swords;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Flame_Sword extends SwordItem {
    public Flame_Sword(IItemTier itemTier, int damage, float attackSpeed, Properties properties) {
        super(itemTier, damage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("\u00A77" + "Damage: " + "\u00A7c" + "+50"));
        tooltip.add(new TranslationTextComponent("\u00A77" + "Strength: " + "\u00A7c" + "+20"));
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent(ColorText.GRAY.toString() + "Ignites enemies for " + ColorText.GREEN.toString() + "3s " + ColorText.GRAY.toString() + "."));
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new TranslationTextComponent(ColorText.GREEN.toString() + "\u00A7l" +"UNCOMMON SWORD"));
    }
}
