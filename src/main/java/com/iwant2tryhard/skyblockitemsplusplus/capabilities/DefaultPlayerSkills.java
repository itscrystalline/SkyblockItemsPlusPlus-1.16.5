package com.iwant2tryhard.skyblockitemsplusplus.capabilities;

public class DefaultPlayerSkills implements IPlayerSkills {

    private int combatLvl;
    private int combatXp;

    private int miningLvl;
    private int miningXp;

    private int farmingLvl;
    private int farmingXp;

    private int enchantingLvl;
    private int enchantingXp;

    private int foragingLvl;
    private int foragingXp;

    private int fishingLvl;
    private int fishingXp;

    private int alchemyLvl;
    private int alchemyXp;

    @Override
    public void setCombatXp(int xp) {
        this.combatXp = xp;
    }
    @Override
    public int getCombatXp() {
        return this.combatXp;
    }
    @Override
    public void setCombatLvl(int lvl) {
        this.combatLvl = lvl;
    }
    @Override
    public int getCombatLvl() {
        return this.combatLvl;
    }

    @Override
    public void setMiningXp(int xp) {
        this.miningXp = xp;
    }
    @Override
    public int getMiningXp() {
        return this.miningXp;
    }
    @Override
    public void setMiningLvl(int lvl) {
        this.miningLvl = lvl;
    }
    @Override
    public int getMiningLvl() {
        return this.miningLvl;
    }

    @Override
    public void setFarmingXp(int xp) {
        this.farmingXp = xp;
    }
    @Override
    public int getFarmingXp() {
        return this.farmingXp;
    }
    @Override
    public void setFarmingLvl(int lvl) {
        this.farmingLvl = lvl;
    }
    @Override
    public int getFarmingLvl() {
        return this.farmingLvl;
    }

    @Override
    public void setForagingXp(int xp) {
        this.foragingXp = xp;
    }
    @Override
    public int getForagingXp() {
        return this.foragingXp;
    }
    @Override
    public void setForagingLvl(int lvl) {
        this.foragingLvl = lvl;
    }
    @Override
    public int getForagingLvl() {
        return this.foragingLvl;
    }

    @Override
    public void setEnchantingXp(int xp) {
        this.enchantingXp = xp;
    }
    @Override
    public int getEnchantingXp() {
        return this.enchantingXp;
    }
    @Override
    public void setEnchantingLvl(int lvl) {
        this.enchantingLvl = lvl;
    }
    @Override
    public int getEnchantingLvl() {
        return this.enchantingLvl;
    }

    @Override
    public void setFishingXp(int xp) {
        this.fishingXp = xp;
    }
    @Override
    public int getFishingXp() {
        return this.fishingXp;
    }
    @Override
    public void setFishingLvl(int lvl) {
        this.fishingLvl = lvl;
    }
    @Override
    public int getFishingLvl() {
        return this.fishingLvl;
    }

    @Override
    public void setAlchemyXp(int xp) {
        this.alchemyXp = xp;
    }
    @Override
    public int getAlchemyXp() {
        return this.alchemyXp;
    }
    @Override
    public void setAlchemyLvl(int lvl) {
        this.alchemyLvl = lvl;
    }
    @Override
    public int getAlchemyLvl() {
        return this.alchemyLvl;
    }


    public void AwardCombatXp(int xp)
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


    public void AwardMiningXp(int xp)
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

    public void AwardFarmingXp(int xp)
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

    public void AwardEnchantingXp(int xp)
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

    public void AwardForagingXp(int xp)
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

    public void AwardFishingXp(int xp)
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

    public void AwardAlchemyXp(int xp)
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
}
