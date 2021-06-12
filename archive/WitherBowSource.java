package com.iwant2tryhard.skyblockitemsplusplus.common.materials.tools.bows;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public class WitherBowSource implements IItemTier {
    @Override
    public int getUses() {
        return 1337;
    }

    @Override
    public float getSpeed() {
        return 0;
    }

    @Override
    public float getAttackDamageBonus() {
        return 0;
    }

    @Override
    public int getLevel() {
        return 1;
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
