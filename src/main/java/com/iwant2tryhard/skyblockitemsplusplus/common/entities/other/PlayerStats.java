package com.iwant2tryhard.skyblockitemsplusplus.common.entities.other;

import com.iwant2tryhard.skyblockitemsplusplus.client.util.ClientUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class PlayerStats {
    
    @OnlyIn(Dist.CLIENT)
    public static boolean debugLogging = false;

    public PlayerStats() {
    }

    public static float damageEntity(float srcDamage, float targetDefense, float targetMaxHealth, boolean hasOFA, boolean hasEmeraldBlade, int strengthPercent, int coins, int combatlvl)
    {
        float actualSrcDamage;
        actualSrcDamage = hasOFA ? srcDamage + 20 : srcDamage;
        actualSrcDamage += hasEmeraldBlade ? calcEmeraldBladeBoost(coins) : 0f;
        actualSrcDamage += 5;
        float targetEHP = targetDefense * 10;
        return (strengthPercent / 100f) * (actualSrcDamage / (targetEHP + (targetMaxHealth * 5)) * targetMaxHealth) * (1 + (combatlvl * 0.04f));
    }

    public static int calcManaUsage(float manaUsage, float manaReductionPercent, float ultWiseLvl)
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
    public static boolean isEnoughMana(float manaUsage, float manaReductionPercent, float ultWiseLvl,  PlayerEntity player)
    {
        return player.getFoodData().getFoodLevel() - PlayerStats.calcManaUsage(manaUsage, manaReductionPercent, ultWiseLvl) >= 0f;
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

    public static int calcEmeraldBladeBoost(int coins)
    {
        return (int) Math.round(2.5D * Math.sqrt(Math.sqrt(coins)));
    }

}
