package com.iwant2tryhard.skyblockitemsplusplus.capabilities.reforges;

public class DefaultItemReforges implements IItemReforges {

    private int reforgeItemType = -1;
    private int reforgeType = -1;

    @Override
    public void setReforgeItemType(int reforgeItemType) {
        this.reforgeItemType = reforgeItemType;
    }
    @Override
    public int getReforgeItemType() {
        return this.reforgeItemType;
    }

    @Override
    public void setReforgeType(int reforgeType) {
        this.reforgeType = reforgeType;
    }
    @Override
    public int getReforgeType() {
        return this.reforgeType;
    }
}
