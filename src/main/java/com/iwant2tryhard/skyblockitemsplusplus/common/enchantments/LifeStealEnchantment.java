package com.iwant2tryhard.skyblockitemsplusplus.common.enchantments;

import com.iwant2tryhard.skyblockitemsplusplus.core.init.EnchantmentInit;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;

public class LifeStealEnchantment extends Enchantment {
    public LifeStealEnchantment(Rarity rarity, EnchantmentType type, EquipmentSlotType[] slotTypes) {
        super(rarity, type, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }

    @Override
    protected boolean checkCompatibility(Enchantment ench) {
        return !ench.equals(EnchantmentInit.LIFE_STEAL.get());
    }
}
