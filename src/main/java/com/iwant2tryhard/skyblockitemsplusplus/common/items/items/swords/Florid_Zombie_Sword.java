package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.swords;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.other.PlayerStats;
import com.iwant2tryhard.skyblockitemsplusplus.common.util.CustomRarity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Florid_Zombie_Sword extends SwordItem {
    private final CustomRarity rarity;
    private static int timesSinceDelay = 0;
    private final float manaUsage = 14f/* * ((EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), this.asItem().getDefaultInstance()) * 10) / 100)*/;
    private final float displayManaUsage = 70f/* * ((EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), this.asItem().getDefaultInstance()) * 10) / 100)*/;
    //private static String oneForAllText = ColorText.LIGHT_PURPLE.toString() + "(+20)";
    //boolean hasOneForAll = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ONE_FOR_ALL.get(), this.asItem().getDefaultInstance()) > 0;
    public Florid_Zombie_Sword(IItemTier itemTier, int damage, float attackSpeed, Properties properties, CustomRarity rarity) {
        super(itemTier, damage, attackSpeed, properties);
        this.rarity = rarity;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new StringTextComponent("\u00A77" + "Damage: " + "\u00A7c" + "+150"));
        tooltip.add(new StringTextComponent("\u00A77" + "Strength: " + "\u00A7c" + "+80"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A77" + "Mana Reduction: " + ColorText.GREEN + "+50%"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent(ColorText.GOLD + "Item Ability: Instant Heal " + ColorText.YELLOW + ColorText.BOLD + "RIGHT CLICK"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Heal for " + ColorText.RED + "2 + 15% Health"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Mana Cost: " + ColorText.AQUA + displayManaUsage + "" + ColorText.GRAY + "(Mana Reduction: -" + PlayerStats.getManaReductionPercent() + "%)"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Charges: " + ColorText.YELLOW + "5  " + ColorText.GRAY + "/ " + ColorText.GREEN + "15s"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new StringTextComponent(rarity + "SWORD"));
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity player, Hand hand) {
        if (PlayerStats.isEnoughMana(manaUsage, player))
        {
            int foodLevel = PlayerStats.calcManaUsage(manaUsage);
            if (!player.getCooldowns().isOnCooldown(this))
            {
                if (timesSinceDelay >= 8)
                {
                    player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - foodLevel);
                    float healAmmt = 2f + (player.getMaxHealth() * 0.15f);
                    player.heal(2f + (player.getMaxHealth() * 0.15f));

                    Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty(ColorText.BOLD.toString() + ColorText.GREEN + "You used your " + ColorText.GOLD + "Florid Zombie Sword " + ColorText.GREEN + "to heal yourself for " + healAmmt + " health! (" + (foodLevel * 5) + " Mana)"), false);
                    worldIn.playSound(player, player, SoundEvents.NOTE_BLOCK_BIT, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                    timesSinceDelay = 0;
                    player.getCooldowns().addCooldown(this, 300);
                    return ActionResult.success(player.getItemInHand(hand));
                }
                else
                {
                    player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - foodLevel);
                    float healAmmt = 2f + (player.getMaxHealth() * 0.15f);
                    player.heal(2f + (player.getMaxHealth() * 0.15f));

                    Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty(ColorText.BOLD.toString() + ColorText.GREEN + "You used your " + ColorText.GOLD + "Florid Zombie Sword " + ColorText.GREEN + "to heal yourself for " + healAmmt + " health! (" + (foodLevel * 5) + " Mana)"), false);
                    worldIn.playSound(player, player, SoundEvents.NOTE_BLOCK_BIT, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                    timesSinceDelay++;
                    return ActionResult.success(player.getItemInHand(hand));
                }
            }
            return ActionResult.fail(player.getItemInHand(hand));
        }
        return ActionResult.fail(player.getItemInHand(hand));
    }
}
