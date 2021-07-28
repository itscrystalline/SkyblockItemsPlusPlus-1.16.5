package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.swords;

import com.iwant2tryhard.skyblockitemsplusplus.capabilities.playerskills.CapabilityPlayerSkills;
import com.iwant2tryhard.skyblockitemsplusplus.capabilities.playerskills.IPlayerSkills;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.TaggedSwordItem;
import com.iwant2tryhard.skyblockitemsplusplus.common.util.CustomRarity;
import com.sun.corba.se.spi.ior.TaggedComponentBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Emerald_Blade extends TaggedSwordItem {

    IPlayerSkills iskills;
    //private static String oneForAllText = ColorText.LIGHT_PURPLE.toString() + "(+20)";
    //boolean hasOneForAll = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ONE_FOR_ALL.get(), this.asItem().getDefaultInstance()) > 0;
    public Emerald_Blade(IItemTier itemTier, int damage, float attackSpeed, Properties properties, CustomRarity rarity) {
        super(itemTier, damage, attackSpeed, properties, rarity);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new StringTextComponent("\u00A77" + "Damage: " + "\u00A7c" + "+" + (130f/* + PlayerStats.calcEmeraldBladeBoost(iskills.getCoins())*/) + ColorText.GREEN + " (+" /*+ PlayerStats.calcEmeraldBladeBoost(iskills.getCoins())*/ + ")"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "A powerful blade made from pure"));
        tooltip.add(new StringTextComponent(ColorText.GREEN + "Emeralds" + ColorText.GRAY + ". This blade becomes"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "stronger as you carry more"));
        tooltip.add(new StringTextComponent(ColorText.GREEN + "emeralds" + ColorText.GRAY + " in your inventory."));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Current damage bonus: "/* + ColorText.GREEN + (PlayerStats.calcEmeraldBladeBoost(iskills.getCoins())))*/));
        tooltip.add(new StringTextComponent(ColorText.YELLOW + "Hold " + ColorText.BOLD + ColorText.YELLOW + "SHIFT " + ColorText.YELLOW + "for more information"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new StringTextComponent(rarity + "SWORD"));
    }

    @Override
    public void inventoryTick(ItemStack p_77663_1_, World p_77663_2_, Entity player, int p_77663_4_, boolean p_77663_5_) {
        super.inventoryTick(p_77663_1_, p_77663_2_, player, p_77663_4_, p_77663_5_);
        if (player instanceof PlayerEntity)
        {
            ((PlayerEntity) player).getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                iskills = skills;
            });
        }
    }
}
