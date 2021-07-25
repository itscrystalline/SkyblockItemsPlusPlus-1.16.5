package com.iwant2tryhard.skyblockitemsplusplus.slayers.capability;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.capabilities.playerskills.PlayerSkillsProvider;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ClientUtils;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.slayers.entity.slayerdealer.SlayerDealerEntity;
import com.iwant2tryhard.skyblockitemsplusplus.slayers.util.SlayerStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Arrays;

@Mod.EventBusSubscriber(modid = SkyblockItemsPlusPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SlayerStatusEventHandler {
    @SubscribeEvent
    public static void onAttachCapabilitiesEvent(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity)
        {
            SlayerStatusProvider provider = new SlayerStatusProvider();
            event.addCapability(new ResourceLocation(SkyblockItemsPlusPlus.MOD_ID, "slayerstatus"), provider);
            event.addListener(provider::invalidate);
        }
    }

    @SubscribeEvent
    public static void onKillEntity(LivingDeathEvent event)
    {
        if (event.getSource().getEntity() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
            player.getCapability(CapabilitySlayerStatus.SLAYER_STATUS_CAPABILITY).ifPresent(slayerStatus -> {
                if (slayerStatus.getSlayerStatus() > 0)
                {
                    switch (slayerStatus.getSlayerStatus())
                    {
                        case 1:
                            slayerStatus.setSlayerStatus(event.getEntityLiving() instanceof ZombieEntity ?
                                    slayerStatus.getSlayerStatus() + 1 :
                                    slayerStatus.getSlayerStatus());
                        case 2:
                            slayerStatus.setSlayerStatus(event.getEntityLiving() instanceof SpiderEntity ?
                                    slayerStatus.getSlayerStatus() + 1 :
                                    slayerStatus.getSlayerStatus());
                        case 3:
                            slayerStatus.setSlayerStatus(event.getEntityLiving() instanceof WolfEntity ?
                                    slayerStatus.getSlayerStatus() + 1 :
                                    slayerStatus.getSlayerStatus());
                        case 4:
                            slayerStatus.setSlayerStatus(event.getEntityLiving() instanceof EndermanEntity ?
                                    slayerStatus.getSlayerStatus() + 1 :
                                    slayerStatus.getSlayerStatus());
                    }
                }
            });
        }
    }

    @SubscribeEvent
    public static void onInteractLeft(LivingAttackEvent event)
    {
        if (event.getSource().getEntity() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
            if (player == Minecraft.getInstance().player)
            {
                try {
                    player.getCapability(CapabilitySlayerStatus.SLAYER_STATUS_CAPABILITY).ifPresent(slayerstatus -> {
                        ClientUtils.SendPrivateMessage("Your Slayer Data is:");
                        ClientUtils.SendPrivateMessage("    Slayer Type: " + SlayerStatus.fromId(slayerstatus.getSlayerStatus()).name);
                        ClientUtils.SendPrivateMessage("    Mob Count: " + slayerstatus.getMobCount());
                        player.level.playSound(player, player, SoundEvents.VILLAGER_TRADE, SoundCategory.AMBIENT, 1, 1);
                    });
                }
                catch (ClassCastException e)
                {
                    ClientUtils.SendPrivateMessage(ColorText.RED.toString() + "Why is there an error?");
                    ClientUtils.SendPrivateMessage(ColorText.RED.toString() + e + "," + e.getMessage() + "," + Arrays.toString(e.getStackTrace()));
                }
            }
        }
    }

    @SubscribeEvent
    public static void onInteractRight(PlayerInteractEvent.EntityInteract event)
    {
        if (event.getTarget() instanceof SlayerDealerEntity)
        {
            PlayerEntity player = event.getPlayer();
            SlayerDealerEntity slayerDealer = (SlayerDealerEntity) event.getTarget();

            player.getCapability(CapabilitySlayerStatus.SLAYER_STATUS_CAPABILITY).ifPresent(slayerstatus -> {
                if (slayerstatus.getSlayerStatus() < 1 | slayerstatus.getMobCount() == 0)
                {
                    if (slayerstatus.getSlayerStatus() < 4)
                    {
                        slayerstatus.setSlayerStatus(slayerstatus.getSlayerStatus() + 1);
                    }else{
                        slayerstatus.setSlayerStatus(-1);
                    }
                    ClientUtils.SendPrivateMessage("Changed slayer type to: " + SlayerStatus.fromId(slayerstatus.getSlayerStatus()).name);
                    player.level.playSound(player, player, SoundEvents.NOTE_BLOCK_BIT, SoundCategory.AMBIENT, 1, 1);
                }
                else
                {
                    ClientUtils.SendPrivateMessage(ColorText.RED.toString() +"You must finish you current slayer first!");
                    player.level.playSound(player, player, SoundEvents.VILLAGER_NO, SoundCategory.AMBIENT, 1, 1);
                }
            });

        }
    }
}
