package com.iwant2tryhard.skyblockitemsplusplus.capabilities.entitylevel;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;

public class CapabilityMobLevel {

    @CapabilityInject(IMobLevel.class)
    public static Capability<IMobLevel> MOB_LEVEL_CAPABILITY = null;

    public static void register() {
        CapabilityManager.INSTANCE.register(IMobLevel.class, new Storage(), DefaultMobLevel::new);
    }

    public static class Storage implements Capability.IStorage<IMobLevel> {

        @Nullable
        @Override
        public INBT writeNBT(Capability<IMobLevel> capability, IMobLevel instance, Direction direction) {
            CompoundNBT compoundNBT = new CompoundNBT();
            compoundNBT.putInt("mobLevel", instance.getMobLevel());
            return compoundNBT;
        }

        @Override
        public void readNBT(Capability<IMobLevel> capability, IMobLevel instance, Direction direction, INBT nbt) {
            int mobLevel = ((CompoundNBT) nbt).getInt("mobLevel");
            instance.setMobLevel(mobLevel);
        }
    }
}
