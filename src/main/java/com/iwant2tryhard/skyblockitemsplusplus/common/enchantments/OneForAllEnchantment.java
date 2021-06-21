package com.iwant2tryhard.skyblockitemsplusplus.common.enchantments;

import com.iwant2tryhard.skyblockitemsplusplus.core.init.EnchantmentInit;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.inventory.EquipmentSlotType;

public class OneForAllEnchantment extends Enchantment {
    public OneForAllEnchantment(Rarity rarity, EnchantmentType type, EquipmentSlotType[] slotTypes) {
        super(rarity, type, slotTypes);
    }

    @Override
    public int getMaxLevel() {
        return 1;
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
        return (ench.equals(Enchantments.UNBREAKING) | ench.equals(Enchantments.MENDING) | ench.equals(EnchantmentInit.TELEKINESIS));
    }
}
