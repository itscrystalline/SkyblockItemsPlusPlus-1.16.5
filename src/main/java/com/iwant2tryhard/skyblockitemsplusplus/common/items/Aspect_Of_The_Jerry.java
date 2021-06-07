package com.iwant2tryhard.skyblockitemsplusplus.common.items;

import com.iwant2tryhard.skyblockitemsplusplus.common.entities.PlayerStats;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;

import javax.annotation.Nullable;
import java.util.List;

public class Aspect_Of_The_Jerry extends SwordItem {
    private static float manaUsage = 10f;
    public Aspect_Of_The_Jerry(IItemTier itemTier, int damage, float attackSpeed, Properties properties) {
        super(itemTier, damage, attackSpeed, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("\u00A77" + "True Damage: " + "\u00A7c" + "+1"));
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent("\u00A76" + "Item Ablity: Parley " + "\u00A7e" + "\u00A7l" + "RIGHT CLICK"));
        tooltip.add(new TranslationTextComponent("\u00A77" + "Channel your Inner Jerry!"));
        tooltip.add(new TranslationTextComponent("\u00A77" + "Mana Cost: " + "\u00A7b" + "50" + "\u00A77" + " (Mana Reduction -" + PlayerStats.getManaReductionPercent() + "\u00A77" + "%)"));
        tooltip.add(new TranslationTextComponent(""));
        tooltip.add(new TranslationTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new TranslationTextComponent("\u00A7l" +"COMMON SWORD"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity player, Hand hand) {
        if (Math.round(player.getFoodData().getFoodLevel() - manaUsage * ((100f - PlayerStats.getManaReductionPercent()) / 100f)) >= 0f)
        {
            Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("\u00A73" + "Used " + "\u00A76" + "Parley! " + "\u00A73" + "(" + Math.round(manaUsage * ((100f - PlayerStats.getManaReductionPercent()) / 100f)) + " Mana)"), false);

            player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - Math.round(manaUsage * ((100f - PlayerStats.getManaReductionPercent()) / 100f)));
            worldIn.playSound(player, player, SoundEvents.VILLAGER_AMBIENT,SoundCategory.NEUTRAL, 1.0f, 1.0f);
        }
        //return super.use(worldIn, player, hand);
        return ActionResult.success(player.getItemInHand(hand));
    }
}
