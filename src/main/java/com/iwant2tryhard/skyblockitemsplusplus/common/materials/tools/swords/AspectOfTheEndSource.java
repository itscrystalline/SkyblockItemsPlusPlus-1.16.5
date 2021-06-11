package com.iwant2tryhard.skyblockitemsplusplus.common.materials.tools.swords;

import com.iwant2tryhard.skyblockitemsplusplus.core.init.ItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public class AspectOfTheEndSource implements IItemTier {

    //ASPECT_OF_THE_JERRY_SOURCE(4000, 1.6, 5, 2, 17, null);
    @Override
    public int getUses() {
        return 4000;
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
        return 3;
    }

    @Override
    public int getEnchantmentValue() {
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemInit.REFINED_ENDER_PEARL.get().asItem());
    }
}
