package com.iwant2tryhard.skyblockitemsplusplus.core.event;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ClientUtils;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.ZealotEntity;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.materials.items.EyeOfTheDragons;
import com.iwant2tryhard.skyblockitemsplusplus.core.enums.MobStats;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.other.PlayerStats;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Boots;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Chestplate;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Helmet;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Leggings;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.hardened_refined_netherite_armor.Hardened_Refined_Netherite_Boots;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.hardened_refined_netherite_armor.Hardened_Refined_Netherite_Chestplate;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.hardened_refined_netherite_armor.Hardened_Refined_Netherite_Helmet;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.hardened_refined_netherite_armor.Hardened_Refined_Netherite_Leggings;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.refined_netherite_armor.Refined_Netherite_Boots;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.refined_netherite_armor.Refined_Netherite_Chestplate;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.refined_netherite_armor.Refined_Netherite_Helmet;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.refined_netherite_armor.Refined_Netherite_Leggings;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.axes.Netherite_Plated_Diamond_Axe;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.hoes.Netherite_Plated_Diamond_Hoe;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.pickaxes.Netherite_Plated_Diamond_Pickaxe;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.shovels.Netherite_Plated_Diamond_Shovel;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.swords.*;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.EnchantmentInit;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.EntityTypeInit;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.ItemInit;
import net.minecraft.block.*;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.EnderDragonPartEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@EventBusSubscriber(modid = SkyblockItemsPlusPlus.MOD_ID, bus = EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    @SubscribeEvent
    public static void onLivingEntityHurt(final LivingHurtEvent event)
    {
        World worldIn = event.getEntity().getCommandSenderWorld();

        float initialDamage = event.getAmount();
        //System.out.println("Hit " + target + " " + event.getSource());
        if (event.getSource().getEntity() instanceof PlayerEntity)
        {
            LivingEntity target = event.getEntityLiving();
            PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
            boolean hasOneForAll = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ONE_FOR_ALL.get(), player.getMainHandItem()) > 0;
            int lifeStealLvl = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.LIFE_STEAL.get(), player.getMainHandItem());
            boolean hasEmeraldBlade = player.getMainHandItem().getItem() instanceof Emerald_Blade;


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
            (player.getMainHandItem().getItem() == Items.BOW)|
            (player.getMainHandItem().getItem() instanceof Aspect_Of_The_Jerry)|
            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Sword)|
            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Axe)|
             (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Pickaxe)|
              (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Shovel)|
              (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Hoe))
            {
                event.setAmount(event.getAmount());
                if (lifeStealLvl > 0)
                {
                    int rnd = MathHelper.nextInt(new Random(), 1, 40 - (lifeStealLvl * 10));
                    if (rnd == 1 && PlayerStats.isEnoughMana(6f, player))
                    {
                        float healAmnt = target.getHealth() * (lifeStealLvl * 0.075f * PlayerStats.getLifeStealDamageMultiplier((player.getArmorValue() / 3f) * 10f));
                        if (PlayerStats.debugLogging) {ClientUtils.SendPrivateMessage("armorVal: " + player.getArmorValue());}
                        player.heal(healAmnt);
                        target.setHealth(target.getHealth() - (healAmnt / 2f));
                        int mana = PlayerStats.calcManaUsage(6f);
                        player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - mana);
                        ClientUtils.SendPrivateMessage(ColorText.GREEN + "Your " + ColorText.GRAY + "Life Steal " + lifeStealLvl + ColorText.GREEN + " Stole " + ColorText.RED + Math.round(healAmnt / 2) + " health " + ColorText.GREEN + "from " + ColorText.GOLD + "PLACEHOLDER_ENTITY" + ColorText.GREEN + "! " + ColorText.AQUA + "(" + (mana * 5) + " Mana)");
                    }
                }
                //Refined netherite armor
                if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Refined_Netherite_Helmet
                        & player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Refined_Netherite_Chestplate
                        & player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Refined_Netherite_Leggings
                        & player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Refined_Netherite_Boots)
                {
                    if ((player.getMainHandItem().getItem() == Items.NETHERITE_SWORD) |
                            (player.getMainHandItem().getItem() instanceof Hardened_Refined_Netherite_Sword) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Sword) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_AXE) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Axe) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_HOE) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Hoe) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_SHOVEL) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Shovel) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_PICKAXE) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Pickaxe))
                    {
                        if (PlayerStats.debugLogging) {ClientUtils.SendPrivateMessage("before: " + event.getAmount());}
                        event.setAmount(event.getAmount() * 1.2f);
                        initialDamage *= 1.2f;
                        if (PlayerStats.debugLogging) {ClientUtils.SendPrivateMessage("after: " + event.getAmount());}
                        if (PlayerStats.debugLogging) {ClientUtils.SendPrivateMessage("from: 1/1");}
                    }
                }
                //Hardened Refined netherite armor
                else if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Hardened_Refined_Netherite_Helmet
                        & player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Hardened_Refined_Netherite_Chestplate
                        & player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Hardened_Refined_Netherite_Leggings
                        & player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Hardened_Refined_Netherite_Boots)
                {
                    if ((player.getMainHandItem().getItem() == Items.NETHERITE_SWORD) |
                            (player.getMainHandItem().getItem() instanceof Hardened_Refined_Netherite_Sword) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Sword) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_AXE) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Axe) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_HOE) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Hoe) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_SHOVEL) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Shovel) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_PICKAXE) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Pickaxe))
                    {
                        if (PlayerStats.debugLogging) {ClientUtils.SendPrivateMessage("before: " + event.getAmount());}
                        event.setAmount(event.getAmount() * 1.4f);
                        initialDamage *= 1.4f;
                        if (PlayerStats.debugLogging) {ClientUtils.SendPrivateMessage("after: " + event.getAmount());}
                        if (PlayerStats.debugLogging) {ClientUtils.SendPrivateMessage("from: 1/2");}
                    }
                }
            }
            else
            {
                if      (target instanceof ZombieEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade))); initialDamage *= 2; }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); } }
                else if (target instanceof SkeletonEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.SKELETON.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade))); initialDamage *= 2; }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.SKELETON.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); }  }
                else if (target instanceof EndermanEntity) { if (player.getMainHandItem().getItem() instanceof End_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ENDERMAN.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade))); initialDamage *= 2; }else { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ENDERMAN.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); } }
                else if (target instanceof ZealotEntity) { if (player.getMainHandItem().getItem() instanceof End_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ZEALOT.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade))); initialDamage *= 2; }else { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ZEALOT.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); } }
                else if (target instanceof EndermiteEntity) { if (player.getMainHandItem().getItem() instanceof End_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ENDERMITE.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade))); initialDamage *= 2; }else { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ENDERMITE.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); } }
                else if (target instanceof CreeperEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.CREEPER.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); }
                else if (target instanceof SlimeEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.SLIME.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); }
                else if (target instanceof SpiderEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.SPIDER.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); }
                else if (target instanceof CaveSpiderEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.CAVE_SPIDER.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); }
                else if (target instanceof VillagerEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.VILLAGER.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); }
                else if (target instanceof IronGolemEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.IRON_GOLEM.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); }
                else if (target instanceof ZombifiedPiglinEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE_PIGMAN.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade))); initialDamage *= 2; }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE_PIGMAN.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); }  }
                else if (target instanceof WitherSkeletonEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER_SKELETON.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade))); initialDamage *= 2; }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER_SKELETON.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); }  }
                else if (target instanceof WitherEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade))); initialDamage *= 2; }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); }  }
                else if (target instanceof EnderDragonEntity) { if (player.getMainHandItem().getItem() instanceof End_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ENDER_DRAGON.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade))); initialDamage *= 2; }else { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ENDER_DRAGON.defense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade)); } }

                else if (target instanceof PlayerEntity) { event.setAmount(event.getAmount()); }

                if (lifeStealLvl > 0)
                {
                    int rnd = MathHelper.nextInt(new Random(), 1, 40 - (lifeStealLvl * 10));
                    if (rnd == 1 && PlayerStats.isEnoughMana(6f, player))
                    {
                        float healAmnt = target.getHealth() * (lifeStealLvl * 0.05f * PlayerStats.getLifeStealDamageMultiplier((player.getArmorValue() / 3f) * 10f));
                        if (PlayerStats.debugLogging) {ClientUtils.SendPrivateMessage("armorVal: " + player.getArmorValue());}
                        player.heal(healAmnt);
                        target.setHealth(target.getHealth() - (healAmnt / 2f));
                        int mana = PlayerStats.calcManaUsage(6f);
                        player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - mana);
                        ClientUtils.SendPrivateMessage(ColorText.GREEN + "Your " + ColorText.GRAY + "Life Steal " + lifeStealLvl + ColorText.GREEN + " Stole " + ColorText.RED + Math.round(healAmnt / 2) + " health " + ColorText.GREEN + "from " + ColorText.GOLD + "PLACEHOLDER_ENTITY" + ColorText.GREEN + "! " + ColorText.AQUA + "(" + (mana * 5) + " Mana)");
                    }
                }
                //Refined netherite armor
                if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Refined_Netherite_Helmet
                        & player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Refined_Netherite_Chestplate
                        & player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Refined_Netherite_Leggings
                        & player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Refined_Netherite_Boots)
                {
                    if ((player.getMainHandItem().getItem() == Items.NETHERITE_SWORD) |
                            (player.getMainHandItem().getItem() instanceof Hardened_Refined_Netherite_Sword) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Sword) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_AXE) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Axe) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_HOE) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Hoe) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_SHOVEL) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Shovel) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_PICKAXE) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Pickaxe))
                    {
                        if (PlayerStats.debugLogging) {ClientUtils.SendPrivateMessage("before: " + event.getAmount());}
                        event.setAmount(event.getAmount() * 1.2f);
                        initialDamage *= 1.2f;
                        if (PlayerStats.debugLogging) {ClientUtils.SendPrivateMessage("after: " + event.getAmount());}
                        if (PlayerStats.debugLogging) {ClientUtils.SendPrivateMessage("from: 2/1");}
                    }
                }
                //Hardened Refined netherite armor
                else if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Hardened_Refined_Netherite_Helmet
                        & player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Hardened_Refined_Netherite_Chestplate
                        & player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Hardened_Refined_Netherite_Leggings
                        & player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Hardened_Refined_Netherite_Boots)
                {
                    if ((player.getMainHandItem().getItem() == Items.NETHERITE_SWORD) |
                            (player.getMainHandItem().getItem() instanceof Hardened_Refined_Netherite_Sword) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Sword) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_AXE) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Axe) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_HOE) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Hoe) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_SHOVEL) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Shovel) |
                            (player.getMainHandItem().getItem() == Items.NETHERITE_PICKAXE) |
                            (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Pickaxe))
                    {
                        if (PlayerStats.debugLogging) {ClientUtils.SendPrivateMessage("before: " + event.getAmount());}
                        event.setAmount(event.getAmount() * 1.4f);
                        initialDamage *= 1.4f;
                        if (PlayerStats.debugLogging) {ClientUtils.SendPrivateMessage("after: " + event.getAmount());}
                        if (PlayerStats.debugLogging) {ClientUtils.SendPrivateMessage("from: 2/2");}
                    }
                }
                
            }
            if (player.getMainHandItem().getItem() instanceof Flame_Sword)
            {
                target.setSecondsOnFire(3);
            }


            ArmorStandEntity dmgTag = new ArmorStandEntity(worldIn, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
            //dmgTag.forceAddEffect(new EffectInstance(Effects.INVISIBILITY, 1000, 1));
            dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + Math.round((initialDamage + (hasEmeraldBlade ? PlayerStats.calcEmeraldBladeBoost() : 0)) * 100)));
            dmgTag.setCustomNameVisible(true);
            dmgTag.setInvulnerable(true);
            dmgTag.noPhysics = true;
            dmgTag.setInvisible(true);
            worldIn.addFreshEntity(dmgTag);
            //dmgTag.kill();

            if (PlayerStats.debugLogging) { Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calculatedDamage : " + event.getAmount()), false); }
        }
        if (event.getEntity() instanceof PlayerEntity)
        {
            PlayerEntity target = (PlayerEntity) event.getEntity();
            if (event.getSource() == DamageSource.FALL) {
                ArmorStandEntity dmgTag = new ArmorStandEntity(worldIn, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
                //dmgTag.forceAddEffect(new EffectInstance(Effects.INVISIBILITY, 1000, 1));
                dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + Math.round(initialDamage * 100)));
                dmgTag.setCustomNameVisible(true);
                dmgTag.setInvulnerable(true);
                dmgTag.noPhysics = true;
                dmgTag.setInvisible(true);
                worldIn.addFreshEntity(dmgTag);
                if (PlayerStats.debugLogging) {
                    Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("initialDamage: " + event.getAmount()), false);
                }
                if (PlayerStats.debugLogging) {
                    Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calc: " + "(1 - (event.getAmount() - (" + PlayerStats.getDefense() + " / (" + PlayerStats.getDefense() + " + 20f))))"), false);
                }
                if (PlayerStats.debugLogging) {
                    Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calc: " + (1 - (event.getAmount() - (PlayerStats.getDefense() / (PlayerStats.getDefense() + 20f))))), false);
                }
                if (PlayerStats.debugLogging) {
                    Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("defense: " + PlayerStats.getDefense()), false);
                }
                if (PlayerStats.debugLogging) {
                    Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("damageTaken : " + event.getAmount()), false);
                }
                float fallDamageMultiplier = 0f;

                if (target.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Refined_Netherite_Helmet) {
                    fallDamageMultiplier += 0.25f;
                }
                if (target.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Refined_Netherite_Chestplate) {
                    fallDamageMultiplier += 0.25f;
                }
                if (target.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Refined_Netherite_Leggings) {
                    fallDamageMultiplier += 0.25f;
                }
                if (target.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Refined_Netherite_Boots) {
                    fallDamageMultiplier += 0.25f;
                }

                if (target.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Hardened_Refined_Netherite_Helmet) {
                    fallDamageMultiplier += 0.5f;
                }
                if (target.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Hardened_Refined_Netherite_Chestplate) {
                    fallDamageMultiplier += 0.5f;
                }
                if (target.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Hardened_Refined_Netherite_Leggings) {
                    fallDamageMultiplier += 0.5f;
                }
                if (target.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Hardened_Refined_Netherite_Boots) {
                    fallDamageMultiplier += 0.5f;
                }

                event.setAmount(event.getAmount() + event.getAmount() * fallDamageMultiplier);
                ClientUtils.SendPrivateMessage("fallMultiplier: " + fallDamageMultiplier);
                ClientUtils.SendPrivateMessage("final: " + event.getAmount());

            } else if (event.getSource().isBypassArmor()) {
                event.setAmount(event.getAmount());

            }else{
                ArmorStandEntity dmgTag = new ArmorStandEntity(worldIn, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
                //dmgTag.forceAddEffect(new EffectInstance(Effects.INVISIBILITY, 1000, 1));
                dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + Math.round(initialDamage * 100)));
                dmgTag.setCustomNameVisible(true);
                dmgTag.setInvulnerable(true);
                dmgTag.noPhysics = true;
                dmgTag.setInvisible(true);
                worldIn.addFreshEntity(dmgTag);
                if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("initialDamage: " + event.getAmount()), false);}
                if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calc: " + "(1 - (event.getAmount() - (" + PlayerStats.getDefense() + " / (" + PlayerStats.getDefense() + " + 20f))))"), false);}
                if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calc: " + (1 - (event.getAmount() - (PlayerStats.getDefense() / (PlayerStats.getDefense() + 20f))))), false);}
                event.setAmount(event.getAmount() * (1 - (PlayerStats.getDefense() / (PlayerStats.getDefense() + 20f))));
                if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("defense: " + PlayerStats.getDefense()), false);}
                if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("damageTaken : " + event.getAmount()), false);}
            }
            //float EHP = (target.getMaxHealth() * 5) * ((PlayerStats.getDefense() / 100) + 1);



        }
        if (!(event.getEntityLiving() instanceof PlayerEntity))
        {
            LivingEntity target =  event.getEntityLiving();
            Item head = target.getItemBySlot(EquipmentSlotType.HEAD).getItem();
            Item chest = target.getItemBySlot(EquipmentSlotType.CHEST).getItem();
            Item legs = target.getItemBySlot(EquipmentSlotType.LEGS).getItem();
            Item boot = target.getItemBySlot(EquipmentSlotType.FEET).getItem();
            if (((head == Items.NETHERITE_HELMET) &
                    (chest == Items.NETHERITE_CHESTPLATE) &
                    (legs == Items.NETHERITE_LEGGINGS) &
                    (boot == Items.NETHERITE_BOOTS)) |
                    ((head == Items.DIAMOND_HELMET) &
                            (chest == Items.DIAMOND_CHESTPLATE) &
                            (legs == Items.DIAMOND_LEGGINGS) &
                            (boot == Items.DIAMOND_BOOTS)) |
                    ((head == Items.GOLDEN_HELMET) &
                            (chest == Items.GOLDEN_CHESTPLATE) &
                            (legs == Items.GOLDEN_LEGGINGS) &
                            (boot == Items.GOLDEN_BOOTS)) |
                    ((head == Items.IRON_HELMET) &
                            (chest == Items.IRON_CHESTPLATE) &
                            (legs == Items.IRON_LEGGINGS) &
                            (boot == Items.IRON_BOOTS)) |
                    ((head == Items.LEATHER_HELMET) &
                            (chest == Items.LEATHER_CHESTPLATE) &
                            (legs == Items.LEATHER_LEGGINGS) &
                            (boot == Items.LEATHER_BOOTS)))
            {
                event.setAmount(event.getAmount());
            }else
            {
                event.setAmount(event.getAmount() * 2);
            }
        }

    }

    private static int ticksSinceOnFire = 0;

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
            if (player.experienceLevel > 90) {
                PlayerStats.setManaReductionPercent(90);
            } else {
                PlayerStats.setManaReductionPercent(player.experienceLevel);
            }
            if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), player.getOffhandItem()) > 0)
            {
                PlayerStats.setUltWiseLvl(EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), player.getOffhandItem()));
            }else if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), player.getMainHandItem()) > 0)
            {
                PlayerStats.setUltWiseLvl(EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), player.getMainHandItem()));
            }else
            {
                PlayerStats.setUltWiseLvl(0);
            }

            //emeralds to coins
            PlayerStats.setCoins((player.inventory.countItem(Items.EMERALD) * 6) + (player.inventory.countItem(Items.EMERALD_BLOCK) * 54) + (player.inventory.countItem(ItemInit.REFINED_EMERALD.get()) * 960) + (player.inventory.countItem(ItemInit.REFINED_EMERALD_BLOCK.get()) * 8640));

            if (player.getMainHandItem().getItem() instanceof Aspect_Of_The_End || player.getOffhandItem().getItem() instanceof Aspect_Of_The_End)
            {
                PlayerStats.addStrength(100);
            }
            if (player.getMainHandItem().getItem() instanceof Flame_Sword || player.getOffhandItem().getItem() instanceof Flame_Sword)
            {
                PlayerStats.addStrength(20);
            }
            if (player.getMainHandItem().getItem() instanceof Zombie_Sword || player.getOffhandItem().getItem() instanceof Zombie_Sword)
            {
                PlayerStats.addStrength(50);
                if (player.experienceLevel > 65)
                { PlayerStats.setManaReductionPercent(90); }
                else
                { PlayerStats.addManaReductionPercent(25); }
            }
            if (player.getMainHandItem().getItem() instanceof Ornate_Zombie_Sword || player.getOffhandItem().getItem() instanceof Ornate_Zombie_Sword)
            {
                PlayerStats.addStrength(60);
                if (player.experienceLevel > 65)
                { PlayerStats.setManaReductionPercent(90); }
                else
                { PlayerStats.addManaReductionPercent(25); }
            }
            if (player.getMainHandItem().getItem() instanceof Florid_Zombie_Sword || player.getOffhandItem().getItem() instanceof Florid_Zombie_Sword)
            {
                PlayerStats.addStrength(80);
                if (player.experienceLevel > 40)
                { PlayerStats.setManaReductionPercent(90); }
                else
                { PlayerStats.addManaReductionPercent(50); }
            }
            if (player.getMainHandItem().getItem() instanceof Hunter_Knife || player.getOffhandItem().getItem() instanceof Hunter_Knife)
            {
                player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 20, 0));
            }
            if (player.getMainHandItem().getItem() instanceof Ink_Wand || player.getOffhandItem().getItem() instanceof Ink_Wand)
            {
                PlayerStats.addStrength(90);
            }

            if (player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Refined_Netherite_Leggings
                    & player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Refined_Netherite_Boots)
            {
                player.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20, 0));
            }
            if (player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Hardened_Refined_Netherite_Boots)
            {
                player.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20, 0));
            }


            //Accessory abilities
            boolean hasCampfireBadge = false;
            if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) |
                    player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()) |
                    player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance()) |
                    player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance()))
            {
                hasCampfireBadge = true;
            }
            //campfire
            if (hasCampfireBadge)
            {
                if (!((player.inventory.countItem(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem()) > 1) |
                        (player.inventory.countItem(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem()) > 1) |
                        (player.inventory.countItem(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem()) > 1) |
                        (player.inventory.countItem(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem()) > 1)))
                {
                    if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance()))
                    {
                        player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                        player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 40) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }

                    else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance()))
                    {
                        player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 40) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 30);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }

                    else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance()))
                    {
                        player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                        player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 40) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }

                    else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance()))
                    {
                        player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                        player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 40) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }

                    else if (player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance()))
                    {
                        player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                        player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 40) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }

                    else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()))
                    {
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 60) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 40);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }

                    else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance()))
                    {
                        player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 40) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 30);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }

                    else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance()))
                    {
                        player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                        player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 40) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }

                    else if (player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance()))
                    {
                        player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 40) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 30);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }

                    else if (player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance()))
                    {
                        player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                        player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 40) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }

                    else if (player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance()) &
                            player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance()))
                    {
                        player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                        player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 40) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }

                    else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()))
                    {
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 60) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 50);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }

                    else if (player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()))
                    {
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 60) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 40);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }

                    else if (player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance()))
                    {
                        player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 40) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 30);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }

                    else if (player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance()))
                    {
                        player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                        player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                        if (player.isOnFire())
                        {
                            //ClientUtils.SendPrivateMessage("you are on fire!");
                            //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                            if (ticksSinceOnFire >= 40) {
                                //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                if (rnd == 10)
                                {
                                    ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                    ClientUtils.SendPrivateMessage("you healed!");
                                    player.heal(1f);
                                }
                                ticksSinceOnFire += 1;
                            } else {
                                ticksSinceOnFire += 1;
                            }
                        } else {
                            ticksSinceOnFire = 0;
                        }
                    }
                }
            }






            int headDefense;
            int chestDefense;
            int legsDefense;
            int feetDefense;

            if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof ArmorItem) { ArmorItem head = (ArmorItem) player.getItemBySlot(EquipmentSlotType.HEAD).getItem();headDefense = head.getDefense(); }else { headDefense = 0; }

            if (player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof ArmorItem) { ArmorItem chest = (ArmorItem) player.getItemBySlot(EquipmentSlotType.CHEST).getItem();chestDefense = chest.getDefense(); }else { chestDefense = 0; }

            if (player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof ArmorItem) { ArmorItem legs = (ArmorItem) player.getItemBySlot(EquipmentSlotType.LEGS).getItem();legsDefense = legs.getDefense(); }else { legsDefense = 0; }

            if (player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof ArmorItem) { ArmorItem feet = (ArmorItem) player.getItemBySlot(EquipmentSlotType.FEET).getItem();feetDefense = feet.getDefense(); }else { feetDefense = 0; }

            PlayerStats.setDefense(headDefense + chestDefense + legsDefense + feetDefense);


            //Armor abilities
            //farm suit
            //Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("armor: " + player.getItemBySlot(EquipmentSlotType.HEAD).getItem() + " ," + player.getItemBySlot(EquipmentSlotType.CHEST).getItem() + " ," + player.getItemBySlot(EquipmentSlotType.LEGS).getItem() + " ," + player.getItemBySlot(EquipmentSlotType.FEET).getItem()), false);
            if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Farm_Suit_Helmet
            & player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Farm_Suit_Chestplate
            & player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Farm_Suit_Leggings
            & player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Farm_Suit_Boots)
            {
                Block aboveFeetBlock = event.getEntity().getCommandSenderWorld()
                        .getBlockState(new BlockPos(player.position().x, player.position().y + 1, player.position().z))
                        .getBlock();
                Block feetBlock = event.getEntity().getCommandSenderWorld()
                        .getBlockState(new BlockPos(player.position().x, player.position().y, player.position().z))
                        .getBlock();
                Block belowFeetBlock = event.getEntity().getCommandSenderWorld()
                        .getBlockState(new BlockPos(player.position().x, player.position().y - 1, player.position().z))
                        .getBlock();
                //Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("block: " + feetBlock + " ," + belowFeetBlock), false);
                if (feetBlock instanceof BushBlock || belowFeetBlock instanceof BushBlock || aboveFeetBlock instanceof BushBlock ||
                        feetBlock instanceof SugarCaneBlock || belowFeetBlock instanceof SugarCaneBlock || aboveFeetBlock instanceof SugarCaneBlock ||
                    feetBlock instanceof FarmlandBlock || belowFeetBlock instanceof FarmlandBlock || aboveFeetBlock instanceof FarmlandBlock)
                {
                    //Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("on cropblock!"), false);
                    player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 60, 2));
                }
            }


        }
    }

    @SubscribeEvent
    public static void playerInteractEntity(final PlayerInteractEvent.EntityInteract event)
    {
        if (event.getTarget() instanceof LivingEntity)
        {
            PlayerEntity player = event.getPlayer();
            LivingEntity target = event.getTarget() instanceof EnderDragonPartEntity ? ((EnderDragonPartEntity) event.getTarget()).getParent() : (LivingEntity) event.getTarget();
            if (player.getMainHandItem().getItem() instanceof Ink_Wand)
            {
                Ink_Wand wand = (Ink_Wand) player.getMainHandItem().getItem();
                if (!player.getCooldowns().isOnCooldown(wand))
                {
                    target.hurt(DamageSource.playerAttack(player), ((10000 + (PlayerStats.getManaReductionPercent() * 10) + 100) / 100));
                    target.addEffect(new EffectInstance(Effects.BLINDNESS, 200, 0));
                    target.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 200, 11));
                    target.addEffect(new EffectInstance(Effects.WITHER, 200, 2));
                    AreaEffectCloudEntity effect = new AreaEffectCloudEntity(event.getWorld(), target.position().x, target.position().y, target.position().z);
                    effect.setRadius(1f);
                    effect.setDuration(200);
                    effect.setPotion(new Potion(new EffectInstance(Effects.BLINDNESS, 200, 0),
                            new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 200, 11),
                            new EffectInstance(Effects.WITHER, 200, 2)));
                    event.getWorld().addFreshEntity(effect);
                }
            }
        }
    }

    //TODO:Fix drops
    @SubscribeEvent
    public static void OnKillTelekinesis(final LivingDeathEvent event)
    {

        if (PlayerStats.debugLogging) { Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("Event fired!"), false); }

        if (event.getSource().getEntity() instanceof PlayerEntity)
        {
            if (PlayerStats.debugLogging) { Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("Event is player"), false); }

            PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
            LivingEntity target = event.getEntityLiving();
            player.getCommandSenderWorld().playSound(player, player, SoundEvents.PLAYER_ATTACK_STRONG, SoundCategory.NEUTRAL, 1.0f, 1.0f);
            if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.TELEKINESIS.get(), player.getMainHandItem()) > 0)
            {
                if (PlayerStats.debugLogging) { Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("Event detected telekinesis"), false); }

                /*target.lootFrom()*/
            }
        }
    }

    @SubscribeEvent
    public static void OnBreakTelekinesis(final BlockEvent.BreakEvent event)
    {
       /* PlayerEntity player = event.getPlayer();
        if (player.getMainHandItem().getItem() instanceof ToolItem)
        {
            ToolItem tool = (ToolItem) player.getMainHandItem().getItem();
            ItemStack toolStack = player.getMainHandItem();
            if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.TELEKINESIS.get(), toolStack) > 0)
            {
                event.getState().getDrops()
            }
        }*/

    }

    @SubscribeEvent
    public static void OnReciveEOTD(final PlayerEvent.ItemPickupEvent event)
    {
        ClientUtils.SendPrivateMessage("received item:" + event.getStack().getItem().getRegistryName());
        if (event.getStack().getItem() == ItemInit.EYE_OF_THE_DRAGONS.get())
        {
            ClientUtils.SendPrivateMessage(ColorText.AQUA + "\uD83D\uDD25 " + ColorText.GOLD + event.getPlayer().getGameProfile().getName() + ColorText.AQUA + " has obtained " + ColorText.DARK_PURPLE + "Eye of the Dragons" + ColorText.AQUA + "!");
        }
    }

    @SubscribeEvent
    public static void OnKillZealot(final LivingDeathEvent event)
    {
        if (event.getEntityLiving() instanceof ZealotEntity && event.getSource().getEntity() instanceof PlayerEntity)
        {
            World world = event.getEntityLiving().level;
            int rnd = MathHelper.nextInt(new Random(), 1, 250);
            if (rnd == 50)
            {
                ItemEntity eotd = new ItemEntity(world, event.getEntityLiving().position().x, event.getEntityLiving().position().y, event.getEntityLiving().position().z);
                eotd.setItem(ItemInit.EYE_OF_THE_DRAGONS.get().getDefaultInstance());
                world.addFreshEntity(eotd);
                world.playSound((PlayerEntity) event.getSource().getEntity(), event.getSource().getEntity(), SoundEvents.WITHER_SPAWN, SoundCategory.NEUTRAL, 1.0f, 1.0f);
            }
        }
    }

    /*@SubscribeEvent
    public static void OnTickEnderman(final LivingEvent.LivingUpdateEvent event)
    {
        if (event.getEntityLiving() instanceof EndermanEntity && event.getEntityLiving().level.dimensionType().equals(Dimension.END))
        {
            int rnd = MathHelper.nextInt(new Random(), 1, 10000);
            if (rnd == 100)
            {
                ZealotEntity zealot = new ZealotEntity(event.getEntityLiving().level);
                zealot.setPos(event.getEntityLiving().getX(), event.getEntityLiving().getY(), event.getEntityLiving().getZ());
                zealot.changeDimension()
                event.getEntityLiving().level.addFreshEntity()
                event.getEntityLiving().kill();
            }
        }
    }*/

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        if (event.getCategory().equals(Biome.Category.THEEND))
        {
            List<MobSpawnInfo.Spawners> spawns =
                    event.getSpawns().getSpawner(EntityClassification.MONSTER);

            spawns.add(new MobSpawnInfo.Spawners(EntityTypeInit.ZEALOT.get(), 5, 1, 3));
        }
    }

}
