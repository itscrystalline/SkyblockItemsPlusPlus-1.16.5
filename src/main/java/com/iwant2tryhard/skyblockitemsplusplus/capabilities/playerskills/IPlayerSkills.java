package com.iwant2tryhard.skyblockitemsplusplus.capabilities.playerskills;

public interface IPlayerSkills {
    void setCombatXp(int xp);
    int getCombatXp();
    void setCombatLvl(int lvl);
    int getCombatLvl();

    void setMiningXp(int xp);
    int getMiningXp();
    void setMiningLvl(int lvl);
    int getMiningLvl();

    void setFarmingXp(int xp);
    int getFarmingXp();
    void setFarmingLvl(int lvl);
    int getFarmingLvl();

    void setForagingXp(int xp);
    int getForagingXp();
    void setForagingLvl(int lvl);
    int getForagingLvl();

    void setEnchantingXp(int xp);
    int getEnchantingXp();
    void setEnchantingLvl(int lvl);
    int getEnchantingLvl();

    void setFishingXp(int xp);
    int getFishingXp();
    void setFishingLvl(int lvl);
    int getFishingLvl();

    void setAlchemyXp(int xp);
    int getAlchemyXp();
    void setAlchemyLvl(int lvl);
    int getAlchemyLvl();

    void setStrength(int strength);
    int getStrength();
    void setBaseStrength(int baseStrength);
    int getBaseStrength();

    void setMana(int mana);
    int getMana();
    void setMaxMana(int maxMana);
    int getMaxMana();
    void setBaseMaxMana(int baseMana);
    int getBaseMaxMana();

    void setDefense(int defense);
    int getDefense();
    void setBaseDefense(int baseDefense);
    int getBaseDefense();

    void setHealth(float health);
    float getHealth();

    void setMaxHealth(float maxHealth);

    float getMaxHealth();

    void setBaseMaxHealth(float baseMaxHealth);

    float getBaseMaxHealth();

    void setFerocity(int ferocity);

    int getFerocity();

    void setBaseFerocity(int baseFerocity);

    int getBaseFerocity();

    void setSpeed(float speed);

    float getSpeed();

    void setBaseSpeed(float baseSpeed);

    float getBaseSpeed();

    void setCoins(int coins);

    int getCoins();

    void setUltWiseLvl(int ultWiseLvl);

    int getUltWiseLvl();

    void setRBootTimer(int rbootTimer);

    int getRBootTimer();

    void setRHelmTimer(int rhelmTimer);

    int getRHelmTimer();

    void setHRBootTimer(int hrbootTimer);

    int getHRBootTimer();

    void setHRHelmTimer(int hrhelmTimer);

    int getHRHelmTimer();

    void setDiamondTimer(int diamondTimer);

    float getBootSlowFactor();

    void setBootSlowFactor(float bootSlowFactor);

    int getDiamondTimer();

    void setNetheriteTimer(int netheriteTimer);

    int getNetheriteTimer();

    void setNetheritePlatedDiamondTimer(int netheritePlatedDiamondTimer);

    int getNetheritePlatedDiamondTimer();

    void setDiamondStrBoost(int diamondStrBoost);

    int getDiamondStrBoost();

    void setNetheriteStrBoost(int netheriteStrBoost);

    int getNetheriteStrBoost();


    void AwardCombatXp(int xp);

    void AwardMiningXp(int xp);

    void AwardFarmingXp(int xp);

    void AwardForagingXp(int xp);

    void AwardEnchantingXp(int xp);

    void AwardFishingXp(int xp);

    void AwardAlchemyXp(int xp);





    int getSlayerStatus();
    void setSlayerStatus(int slayerStatus);

    int getMobCount();
    void setMobCount(int mobCount);

    int getZombieSlayerLvl();
    void setZombieSlayerLvl(int zombieSlayerLvl);
    int getSpiderSlayerLvl();
    void setSpiderSlayerLvl(int spiderSlayerLvl);
    int getWolfSlayerLvl();
    void setWolfSlayerLvl(int wolfSlayerLvl);
    int getEndermanSlayerLvl();
    void setEndermanSlayerLvl(int endermanSlayerLvl);
}
