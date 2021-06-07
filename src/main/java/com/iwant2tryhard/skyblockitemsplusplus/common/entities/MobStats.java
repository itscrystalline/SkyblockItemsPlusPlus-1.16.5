package com.iwant2tryhard.skyblockitemsplusplus.common.entities;

public enum MobStats {
    ZOMBIE(0),
    SKELETON(0),
    ENDERMAN(10),
    CREEPER(5),
    SLIME(5),
    SPIDER(3),
    CAVE_SPIDER(2),
    ZOMBIE_PIGMAN(5),
    VILLAGER(5),
    IRON_GOLEM(50),
    WITHER_SKELETON(5),
    WITHER(100),
    ENDER_DRAGON(500);

    public final int defense;

    private MobStats(int defense) {
        this.defense = defense;
    }
}
