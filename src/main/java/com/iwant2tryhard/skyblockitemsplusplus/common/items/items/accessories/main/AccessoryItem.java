package com.iwant2tryhard.skyblockitemsplusplus.common.items.items.accessories.main;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AccessoryItem extends Item {

    private final int defenseBoost;
    private final int healthBoost;
    private final int speedBoost;
    private final float manaReductionPercent;
    private final int strengthBoost;

    public AccessoryItem(Properties properties, int defenseBoost, int healthBoost, int speedBoost, float manaReductionPercent, int strengthBoost) {
        super(properties);
        this.defenseBoost = defenseBoost;
        this.healthBoost = healthBoost;
        this.speedBoost = speedBoost;
        this.strengthBoost = strengthBoost;
        this.manaReductionPercent = manaReductionPercent;
    }


    public int getStrengthBoost() {
        return strengthBoost;
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }

    public int getSpeedBoost() {
        return speedBoost;
    }

    public int getHealthBoost() {
        return healthBoost;
    }

    public float getManaReductionPercent() {
        return manaReductionPercent;
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
        if (entityIn instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) entityIn;
            player.setSpeed(((((player.getSpeed() / 0.699999988079071f) * 100f) + speedBoost) / 100f) * 0.699999988079071f);
            //player.setHealth(player.getHealth)
        }
    }
}
