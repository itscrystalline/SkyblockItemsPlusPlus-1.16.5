package com.iwant2tryhard.skyblockitemsplusplus.capabilities.playerskills;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ClientUtils;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.core.event.EventHandler;
import com.iwant2tryhard.skyblockitemsplusplus.slayers.entity.slayerdealer.SlayerDealerEntity;
import com.iwant2tryhard.skyblockitemsplusplus.slayers.util.SlayerStatus;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.brewing.PotionBrewEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SkyblockItemsPlusPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerSkillsEventHandler {
    @SubscribeEvent
    public static void onAttachCapabilitiesEvent(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof PlayerEntity) {
            PlayerSkillsProvider providerskills = new PlayerSkillsProvider();
            event.addCapability(new ResourceLocation(SkyblockItemsPlusPlus.MOD_ID, "skills"), providerskills);
            event.addListener(providerskills::invalidate);
        }
    }

    @SubscribeEvent
    public static void AwardCombatStats(final LivingDeathEvent event)
    {
        if (event.getSource().getEntity() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
            player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                skills.AwardCombatXp(Math.round(event.getEntityLiving().getExperienceReward((PlayerEntity) event.getSource().getEntity()) + (event.getEntityLiving().getMaxHealth() * 3)));
                //ClientUtils.SendPrivateMessage("Combat XP: " + skills.getCombatXp() + "/" + ((Math.pow((skills.getCombatLvl() + 3), 3) - Math.pow((skills.getCombatLvl() + 1), 2)) * 2));
                //ClientUtils.SendPrivateMessage("Progress: " + Math.round(skills.getCombatXp() / ((Math.pow((skills.getCombatLvl() + 3), 3) - Math.pow((skills.getCombatLvl() + 1), 2)) * 2) * 100) + "%");
                //ClientUtils.SendPrivateMessage("Combat LVL: " + skills.getCombatLvl());
                player.level.playSound(null, player, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1f, 1f);
                EventHandler.skillShowText = ColorText.DARK_AQUA + "+" + (Math.round(event.getEntityLiving().getExperienceReward((PlayerEntity) event.getSource().getEntity()) + (event.getEntityLiving().getMaxHealth() * 3))) + " Combat (" + skills.getCombatXp() + "/" + ((Math.pow((skills.getCombatLvl() + 3), 3) - Math.pow((skills.getCombatLvl() + 1), 2)) * 2) + ")";
                EventHandler.skillShowTimer = 60;
            });
            //ClientUtils.SendPrivateMessage("calc: " + "(((" + PlayerSkills.combatLvl + " + 3) ^ 2) - ((" + PlayerSkills.combatLvl + " + 1) ^ 2))");
        }
    }

    @SubscribeEvent
    public static void AwardMiningStats(final BlockEvent.BreakEvent event)
    {
        if (!event.getPlayer().isCreative())
        {
            event.getPlayer().getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                if (event.getState().is(BlockTags.CROPS)) {
                    skills.AwardFarmingXp(6);
                    //ClientUtils.SendPrivateMessage("Farming XP: " + skills.getFarmingXp() + "/" + ((Math.pow((skills.getFarmingLvl() + 3), 3) - Math.pow((skills.getFarmingLvl() + 1), 2)) * 2));
                    //ClientUtils.SendPrivateMessage("Progress: " + Math.round(skills.getFarmingXp() / ((Math.pow((skills.getFarmingLvl() + 3), 3) - Math.pow((skills.getFarmingLvl() + 1), 2)) * 2) * 100) + "%");
                    //ClientUtils.SendPrivateMessage("Mining LVL: " + skills.getFarmingLvl());
                    event.getPlayer().level.playSound(null, event.getPlayer(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1f, 1f);
                    EventHandler.skillShowText = ColorText.DARK_AQUA + "+6 Farming (" + skills.getFarmingXp() + "/" + ((Math.pow((skills.getFarmingLvl() + 3), 3) - Math.pow((skills.getFarmingLvl() + 1), 2)) * 2) + ")";
                    EventHandler.skillShowTimer = 60;
                } else if (event.getState().getBlock() == Blocks.NETHER_WART) {
                    skills.AwardAlchemyXp(10);
                    //ClientUtils.SendPrivateMessage("Farming XP: " + skills.getFarmingXp() + "/" + ((Math.pow((skills.getFarmingLvl() + 3), 3) - Math.pow((skills.getFarmingLvl() + 1), 2)) * 2));
                    //ClientUtils.SendPrivateMessage("Progress: " + Math.round(skills.getFarmingXp() / ((Math.pow((skills.getFarmingLvl() + 3), 3) - Math.pow((skills.getFarmingLvl() + 1), 2)) * 2) * 100) + "%");
                    //ClientUtils.SendPrivateMessage("Mining LVL: " + skills.getFarmingLvl());
                    event.getPlayer().level.playSound(null, event.getPlayer(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1f, 1f);
                    EventHandler.skillShowText = ColorText.DARK_AQUA + "+10 Alchemy (" + skills.getAlchemyXp() + "/" + ((Math.pow((skills.getAlchemyLvl() + 3), 3) - Math.pow((skills.getAlchemyLvl() + 1), 2)) * 2) + ")";
                    EventHandler.skillShowTimer = 60;
                } else if (event.getState().is(BlockTags.LOGS)) {
                    skills.AwardForagingXp(10);
                    //ClientUtils.SendPrivateMessage("Foraging XP: " + skills.getForagingXp() + "/" + ((Math.pow((skills.getForagingLvl() + 3), 3) - Math.pow((skills.getForagingLvl() + 1), 2)) * 2));
                    //ClientUtils.SendPrivateMessage("Progress: " + Math.round(skills.getForagingXp() / ((Math.pow((skills.getForagingLvl() + 3), 3) - Math.pow((skills.getForagingLvl() + 1), 2)) * 2) * 100) + "%");
                    //ClientUtils.SendPrivateMessage("Mining LVL: " + skills.getForagingLvl());
                    event.getPlayer().level.playSound(null, event.getPlayer(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1f, 1f);
                    EventHandler.skillShowText = ColorText.DARK_AQUA + "+10 Foraging (" + skills.getForagingXp() + "/" + ((Math.pow((skills.getForagingLvl() + 3), 3) - Math.pow((skills.getForagingLvl() + 1), 2)) * 2) + ")";
                    EventHandler.skillShowTimer = 60;
                }
                else {
                    skills.AwardMiningXp(((event.getState().getHarvestLevel() + 1) * 5) + (event.getExpToDrop() * 2));
                    //ClientUtils.SendPrivateMessage("Mining XP: " + skills.getMiningXp() + "/" + ((Math.pow((skills.getMiningLvl() + 3), 3) - Math.pow((skills.getMiningLvl() + 1), 2)) * 2));
                    //ClientUtils.SendPrivateMessage("Progress: " + Math.round(skills.getMiningXp() / ((Math.pow((skills.getMiningLvl() + 3), 3) - Math.pow((skills.getMiningLvl() + 1), 2)) * 2) * 100) + "%");
                    //ClientUtils.SendPrivateMessage("Mining LVL: " + skills.getMiningLvl());
                    event.getPlayer().level.playSound(null, event.getPlayer(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1f, 1f);
                    EventHandler.skillShowText = ColorText.DARK_AQUA + "+" + (((event.getState().getHarvestLevel() + 1) * 5) + (event.getExpToDrop() * 2)) + " Mining (" + skills.getMiningXp() + "/" + ((Math.pow((skills.getMiningLvl() + 3), 3) - Math.pow((skills.getMiningLvl() + 1), 2)) * 2) + ")";
                    EventHandler.skillShowTimer = 60;
                }
            });
        }
    }

    @SubscribeEvent
    public static void AwardAlchemyStats(final PotionBrewEvent event)
    {
        //skills.AwardAlchemyXP(10);
        /*ClientUtils.SendPrivateMessage("Mining XP: " + PlayerSkills.miningXp + "/" + ((Math.pow((PlayerSkills.miningLvl + 3), 3) - Math.pow((PlayerSkills.miningLvl + 1), 2)) * 2));
        ClientUtils.SendPrivateMessage("Progress: " + Math.round(PlayerSkills.miningXp / ((Math.pow((PlayerSkills.miningLvl + 3), 3) - Math.pow((PlayerSkills.miningLvl + 1), 2)) * 2) * 100) + "%");
        ClientUtils.SendPrivateMessage("Mining LVL: " + PlayerSkills.miningLvl);*/
    }


    @SubscribeEvent
    public static void onInteractSlayerDealerLeft(final LivingAttackEvent event)
    {
        if (event.getSource().getEntity() instanceof PlayerEntity & event.getEntityLiving() instanceof SlayerDealerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
            player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(slayerStatus -> {
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
    public static void onInteractSlayerDealerRight(final PlayerInteractEvent.EntityInteract event)
    {
        PlayerEntity player = event.getPlayer();
        if (event.getTarget() instanceof SlayerDealerEntity)
        {
            player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(slayerStatus -> {
                if (slayerStatus.getSlayerStatus() > 3){
                    slayerStatus.setSlayerStatus(-1);
                } else {
                    slayerStatus.setSlayerStatus(slayerStatus.getSlayerStatus() + 1);
                }
                ClientUtils.SendPrivateMessage("Your slayer status is set to: " + SlayerStatus.fromId(slayerStatus.getSlayerStatus()).name.getString());
                player.level.playSound(event.getPlayer(), event.getPlayer(), SoundEvents.NOTE_BLOCK_SNARE, SoundCategory.NEUTRAL, 10000000f, 100000f);
            });
        }
    }

    @SubscribeEvent
    public static void RegisterMobCount(final LivingDeathEvent event)
    {
        if (event.getSource().getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
            player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(slayerStatus -> {
                if (event.getEntityLiving() instanceof ZombieEntity && slayerStatus.getSlayerStatus() == 1) {
                    slayerStatus.setMobCount(slayerStatus.getMobCount() + 1);
                } else if (event.getEntityLiving() instanceof SpiderEntity && slayerStatus.getSlayerStatus() == 2) {
                    slayerStatus.setMobCount(slayerStatus.getMobCount() + 1);
                } else if (event.getEntityLiving() instanceof WolfEntity && slayerStatus.getSlayerStatus() == 3) {
                    slayerStatus.setMobCount(slayerStatus.getMobCount() + 1);
                } else if (event.getEntityLiving() instanceof EndermanEntity && slayerStatus.getSlayerStatus() == 4) {
                    slayerStatus.setMobCount(slayerStatus.getMobCount() + 1);
                }
            });
        }
    }


    /*public static void addMana(PlayerItemConsume event)
    {
        PlayerEntity player = event.getPlayer();
        player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(slayerStatus -> {
            ClientUtils.SendPrivateMessage("Switch Slayer coming soon!");
            player.level.playSound(event.getPlayer(), event.getPlayer(), SoundEvents.NOTE_BLOCK_BIT, SoundCategory.NEUTRAL, 1.0f, 1f);
        });
    }*/

    @SubscribeEvent
    public static void PersistCapabilityData(final PlayerEvent.Clone event)
    {
        PlayerEntity player = event.getPlayer();
        player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(newskills -> {
            if (event.isWasDeath()){
                event.getOriginal().getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(oldskills -> {
                    newskills.setCombatXp(oldskills.getCombatXp());
                    newskills.setCombatLvl(oldskills.getCombatLvl());
                    
                    newskills.setMiningXp(oldskills.getMiningXp());
                    newskills.setMiningLvl(oldskills.getMiningLvl());
                    
                    newskills.setFarmingXp(oldskills.getFarmingXp());
                    newskills.setFarmingLvl(oldskills.getFarmingLvl());
                    
                    newskills.setForagingXp(oldskills.getForagingXp());
                    newskills.setForagingLvl(oldskills.getForagingLvl());
                    
                    newskills.setEnchantingXp(oldskills.getEnchantingXp());
                    newskills.setEnchantingLvl(oldskills.getEnchantingLvl());
                    
                    newskills.setFishingXp(oldskills.getFishingXp());
                    newskills.setFishingLvl(oldskills.getFishingLvl());
                    
                    newskills.setAlchemyXp(oldskills.getAlchemyXp());
                    newskills.setAlchemyLvl(oldskills.getAlchemyLvl());
                    

                    newskills.setStrength(oldskills.getStrength());
                    newskills.setBaseStrength(oldskills.getBaseStrength());

                    newskills.setMana(oldskills.getMana());
                    newskills.setMaxMana(oldskills.getMaxMana());
                    newskills.setBaseMaxMana(oldskills.getBaseMaxMana());

                    newskills.setDefense(oldskills.getDefense());
                    newskills.setBaseDefense(oldskills.getBaseDefense());

                    newskills.setHealth(oldskills.getHealth());
                    newskills.setMaxHealth(oldskills.getMaxHealth());
                    newskills.setBaseMaxHealth(oldskills.getBaseMaxHealth());

                    newskills.setFerocity(oldskills.getFerocity());
                    newskills.setBaseFerocity(oldskills.getBaseFerocity());

                    newskills.setCoins(oldskills.getCoins());

                    newskills.setUltWiseLvl(oldskills.getUltWiseLvl());
                });
            }
        });
    }
}
