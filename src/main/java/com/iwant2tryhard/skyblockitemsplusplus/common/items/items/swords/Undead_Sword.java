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

public class Undead_Sword extends SwordItem {
    public Undead_Sword(IItemTier itemTier, int damage, float attackSpeed, Properties properties) {
        super(itemTier, damage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("\u00A77" + "Damage: " + "\u00A7c" + "+30"));
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent(ColorText.GRAY.toString() + "Deals " + ColorText.GREEN.toString() + "+100% " + ColorText.GRAY.toString() + "damage to"));
        tooltip.add(new TranslationTextComponent(ColorText.GRAY.toString() + "Skeletons, Withers,"));
        tooltip.add(new TranslationTextComponent(ColorText.GRAY.toString() + "Zombie Pigmen, and"));
        tooltip.add(new TranslationTextComponent(ColorText.GRAY.toString() + "Zombies."));
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new TranslationTextComponent("\u00A7l" +"COMMON SWORD"));
    }
}
