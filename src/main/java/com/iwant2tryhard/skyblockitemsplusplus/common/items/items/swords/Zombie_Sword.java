package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.swords;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.PlayerStats;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Zombie_Sword extends SwordItem {
    private static int timesSinceDelay = 0;
    private static float manaUsage = 14f;
    private static float displayManaUsage = 70f;
    public Zombie_Sword(IItemTier itemTier, int damage, float attackSpeed, Properties properties) {
        super(itemTier, damage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("\u00A77" + "Damage: " + "\u00A7c" + "+100"));
        tooltip.add(new TranslationTextComponent("\u00A77" + "Strength: " + "\u00A7c" + "+50"));
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent("\u00A77" + "Mana Reduction: " + ColorText.GREEN.toString() + "+25%"));
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent(ColorText.GOLD.toString() + "Item Ability: Instant Heal " + ColorText.YELLOW.toString() + ColorText.BOLD.toString() + "RIGHT CLICK"));
        tooltip.add(new TranslationTextComponent(ColorText.GRAY.toString() + "Heal for " + ColorText.RED.toString() + "1 + 5% Health"));
        tooltip.add(new TranslationTextComponent(ColorText.GRAY.toString() + "Mana Cost: " + ColorText.AQUA.toString() + "70 " + ColorText.GRAY.toString() + "(Mana Reduction: -" + PlayerStats.getManaReductionPercent() + "%)"));
        tooltip.add(new TranslationTextComponent(ColorText.GRAY.toString() + "Charges: " + ColorText.YELLOW.toString() + "4  " + ColorText.GRAY.toString() + "/ " + ColorText.GREEN.toString() + "15s"));
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new TranslationTextComponent(ColorText.BLUE.toString() + "\u00A7l" +"RARE SWORD"));
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity player, Hand hand) {
        if (Math.round(player.getFoodData().getFoodLevel() - manaUsage * ((100f - PlayerStats.getManaReductionPercent()) / 100f)) >= 0f)
        {
            if (!player.getCooldowns().isOnCooldown(this))
            {
                if (timesSinceDelay >= 5)
                {
                    player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - Math.round(manaUsage * ((100f - PlayerStats.getManaReductionPercent()) / 100f)));
                    float healAmmt = 1f + (player.getMaxHealth() * 0.05f);
                    player.heal(1f + (player.getMaxHealth() * 0.05f));

                    Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty(ColorText.BOLD.toString() + ColorText.GREEN.toString() + "You used your " + ColorText.BLUE.toString() + "Zombie Sword " + ColorText.GREEN.toString() + "to heal yourself for " + healAmmt + " health! (" + Math.round(displayManaUsage * ((100f - PlayerStats.getManaReductionPercent()) / 100f)) + " Mana)"), false);
                    worldIn.playSound(player, player, SoundEvents.NOTE_BLOCK_BIT, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                    timesSinceDelay = 0;
                    player.getCooldowns().addCooldown(this, 300);
                    return ActionResult.success(player.getItemInHand(hand));
                }
                else
                {
                    player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - Math.round(manaUsage * ((100f - PlayerStats.getManaReductionPercent()) / 100f)));
                    float healAmmt = 1f + (player.getMaxHealth() * 0.05f);
                    player.heal(1f + (player.getMaxHealth() * 0.05f));

                    Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty(ColorText.BOLD.toString() + ColorText.GREEN.toString() + "You used your " + ColorText.BLUE.toString() + "Zombie Sword " + ColorText.GREEN.toString() + "to heal yourself for " + healAmmt + " health! (" + Math.round(displayManaUsage * ((100f - PlayerStats.getManaReductionPercent()) / 100f)) + " Mana)"), false);
                    worldIn.playSound(player, player, SoundEvents.NOTE_BLOCK_BIT, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                    timesSinceDelay++;
                    return ActionResult.success(player.getItemInHand(hand));
                }
            }
        }
        return ActionResult.fail(player.getItemInHand(hand));
    }
}
