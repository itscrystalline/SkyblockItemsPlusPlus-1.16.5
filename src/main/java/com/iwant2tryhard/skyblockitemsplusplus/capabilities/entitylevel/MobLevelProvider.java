package com.iwant2tryhard.skyblockitemsplusplus.capabilities.entitylevel;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MobLevelProvider implements ICapabilitySerializable<CompoundNBT> {
    private final DefaultMobLevel mobLevel = new DefaultMobLevel();
    private final LazyOptional<IMobLevel> mobLevelOptional = LazyOptional.of(() -> mobLevel);

    public void invalidate() {
        mobLevelOptional.invalidate();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return mobLevelOptional.cast();
    }

    @Override
    public CompoundNBT serializeNBT() {
        if (CapabilityMobLevel.MOB_LEVEL_CAPABILITY == null) {
            return new CompoundNBT();
        } else {
            return (CompoundNBT) CapabilityMobLevel.MOB_LEVEL_CAPABILITY.writeNBT(mobLevel, null);
        }
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        if (CapabilityMobLevel.MOB_LEVEL_CAPABILITY != null) {
            CapabilityMobLevel.MOB_LEVEL_CAPABILITY.readNBT(mobLevel, null, nbt);
        }
    }
}
