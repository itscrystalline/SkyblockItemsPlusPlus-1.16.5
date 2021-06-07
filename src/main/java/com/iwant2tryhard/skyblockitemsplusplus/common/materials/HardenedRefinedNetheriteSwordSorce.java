package com.iwant2tryhard.skyblockitemsplusplus.common.materials;

import com.iwant2tryhard.skyblockitemsplusplus.core.init.ItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class HardenedRefinedNetheriteSwordSorce implements IItemTier {
    @Override
    public int getUses() {
        return 7000;
    }

    @Override
    public float getSpeed() {
        return 0f;
    }

    @Override
    public float getAttackDamageBonus() {
        return 0;
    }

    @Override
    public int getLevel() {
        return 4;
    }

    @Override
    public int getEnchantmentValue() {
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null/*Ingredient.of(ItemInit.REFINED_NETHERITE_BLOCK)*/;
    }
}
