package com.iwant2tryhard.skyblockitemsplusplus.capabilities.playerskills;

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

    private int strength = 100;
    private int baseStrength = 100;

    private int mana = 100;
    private int maxMana = 100;
    private int baseMaxMana = 100;

    private int defense;
    private int baseDefense;

    private float health = 100f;
    private float maxHealth = 100f;
    private float baseMaxHealth = 100f;

    private int ferocity;
    private int baseFerocity;

    private int coins;

    private int ultWiseLvl;


    private int slayerStatus = -1;
    private int mobCount = -1;
    private int zombieSlayerLvl = -1;
    private int spiderSlayerLvl = -1;
    private int wolfSlayerLvl = -1;
    private int endermanSlayerLvl = -1;

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

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }
    @Override
    public int getStrength() {
        return this.strength;
    }
    @Override
    public void setBaseStrength(int baseStrength) {
        this.baseStrength = baseStrength;
    }
    @Override
    public int getBaseStrength() {
        return this.baseStrength;
    }

    @Override
    public void setMana(int mana) {
        this.mana = mana;
    }
    @Override
    public int getMana() {
        return this.mana;
    }
    @Override
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }
    @Override
    public int getMaxMana() {
        return this.maxMana;
    }
    @Override
    public void setBaseMaxMana(int baseMana) {
        this.baseMaxMana = baseMana;
    }
    @Override
    public int getBaseMaxMana() {
        return this.baseMaxMana;
    }

    @Override
    public void setCoins(int coins) {
        this.coins = coins;
    }
    @Override
    public int getCoins() {
        return this.coins;
    }

    @Override
    public int getUltWiseLvl() {
        return this.ultWiseLvl;
    }
    @Override
    public void setUltWiseLvl(int ultWiseLvl) {
        this.ultWiseLvl = ultWiseLvl;
    }

    @Override
    public void setDefense(int defense) {
        this.defense = defense;
    }
    @Override
    public int getDefense() {
        return this.defense;
    }
    @Override
    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }
    @Override
    public int getBaseDefense() {
        return this.baseDefense;
    }

    @Override
    public void setHealth(float health) {
        this.health = health;
    }
    @Override
    public float getHealth() {
        return this.health;
    }
    @Override
    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }
    @Override
    public float getMaxHealth() {
        return this.maxHealth;
    }
    @Override
    public void setBaseMaxHealth(float baseMaxHealth) {
        this.baseMaxHealth = baseMaxHealth;
    }
    @Override
    public float getBaseMaxHealth() {
        return this.baseMaxHealth;
    }

    @Override
    public void setFerocity(int ferocity) {
        this.ferocity = ferocity;
    }
    @Override
    public int getFerocity() {
        return ferocity;
    }
    @Override
    public void setBaseFerocity(int baseFerocity) {
        this.baseFerocity = baseFerocity;
    }
    @Override
    public int getBaseFerocity() {
        return 0;
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
        if (combatXp > (Math.pow((combatLvl + 3), 3) - Math.pow((combatLvl + 1), 2)) * 2)
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
        if (miningXp > (Math.pow((miningLvl + 3), 3) - Math.pow((miningLvl + 1), 2)) * 2)
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
        if (farmingXp > (Math.pow((farmingLvl + 3), 3) - Math.pow((farmingLvl + 1), 2)) * 2)
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
        if (enchantingXp > (Math.pow((enchantingLvl + 3), 3) - Math.pow((enchantingLvl + 1), 2)) * 2)
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
        if (foragingXp > (Math.pow((foragingLvl + 3), 3) - Math.pow((foragingLvl + 1), 2)) * 2)
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
        if (fishingXp > (Math.pow((fishingLvl + 3), 3) - Math.pow((fishingLvl + 1), 2)) * 2)
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
        if (alchemyXp > (Math.pow((alchemyLvl + 3), 3) - Math.pow((alchemyLvl + 1), 2)) * 2)
        {
            ++alchemyLvl;
            alchemyXp = 0;
        }
    }


    @Override
    public int getSlayerStatus() {
        return slayerStatus;
    }

    @Override
    public void setSlayerStatus(int slayerStatus) {
        this.slayerStatus = slayerStatus;
    }

    @Override
    public int getMobCount() {
        return mobCount;
    }

    @Override
    public void setMobCount(int mobCount) {
        this.mobCount = mobCount;
    }

    @Override
    public int getZombieSlayerLvl() {
        return zombieSlayerLvl;
    }

    @Override
    public void setZombieSlayerLvl(int zombieSlayerLvl) {
        this.zombieSlayerLvl = zombieSlayerLvl;
    }

    @Override
    public int getSpiderSlayerLvl() {
        return spiderSlayerLvl;
    }

    @Override
    public void setSpiderSlayerLvl(int spiderSlayerLvl) {
        this.spiderSlayerLvl = spiderSlayerLvl;
    }

    @Override
    public int getWolfSlayerLvl() {
        return wolfSlayerLvl;
    }

    @Override
    public void setWolfSlayerLvl(int wolfSlayerLvl) {
        this.wolfSlayerLvl = wolfSlayerLvl;
    }

    @Override
    public int getEndermanSlayerLvl() {
        return endermanSlayerLvl;
    }

    @Override
    public void setEndermanSlayerLvl(int endermanSlayerLvl) {
        this.endermanSlayerLvl = endermanSlayerLvl;
    }
}
