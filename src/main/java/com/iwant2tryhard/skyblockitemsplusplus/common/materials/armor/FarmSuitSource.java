package com.iwant2tryhard.skyblockitemsplusplus.common.materials.armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class FarmSuitSource implements IArmorMaterial {
    private static final int[] baseDurability = {128, 144, 160, 112};
    private final int durabilityMultiplier = 2;
    private final int[] baseDefense = {0, 2, 1, 0};

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
        return 5;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_LEATHER;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Items.HAY_BLOCK);
    }

    @Override
    public String getName() {
        return "farm_suit";
    }

    @Override
    public float getToughness() {
        return 1f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0f;
    }
}
