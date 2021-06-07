package com.iwant2tryhard.skyblockitemsplusplus.core.event;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.MobStats;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.PlayerStats;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.Aspect_Of_The_End;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.Aspect_Of_The_Jerry;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.Undead_Sword;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = SkyblockItemsPlusPlus.MOD_ID, bus = EventBusSubscriber.Bus.FORGE)
public class EventHandler {
    @SubscribeEvent
    public static void onLivingEntityHurt(final LivingHurtEvent event)
    {
        //System.out.println("Hit " + target + " " + event.getSource());
        if (event.getSource().getEntity() instanceof PlayerEntity)
        {
            LivingEntity target = event.getEntityLiving();
            PlayerEntity player = (PlayerEntity) event.getSource().getEntity();

            if (PlayerStats.debugLogging) { Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("initialDamage : " + event.getAmount()), false); }

            if ((player.getMainHandItem().getItem() == Items.NETHERITE_SWORD) |
             (player.getMainHandItem().getItem() == Items.DIAMOND_SWORD)|
             (player.getMainHandItem().getItem() == Items.GOLDEN_SWORD)|
             (player.getMainHandItem().getItem() == Items.IRON_SWORD)|
             (player.getMainHandItem().getItem() == Items.WOODEN_SWORD)|
             (player.getMainHandItem().getItem() == Items.NETHERITE_AXE)|
             (player.getMainHandItem().getItem() == Items.DIAMOND_AXE)|
             (player.getMainHandItem().getItem() == Items.GOLDEN_AXE) |
             (player.getMainHandItem().getItem() == Items.IRON_AXE)|
             (player.getMainHandItem().getItem() == Items.WOODEN_AXE)|
             (player.getMainHandItem().getItem() == Items.NETHERITE_PICKAXE)|
             (player.getMainHandItem().getItem() == Items.DIAMOND_PICKAXE)|
             (player.getMainHandItem().getItem() == Items.GOLDEN_PICKAXE)|
             (player.getMainHandItem().getItem() == Items.IRON_PICKAXE)|
             (player.getMainHandItem().getItem() == Items.WOODEN_PICKAXE)|
             (player.getMainHandItem().getItem() == Items.NETHERITE_SHOVEL) |
             (player.getMainHandItem().getItem() == Items.DIAMOND_SHOVEL)|
             (player.getMainHandItem().getItem() == Items.GOLDEN_SHOVEL)|
             (player.getMainHandItem().getItem() == Items.IRON_SHOVEL)|
             (player.getMainHandItem().getItem() == Items.WOODEN_SHOVEL)|
             (player.getMainHandItem().getItem() == Items.NETHERITE_HOE)|
             (player.getMainHandItem().getItem() == Items.DIAMOND_HOE)|
             (player.getMainHandItem().getItem() == Items.GOLDEN_HOE)|
             (player.getMainHandItem().getItem() == Items.IRON_HOE)|
            (player.getMainHandItem().getItem() == Items.WOODEN_HOE)|
            (player.getMainHandItem().getItem() instanceof Aspect_Of_The_Jerry))
            {
                event.setAmount(event.getAmount());
            }else
            {
                if      (target instanceof ZombieEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE.defense, target.getMaxHealth()))); }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE.defense, target.getMaxHealth())); } }
                else if (target instanceof SkeletonEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.SKELETON.defense, target.getMaxHealth()))); }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.SKELETON.defense, target.getMaxHealth())); }  }
                else if (target instanceof EndermanEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ENDERMAN.defense, target.getMaxHealth())); }
                else if (target instanceof CreeperEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.CREEPER.defense, target.getMaxHealth())); }
                else if (target instanceof SlimeEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.SLIME.defense, target.getMaxHealth())); }
                else if (target instanceof SpiderEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.SPIDER.defense, target.getMaxHealth())); }
                else if (target instanceof CaveSpiderEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.CAVE_SPIDER.defense, target.getMaxHealth())); }
                else if (target instanceof VillagerEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.VILLAGER.defense, target.getMaxHealth())); }
                else if (target instanceof IronGolemEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.IRON_GOLEM.defense, target.getMaxHealth())); }
                else if (target instanceof ZombifiedPiglinEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE_PIGMAN.defense, target.getMaxHealth()))); }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE_PIGMAN.defense, target.getMaxHealth())); }  }
                else if (target instanceof WitherSkeletonEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER_SKELETON.defense, target.getMaxHealth()))); }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER_SKELETON.defense, target.getMaxHealth())); }  }
                else if (target instanceof WitherEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER.defense, target.getMaxHealth()))); }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER.defense, target.getMaxHealth())); }  }
                else if (target instanceof EnderDragonEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ENDER_DRAGON.defense, target.getMaxHealth())); }
            }

            if (PlayerStats.debugLogging) { Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calculatedDamage : " + event.getAmount()), false); }
        }

    }

    @SubscribeEvent
    public static void playerUpdate(final LivingEvent.LivingUpdateEvent event)
    {
        if (event.getEntityLiving() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();

            //S02PacketChat packet = new S02PacketChat(new ChatComponentText(message), Byte.parseByte("2"));
            //player.playerNetServerHandler.sendPacket(packet);
            //System.out.println(PlayerStats.getStrength());

            PlayerStats.setStrength(player.experienceLevel + 100);
            PlayerStats.setManaReductionPercent(player.experienceLevel + 0);

            if (player.getMainHandItem().getItem() instanceof Aspect_Of_The_End || player.getOffhandItem().getItem() instanceof Aspect_Of_The_End)
            {
                PlayerStats.addStrength(100);
            }
        }
    }
}
