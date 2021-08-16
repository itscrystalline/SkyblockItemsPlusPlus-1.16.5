package com.iwant2tryhard.skyblockitemsplusplus.common.materials.armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class MushroomArmorSource implements IArmorMaterial {
    private static final int[] baseDurability = {100, 120, 110, 100};
    private final int durabilityMultiplier = 1;
    private final int[] baseDefense = {0, 1, 0, 0};

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
        return 10;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(Items.RED_MUSHROOM);
    }

    @Override
    public String getName() {
        return "mushroom_armor";
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        return 0f;
    }
}
