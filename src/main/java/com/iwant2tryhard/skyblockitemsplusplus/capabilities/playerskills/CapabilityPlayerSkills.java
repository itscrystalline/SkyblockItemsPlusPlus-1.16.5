package com.iwant2tryhard.skyblockitemsplusplus.capabilities.playerskills;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;

public class CapabilityPlayerSkills {

    @CapabilityInject(IPlayerSkills.class)
    public static Capability<IPlayerSkills> PLAYER_STATS_CAPABILITY = null;

    public static void register()
    {
        CapabilityManager.INSTANCE.register(IPlayerSkills.class, new Storage(), DefaultPlayerSkills::new);
    }

    public static class Storage implements Capability.IStorage<IPlayerSkills>
    {

        @Nullable
        @Override
        public INBT writeNBT(Capability<IPlayerSkills> capability, IPlayerSkills instance, Direction direction) {
            CompoundNBT compoundNBT = new CompoundNBT();
            compoundNBT.putInt("combatLvl", instance.getCombatLvl());
            compoundNBT.putInt("combatXp", instance.getCombatXp());

            compoundNBT.putInt("miningLvl", instance.getMiningLvl());
            compoundNBT.putInt("miningXp", instance.getMiningXp());

            compoundNBT.putInt("farmingLvl", instance.getFarmingLvl());
            compoundNBT.putInt("farmingXp", instance.getFarmingXp());

            compoundNBT.putInt("enchantingLvl", instance.getEnchantingLvl());
            compoundNBT.putInt("enchantingXp", instance.getEnchantingXp());

            compoundNBT.putInt("foragingLvl", instance.getForagingLvl());
            compoundNBT.putInt("foragingXp", instance.getForagingXp());

            compoundNBT.putInt("fishingLvl", instance.getFishingLvl());
            compoundNBT.putInt("fishingXp", instance.getFishingXp());

            compoundNBT.putInt("alchemyLvl", instance.getAlchemyLvl());
            compoundNBT.putInt("alchemyXp", instance.getAlchemyXp());

            compoundNBT.putInt("strength", instance.getStrength());
            compoundNBT.putInt("baseStrength", instance.getBaseStrength());

            compoundNBT.putInt("manaReductionPercent", instance.getManaReductionPercent());
            compoundNBT.putInt("baseManaReductionPercent", instance.getBaseManaReductionPercent());

            compoundNBT.putInt("defense", instance.getDefense());
            compoundNBT.putInt("baseDefense", instance.getBaseDefense());

            compoundNBT.putInt("coins", instance.getCoins());

            compoundNBT.putInt("ultWiseLvl", instance.getUltWiseLvl());
            return compoundNBT;
        }

        @Override
        public void readNBT(Capability<IPlayerSkills> capability, IPlayerSkills instance, Direction direction, INBT nbt) {
            int combatLvl = ((CompoundNBT)nbt).getInt("combatLvl");
            int combatXp = ((CompoundNBT)nbt).getInt("combatXp");
            instance.setCombatLvl(combatLvl);
            instance.setCombatXp(combatXp);

            int miningLvl = ((CompoundNBT)nbt).getInt("miningLvl");
            int miningXp = ((CompoundNBT)nbt).getInt("miningXp");
            instance.setMiningLvl(miningLvl);
            instance.setMiningXp(miningXp);

            int farmingLvl = ((CompoundNBT)nbt).getInt("farmingLvl");
            int farmingXp = ((CompoundNBT)nbt).getInt("farmingXp");
            instance.setFarmingLvl(farmingLvl);
            instance.setFarmingXp(farmingXp);

            int foragingLvl = ((CompoundNBT)nbt).getInt("foragingLvl");
            int foragingXp = ((CompoundNBT)nbt).getInt("foragingXp");
            instance.setForagingLvl(foragingLvl);
            instance.setForagingXp(foragingXp);

            int enchantingLvl = ((CompoundNBT)nbt).getInt("enchantingLvl");
            int enchantingXp = ((CompoundNBT)nbt).getInt("enchantingXp");
            instance.setEnchantingLvl(enchantingLvl);
            instance.setEnchantingXp(enchantingXp);

            int fishingLvl = ((CompoundNBT)nbt).getInt("fishingLvl");
            int fishingXp = ((CompoundNBT)nbt).getInt("fishingXp");
            instance.setFishingLvl(fishingLvl);
            instance.setFishingXp(fishingXp);

            int alchemyLvl = ((CompoundNBT)nbt).getInt("alchemyLvl");
            int alchemyXp = ((CompoundNBT)nbt).getInt("alchemyXp");
            instance.setAlchemyLvl(alchemyLvl);
            instance.setAlchemyXp(alchemyXp);

            int strength = ((CompoundNBT)nbt).getInt("strength");
            int manaReductionPercent = ((CompoundNBT)nbt).getInt("manaReductionPercent");
            int defense = ((CompoundNBT)nbt).getInt("defense");
            int coins = ((CompoundNBT)nbt).getInt("coins");
            int ultWiseLvl = ((CompoundNBT)nbt).getInt("ultWiseLvl");
            instance.setStrength(strength);
            instance.setManaReductionPercent(manaReductionPercent);
            instance.setDefense(defense);
            instance.setCoins(coins);
            instance.setUltWiseLvl(ultWiseLvl);

            int baseStrength = ((CompoundNBT)nbt).getInt("baseStrength");
            int baseManaReductionPercent = ((CompoundNBT)nbt).getInt("baseManaReductionPercent");
            int baseDefense = ((CompoundNBT)nbt).getInt("baseDefense");
            instance.setBaseStrength(baseStrength);
            instance.setBaseManaReductionPercent(baseManaReductionPercent);
            instance.setBaseDefense(baseDefense);
        }
    }
}