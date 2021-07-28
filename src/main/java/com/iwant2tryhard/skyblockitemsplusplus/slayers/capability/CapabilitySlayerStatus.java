package com.iwant2tryhard.skyblockitemsplusplus.slayers.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;
import javax.swing.*;

public class CapabilitySlayerStatus {

    /*@CapabilityInject(ISlayerStatus.class)
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
            CompoundNBT tag = new CompoundNBT();
            tag.putInt("slayerStatus", instance.getSlayerStatus());
            tag.putInt("mobCount", instance.getMobCount());
            tag.putInt("zombieSlayerLvl", instance.getZombieSlayerLvl());
            tag.putInt("spiderSlayerLvl", instance.getSpiderSlayerLvl());
            tag.putInt("wolfSlayerLvl", instance.getWolfSlayerLvl());
            tag.putInt("endermanSlayerLvl", instance.getEndermanSlayerLvl());
            return tag;
        }

        @Override
        public void readNBT(Capability<ISlayerStatus> capability, ISlayerStatus instance, Direction direction, INBT inbt) {
            int slayerStatus = ((CompoundNBT) inbt).getInt("slayerStatus");
            int mobCount = ((CompoundNBT) inbt).getInt("mobCount");
            int zombieSlayerLvl = ((CompoundNBT) inbt).getInt("zombieSlayerLvl");
            int spiderSlayerLvl = ((CompoundNBT) inbt).getInt("spiderSlayerLvl");
            int wolfSlayerLvl = ((CompoundNBT) inbt).getInt("wolfSlayerLvl");
            int endermanSlayerLvl = ((CompoundNBT) inbt).getInt("endermanSlayerLvl");
            instance.setSlayerStatus(slayerStatus);
            instance.setMobCount(mobCount);
            instance.setZombieSlayerLvl(zombieSlayerLvl);
            instance.setSpiderSlayerLvl(spiderSlayerLvl);
            instance.setWolfSlayerLvl(wolfSlayerLvl);
            instance.setEndermanSlayerLvl(endermanSlayerLvl);
        }
    }*/
}
