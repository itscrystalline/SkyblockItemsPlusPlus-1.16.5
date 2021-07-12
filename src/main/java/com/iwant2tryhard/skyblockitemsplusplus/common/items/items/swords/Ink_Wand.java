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
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Ink_Wand extends SwordItem {
    private static final float manaUsage = 12f;
    private static final float displayManaUsage = 60f;
    private final CustomRarity rarity;

    IPlayerSkills iskills;
    //private static String oneForAllText = ColorText.LIGHT_PURPLE.toString() + "(+20)";
    //boolean hasOneForAll = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ONE_FOR_ALL.get(), this.asItem().getDefaultInstance()) > 0;
    public Ink_Wand(IItemTier itemTier, int damage, float attackSpeed, Properties properties, CustomRarity rarity) {
        super(itemTier, damage, attackSpeed, properties);
        this.rarity = rarity;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new StringTextComponent("\u00A77" + "Damage: " + "\u00A7c" + "+130"));
        tooltip.add(new StringTextComponent("\u00A77" + "Strength: " + "\u00A7c" + "+90"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A76" + "Item Ablity: Ink Bomb " + "\u00A7e" + "\u00A7l" + "RIGHT CLICK"));
        tooltip.add(new StringTextComponent("\u00A77" + "Shoot an ink bomb in front of"));
        tooltip.add(new StringTextComponent("\u00A77" + "you dealing " + ColorText.GREEN + "10000"/* + " + ( (iskills.getManaReductionPercent() * 10) + 100 ) + ColorText.GRAY + " damage")*/));
        tooltip.add(new StringTextComponent("\u00A77" + "and giving blindness!"));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Mana Cost: " + ColorText.AQUA + "50 "/* + ColorText.GRAY + "(Mana Reduction: -" + iskills.getManaReductionPercent() + "%)"*/));
        tooltip.add(new StringTextComponent(ColorText.GRAY + "Cooldown: " + ColorText.GREEN + "30s"));
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new StringTextComponent(rarity + "SWORD"));
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity player, Hand hand) {
        player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
            if (PlayerStats.isEnoughMana(manaUsage, skills.getManaReductionPercent(), skills.getUltWiseLvl(), player))
            {
                int foodLevel = PlayerStats.calcManaUsage(manaUsage, skills.getManaReductionPercent(), skills.getUltWiseLvl());
                if (!player.getCooldowns().isOnCooldown(this))
                {
                    player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - foodLevel);

                    Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("\u00A73" + "Used " + "\u00A76" + "Ink Bomb! " + "\u00A73" + "(" + (foodLevel * 5) + " Mana)"), false);
                    worldIn.playSound(player, player, SoundEvents.SQUID_SQUIRT, SoundCategory.NEUTRAL, 1.0f, 1.0f);
                    player.getCooldowns().addCooldown(this, 600);
                    damageItem(this.getItem().getDefaultInstance(), 1, player, null);
                    //return ActionResult.success(player.getItemInHand(hand));
                }
            }
        });

        //return super.use(worldIn, player, hand);
        return ActionResult.pass(player.getItemInHand(hand));
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
