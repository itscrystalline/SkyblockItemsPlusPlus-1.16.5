package com.iwant2tryhard.skyblockitemsplusplus.common.entities;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;

public class PlayerSkills {

    private int combatLvl = 0;
    private int combatXp = 0;

    private int miningLvl = 0;
    private int miningXp = 0;

    private int farmingLvl = 0;
    private int farmingXp = 0;

    private int enchantingLvl = 0;
    private int enchantingXp = 0;

    private int foragingLvl = 0;
    private int foragingXp = 0;

    private int fishingLvl = 0;
    private int fishingXp = 0;

    private int alchemyLvl = 0;
    private int alchemyXp = 0;

    public PlayerSkills() {
    }

    public void AwardCombatXP(int xp)
    {
        int qxp = xp;
        while (qxp > 0)
        {
            ++combatXp;
            CheckCombatXP();
            qxp -= 1;
        }
    }
    private void CheckCombatXP()
    {
        if (combatXp > (Math.pow((combatLvl + 3), 3) - Math.pow((combatLvl + 1), 2)) * 5)
        {
            ++combatLvl;
            combatXp = 0;
        }
    }


    public void AwardMiningXP(int xp)
    {
        int qxp = xp;
        while (qxp > 0)
        {
            ++miningXp;
            CheckMiningXP();
            qxp -= 1;
        }
    }
    private void CheckMiningXP()
    {
        if (miningXp > (Math.pow((miningLvl + 3), 3) - Math.pow((miningLvl + 1), 2)) * 5)
        {
            ++miningLvl;
            miningXp = 0;
        }
    }

    public void AwardFarmingXP(int xp)
    {
        int qxp = xp;
        while (qxp > 0)
        {
            ++farmingXp;
            CheckFarmingXP();
            qxp -= 1;
        }
    }
    private void CheckFarmingXP()
    {
        if (farmingXp > (Math.pow((farmingLvl + 3), 3) - Math.pow((farmingLvl + 1), 2)) * 5)
        {
            ++farmingLvl;
            farmingXp = 0;
        }
    }

    public void AwardEnchantingXP(int xp)
    {
        int qxp = xp;
        while (qxp > 0)
        {
            ++enchantingXp;
            CheckEnchantingXP();
            qxp -= 1;
        }
    }
    private void CheckEnchantingXP()
    {
        if (enchantingXp > (Math.pow((enchantingLvl + 3), 3) - Math.pow((enchantingLvl + 1), 2)) * 5)
        {
            ++enchantingLvl;
            enchantingXp = 0;
        }
    }

    public void AwardForagingXP(int xp)
    {
        int qxp = xp;
        while (qxp > 0)
        {
            ++foragingXp;
            CheckForagingXP();
            qxp -= 1;
        }
    }
    private void CheckForagingXP()
    {
        if (foragingXp > (Math.pow((foragingLvl + 3), 3) - Math.pow((foragingLvl + 1), 2)) * 5)
        {
            ++foragingLvl;
            foragingXp = 0;
        }
    }

    public void AwardFishingXP(int xp)
    {
        int qxp = xp;
        while (qxp > 0)
        {
            ++fishingXp;
            CheckFishingXP();
            qxp -= 1;
        }
    }
    private void CheckFishingXP()
    {
        if (fishingXp > (Math.pow((fishingLvl + 3), 3) - Math.pow((fishingLvl + 1), 2)) * 5)
        {
            ++fishingLvl;
            fishingXp = 0;
        }
    }

    public void AwardAlchemyXP(int xp)
    {
        int qxp = xp;
        while (qxp > 0)
        {
            ++alchemyXp;
            CheckAlchemyXP();
            qxp -= 1;
        }
    }
    private void CheckAlchemyXP()
    {
        if (alchemyXp > (Math.pow((alchemyLvl + 3), 3) - Math.pow((alchemyLvl + 1), 2)) * 5)
        {
            ++alchemyLvl;
            alchemyXp = 0;
        }
    }

    public void addAdditionalSaveData(CompoundNBT compoundNBT) {

        compoundNBT.putInt("combatLvl", combatLvl);
        compoundNBT.putInt("combatXp", combatXp);

        compoundNBT.putInt("miningLvl", miningLvl);
        compoundNBT.putInt("miningXp", miningXp);

        compoundNBT.putInt("farmingLvl", farmingLvl);
        compoundNBT.putInt("farmingXp", farmingXp);

        compoundNBT.putInt("enchantingLvl", enchantingLvl);
        compoundNBT.putInt("enchantingXp", enchantingXp);

        compoundNBT.putInt("foragingLvl", foragingLvl);
        compoundNBT.putInt("foragingXp", foragingXp);

        compoundNBT.putInt("fishingLvl", fishingLvl);
        compoundNBT.putInt("fishingXp", fishingXp);

        compoundNBT.putInt("alchemyLvl", alchemyLvl);
        compoundNBT.putInt("alchemyXp", alchemyXp);
        
    }

    public void readAdditionalSaveData(CompoundNBT compoundNBT) {
        combatLvl = compoundNBT.getInt("combatLvl");
        combatXp = compoundNBT.getInt("combatXp");

        miningLvl = compoundNBT.getInt("miningLvl");
        miningXp = compoundNBT.getInt("miningXp");

        farmingLvl = compoundNBT.getInt("farmingLvl");
        farmingXp = compoundNBT.getInt("farmingXp");

        enchantingLvl = compoundNBT.getInt("enchantingLvl");
        enchantingXp = compoundNBT.getInt("enchantingXp");

        foragingLvl = compoundNBT.getInt("foragingLvl");
        foragingXp = compoundNBT.getInt("foragingXp");

        fishingLvl = compoundNBT.getInt("fishingLvl");
        fishingXp = compoundNBT.getInt("fishingXp");

        alchemyLvl = compoundNBT.getInt("alchemyLvl");
        alchemyXp = compoundNBT.getInt("alchemyXp");

    }

}
