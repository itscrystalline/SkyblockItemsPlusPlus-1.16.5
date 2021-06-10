package com.iwant2tryhard.skyblockitemsplusplus.common.materials.items;

import com.iwant2tryhard.skyblockitemsplusplus.core.init.ItemInit;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum CustomItemMaterialInit implements IItemTier {
    ASPECT_OF_THE_END_SOURCE(4000, 0f, 0, 3, 30, Ingredient.of(ItemInit.REFINED_ENDER_PEARL.get().asItem())),
    ASPECT_OF_THE_JERRY_SOURCE(1000, 0f, 0, 1, 10, null),
    ROGUE_SWORD_SOURCE(2500, 0f, 0, 1, 13, Ingredient.of(ItemInit.REFINED_GOLD_INGOT.get().asItem())),
    HARDENED_REFINED_NETHERITE_SWORD_SOURCE(10000, 0f, 0, 4, 30, Ingredient.of(ItemInit.REFINED_NETHERITE_BLOCK.get().asItem())),
    UNDEAD_SWORD_SOURCE(1000, 0f, 0, 2, 15, null);

    private final int uses;
    private final float speed;
    private final int attackDamageBonus;
    private final int level;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    CustomItemMaterialInit(int uses, float speed, int attackDamageBonus, int level, int enchantmentValue, Ingredient repairIngredient) {
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.level = level;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamageBonus;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }
}
