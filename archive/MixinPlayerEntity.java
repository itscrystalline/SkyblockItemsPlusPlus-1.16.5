package com.iwant2tryhard.skyblockitemsplusplus.mixins;

import com.iwant2tryhard.skyblockitemsplusplus.common.entities.other.PlayerStats;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//@Mixin(PlayerEntity.class)
public class MixinPlayerEntity {
    //@Inject(at = @At("CONSTANT"), )
    //public final PlayerStats stats;

    /*@Inject(at = @At("HEAD"), method = "addAdditionalSaveData")
    private void addAdditionalSaveData(CompoundNBT compoundNBT, CallbackInfo callbackInfo)
    {
        compoundNBT.putInt("combatLvl", combatLvl);
        compoundNBT.putInt("combatXp", combatXp);

        compoundNBT.putInt("miningLvl", miningLvl);
        compoundNBT.putInt("miningXp", miningXp);

        compoundNBT.putInt("farmingLvl", farmingLvl);
        compoundNBT.putInt("farmingXp", farmingXp);

        compoundNBT.putInt("enchantingLvl", enchantingLvl);
        compoundNBT.putInt("enchantingXp", enchantingXp);

        compoundNBT.putInt("foragingLvl", foragingLvl);
        compoundNBT.putInt("foragingXp", foragingXp);

        compoundNBT.putInt("fishingLvl", fishingLvl);
        compoundNBT.putInt("fishingXp", fishingXp);

        compoundNBT.putInt("alchemyLvl", alchemyLvl);
        compoundNBT.putInt("alchemyXp", alchemyXp);
    }*/
}
