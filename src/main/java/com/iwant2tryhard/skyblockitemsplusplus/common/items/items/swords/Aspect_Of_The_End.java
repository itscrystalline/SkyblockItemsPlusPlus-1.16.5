package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.swords;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.PlayerStats;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.EnchantmentInit;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Aspect_Of_The_End extends SwordItem {
    private final float manaUsage = 10f/* * ((EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), this.asItem().getDefaultInstance()) * 10) / 100)*/;
    private final float displayManaUsage = 50f/* * ((EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), this.asItem().getDefaultInstance()) * 10) / 100)*/;
    //private static String oneForAllText = ColorText.LIGHT_PURPLE.toString() + "(+20)";
    //boolean hasOneForAll = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ONE_FOR_ALL.get(), this.asItem().getDefaultInstance()) > 0;
    public Aspect_Of_The_End(IItemTier itemTier, int damage, float attackSpeed, Properties properties) {
        super(itemTier, damage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A77" + "Damage: " + "\u00A7c" + "+100"/* + (hasOneForAll ? oneForAllText : "")*/));
        tooltip.add(new StringTextComponent("\u00A77" + "Strength: " + "\u00A7c" + "+100"));
        tooltip.add(new StringTextComponent(""));
        //tooltip.add(new StringTextComponent(ItemStack.appendEnchantmentNames();
        //tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A76" + "Item Ablity: Instant Transmission " + "\u00A7e" + "\u00A7l" + "RIGHT CLICK"));
        tooltip.add(new StringTextComponent("\u00A77" + "Teleport " + ColorText.GREEN + "8 blocks " + ColorText.GRAY + "ahead of"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "you and gain " + ColorText.WHITE + "Speed 5"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "for " + ColorText.GREEN + "3 seconds."));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Mana Cost: " + ColorText.AQUA + displayManaUsage + " " + ColorText.GRAY + "(Mana Reduction: -" + PlayerStats.getManaReductionPercent() + "%)"));
        tooltip.add(new StringTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new StringTextComponent(ColorText.BLUE + "\u00A7l" +"RARE SWORD"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity player, Hand hand) {
        if (PlayerStats.isEnoughMana(manaUsage, player))
        {
            int foodLevel = PlayerStats.calcManaUsage(manaUsage, player);
            player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - foodLevel);

            Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("\u00A73" + "Used " + "\u00A76" + "Instant Transmission! " + "\u00A73" + "(" + (foodLevel * 5) + " Mana)"), false);

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
