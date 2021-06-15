package com.iwant2tryhard.skyblockitemsplusplus.core.event;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.MobStats;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.PlayerStats;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Boots;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Chestplate;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Helmet;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Leggings;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.axes.Netherite_Plated_Diamond_Axe;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.hoes.Netherite_Plated_Diamond_Hoe;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.pickaxes.Netherite_Plated_Diamond_Pickaxe;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.shovels.Netherite_Plated_Diamond_Shovel;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.swords.*;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.EnchantmentInit;
import net.minecraft.block.*;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.particles.IParticleData;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import javax.tools.Tool;
import java.util.Arrays;

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
            }
            else
            {
                if      (target instanceof ZombieEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE.defense, target.getMaxHealth()))); initialDamage *= 2; }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE.defense, target.getMaxHealth())); } }
                else if (target instanceof SkeletonEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.SKELETON.defense, target.getMaxHealth()))); initialDamage *= 2; }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.SKELETON.defense, target.getMaxHealth())); }  }
                else if (target instanceof EndermanEntity) { if (player.getMainHandItem().getItem() instanceof End_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ENDERMAN.defense, target.getMaxHealth()))); initialDamage *= 2; }else { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ENDERMAN.defense, target.getMaxHealth())); } }
                else if (target instanceof EndermiteEntity) { if (player.getMainHandItem().getItem() instanceof End_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ENDERMITE.defense, target.getMaxHealth()))); initialDamage *= 2; }else { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ENDERMITE.defense, target.getMaxHealth())); } }
                else if (target instanceof CreeperEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.CREEPER.defense, target.getMaxHealth())); }
                else if (target instanceof SlimeEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.SLIME.defense, target.getMaxHealth())); }
                else if (target instanceof SpiderEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.SPIDER.defense, target.getMaxHealth())); }
                else if (target instanceof CaveSpiderEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.CAVE_SPIDER.defense, target.getMaxHealth())); }
                else if (target instanceof VillagerEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.VILLAGER.defense, target.getMaxHealth())); }
                else if (target instanceof IronGolemEntity) { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.IRON_GOLEM.defense, target.getMaxHealth())); }
                else if (target instanceof ZombifiedPiglinEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE_PIGMAN.defense, target.getMaxHealth()))); initialDamage *= 2; }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE_PIGMAN.defense, target.getMaxHealth())); }  }
                else if (target instanceof WitherSkeletonEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER_SKELETON.defense, target.getMaxHealth()))); initialDamage *= 2; }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER_SKELETON.defense, target.getMaxHealth())); }  }
                else if (target instanceof WitherEntity) { if (player.getMainHandItem().getItem() instanceof Undead_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER.defense, target.getMaxHealth()))); initialDamage *= 2; }else{ event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER.defense, target.getMaxHealth())); }  }
                else if (target instanceof EnderDragonEntity) { if (player.getMainHandItem().getItem() instanceof End_Sword) { event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ENDER_DRAGON.defense, target.getMaxHealth()))); initialDamage *= 2; }else { event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ENDER_DRAGON.defense, target.getMaxHealth())); } }

                else if (target instanceof PlayerEntity) { event.setAmount(event.getAmount()); }
            }
            if (player.getMainHandItem().getItem() instanceof Flame_Sword)
            {
                target.setSecondsOnFire(3);
            }

            ArmorStandEntity dmgTag = new ArmorStandEntity(worldIn, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
            //dmgTag.forceAddEffect(new EffectInstance(Effects.INVISIBILITY, 1000, 1));
            dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + Math.round(initialDamage * 100)));
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
            float EHP = (target.getMaxHealth() * 5) * ((PlayerStats.getDefense() / 100) + 1);
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
            }
            else
            {
                ArmorStandEntity dmgTag = new ArmorStandEntity(worldIn, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
                //dmgTag.forceAddEffect(new EffectInstance(Effects.INVISIBILITY, 1000, 1));
                dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + Math.round(initialDamage * 100)));
                dmgTag.setCustomNameVisible(true);
                dmgTag.setInvulnerable(true);
                dmgTag.noPhysics = true;
                dmgTag.setInvisible(true);
                worldIn.addFreshEntity(dmgTag);
                if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("initialDamage: " + event.getAmount()), false);}
                event.setAmount(((event.getAmount() / EHP) * target.getMaxHealth()) * 6);
                if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("defense: " + PlayerStats.getDefense()), false);}
                if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("ehp: " + EHP), false);}
                if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("targetMaxHealth: " + target.getMaxHealth()), false);}
                if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("damageTaken : " + event.getAmount()), false);}
            }
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

            int headDefense;
            int chestDefense;
            int legsDefense;
            int feetDefense;

            if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof ArmorItem) { ArmorItem head = (ArmorItem) player.getItemBySlot(EquipmentSlotType.HEAD).getItem();headDefense = head.getDefense(); }else { headDefense = 0; }

            if (player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof ArmorItem) { ArmorItem chest = (ArmorItem) player.getItemBySlot(EquipmentSlotType.CHEST).getItem();chestDefense = chest.getDefense(); }else { chestDefense = 0; }

            if (player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof ArmorItem) { ArmorItem legs = (ArmorItem) player.getItemBySlot(EquipmentSlotType.LEGS).getItem();legsDefense = legs.getDefense(); }else { legsDefense = 0; }

            if (player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof ArmorItem) { ArmorItem feet = (ArmorItem) player.getItemBySlot(EquipmentSlotType.FEET).getItem();feetDefense = feet.getDefense(); }else { feetDefense = 0; }

            PlayerStats.setDefense((headDefense + chestDefense + legsDefense + feetDefense) / 5);


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
        PlayerEntity player = event.getPlayer();
        LivingEntity target = (LivingEntity) event.getTarget();
        if (player.getMainHandItem().getItem() instanceof Ink_Wand)
        {
            Ink_Wand wand = (Ink_Wand) player.getMainHandItem().getItem();
            if (!player.getCooldowns().isOnCooldown(wand))
            {
                target.hurt(DamageSource.playerAttack(player), ((10000 + (PlayerStats.getManaReductionPercent() * 10) + 100) / 100));
                target.addEffect(new EffectInstance(Effects.BLINDNESS, 200, 0));
                target.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 200, 11));
                target.addEffect(new EffectInstance(Effects.WITHER, 60, 2));
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



                if (PlayerStats.debugLogging) { Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("Event Array: " + target.captureDrops()), false); }

                /*for (int i = 0; i < Arrays.stream(collection).count(); ++i)
                {
                    if (PlayerStats.debugLogging) { Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("Event Item: " + collection[i].getItem()), false); }

                    player.addItem(collection[i].getItem());

                    if (PlayerStats.debugLogging) { Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("Event Item added"), false); }
                }*/
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

}
