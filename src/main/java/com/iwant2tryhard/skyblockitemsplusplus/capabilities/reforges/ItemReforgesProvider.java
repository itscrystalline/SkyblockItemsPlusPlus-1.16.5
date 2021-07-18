package com.iwant2tryhard.skyblockitemsplusplus.capabilities.reforges;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ItemReforgesProvider implements ICapabilitySerializable<CompoundNBT> {
    private final DefaultItemReforges reforges = new DefaultItemReforges();
    private final LazyOptional<IItemReforges> playerSkillsOptional = LazyOptional.of(() -> reforges);

    public void invalidate() {
        playerSkillsOptional.invalidate();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return playerSkillsOptional.cast();
    }

    @Override
    public CompoundNBT serializeNBT() {
        if (CapabilityItemReforges.ITEM_REFORGES_CAPABILITY == null) {
            return new CompoundNBT();
        } else {
            return (CompoundNBT) CapabilityItemReforges.ITEM_REFORGES_CAPABILITY.writeNBT(reforges, null);
        }
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        if (CapabilityItemReforges.ITEM_REFORGES_CAPABILITY != null) {
            CapabilityItemReforges.ITEM_REFORGES_CAPABILITY.readNBT(reforges, null, nbt);
        }
    }
}
