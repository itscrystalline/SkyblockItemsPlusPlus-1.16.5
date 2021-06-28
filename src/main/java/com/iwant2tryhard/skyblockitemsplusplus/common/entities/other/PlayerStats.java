package com.iwant2tryhard.skyblockitemsplusplus.common.entities.other;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ClientUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;

public class PlayerStats {
    private static int manaReductionPercent = 0;
    private static int strengthPercent = 100;
    private static int defense = 0;
    public static boolean debugLogging = false;
    private static int ultWiseLvl = 0;

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

    public static int getUltWiseLvl() {
        return ultWiseLvl;
    }

    public static void setUltWiseLvl(int ultWiseLvl) {
        PlayerStats.ultWiseLvl = ultWiseLvl;
    }

    public static float damageEntity(float srcDamage, float targetDefense, float targetMaxHealth, boolean hasOFA)
    {
        float actualSrcDamage;
        actualSrcDamage = hasOFA ? srcDamage + 20 : srcDamage;
        float targetEHP = targetDefense * 10;
        /*if (isCrit)
        {
            return 1.25f * (strengthPercent / 100) * (srcDamage / (targetEHP + (targetMaxHealth * 5)) * targetMaxHealth);
        }
        else
        {*/
            return (strengthPercent / 100f) * (actualSrcDamage / (targetEHP + (targetMaxHealth * 5)) * targetMaxHealth);
        //}
    }

    public static int calcManaUsage(float manaUsage)
    {
        int returnValue = Math.round((manaUsage * (1f - (manaReductionPercent / 100f)) * (1f - (ultWiseLvl * 0.1f))));

        if (PlayerStats.debugLogging)
        {
            Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("ultWiseLvl :" + ultWiseLvl), false);
            Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("ultWiseLvl :" + ultWiseLvl * 0.1f), false);
            Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("ultWiseLvl :" + (manaUsage * (1f - (manaReductionPercent / 100f)) * (1f - (ultWiseLvl * 0.1f)))), false);
            Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("returnValue :" + returnValue), false);
        }
        return Math.max(returnValue, 1);
    }
    public static boolean isEnoughMana(float manaUsage, PlayerEntity player)
    {
        return player.getFoodData().getFoodLevel() - PlayerStats.calcManaUsage(manaUsage) >= 0f;
    }

    public static float getLifeStealDamageMultiplier(float armorDamageReductionPercent)
    {
        int fullRoundedPercent = Math.round((armorDamageReductionPercent / 80f) * 100f);
        if (PlayerStats.debugLogging) {
            ClientUtils.SendPrivateMessage(fullRoundedPercent >= 50f ?
                "((50f - (" + fullRoundedPercent + " - 50f)) + 50) / 100" :
                "((50f - " + fullRoundedPercent + ") + 100) / 100)");
        }
        return fullRoundedPercent >= 50f ?
                ((50f - (fullRoundedPercent - 50f)) + 50) / 100 :
                ((50f - fullRoundedPercent) + 100) / 100;
    }

}
