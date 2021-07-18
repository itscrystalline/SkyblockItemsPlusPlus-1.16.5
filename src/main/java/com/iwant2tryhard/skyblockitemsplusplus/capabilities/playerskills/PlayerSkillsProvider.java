package com.iwant2tryhard.skyblockitemsplusplus.capabilities.playerskills;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PlayerSkillsProvider implements ICapabilitySerializable<CompoundNBT> {
    private final DefaultPlayerSkills skills = new DefaultPlayerSkills();
    private final LazyOptional<IPlayerSkills> playerSkillsOptional = LazyOptional.of(() -> skills);

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
        if (CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY == null) {
            return new CompoundNBT();
        } else {
            return (CompoundNBT) CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY.writeNBT(skills, null);
        }
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        if (CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY != null) {
            CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY.readNBT(skills, null, nbt);
        }
    }
}
