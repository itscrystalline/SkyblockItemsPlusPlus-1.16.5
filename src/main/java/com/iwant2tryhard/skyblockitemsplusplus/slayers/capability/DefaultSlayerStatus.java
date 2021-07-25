package com.iwant2tryhard.skyblockitemsplusplus.slayers.capability;

public class DefaultSlayerStatus implements ISlayerStatus {

    private int slayerStatus = -1;
    private int mobCount = -1;

    @Override
    public void setSlayerStatus(int slayerStatus) {
        this.slayerStatus = slayerStatus;
    }
    @Override
    public int getSlayerStatus() {
        return this.slayerStatus;
    }

    @Override
    public void setMobCount(int mobCount) {
        this.mobCount = mobCount;
    }
    @Override
    public int getMobCount() {
        return this.mobCount;
    }
}
