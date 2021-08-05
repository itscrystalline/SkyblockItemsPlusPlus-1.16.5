package com.iwant2tryhard.skyblockitemsplusplus.capabilities.reforges;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;
import java.util.UUID;

public class CapabilityItemReforges {

    @CapabilityInject(IItemReforges.class)
    public static Capability<IItemReforges> ITEM_REFORGES_CAPABILITY = null;

    public static void register()
    {
        CapabilityManager.INSTANCE.register(IItemReforges.class, new Storage(), DefaultItemReforges::new);
    }

    public static class Storage implements Capability.IStorage<IItemReforges>
    {

        @Nullable
        @Override
        public INBT writeNBT(Capability<IItemReforges> capability, IItemReforges instance, Direction direction) {
            CompoundNBT compoundNBT = new CompoundNBT();
            compoundNBT.putInt("reforgeItemType", instance.getReforgeItemType());
            compoundNBT.putInt("reforgeType", instance.getReforgeType());
            //compoundNBT.putUUID("owner", instance.getOwner());
            return compoundNBT;
        }

        @Override
        public void readNBT(Capability<IItemReforges> capability, IItemReforges instance, Direction direction, INBT nbt) {
            int reforgeItemType = ((CompoundNBT)nbt).getInt("reforgeItemType");
            int reforgeType = ((CompoundNBT)nbt).getInt("reforgeType");
            //UUID owner = ((CompoundNBT)nbt).getUUID("owner");
            instance.setReforgeItemType(reforgeItemType);
            instance.setReforgeType(reforgeType);
            //instance.setOwner(owner);
        }
    }
}
