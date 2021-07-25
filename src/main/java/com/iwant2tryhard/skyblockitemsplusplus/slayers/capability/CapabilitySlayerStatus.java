package com.iwant2tryhard.skyblockitemsplusplus.slayers.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;

public class CapabilitySlayerStatus {

    @CapabilityInject(ISlayerStatus.class)
    public static Capability<ISlayerStatus> SLAYER_STATUS_CAPABILITY = null;

    public static void register()
    {
        CapabilityManager.INSTANCE.register(ISlayerStatus.class, new Storage(), DefaultSlayerStatus::new);
    }

    public static class Storage implements Capability.IStorage<ISlayerStatus>
    {

        @Nullable
        @Override
        public INBT writeNBT(Capability<ISlayerStatus> capability, ISlayerStatus instance, Direction direction) {
            CompoundNBT compoundNBT = new CompoundNBT();
            compoundNBT.putInt("slayerStatus", instance.getSlayerStatus());
            compoundNBT.putInt("mobCount", instance.getMobCount());
            return compoundNBT;
        }

        @Override
        public void readNBT(Capability<ISlayerStatus> capability, ISlayerStatus instance, Direction direction, INBT nbt) {
            int slayerStatus = ((CompoundNBT)nbt).getInt("slayerStatus");
            int mobCount = ((CompoundNBT)nbt).getInt("mobCount");
            instance.setSlayerStatus(slayerStatus);
            instance.setMobCount(mobCount);
        }
    }
}
