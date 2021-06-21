package com.iwant2tryhard.skyblockitemsplusplus.common.materials.tools.swords;

import com.iwant2tryhard.skyblockitemsplusplus.core.init.ItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

public class SilverFangSource implements IItemTier {
    @Override
    public int getUses() {
        return 800;
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
        return 2;
    }

    @Override
    public int getEnchantmentValue() {
        return 12;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemInit.REFINED_GHAST_TEAR.get());
    }
}
