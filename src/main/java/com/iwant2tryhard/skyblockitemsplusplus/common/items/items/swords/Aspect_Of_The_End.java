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
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Aspect_Of_The_End extends SwordItem {
    private static float manaUsage = 10f;
    private static float displayManaUsage = 50f;
    public Aspect_Of_The_End(IItemTier itemTier, int damage, float attackSpeed, Properties properties) {
        super(itemTier, damage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("\u00A77" + "Damage: " + "\u00A7c" + "+100"));
        tooltip.add(new TranslationTextComponent("\u00A77" + "Strength: " + "\u00A7c" + "+100"));
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent("\u00A76" + "Item Ablity: Instant Transmission " + "\u00A7e" + "\u00A7l" + "RIGHT CLICK"));
        tooltip.add(new TranslationTextComponent("\u00A77" + "Teleport " + ColorText.GREEN.toString() + "8 blocks " + ColorText.GRAY.toString() + "ahead of"));
        tooltip.add(new TranslationTextComponent(ColorText.GRAY.toString() + "you and gain " + ColorText.WHITE.toString() + "Speed 5"));
        tooltip.add(new TranslationTextComponent(ColorText.GRAY.toString() + "for " + ColorText.GREEN.toString() + "3 seconds."));
        tooltip.add(new TranslationTextComponent(ColorText.GRAY.toString() + "Mana Cost: " + ColorText.AQUA.toString() + "50 " + ColorText.GRAY.toString() + "(Mana Reduction: -" + PlayerStats.getManaReductionPercent() + "%)"));
        tooltip.add(new TranslationTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new TranslationTextComponent(ColorText.BLUE + "\u00A7l" +"RARE SWORD"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity player, Hand hand) {
        if (Math.round(player.getFoodData().getFoodLevel() - manaUsage * ((100f - PlayerStats.getManaReductionPercent()) / 100f)) >= 0f)
        {
            player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - Math.round(manaUsage * ((100f - PlayerStats.getManaReductionPercent()) / 100f)));

            Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("\u00A73" + "Used " + "\u00A76" + "Instant Transmission! " + "\u00A73" + "(" + Math.round(displayManaUsage * ((100f - PlayerStats.getManaReductionPercent()) / 100f)) + " Mana)"), false);

            player.setPos(player.position().x + player.getLookAngle().x * 8,
                    player.position().y + player.getLookAngle().y * 8,
                    player.position().z + player.getLookAngle().z * 8);

            player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 60, 4));
            worldIn.playSound(player, player, SoundEvents.ENDERMAN_TELEPORT,SoundCategory.NEUTRAL, 1.0f, 1.0f);
        }
        //return super.use(worldIn, player, hand);
        return ActionResult.success(player.getItemInHand(hand));
    }
}
