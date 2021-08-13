package com.iwant2tryhard.skyblockitemsplusplus.capabilities.entitylevel;

public class DefaultMobLevel implements IMobLevel {

    private int mobLevel;

    @Override
    public void setMobLevel(int mobLevel) {
        this.mobLevel = mobLevel;
    }

    @Override
    public int getMobLevel() {
        return this.mobLevel;
    }
}
