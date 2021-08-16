package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.swords;

import com.iwant2tryhard.skyblockitemsplusplus.capabilities.playerskills.CapabilityPlayerSkills;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.TaggedSwordItem;
import com.iwant2tryhard.skyblockitemsplusplus.common.util.CustomRarity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class Netherite_Plated_Diamond_Sword extends TaggedSwordItem {
    public Netherite_Plated_Diamond_Sword(IItemTier itemTier, int damage, float attackSpeed, Properties properties, CustomRarity rarity) {
        super(itemTier, damage, attackSpeed, properties, rarity);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        PlayerEntity player = null;
        if (stack.getEntityRepresentation() instanceof PlayerEntity) {
            player = (PlayerEntity) stack.getEntityRepresentation();
        }
        tooltip.add(new StringTextComponent("\u00A77" + "True Damage: " + "\u00A7c" + "+7"));
        if (player != null) {
            player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills ->
                    tooltip.add(new StringTextComponent("\u00A77" + "Strength: " + "\u00A7c" + "+" + (30 + Math.round((skills.getNetheriteStrBoost() / 4f) + (skills.getDiamondStrBoost() / 4f * 3f))) + ColorText.GREEN + "(+" + Math.round((skills.getNetheriteStrBoost() / 4f) + (skills.getDiamondStrBoost() / 4f * 3f)) + ")")));
        } else {
            tooltip.add(new StringTextComponent("\u00A77" + "Strength: " + "\u00A7c" + "+30"));
        }
        tooltip.add(new StringTextComponent(""));
        tooltip.add(new StringTextComponent("\u00A77" + "This item can be reforged!"));
        tooltip.add(new StringTextComponent(rarity + "SWORD"));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
