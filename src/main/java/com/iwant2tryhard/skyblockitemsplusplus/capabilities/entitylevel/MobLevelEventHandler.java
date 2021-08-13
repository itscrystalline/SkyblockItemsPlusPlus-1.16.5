package com.iwant2tryhard.skyblockitemsplusplus.capabilities.entitylevel;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SkyblockItemsPlusPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MobLevelEventHandler {
    @SubscribeEvent
    public static void onAttachCapabilitiesEvent(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof MobEntity) {
            MobLevelProvider providerMobLevel = new MobLevelProvider();
            event.addCapability(new ResourceLocation(SkyblockItemsPlusPlus.MOD_ID, "moblevel"), providerMobLevel);
            event.addListener(providerMobLevel::invalidate);
        }
    }

    @SubscribeEvent
    public static void OnSpawn(final EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof MobEntity) {
            MobEntity target = (MobEntity) event.getEntity();
            target.getCapability(CapabilityMobLevel.MOB_LEVEL_CAPABILITY).ifPresent(mobLevel -> {
                mobLevel.setMobLevel((int) Math.floor(Math.abs(Math.random() - Math.random()) * (1 + 100 - 1) + 1));
            });
        }
    }
}
