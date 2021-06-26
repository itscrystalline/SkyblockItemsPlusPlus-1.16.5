package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.swords;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ClientUtils;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.PlayerStats;
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

public class Ornate_Zombie_Sword extends SwordItem {
    private static int timesSinceDelay = 0;
    private static final float manaUsage = 14f;
    private static final float displayManaUsage = 70f;
    //private static String oneForAllText = ColorText.LIGHT_PURPLE.toString() + "(+20)";
    //boolean hasOneForAll = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ONE_FOR_ALL.get(), this.asItem().getDefaultInstance()) > 0;
    public Ornate_Zombie_Sword(IItemTier itemTier, int damage, float attackSpeed, Properties properties) {
        super(itemTier, damage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new StringTextComponent("\u00A77" + "Damage: " + "\u00A7c" + "+110"));
        tooltip.add(new StringTextComponent("\u00A77" + "Strength: " + "\u00A7c" + "+60"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A77" + "Mana Reduction: " + ColorText.GREEN + "+25%"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent(ColorText.GOLD + "Item Ability: Instant Heal " + ColorText.YELLOW + ColorText.BOLD + "RIGHT CLICK"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Heal for " + ColorText.RED + "1.5 + 10% Health"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Mana Cost: " + ColorText.AQUA + "70 " + ColorText.GRAY + "(Mana Reduction: -" + PlayerStats.getManaReductionPercent() + "%)"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Charges: " + ColorText.YELLOW + "5  " + ColorText.GRAY + "/ " + ColorText.GREEN + "15s"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new StringTextComponent(ColorText.DARK_PURPLE + "\u00A7l" +"EPIC SWORD"));
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
                    float healAmmt = 1.5f + (player.getMaxHealth() * 0.1f);
                    player.heal(1.5f + (player.getMaxHealth() * 0.1f));

                    Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty(ColorText.BOLD.toString() + ColorText.GREEN + "You used your " + ColorText.DARK_PURPLE + "Ornate Zombie Sword " + ColorText.GREEN + "to heal yourself for " + healAmmt + " health! (" + (foodLevel * 5) + " Mana)"), false);
                    worldIn.playSound(player, player, SoundEvents.NOTE_BLOCK_BIT, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                    timesSinceDelay = 0;
                    player.getCooldowns().addCooldown(this, 300);
                    return ActionResult.success(player.getItemInHand(hand));
                }
                else
                {
                    player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - foodLevel);
                    float healAmmt = 1.5f + (player.getMaxHealth() * 0.1f);
                    player.heal(1.5f + (player.getMaxHealth() * 0.1f));

                    ClientUtils.SendPrivateMessage(ColorText.BOLD.toString() + ColorText.GREEN + "You used your " + ColorText.DARK_PURPLE + "Ornate Zombie Sword " + ColorText.GREEN + "to heal yourself for " + healAmmt + " health! (" + (foodLevel * 5) + " Mana)");
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
