package com.iwant2tryhard.skyblockitemsplusplus.slayers.capability;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ClientUtils;
import com.iwant2tryhard.skyblockitemsplusplus.slayers.entity.slayerdealer.SlayerDealerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SkyblockItemsPlusPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SlayerStatusEventHandler {

    /*@SubscribeEvent
    public static void onAttachCapabilitiesEvent(AttachCapabilitiesEvent<Entity> event)
    {
        if (event.getObject() instanceof PlayerEntity)
        {
            *//*SlayerStatusProvider provider = new SlayerStatusProvider();
            event.addCapability(new ResourceLocation(SkyblockItemsPlusPlus.MOD_ID, "slayerstats"), provider);
            event.addListener(provider::invalidate);*//*
        }
    }*/

    /*@SubscribeEvent
    public static void onInteractSlayerDealerLeft(LivingAttackEvent event)
    {
        if (event.getSource().getEntity() instanceof PlayerEntity & event.getEntityLiving() instanceof SlayerDealerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
            player.getCapability(CapabilitySlayerStatus.SLAYER_STATUS_CAPABILITY).ifPresent(slayerStatus -> {
                ClientUtils.SendPrivateMessage("Your Slayer Stats is:");
                ClientUtils.SendPrivateMessage("    Your Current Slayer Stats is: " + slayerStatus.getSlayerStatus());
                ClientUtils.SendPrivateMessage("    Your Mob Count is: " + slayerStatus.getMobCount());
                ClientUtils.SendPrivateMessage("    Your Zombie Slayer is: " + slayerStatus.getZombieSlayerLvl());
                ClientUtils.SendPrivateMessage("    Your Spider Slayer is: " + slayerStatus.getSpiderSlayerLvl());
                ClientUtils.SendPrivateMessage("    Your Wolf Slayer is: " + slayerStatus.getWolfSlayerLvl());
                ClientUtils.SendPrivateMessage("    Your Enderman Slayer is: " + slayerStatus.getEndermanSlayerLvl());
                player.level.playSound((PlayerEntity) event.getSource().getEntity(), event.getSource().getEntity(), SoundEvents.VILLAGER_AMBIENT, SoundCategory.NEUTRAL, 1.0f, 1f);
            });
        }
    }
    @SubscribeEvent
    public static void onInteractSlayerDealerRight(PlayerInteractEvent.EntityInteract event)
    {
        PlayerEntity player = event.getPlayer();
        player.getCapability(CapabilitySlayerStatus.SLAYER_STATUS_CAPABILITY).ifPresent(slayerStatus -> {
            ClientUtils.SendPrivateMessage("Switch Slayer coming soon!");
            player.level.playSound(event.getPlayer(), event.getPlayer(), SoundEvents.NOTE_BLOCK_BIT, SoundCategory.NEUTRAL, 1.0f, 1f);
        });
    }*/
}
