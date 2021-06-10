package com.iwant2tryhard.skyblockitemsplusplus.common.materials.armor;

import com.iwant2tryhard.skyblockitemsplusplus.core.init.ItemInit;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

import java.util.function.Supplier;

public enum CustomArmorMaterialInit implements IArmorMaterial {
    FARM_SUIT(new int[] {15, 40, 35, 15}, 5, SoundEvents.ARMOR_EQUIP_LEATHER, Ingredient.of(Items.HAY_BLOCK), "farm_suit", 2f, 0f, 1);

    private static final int[] baseDurability = {128, 144, 160, 112};
    private final int[] baseDefense;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final Ingredient repairIngredient;
    private final String name;
    private final float toughness;
    private final float knockbackResistance;
    private final int durabilityMultiplier;

    CustomArmorMaterialInit(int[] baseDefense, int enchantmentValue, SoundEvent equipSound, Ingredient repairIngredient, String name, float toughness, float knockbackResistance, int durabilityMultiplier) {
        this.baseDefense = baseDefense;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.repairIngredient = repairIngredient;
        this.name = name;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.durabilityMultiplier = durabilityMultiplier;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType p_200896_1_) {
        return baseDurability[p_200896_1_.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType p_200902_1_) {
        return this.baseDefense[p_200902_1_.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
