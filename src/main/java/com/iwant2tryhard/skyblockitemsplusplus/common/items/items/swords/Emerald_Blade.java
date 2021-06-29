package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.swords;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.other.PlayerStats;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Emerald_Blade extends SwordItem {
    //private static String oneForAllText = ColorText.LIGHT_PURPLE.toString() + "(+20)";
    //boolean hasOneForAll = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ONE_FOR_ALL.get(), this.asItem().getDefaultInstance()) > 0;
    public Emerald_Blade(IItemTier itemTier, int damage, float attackSpeed, Properties properties) {
        super(itemTier, damage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new StringTextComponent("\u00A77" + "Damage: " + "\u00A7c" + "+" + (130f + PlayerStats.calcEmeraldBladeBoost()) + ColorText.GREEN + " (+" + PlayerStats.calcEmeraldBladeBoost() + ")"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "A powerful blade made from pure"));
        tooltip.add(new StringTextComponent(ColorText.GREEN + "Emeralds" + ColorText.GRAY + ". This blade becomes"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "stronger as you carry more"));
        tooltip.add(new StringTextComponent(ColorText.GREEN + "emeralds" + ColorText.GRAY + " in your inventory."));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Current damage bonus: " + ColorText.GREEN + (PlayerStats.calcEmeraldBladeBoost())));
        tooltip.add(new StringTextComponent(ColorText.YELLOW + "Hold " + ColorText.BOLD + ColorText.YELLOW + "SHIFT " + ColorText.YELLOW + "for more information"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new StringTextComponent(ColorText.DARK_PURPLE + "\u00A7l" + "EPIC SWORD"));
    }
}
