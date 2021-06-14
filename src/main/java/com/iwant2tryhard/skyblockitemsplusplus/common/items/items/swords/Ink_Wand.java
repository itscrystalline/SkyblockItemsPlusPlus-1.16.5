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

public class Ink_Wand extends SwordItem {
    private static float manaUsage = 12f;
    private static float displayManaUsage = 60f;
    public Ink_Wand(IItemTier itemTier, int damage, float attackSpeed, Properties properties) {
        super(itemTier, damage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("\u00A77" + "Damage: " + "\u00A7c" + "+130"));
        tooltip.add(new TranslationTextComponent("\u00A77" + "Strength: " + "\u00A7c" + "+90"));
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent("\u00A76" + "Item Ablity: Ink Bomb " + "\u00A7e" + "\u00A7l" + "RIGHT CLICK"));
        tooltip.add(new TranslationTextComponent("\u00A77" + "Shoot an ink bomb in front of"));
        tooltip.add(new TranslationTextComponent("\u00A77" + "you dealing " + ColorText.GREEN.toString() + "10000 + " + ( (PlayerStats.getManaReductionPercent() * 10) + 100 ) + ColorText.GRAY.toString() + " damage"));
        tooltip.add(new TranslationTextComponent("\u00A77" + "and giving blindness!"));
        tooltip.add(new TranslationTextComponent(ColorText.GRAY.toString() + "Mana Cost: " + ColorText.AQUA.toString() + "50 " + ColorText.GRAY.toString() + "(Mana Reduction: -" + PlayerStats.getManaReductionPercent() + "%)"));
        tooltip.add(new TranslationTextComponent(ColorText.GRAY.toString() + "Cooldown: " + ColorText.GREEN.toString() + "30s"));
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new TranslationTextComponent(ColorText.DARK_PURPLE.toString() + "\u00A7l" +"EPIC SWORD"));
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity player, Hand hand) {
        if (Math.round(player.getFoodData().getFoodLevel() - manaUsage * ((100f - PlayerStats.getManaReductionPercent()) / 100f)) >= 0f)
        {
            if (!player.getCooldowns().isOnCooldown(this))
            {
                player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - Math.round(manaUsage * ((100f - PlayerStats.getManaReductionPercent()) / 100f)));

                Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("\u00A73" + "Used " + "\u00A76" + "Ink Bomb! " + "\u00A73" + "(" + Math.round(displayManaUsage * ((100f - PlayerStats.getManaReductionPercent()) / 100f)) + " Mana)"), false);
                worldIn.playSound(player, player, SoundEvents.SQUID_SQUIRT, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                player.getCooldowns().addCooldown(this, 600);
                damageItem(this.getItem().getDefaultInstance(), 1, player, null);
                return ActionResult.success(player.getItemInHand(hand));
            }
        }
        //return super.use(worldIn, player, hand);
        return ActionResult.fail(player.getItemInHand(hand));
    }
}
