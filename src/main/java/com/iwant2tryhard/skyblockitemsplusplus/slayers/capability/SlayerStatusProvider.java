package com.iwant2tryhard.skyblockitemsplusplus.slayers.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.lwjgl.system.CallbackI;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SlayerStatusProvider /*implements ICapabilitySerializable<CompoundNBT>*/ {

    /*private final DefaultSlayerStatus slayerStatus = new DefaultSlayerStatus();
    private final LazyOptional<ISlayerStatus> slayerStatusOptional = LazyOptional.of(() -> slayerStatus);

    public void invalidate() {slayerStatusOptional.invalidate();}

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction direction) {
        return slayerStatusOptional.cast();
    }

    @Override
    public CompoundNBT serializeNBT() {
        if (CapabilitySlayerStatus.SLAYER_STATUS_CAPABILITY == null)
        {
            return new CompoundNBT();
        }
        else
        {
            return (CompoundNBT) CapabilitySlayerStatus.SLAYER_STATUS_CAPABILITY.writeNBT(slayerStatus, null);
        }
    }

    @Override
    public void deserializeNBT(CompoundNBT compoundNBT) {
        if (CapabilitySlayerStatus.SLAYER_STATUS_CAPABILITY != null)
        {
            CapabilitySlayerStatus.SLAYER_STATUS_CAPABILITY.readNBT(slayerStatus, null, compoundNBT);
        }
    }*/
}
