package com.iwant2tryhard.skyblockitemsplusplus.common.materials.armor;

import com.iwant2tryhard.skyblockitemsplusplus.core.init.ItemInit;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class RefinedNetheriteArmorSource implements IArmorMaterial {
    private static final int[] baseDurability = {610, 888, 832, 721};
    private final int durabilityMultiplier = 1;
    private final int[] baseDefense = {8, 20, 15, 8};

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
        return 30;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ItemInit.REFINED_NETHERITE_INGOT.get());
    }

    @Override
    public String getName() {
        return "refined_netherite_armor";
    }

    @Override
    public float getToughness() {
        return 10f;
    }

    @Override
    public float getKnockbackResistance() {
        return 1f;
    }
}
