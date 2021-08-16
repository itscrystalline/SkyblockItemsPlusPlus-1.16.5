package com.iwant2tryhard.skyblockitemsplusplus.common.materials.armor;

import com.iwant2tryhard.skyblockitemsplusplus.core.init.ItemInit;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class HardenedRefinedNetheriteArmorSource implements IArmorMaterial {
    private static final int[] baseDurability = {1220, 1776, 1664, 1442};
    private final int durabilityMultiplier = 1;
    private final int[] baseDefense = {67, 180, 135, 67};

    @Override
    public int getDurabilityForSlot(EquipmentSlotType slotType) {
        return baseDurability[slotType.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType slotType) {
        return this.baseDefense[slotType.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return 50;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemInit.REFINED_NETHERITE_BLOCK.get());
    }

    @Override
    public String getName() {
        return "hardened_refined_netherite_armor";
    }

    @Override
    public float getToughness() {
        return 20f;
    }

    @Override
    public float getKnockbackResistance() {
        return 1f;
    }
}
