package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.swords;

import com.iwant2tryhard.skyblockitemsplusplus.capabilities.CapabilityPlayerSkills;
import com.iwant2tryhard.skyblockitemsplusplus.capabilities.IPlayerSkills;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.other.PlayerStats;
import com.iwant2tryhard.skyblockitemsplusplus.common.util.CustomRarity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Aspect_Of_The_Jerry extends SwordItem {
    private static final float manaUsage = 10f;
    private static final float displayManaUsage = 50f;
    private final CustomRarity rarity;

    IPlayerSkills iskills = null;
    public Aspect_Of_The_Jerry(IItemTier itemTier, int damage, float attackSpeed, Properties properties, CustomRarity rarity) {
        super(itemTier, damage, attackSpeed, properties);
        this.rarity = rarity;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("\u00A77" + "True Damage: " + "\u00A7c" + "+1"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A76" + "Item Ablity: Parley " + "\u00A7e" + "\u00A7l" + "RIGHT CLICK"));
        tooltip.add(new StringTextComponent("\u00A77" + "Channel your Inner Jerry!"));
        tooltip.add(new StringTextComponent("\u00A77" + "Mana Cost: " + "\u00A7b" + "50 "/* + ColorText.GRAY + "(Mana Reduction: -" + iskills.getManaReductionPercent() + "%)"*/));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new StringTextComponent(rarity + "SWORD"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity player, Hand hand) {
        player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
            if (PlayerStats.isEnoughMana(manaUsage, skills.getManaReductionPercent(), skills.getUltWiseLvl(), player))
            {
                int foodLevel = PlayerStats.calcManaUsage(manaUsage, skills.getManaReductionPercent(), skills.getUltWiseLvl());
                Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("\u00A73" + "Used " + "\u00A76" + "Parley! " + "\u00A73" + "(" + (foodLevel * 5) + " Mana)"), false);

                player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - foodLevel);
                worldIn.playSound(player, player, SoundEvents.VILLAGER_AMBIENT,SoundCategory.NEUTRAL, 1.0f, 1.0f);
            }
        });
        //return super.use(worldIn, player, hand);
        return ActionResult.success(player.getItemInHand(hand));
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
