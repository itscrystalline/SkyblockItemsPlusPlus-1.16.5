package com.iwant2tryhard.skyblockitemsplusplus.common.entities;

import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.living.LivingEvent;

public class PlayerStats {
    private static int manaReductionPercent = 0;
    private static int strengthPercent = 100;
    private static int defense = 0;
    public static boolean debugLogging = true;

    public static int getManaReductionPercent() {
        return manaReductionPercent;
    }
    public static void setManaReductionPercent(int manaReductionPercent) {
        PlayerStats.manaReductionPercent = manaReductionPercent;
    }
    public static void addManaReductionPercent(int manaReductionPercentToAdd) {
        PlayerStats.manaReductionPercent += manaReductionPercentToAdd;
    }
    public static void removeManaReductionPercent(int manaReductionPercentToRemove) {
        PlayerStats.manaReductionPercent -= manaReductionPercentToRemove;
    }

    public static int getStrength() {
        return strengthPercent;
    }
    public static void setStrength(int strengthPercent) {
        PlayerStats.strengthPercent = strengthPercent;
    }
    public static void addStrength(int strengthPercentToAdd) {
        PlayerStats.strengthPercent += strengthPercentToAdd;
    }
    public static void removeStrength(int strengthPercentToRemove) {
        PlayerStats.strengthPercent -= strengthPercentToRemove;
    }

    public static int getDefense() {
        return defense;
    }
    public static void setDefense(int defense) {
        PlayerStats.defense = defense;
    }

    public static float damageEntity(float srcDamage, float targetDefense, float targetMaxHealth)
    {
        float targetEHP = targetDefense * 10;
        /*if (isCrit)
        {
            return 1.25f * (strengthPercent / 100) * (srcDamage / (targetEHP + (targetMaxHealth * 5)) * targetMaxHealth);
        }
        else
        {*/
            return (strengthPercent / 100) * (srcDamage / (targetEHP + (targetMaxHealth * 5)) * targetMaxHealth);
        //}
    }

}
