package com.iwant2tryhard.skyblockitemsplusplus.core.event;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.capabilities.entitylevel.CapabilityMobLevel;
import com.iwant2tryhard.skyblockitemsplusplus.capabilities.playerskills.CapabilityPlayerSkills;
import com.iwant2tryhard.skyblockitemsplusplus.capabilities.reforges.CapabilityItemReforges;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ClientUtils;
import com.iwant2tryhard.skyblockitemsplusplus.client.util.ColorText;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.ZealotEntity;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.other.PlayerStats;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.TaggedSwordItem;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Boots;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Chestplate;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Helmet;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Leggings;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.hardened_refined_netherite_armor.Hardened_Refined_Netherite_Boots;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.hardened_refined_netherite_armor.Hardened_Refined_Netherite_Chestplate;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.hardened_refined_netherite_armor.Hardened_Refined_Netherite_Helmet;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.hardened_refined_netherite_armor.Hardened_Refined_Netherite_Leggings;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.mushroom_armor.Mushroom_Boots;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.mushroom_armor.Mushroom_Chestplate;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.mushroom_armor.Mushroom_Helmet;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.mushroom_armor.Mushroom_Leggings;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.refined_netherite_armor.Refined_Netherite_Boots;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.refined_netherite_armor.Refined_Netherite_Chestplate;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.refined_netherite_armor.Refined_Netherite_Helmet;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.refined_netherite_armor.Refined_Netherite_Leggings;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.axes.Netherite_Plated_Diamond_Axe;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.bows.ShortBow;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.bows.Terminator;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.hoes.Netherite_Plated_Diamond_Hoe;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.pickaxes.Netherite_Plated_Diamond_Pickaxe;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.shovels.Netherite_Plated_Diamond_Shovel;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.swords.*;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.EnchantmentInit;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.EntityTypeInit;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BushBlock;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.boss.dragon.EnderDragonPartEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

@EventBusSubscriber(modid = SkyblockItemsPlusPlus.MOD_ID, bus = EventBusSubscriber.Bus.FORGE)
public class EventHandler {


    private static final int ferocityCount = 0;

    public static int skillShowTimer = 0;
    public static String skillShowText = "";

    public static int abilityShowTimer = 0;
    public static String abilityShowText = "";

    //private static int ticksSinceHit = 0;
    @SubscribeEvent
    public static void onLivingEntityHurt(final LivingHurtEvent event) {
        World world = event.getEntityLiving().level;
        LivingEntity target = event.getEntityLiving();
        //int targetTotalDefense = 0;
        AtomicReference<Integer> targetTotalDefense = new AtomicReference<>(0);
        if (target != null) {
            targetTotalDefense.updateAndGet(v -> target.getArmorValue() * 20);
        }

        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
        AtomicReference<Integer> attackerTotalDefense = new AtomicReference<>(0);
        if (attacker != null) {
            attackerTotalDefense.updateAndGet(v -> attacker.getArmorValue());
        }

        if (attacker != null) {
            if (!(attacker.getMainHandItem().getItem() instanceof TaggedSwordItem) | event.getSource().getDirectEntity() instanceof AbstractArrowEntity) {
                event.setAmount(event.getAmount() * 20);
            } else {
                event.setAmount(event.getAmount());
            }
        } else {
            event.setAmount(event.getAmount());
        }

        if (attacker instanceof PlayerEntity) {
            PlayerEntity attacker1 = (PlayerEntity) attacker;
            attacker1.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                boolean hasOneForAll = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ONE_FOR_ALL.get(), attacker1.getMainHandItem()) > 0;
                int lifeStealLvl = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.LIFE_STEAL.get(), attacker1.getMainHandItem());
                int lightlvl = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.LIGHT.get(), attacker1.getMainHandItem());
                boolean hasEmeraldBlade = attacker1.getMainHandItem().getItem() instanceof Emerald_Blade;
                float actualAmount = event.getAmount();
                actualAmount += hasOneForAll ? 20f : 0f;
                actualAmount += hasEmeraldBlade ? PlayerStats.calcEmeraldBladeBoost(skills.getCoins()) : 0f;
                event.setAmount(actualAmount * (skills.getStrength() / 100f) * (1f + skills.getCombatLvl() * 0.04f));

                if (lifeStealLvl > 0) {
                    int rnd = MathHelper.nextInt(new Random(), 1, 40 - (lifeStealLvl * 10));

                    if (rnd == 1 && PlayerStats.isEnoughMana(6f, skills.getMana(), skills.getUltWiseLvl(), attacker1)) {
                        float healAmnt = target.getHealth() * (lifeStealLvl * 0.05f * PlayerStats.getLifeStealDamageMultiplier((attacker1.getArmorValue() / 3f) * 10f));
                        if (PlayerStats.debugLogging) {
                            ClientUtils.SendPrivateMessage("armorVal: " + attacker1.getArmorValue());
                        }
                        attacker1.heal(healAmnt);
                        target.setHealth(target.getHealth() - (healAmnt / 2f));
                        int mana = PlayerStats.calcManaUsage(6f, skills.getMana(), skills.getUltWiseLvl());
                        attacker1.getFoodData().setFoodLevel(attacker1.getFoodData().getFoodLevel() - mana);
                        ClientUtils.SendPrivateMessage(ColorText.GREEN + "Your " + ColorText.GRAY + "Life Steal " + lifeStealLvl + ColorText.GREEN + " Stole " + ColorText.RED + Math.round(healAmnt / 2) + " health " + ColorText.GREEN + "from " + ColorText.GOLD + "PLACEHOLDER_ENTITY" + ColorText.GREEN + "! " + ColorText.AQUA + "(" + (mana * 5) + " Mana)");
                    }


                }
                //Refined netherite armor
                if (attacker1.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Refined_Netherite_Helmet
                        & attacker1.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Refined_Netherite_Chestplate
                        & attacker1.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Refined_Netherite_Leggings
                        & attacker1.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Refined_Netherite_Boots) {
                    if ((attacker1.getMainHandItem().getItem() == Items.NETHERITE_SWORD) |
                            (attacker1.getMainHandItem().getItem() instanceof Hardened_Refined_Netherite_Sword) |
                            (attacker1.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Sword) |
                            (attacker1.getMainHandItem().getItem() == Items.NETHERITE_AXE) |
                            (attacker1.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Axe) |
                            (attacker1.getMainHandItem().getItem() == Items.NETHERITE_HOE) |
                            (attacker1.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Hoe) |
                            (attacker1.getMainHandItem().getItem() == Items.NETHERITE_SHOVEL) |
                            (attacker1.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Shovel) |
                            (attacker1.getMainHandItem().getItem() == Items.NETHERITE_PICKAXE) |
                            (attacker1.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Pickaxe)) {
                        if (PlayerStats.debugLogging) {
                            ClientUtils.SendPrivateMessage("before: " + event.getAmount());
                        }
                        event.setAmount(event.getAmount() * 1.2f);
                        if (PlayerStats.debugLogging) {
                            ClientUtils.SendPrivateMessage("after: " + event.getAmount());
                        }
                        if (PlayerStats.debugLogging) {
                            ClientUtils.SendPrivateMessage("from: 2/1");
                        }
                    }
                }
                //Hardened Refined netherite armor
                else if (attacker1.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Hardened_Refined_Netherite_Helmet
                        & attacker1.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Hardened_Refined_Netherite_Chestplate
                        & attacker1.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Hardened_Refined_Netherite_Leggings
                        & attacker1.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Hardened_Refined_Netherite_Boots) {
                    if ((attacker1.getMainHandItem().getItem() == Items.NETHERITE_SWORD) |
                            (attacker1.getMainHandItem().getItem() instanceof Hardened_Refined_Netherite_Sword) |
                            (attacker1.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Sword) |
                            (attacker1.getMainHandItem().getItem() == Items.NETHERITE_AXE) |
                            (attacker1.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Axe) |
                            (attacker1.getMainHandItem().getItem() == Items.NETHERITE_HOE) |
                            (attacker1.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Hoe) |
                            (attacker1.getMainHandItem().getItem() == Items.NETHERITE_SHOVEL) |
                            (attacker1.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Shovel) |
                            (attacker1.getMainHandItem().getItem() == Items.NETHERITE_PICKAXE) |
                            (attacker1.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Pickaxe)) {
                        if (PlayerStats.debugLogging) {
                            ClientUtils.SendPrivateMessage("before: " + event.getAmount());
                        }
                        event.setAmount(event.getAmount() * 1.4f);
                        if (PlayerStats.debugLogging) {
                            ClientUtils.SendPrivateMessage("after: " + event.getAmount());
                        }
                        if (PlayerStats.debugLogging) {
                            ClientUtils.SendPrivateMessage("from: 2/2");
                        }
                    }
                }

                ArmorStandEntity dmgTag = new ArmorStandEntity(world, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
                dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + Math.round(event.getAmount())));
                dmgTag.setCustomNameVisible(true);
                dmgTag.setInvulnerable(true);
                dmgTag.noPhysics = true;
                dmgTag.setInvisible(true);
                world.addFreshEntity(dmgTag);
            });
        }

        if (attacker instanceof MobEntity) {
            MobEntity attacker2 = (MobEntity) attacker;
            attacker2.getCapability(CapabilityMobLevel.MOB_LEVEL_CAPABILITY).ifPresent(mobLevel -> {
                boolean hasOneForAll = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ONE_FOR_ALL.get(), attacker2.getMainHandItem()) > 0;
                int lifeStealLvl = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.LIFE_STEAL.get(), attacker2.getMainHandItem());
                int lightlvl = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.LIGHT.get(), attacker2.getMainHandItem());

                float actualAmount = event.getAmount();
                actualAmount += hasOneForAll ? 20f : 0f;
                event.setAmount(actualAmount * (((((mobLevel.getMobLevel() / 2f) - 1f) * 50f) + 100f) / 100f) * (1f + (mobLevel.getMobLevel() / 4f) * 0.04f));

                //Refined netherite armor
                if (attacker2.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Refined_Netherite_Helmet
                        & attacker2.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Refined_Netherite_Chestplate
                        & attacker2.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Refined_Netherite_Leggings
                        & attacker2.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Refined_Netherite_Boots) {
                    if ((attacker2.getMainHandItem().getItem() == Items.NETHERITE_SWORD) |
                            (attacker2.getMainHandItem().getItem() instanceof Hardened_Refined_Netherite_Sword) |
                            (attacker2.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Sword) |
                            (attacker2.getMainHandItem().getItem() == Items.NETHERITE_AXE) |
                            (attacker2.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Axe) |
                            (attacker2.getMainHandItem().getItem() == Items.NETHERITE_HOE) |
                            (attacker2.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Hoe) |
                            (attacker2.getMainHandItem().getItem() == Items.NETHERITE_SHOVEL) |
                            (attacker2.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Shovel) |
                            (attacker2.getMainHandItem().getItem() == Items.NETHERITE_PICKAXE) |
                            (attacker2.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Pickaxe)) {
                        if (PlayerStats.debugLogging) {
                            ClientUtils.SendPrivateMessage("before: " + event.getAmount());
                        }
                        event.setAmount(event.getAmount() * 1.2f);
                        if (PlayerStats.debugLogging) {
                            ClientUtils.SendPrivateMessage("after: " + event.getAmount());
                        }
                        if (PlayerStats.debugLogging) {
                            ClientUtils.SendPrivateMessage("from: 2/1");
                        }
                    }
                }
                //Hardened Refined netherite armor
                else if (attacker2.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Hardened_Refined_Netherite_Helmet
                        & attacker2.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Hardened_Refined_Netherite_Chestplate
                        & attacker2.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Hardened_Refined_Netherite_Leggings
                        & attacker2.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Hardened_Refined_Netherite_Boots) {
                    if ((attacker2.getMainHandItem().getItem() == Items.NETHERITE_SWORD) |
                            (attacker2.getMainHandItem().getItem() instanceof Hardened_Refined_Netherite_Sword) |
                            (attacker2.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Sword) |
                            (attacker2.getMainHandItem().getItem() == Items.NETHERITE_AXE) |
                            (attacker2.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Axe) |
                            (attacker2.getMainHandItem().getItem() == Items.NETHERITE_HOE) |
                            (attacker2.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Hoe) |
                            (attacker2.getMainHandItem().getItem() == Items.NETHERITE_SHOVEL) |
                            (attacker2.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Shovel) |
                            (attacker2.getMainHandItem().getItem() == Items.NETHERITE_PICKAXE) |
                            (attacker2.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Pickaxe)) {
                        if (PlayerStats.debugLogging) {
                            ClientUtils.SendPrivateMessage("before: " + event.getAmount());
                        }
                        event.setAmount(event.getAmount() * 1.4f);
                        if (PlayerStats.debugLogging) {
                            ClientUtils.SendPrivateMessage("after: " + event.getAmount());
                        }
                        if (PlayerStats.debugLogging) {
                            ClientUtils.SendPrivateMessage("from: 2/2");
                        }
                    }
                }

                ArmorStandEntity dmgTag = new ArmorStandEntity(world, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
                dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + Math.round(event.getAmount())));
                dmgTag.setCustomNameVisible(true);
                dmgTag.setInvulnerable(true);
                dmgTag.noPhysics = true;
                dmgTag.setInvisible(true);
                world.addFreshEntity(dmgTag);
            });
        }

        if (target instanceof PlayerEntity) {
            target.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                if (event.getSource() == DamageSource.FALL) {
                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("initialDamage: " + event.getAmount()), false);
                    }
                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calc: " + "(1 - (event.getAmount() - (" + skills.getDefense() + " / (" + skills.getDefense() + " + 20f))))"), false);
                    }
                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calc: " + (1 - (event.getAmount() - (skills.getDefense() / (skills.getDefense() + 20f))))), false);
                    }
                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("defense: " + skills.getDefense()), false);
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

                    ArmorStandEntity dmgTag = new ArmorStandEntity(world, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
                    dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + (Math.round(event.getAmount() + event.getAmount() * fallDamageMultiplier) * 5)));
                    dmgTag.setCustomNameVisible(true);
                    dmgTag.setInvulnerable(true);
                    dmgTag.noPhysics = true;
                    dmgTag.setInvisible(true);
                    world.addFreshEntity(dmgTag);
                    event.setAmount(event.getAmount() + event.getAmount() * fallDamageMultiplier);
                    event.setAmount(event.getAmount() * (target.getMaxHealth() / skills.getMaxHealth()));
                    //ClientUtils.SendPrivateMessage("fallMultiplier: " + fallDamageMultiplier);
                    //ClientUtils.SendPrivateMessage("final: " + event.getAmount());
                    if (fallDamageMultiplier > 0)
                        target.level.playSound(null, target, SoundEvents.ANVIL_LAND, SoundCategory.NEUTRAL, 1.0f, 1.5f);

                } else if (event.getSource().isBypassArmor()) {
                    /*if (event.getSource() == DamageSource.WITHER | event.getSource() == DamageSource.MAGIC | event.getSource() == DamageSource.FLY_INTO_WALL | event.getSource() == DamageSource.ON_FIRE | event.getSource() == DamageSource.DRAGON_BREATH | event.getSource() == DamageSource.LAVA | event.getSource() == DamageSource.HOT_FLOOR | event.getSource() == DamageSource.indirectMagic(event.getSource().getEntity(), event.getEntity())) {
                        event.setAmount(event.getAmount() * (target.getMaxHealth() / skills.getMaxHealth()));
                    }*/
                    event.setAmount(event.getAmount() * (target.getMaxHealth() / skills.getMaxHealth()));

                } else {
                    /*ArmorStandEntity dmgTag = new ArmorStandEntity(world, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
                    dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + (Math.round((event.getAmount() * (1 - (skills.getDefense() / (skills.getDefense() + 20f)))) / (skills.getMaxHealth() / 100)) * 5)));
                    dmgTag.setCustomNameVisible(true);
                    dmgTag.setInvulnerable(true);
                    dmgTag.noPhysics = true;
                    dmgTag.setInvisible(true);
                    world.addFreshEntity(dmgTag);*/
                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("initialDamage: " + event.getAmount()), false);
                    }
                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calc: " + "(1 - (event.getAmount() - (" + skills.getDefense() + " / (" + skills.getDefense() + " + 20f))))"), false);
                    }
                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calc: " + (1 - (event.getAmount() - (skills.getDefense() / (skills.getDefense() + 20f))))), false);
                    }
                    //skills.setHealth(Math.round((event.getEntityLiving().getHealth() / event.getEntityLiving().getMaxHealth()) * skills.getMaxHealth()));
                    event.setAmount((event.getAmount() * (1 - (skills.getDefense() / (skills.getDefense() + 100f)))) * (target.getMaxHealth() / skills.getMaxHealth()));
                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("defense: " + skills.getDefense()), false);
                    }
                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("damageTaken : " + event.getAmount()), false);
                    }
                }
            });
        }

        if (target instanceof MobEntity) {
            target.getCapability(CapabilityMobLevel.MOB_LEVEL_CAPABILITY).ifPresent(skills -> {
                if (event.getSource() == DamageSource.FALL) {
                    /*if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("initialDamage: " + event.getAmount()), false);
                    }
                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calc: " + "(1 - (event.getAmount() - (" + skills.getDefense() + " / (" + skills.getDefense() + " + 20f))))"), false);
                    }
                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calc: " + (1 - (event.getAmount() - (skills.getDefense() / (skills.getDefense() + 20f))))), false);
                    }
                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("defense: " + skills.getDefense()), false);
                    }
                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("damageTaken : " + event.getAmount()), false);
                    }*/
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

                    ArmorStandEntity dmgTag = new ArmorStandEntity(world, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
                    dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + (Math.round(event.getAmount() + event.getAmount() * fallDamageMultiplier))));
                    dmgTag.setCustomNameVisible(true);
                    dmgTag.setInvulnerable(true);
                    dmgTag.noPhysics = true;
                    dmgTag.setInvisible(true);
                    world.addFreshEntity(dmgTag);
                    event.setAmount(event.getAmount() + event.getAmount() * fallDamageMultiplier);
                    event.setAmount((event.getAmount() * (target.getMaxHealth() / (skills.getMobLevel() * 2.5f * target.getMaxHealth()))));
                    //ClientUtils.SendPrivateMessage("fallMultiplier: " + fallDamageMultiplier);
                    //ClientUtils.SendPrivateMessage("final: " + event.getAmount());
                    if (fallDamageMultiplier > 0)
                        target.level.playSound(null, target, SoundEvents.ANVIL_LAND, SoundCategory.NEUTRAL, 1.0f, 1.5f);

                } else if (event.getSource().isBypassArmor()) {
                    if (event.getSource() == DamageSource.WITHER | event.getSource() == DamageSource.MAGIC | event.getSource() == DamageSource.FLY_INTO_WALL | event.getSource() == DamageSource.ON_FIRE | event.getSource() == DamageSource.DRAGON_BREATH | event.getSource() == DamageSource.LAVA | event.getSource() == DamageSource.HOT_FLOOR | event.getSource() == DamageSource.indirectMagic(event.getSource().getEntity(), event.getEntity())) {
                        event.setAmount(event.getAmount() * (target.getMaxHealth() / (skills.getMobLevel() * 2.5f * target.getMaxHealth())));
                    }

                } else {
                    /*ArmorStandEntity dmgTag = new ArmorStandEntity(world, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
                    dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + (Math.round((event.getAmount() * (1 - (targetTotalDefense.get() / (targetTotalDefense.get() + 20f)))) / ((target.getMaxHealth() * 5 * skills.getMobLevel()) / 100)))));
                    dmgTag.setCustomNameVisible(true);
                    dmgTag.setInvulnerable(true);
                    dmgTag.noPhysics = true;
                    dmgTag.setInvisible(true);
                    world.addFreshEntity(dmgTag);*/
                    //if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("initialDamage: " + event.getAmount()), false);}
                    //if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calc: " + "(1 - (event.getAmount() - (" + skills.getDefense() + " / (" + skills.getDefense() + " + 20f))))"), false);}
                    //if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calc: " + (1 - (event.getAmount() - (skills.getDefense() / (skills.getDefense() + 20f))))), false);}
                    //skills.setHealth(Math.round((event.getEntityLiving().getHealth() / event.getEntityLiving().getMaxHealth()) * skills.getMaxHealth()));
                    event.setAmount(event.getAmount() * (1 - (targetTotalDefense.get() / (targetTotalDefense.get() + 100f))) * (target.getMaxHealth() / (skills.getMobLevel() * 2.5f * target.getMaxHealth())));
                    //if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("defense: " + skills.getDefense()), false);}
                    //if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("damageTaken : " + event.getAmount()), false);}
                }
            });
        }

    }

    public static void PlayerHeal(final LivingHealEvent event)
    {
        if (event.getEntityLiving() instanceof PlayerEntity)
        {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                event.setAmount((event.getAmount() / skills.getMaxHealth()) * 20);
            });
        }
    }

    private static int ticksSinceOnFire = 0;
    public static int ticksSinceManaHeal = 20;

    @SubscribeEvent
    public static void playerUpdate(final LivingEvent.LivingUpdateEvent event)
    {
        if (event.getEntityLiving() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntityLiving();
            //ticksSinceHit += 1;
            skillShowTimer -= 1;
            skillShowText = skillShowTimer < 1 ? "" : skillShowText;
            abilityShowTimer -= 1;
            abilityShowText = abilityShowTimer < 1 ? "" : abilityShowText;
            ticksSinceManaHeal -= 1;
            player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                if (player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Refined_Netherite_Boots) {
                    skills.setRBootTimer(skills.getRBootTimer() + 1);
                } else {
                    if (skills.getRBootTimer() > 0) {
                        skills.setRBootTimer(skills.getRBootTimer() - 1);
                    }
                }
                if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Refined_Netherite_Helmet) {
                    skills.setRHelmTimer((skills.getRHelmTimer() + 1));
                } else {
                    if (skills.getRHelmTimer() > 0) {
                        skills.setRHelmTimer((skills.getRHelmTimer() - 1));
                    }
                }
                if (player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Hardened_Refined_Netherite_Boots) {
                    skills.setHRBootTimer(skills.getHRBootTimer() + 1);
                } else {
                    if (skills.getHRBootTimer() > 0) {
                        skills.setHRBootTimer(skills.getHRBootTimer() - 1);
                    }
                }
                if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Hardened_Refined_Netherite_Helmet) {
                    skills.setHRHelmTimer((skills.getHRHelmTimer() + 1));
                } else {
                    if (skills.getHRHelmTimer() > 0) {
                        skills.setHRHelmTimer((skills.getHRHelmTimer() - 1));
                    }
                }

                if (player.getItemInHand(Hand.MAIN_HAND).getItem() == Items.DIAMOND_SWORD | player.getItemInHand(Hand.OFF_HAND).getItem() == Items.DIAMOND_SWORD) {
                    skills.setDiamondTimer((skills.getDiamondTimer() + 1));
                } else {
                    if (skills.getDiamondTimer() > 0) {
                        skills.setDiamondTimer((skills.getDiamondTimer() - 1));
                    }
                }
                if (player.getItemInHand(Hand.MAIN_HAND).getItem() == Items.NETHERITE_SWORD | player.getItemInHand(Hand.OFF_HAND).getItem() == Items.NETHERITE_SWORD) {
                    skills.setNetheriteTimer((skills.getNetheriteTimer() + 1));
                } else {
                    if (skills.getNetheriteTimer() > 0) {
                        skills.setNetheriteTimer((skills.getNetheriteTimer() - 1));
                    }
                }
                if (player.getItemInHand(Hand.MAIN_HAND).getItem() instanceof Netherite_Plated_Diamond_Sword | player.getItemInHand(Hand.OFF_HAND).getItem() instanceof Netherite_Plated_Diamond_Sword) {
                    skills.setNetheritePlatedDiamondTimer((skills.getNetheritePlatedDiamondTimer() + 1));
                } else {
                    if (skills.getNetheritePlatedDiamondTimer() > 0) {
                        skills.setNetheritePlatedDiamondTimer((skills.getNetheritePlatedDiamondTimer() - 1));
                    }
                }

                //RHelm Abilty
                if (skills.getRHelmTimer() % 20 == 0) {
                    if (skills.getRHelmTimer() > 64000) {
                        skills.setMana(skills.getMana() - 256);
                        player.hurt(DamageSource.GENERIC, 16);
                        player.addEffect(new EffectInstance(Effects.BLINDNESS, 8, 0));
                    } else if (skills.getRHelmTimer() > 32000) {
                        skills.setMana(skills.getMana() - 128);
                        player.hurt(DamageSource.GENERIC, 8);
                        player.addEffect(new EffectInstance(Effects.BLINDNESS, 4, 0));
                    } else if (skills.getRHelmTimer() > 16000) {
                        skills.setMana(skills.getMana() - 64);
                        player.hurt(DamageSource.GENERIC, 4);
                        player.addEffect(new EffectInstance(Effects.BLINDNESS, 2, 0));
                    } else if (skills.getRHelmTimer() > 8000) {
                        skills.setMana(skills.getMana() - 32);
                        player.hurt(DamageSource.GENERIC, 2);
                        player.addEffect(new EffectInstance(Effects.BLINDNESS, 1, 0));
                    } else if (skills.getRHelmTimer() > 4000) {
                        skills.setMana(skills.getMana() - 16);
                    } else if (skills.getRHelmTimer() > 2000) {
                        skills.setMana(skills.getMana() - 8);
                    } else if (skills.getRHelmTimer() > 1000) {
                        skills.setMana(skills.getMana() - 4);
                    } else if (skills.getRHelmTimer() > 500) {
                        skills.setMana(skills.getMana() - 2);
                    }
                }

                //HRHelm ability
                if (skills.getHRHelmTimer() % 20 == 0) {
                    if (skills.getHRHelmTimer() > 25600) {
                        skills.setMana(skills.getMana() - 384);
                        player.hurt(DamageSource.GENERIC, 12);
                        player.addEffect(new EffectInstance(Effects.BLINDNESS, 12, 254));
                    } else if (skills.getHRHelmTimer() > 12800) {
                        skills.setMana(skills.getMana() - 192);
                        player.hurt(DamageSource.GENERIC, 9);
                        player.addEffect(new EffectInstance(Effects.BLINDNESS, 6, 254));
                    } else if (skills.getHRHelmTimer() > 6400) {
                        skills.setMana(skills.getMana() - 96);
                        player.hurt(DamageSource.GENERIC, 6);
                        player.addEffect(new EffectInstance(Effects.BLINDNESS, 3, 254));
                    } else if (skills.getHRHelmTimer() > 3200) {
                        skills.setMana(skills.getMana() - 48);
                        player.hurt(DamageSource.GENERIC, 3);
                        player.addEffect(new EffectInstance(Effects.BLINDNESS, 1, 254));
                    } else if (skills.getHRHelmTimer() > 1600) {
                        skills.setMana(skills.getMana() - 24);
                    } else if (skills.getHRHelmTimer() > 800) {
                        skills.setMana(skills.getMana() - 12);
                    } else if (skills.getHRHelmTimer() > 400) {
                        skills.setMana(skills.getMana() - 6);
                    } else if (skills.getHRHelmTimer() > 200) {
                        skills.setMana(skills.getMana() - 3);
                    }
                }
                //Boots
                skills.setBootSlowFactor((float) (Math.floor(skills.getRBootTimer() / 200f) * 0.2f + Math.floor(skills.getHRBootTimer() / 200f) * 0.5f));
                //Diamond
                if (skills.getDiamondTimer() >= 40000 + (skills.getDiamondStrBoost() * 20)) {
                    skills.setDiamondStrBoost(skills.getDiamondStrBoost() + 1);
                    skills.setDiamondTimer(1);
                }
                //Netherite
                if (skills.getNetheriteTimer() >= 20000 + (skills.getNetheriteStrBoost() * 20)) {
                    skills.setNetheriteStrBoost(skills.getNetheriteStrBoost() + 1);
                    skills.setNetheriteTimer(1);
                }
                //Netherite plated diamond
                if (skills.getNetheritePlatedDiamondTimer() >= 30000 + ((skills.getNetheriteStrBoost() / 4f + (skills.getDiamondStrBoost() / 4f * 3f)) * 20f)) {
                    int rnd = player.level.random.nextInt(3) + 1;
                    if (rnd < 3) {
                        skills.setDiamondStrBoost(skills.getDiamondStrBoost() + 1);
                    } else {
                        skills.setNetheriteStrBoost(skills.getNetheriteStrBoost() + 1);
                    }
                    skills.setNetheritePlatedDiamondTimer(1);
                }
                //mana regen
                if (ticksSinceManaHeal < 0 && skills.getMana() < skills.getMaxMana()) {
                    if (skills.getMana() + (skills.getMaxMana() * 0.02D) > skills.getMaxMana()) {
                        skills.setMana(skills.getMaxMana());
                        ticksSinceManaHeal = 20;
                        //ClientUtils.SendPrivateMessage("heal: " + (skills.getMaxMana() * 0.02D));
                    } else {
                        skills.setMana(skills.getMana() + Math.round(skills.getMaxMana() * 0.02f));
                        ticksSinceManaHeal = 20;
                        //ClientUtils.SendPrivateMessage("heal: " + (skills.getMaxMana() * 0.02D));
                    }
                }
                if (skills.getMana() > skills.getMaxMana()) {
                    skills.setMana(skills.getMaxMana());
                }
                if (skills.getMana() < 0) {
                    skills.setMana(0);
                }
                player.getFoodData().setFoodLevel(Math.round((((float) (skills.getMana())) / ((float) (skills.getMaxMana()))) * 20f));
                //end of mana regen

                int strengthAdder = 100;
                int speedAdder = 100;

                strengthAdder += player.experienceLevel / 5f;
                strengthAdder += player.experienceLevel / 10f;

                if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), player.getOffhandItem()) > 0) {
                    skills.setUltWiseLvl(EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), player.getOffhandItem()));
                } else
                    skills.setUltWiseLvl(Math.max(EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), player.getMainHandItem()), 0));

                //emeralds to coins
                skills.setCoins((player.inventory.countItem(Items.EMERALD) * 6) + (player.inventory.countItem(Items.EMERALD_BLOCK) * 54) + (player.inventory.countItem(ItemInit.REFINED_EMERALD.get()) * 960) + (player.inventory.countItem(ItemInit.REFINED_EMERALD_BLOCK.get()) * 8640));

                speedAdder -= skills.getBootSlowFactor();
                if (player.getMainHandItem().getItem() instanceof Aspect_Of_The_End || player.getOffhandItem().getItem() instanceof Aspect_Of_The_End) {
                    strengthAdder += 100;
                }
                if (player.getMainHandItem().getItem() instanceof Flame_Sword || player.getOffhandItem().getItem() instanceof Flame_Sword) {
                    strengthAdder += 20;
                }
                if (player.getMainHandItem().getItem() instanceof Zombie_Sword || player.getOffhandItem().getItem() instanceof Zombie_Sword) {
                    strengthAdder += 50;
                }
                if (player.getMainHandItem().getItem() instanceof Ornate_Zombie_Sword || player.getOffhandItem().getItem() instanceof Ornate_Zombie_Sword) {
                    strengthAdder += 60;
                }
                if (player.getMainHandItem().getItem() instanceof Florid_Zombie_Sword || player.getOffhandItem().getItem() instanceof Florid_Zombie_Sword) {
                    strengthAdder += 80;
                }
                if (player.getMainHandItem().getItem() instanceof Hunter_Knife || player.getOffhandItem().getItem() instanceof Hunter_Knife) {
                    speedAdder += 20;
                }
                if (player.getMainHandItem().getItem() instanceof Ink_Wand || player.getOffhandItem().getItem() instanceof Ink_Wand) {
                    strengthAdder += 90;
                }
                if (player.getMainHandItem().getItem() == Items.NETHERITE_SWORD || player.getOffhandItem().getItem() == Items.NETHERITE_SWORD) {
                    strengthAdder += 50 + skills.getDiamondStrBoost();
                }
                if (player.getMainHandItem().getItem() == Items.DIAMOND_SWORD || player.getOffhandItem().getItem() == Items.DIAMOND_SWORD) {
                    strengthAdder += 25 + skills.getDiamondStrBoost();
                }
                if (player.getMainHandItem().getItem() == Items.NETHERITE_AXE || player.getOffhandItem().getItem() == Items.NETHERITE_AXE) {
                    strengthAdder += 60;
                }
                if (player.getMainHandItem().getItem() == Items.DIAMOND_AXE || player.getOffhandItem().getItem() == Items.DIAMOND_AXE) {
                    strengthAdder += 35;
                }
                if (player.getMainHandItem().getItem() instanceof Terminator || player.getOffhandItem().getItem() instanceof Terminator) {
                    strengthAdder += 50;
                }
                if (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Sword || player.getOffhandItem().getItem() instanceof Netherite_Plated_Diamond_Sword) {
                    strengthAdder += 30 + Math.round((skills.getNetheriteStrBoost() / 4f) + (skills.getDiamondStrBoost() / 4f * 3f));
                }
                if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.LIGHT.get(), player.getMainHandItem()) > 0) {
                    player.getAttribute(Attributes.ATTACK_SPEED).setBaseValue(player.getAttribute(Attributes.ATTACK_SPEED).getValue() * (1f + ((10f - EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.LIGHT.get(), player.getMainHandItem())) * 0.1f)));
                }


                ColorText color;
                if (player.hasEffect(Effects.WITHER)) {
                    color = ColorText.DARK_GRAY;
                } else if (player.hasEffect(Effects.ABSORPTION)) {
                    color = ColorText.GOLD;
                }else{
                    color = ColorText.RED;
                }

                //String defenseText = (skills.getDefense() != 0) ? (ColorText.GREEN.toString() + (skills.getDefense() * 5) + " Defense" + "  ") : ("");
                //ClientUtils.SendPrivateMessage(defenseText);
                player.displayClientMessage(ITextComponent.nullToEmpty(
                        color.toString() + skills.getHealth() + "/" + skills.getMaxHealth() + " Health" + "  " +
                                (abilityShowTimer > 0 ? (abilityShowText + " ") : ((skills.getDefense() != 0) ? (ColorText.GREEN.toString() + (skills.getDefense() * 5) + " Defense" + "  ") : (""))) +
                                ColorText.BLUE + skills.getMana() + " Mana " +
                                (skillShowTimer > 0 ? skillShowText : "")), true);


                //Accessory abilities
                boolean hasCampfireBadge = player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) |
                        player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()) |
                        player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance()) |
                        player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance());
                //farming
                Block aboveFeetBlock = player.level
                        .getBlockState(new BlockPos(player.position().x, player.position().y + 1, player.position().z))
                        .getBlock();
                Block feetBlock = player.level
                        .getBlockState(new BlockPos(player.position().x, player.position().y, player.position().z))
                        .getBlock();
                Block belowFeetBlock = player.level
                        .getBlockState(new BlockPos(player.position().x, player.position().y - 1, player.position().z))
                        .getBlock();

                if (feetBlock instanceof BushBlock || belowFeetBlock instanceof BushBlock || aboveFeetBlock instanceof BushBlock ||
                        feetBlock instanceof SugarCaneBlock || belowFeetBlock instanceof SugarCaneBlock || aboveFeetBlock instanceof SugarCaneBlock ||
                        feetBlock instanceof FarmlandBlock || belowFeetBlock instanceof FarmlandBlock || aboveFeetBlock instanceof FarmlandBlock) {
                    {
                        speedAdder += 1;
                    }
                }
                //campfire
                if (hasCampfireBadge) {
                    if (!((player.inventory.countItem(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem()) > 1) |
                            (player.inventory.countItem(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem()) > 1) |
                            (player.inventory.countItem(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem()) > 1) |
                            (player.inventory.countItem(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem()) > 1))) {
                        if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance())) {
                            player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                            player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 40) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
                                        player.heal(1f);
                                    }
                                    ticksSinceOnFire += 1;
                                } else {
                                    ticksSinceOnFire += 1;
                                }
                            } else {
                                ticksSinceOnFire = 0;
                            }
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance())) {
                            player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 40) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 30);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
                                        player.heal(1f);
                                    }
                                    ticksSinceOnFire += 1;
                                } else {
                                    ticksSinceOnFire += 1;
                                }
                            } else {
                                ticksSinceOnFire = 0;
                            }
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance())) {
                            player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                            player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 40) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
                                        player.heal(1f);
                                    }
                                    ticksSinceOnFire += 1;
                                } else {
                                    ticksSinceOnFire += 1;
                                }
                            } else {
                                ticksSinceOnFire = 0;
                            }
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance())) {
                            player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                            player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 40) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
                                        player.heal(1f);
                                    }
                                    ticksSinceOnFire += 1;
                                } else {
                                    ticksSinceOnFire += 1;
                                }
                            } else {
                                ticksSinceOnFire = 0;
                            }
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance())) {
                            player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                            player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 40) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
                                        player.heal(1f);
                                    }
                                    ticksSinceOnFire += 1;
                                } else {
                                    ticksSinceOnFire += 1;
                                }
                            } else {
                                ticksSinceOnFire = 0;
                            }
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance())) {
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 60) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 40);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
                                        player.heal(1f);
                                    }
                                    ticksSinceOnFire += 1;
                                } else {
                                    ticksSinceOnFire += 1;
                                }
                            } else {
                                ticksSinceOnFire = 0;
                            }
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance())) {
                            player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 40) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 30);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
                                        player.heal(1f);
                                    }
                                    ticksSinceOnFire += 1;
                                } else {
                                    ticksSinceOnFire += 1;
                                }
                            } else {
                                ticksSinceOnFire = 0;
                            }
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance())) {
                            player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                            player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 40) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
                                        player.heal(1f);
                                    }
                                    ticksSinceOnFire += 1;
                                } else {
                                    ticksSinceOnFire += 1;
                                }
                            } else {
                                ticksSinceOnFire = 0;
                            }
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance())) {
                            player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 40) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 30);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
                                        player.heal(1f);
                                    }
                                    ticksSinceOnFire += 1;
                                } else {
                                    ticksSinceOnFire += 1;
                                }
                            } else {
                                ticksSinceOnFire = 0;
                            }
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance())) {
                            player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                            player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 40) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
                                        player.heal(1f);
                                    }
                                    ticksSinceOnFire += 1;
                                } else {
                                    ticksSinceOnFire += 1;
                                }
                            } else {
                                ticksSinceOnFire = 0;
                            }
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance())) {
                            player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                            player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 40) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
                                        player.heal(1f);
                                    }
                                    ticksSinceOnFire += 1;
                                } else {
                                    ticksSinceOnFire += 1;
                                }
                            } else {
                                ticksSinceOnFire = 0;
                            }
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance())) {
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 60) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 50);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
                                        player.heal(1f);
                                    }
                                    ticksSinceOnFire += 1;
                                } else {
                                    ticksSinceOnFire += 1;
                                }
                            } else {
                                ticksSinceOnFire = 0;
                            }
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance())) {
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 60) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 40);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
                                        player.heal(1f);
                                    }
                                    ticksSinceOnFire += 1;
                                } else {
                                    ticksSinceOnFire += 1;
                                }
                            } else {
                                ticksSinceOnFire = 0;
                            }
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance())) {
                            player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 40) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 30);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
                                        player.heal(1f);
                                    }
                                    ticksSinceOnFire += 1;
                                } else {
                                    ticksSinceOnFire += 1;
                                }
                            } else {
                                ticksSinceOnFire = 0;
                            }
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_GOD_BADGE.get().asItem().getDefaultInstance())) {
                            player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                            player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 40, 0));
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 40) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 20);
                                    if (rnd == 10) {
                                        //ClientUtils.SendPrivateMessage("ticksSinceOnFire: " + ticksSinceOnFire);
                                        //ClientUtils.SendPrivateMessage("you healed!");
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

                skills.setDefense((headDefense + chestDefense + legsDefense + feetDefense) * 20);


                //Armor abilities
                //farm suit
                //Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("armor: " + player.getItemBySlot(EquipmentSlotType.HEAD).getItem() + " ," + player.getItemBySlot(EquipmentSlotType.CHEST).getItem() + " ," + player.getItemBySlot(EquipmentSlotType.LEGS).getItem() + " ," + player.getItemBySlot(EquipmentSlotType.FEET).getItem()), false);
                if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Farm_Suit_Helmet
                        & player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Farm_Suit_Chestplate
                        & player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Farm_Suit_Leggings
                        & player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Farm_Suit_Boots) {
                    //Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("block: " + feetBlock + " ," + belowFeetBlock), false);
                    if (feetBlock instanceof BushBlock || belowFeetBlock instanceof BushBlock || aboveFeetBlock instanceof BushBlock ||
                            feetBlock instanceof SugarCaneBlock || belowFeetBlock instanceof SugarCaneBlock || aboveFeetBlock instanceof SugarCaneBlock ||
                            feetBlock instanceof FarmlandBlock || belowFeetBlock instanceof FarmlandBlock || aboveFeetBlock instanceof FarmlandBlock) {
                        //Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("on cropblock!"), false);
                        speedAdder += 2;
                    }
                }

                if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Mushroom_Helmet
                        & player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Mushroom_Chestplate
                        & player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Mushroom_Leggings
                        & player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Mushroom_Boots) {
                    if (player.level.getTimeOfDay(1f) > 13000 | player.level.getTimeOfDay(1f) < 1000) {
                        player.addEffect(new EffectInstance(Effects.NIGHT_VISION, 20, 0));
                    }
                }

                if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Refined_Netherite_Helmet) {
                    speedAdder -= 1;
                }
                if (player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Refined_Netherite_Chestplate) {
                    speedAdder -= 1;
                }
                if (player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Refined_Netherite_Leggings) {
                    speedAdder -= 1;
                }
                if (player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Refined_Netherite_Boots) {
                    speedAdder -= 1;
                }

                if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Hardened_Refined_Netherite_Helmet) {
                    speedAdder -= 2;
                }
                if (player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Hardened_Refined_Netherite_Chestplate) {
                    speedAdder -= 2;
                }
                if (player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Hardened_Refined_Netherite_Leggings) {
                    speedAdder -= 2;
                }
                if (player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Hardened_Refined_Netherite_Boots) {
                    speedAdder -= 2;
                }

                //skills.setMana(manaReductionPercentAdder);
                skills.setStrength(strengthAdder);
                skills.setMaxMana(100 + (Math.round(((float) (player.experienceLevel)) / 5f)) +
                        (player.getMainHandItem().getItem() instanceof Zombie_Sword || player.getOffhandItem().getItem() instanceof Zombie_Sword ? 50 : 0) +
                        (player.getMainHandItem().getItem() instanceof Ornate_Zombie_Sword || player.getOffhandItem().getItem() instanceof Ornate_Zombie_Sword ? 50 : 0) +
                        (player.getMainHandItem().getItem() instanceof Florid_Zombie_Sword || player.getOffhandItem().getItem() instanceof Florid_Zombie_Sword ? 100 : 0));
                skills.setMaxHealth((float) (100f + Math.floor(player.experienceLevel / 10D)));
                skills.setHealth(Math.round(((event.getEntityLiving().getHealth() + event.getEntityLiving().getAbsorptionAmount()) / event.getEntityLiving().getMaxHealth()) * skills.getMaxHealth()));
                skills.setFerocity((int) Math.floor(((double) (player.experienceLevel)) / 25D));
                skills.setSpeed(speedAdder);
                player.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(skills.getSpeed() / 1000D);
                //ClientUtils.SendPrivateMessage("1: " + (player.getAttribute(Attributes.MOVEMENT_SPEED).getValue()));
                //ClientUtils.SendPrivateMessage("1: " + (skills.getSpeed() / 1000f));
                //ClientUtils.SendPrivateMessage("2: " + player.getSpeed());

            });
        } else if (event.getEntityLiving() instanceof MobEntity) {
            LivingEntity entity = event.getEntityLiving();
            entity.getCapability(CapabilityMobLevel.MOB_LEVEL_CAPABILITY).ifPresent(mobLevel -> {
                entity.setCustomNameVisible(true);
                entity.setCustomName(ITextComponent.nullToEmpty(ColorText.GRAY + "[Lv." + ColorText.RED + (mobLevel.getMobLevel()) + ColorText.GRAY + "] " +
                        entity.getType().getDescription().getString() +
                        " " + ColorText.RED + Math.round((entity.getHealth() + entity.getAbsorptionAmount()) * 5 * (mobLevel.getMobLevel() / 2f)) + "/" + Math.round(entity.getMaxHealth() * 5 * (mobLevel.getMobLevel() / 2f))));
            });
        }
    }

    @SubscribeEvent
    public static void OnJoin(final PlayerEvent.PlayerLoggedInEvent event)
    {
        PlayerEntity player = event.getPlayer();
        player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
            if (player instanceof ServerPlayerEntity) {

                CompoundNBT data = player.getPersistentData();
                CompoundNBT persistent;
                if (!data.contains(PlayerEntity.PERSISTED_NBT_TAG)) {
                    data.put(PlayerEntity.PERSISTED_NBT_TAG, (persistent = new CompoundNBT()));
                } else {
                    persistent = data.getCompound(PlayerEntity.PERSISTED_NBT_TAG);
                }

                if (!persistent.contains("ISNOTFIRSTTIME")) {
                    persistent.putBoolean("ISNOTFIRSTTIME", true);
                    skills.setMaxHealth(100);
                    skills.setHealth(100);
                    skills.setMaxMana(100);
                    skills.setMana(skills.getMaxMana());
                    // message, fired when the player joins for the first time
                    //player.sendMessage(new StringTextComponent(player.getDisplayName().getString() +  " joined the for the first time!"), player.getUUID());
                } else {
                    player.getFoodData().setFoodLevel((skills.getMana() / skills.getMaxMana()) * 20);
                    skills.setMaxHealth((float) (player.getMaxHealth() * 5f + Math.floor(player.experienceLevel / 5D)));
                    skills.setHealth((player.getHealth() / player.getMaxHealth()) * skills.getMaxHealth());
                    skills.setMana((int) ((player.getFoodData().getFoodLevel() / 20f) * skills.getMaxMana()));
                    // another message, fired when the player doesn't join for the first time
                    //player.sendMessage(new StringTextComponent("Welcome back, " + player.getDisplayName().getString() + "!"), player.getUUID());
                }
                // another message, fired when the players joined the server
                //player.sendMessage(new StringTextComponent("You are using mod version: " + "SkyblockItemsPlusPlus v.0.5-072521a"), player.getUUID());

            }

        });
    }

    @SubscribeEvent
    public static void OnRespawn(final PlayerEvent.PlayerRespawnEvent event)
    {
        PlayerEntity player = event.getPlayer();
        player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
            skills.setMaxMana(100 + player.experienceLevel);
            skills.setMana(100 + player.experienceLevel);
        });
    }

    @SubscribeEvent
    public static void playerInteractEntity(final PlayerInteractEvent.EntityInteract event)
    {
        if (event.getTarget() instanceof LivingEntity)
        {
            PlayerEntity player = event.getPlayer();
            LivingEntity target = event.getTarget() instanceof EnderDragonPartEntity ? ((EnderDragonPartEntity) event.getTarget()).getParent() : (LivingEntity) event.getTarget();
            player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                if (player.getMainHandItem().getItem() instanceof Ink_Wand)
                {
                    Ink_Wand wand = (Ink_Wand) player.getMainHandItem().getItem();
                    if (!player.getCooldowns().isOnCooldown(wand))
                    {
                        target.hurt(DamageSource.playerAttack(player), ((10000f + (skills.getMana() * 10f) + 100f) / 100f));
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
            });

        }
    }

    //TODO:Fix drops
    @SubscribeEvent
    public static void OnKillTelekinesis(final LivingDeathEvent event)
    {

        /*if (PlayerStats.debugLogging) { Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("Event fired!"), false); }

        if (event.getSource().getEntity() instanceof PlayerEntity)
        {
            if (PlayerStats.debugLogging) { Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("Event is player"), false); }

            PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
            LivingEntity target = event.getEntityLiving();
            if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.TELEKINESIS.get(), player.getMainHandItem()) > 0)
            {
                int i = ForgeHooks.getLootingLevel(target, player, event.getSource());
                Collection<ItemEntity> drops = target.captureDrops((Collection)null);
                if (!ForgeHooks.onLivingDrops(target, event.getSource(), drops, i, target.getLastHurtByMobTimestamp() > 0)) {
                    drops.forEach((loot) -> {
                        player.inventory.add(loot.getItem());
                        //target.level.addFreshEntity(loot);
                    });
                }
            }


        }*/
    }

    @SubscribeEvent
    public static void OnBreakTelekinesis(final BlockEvent.BreakEvent event)
    {
        PlayerEntity player = event.getPlayer();
        //int i = ForgeHooks.get(target, player, event.getSource());
        /*Collection<ItemEntity> drops = event.getState().getBlock().getDrops(event.getState(), );
        if (!ForgeHooks.onLivingDrops(target, event.getSource(), drops, i, target.getLastHurtByMobTimestamp() > 0)) {
            drops.forEach((loot) -> {
                player.inventory.add(loot.getItem());
                //target.level.addFreshEntity(loot);
            });
        }*/
    }

    @SubscribeEvent
    public static void OnReciveItem(final PlayerEvent.ItemPickupEvent event)
    {
        if (PlayerStats.debugLogging) { ClientUtils.SendPrivateMessage("received item:" + event.getStack().getItem().getRegistryName()); }
        event.getStack().getCapability(CapabilityItemReforges.ITEM_REFORGES_CAPABILITY).ifPresent(itemstats -> {
            if (event.getStack().getItem() == ItemInit.EYE_OF_THE_DRAGONS.get() /*&& !itemstats.getOwner().equals("")*/)
            {
                ClientUtils.SendPrivateMessage(ColorText.AQUA + "\uD83D\uDD25 " + ColorText.GOLD + event.getPlayer().getGameProfile().getName() + ColorText.AQUA + " has obtained " + ColorText.DARK_PURPLE + "Eye of the Dragons" + ColorText.AQUA + "!");
            }
            //itemstats.setOwner(event.getPlayer().getUUID());
        });
    }

    @SubscribeEvent
    public static void ItemInventoryTick(final ItemTooltipEvent event)
    {
        event.getItemStack().getCapability(CapabilityItemReforges.ITEM_REFORGES_CAPABILITY).ifPresent(itemstats -> {
            //itemstats.setOwner(event.getPlayer().getUUID());
        });
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

    /*@SubscribeEvent(priority = EventPriority.HIGH)
    public static void onChangeItem(Event event) {
        if (event.getCategory().equals(Biome.Category.THEEND))
        {
            List<MobSpawnInfo.Spawners> spawns =
                    event.getSpawns().getSpawner(EntityClassification.MONSTER);

            spawns.add(new MobSpawnInfo.Spawners(EntityTypeInit.ZEALOT.get(), 5, 1, 3));
        }
    }*/

    @SubscribeEvent
    public static void playerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        event.getPlayer().getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
            skills.setMaxMana(skills.getBaseMaxMana());
            skills.setMana(skills.getBaseMaxMana());
        });
    }

    @SubscribeEvent
    public static void OnLeftClickEmpty(final PlayerInteractEvent.LeftClickEmpty event) {
        if (event.getPlayer().getMainHandItem().getItem() instanceof ShortBow) {
            ShortBow bow = (ShortBow) event.getPlayer().getMainHandItem().getItem();
            bow.use(event.getWorld(), event.getPlayer(), Hand.MAIN_HAND);
            ClientUtils.SendPrivateMessage("shot");
        }
        if (event.getPlayer().getMainHandItem().getItem() == Items.DIAMOND_SWORD) {
            event.getPlayer().getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                if (skills.getDiamondStrBoost() > 0) {
                    skills.setDiamondStrBoost(skills.getDiamondStrBoost() - 1);
                }
            });
        }
        if (event.getPlayer().getMainHandItem().getItem() == Items.NETHERITE_SWORD) {
            event.getPlayer().getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                if (skills.getNetheriteStrBoost() > 1) {
                    skills.setNetheriteStrBoost(skills.getNetheriteStrBoost() - 2);
                }
            });
        }
        if (event.getPlayer().getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Sword) {
            event.getPlayer().getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                int rnd = event.getPlayer().level.random.nextInt(3) + 1;
                if (rnd < 3) {
                    if (skills.getDiamondStrBoost() > 0) {
                        skills.setDiamondStrBoost(skills.getDiamondStrBoost() - 1);
                    }
                } else {
                    if (skills.getNetheriteStrBoost() > 1) {
                        skills.setNetheriteStrBoost(skills.getNetheriteStrBoost() - 2);
                    }
                }
            });
        }
    }

    @SubscribeEvent
    public static void OnLeftClickBlock(final PlayerInteractEvent.LeftClickBlock event) {
        if (event.getPlayer().getMainHandItem().getItem() == Items.DIAMOND_SWORD) {
            event.getPlayer().getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                if (skills.getDiamondStrBoost() > 0) {
                    skills.setDiamondStrBoost(skills.getDiamondStrBoost() - 1);
                }
            });
        }
        if (event.getPlayer().getMainHandItem().getItem() == Items.NETHERITE_SWORD) {
            event.getPlayer().getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                if (skills.getNetheriteStrBoost() > 1) {
                    skills.setNetheriteStrBoost(skills.getNetheriteStrBoost() - 2);
                }
            });
        }
        if (event.getPlayer().getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Sword) {
            event.getPlayer().getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                int rnd = event.getPlayer().level.random.nextInt(3) + 1;
                if (rnd < 3) {
                    if (skills.getDiamondStrBoost() > 0) {
                        skills.setDiamondStrBoost(skills.getDiamondStrBoost() - 1);
                    }
                } else {
                    if (skills.getNetheriteStrBoost() > 1) {
                        skills.setNetheriteStrBoost(skills.getNetheriteStrBoost() - 2);
                    }
                }
            });
        }
    }

    @SubscribeEvent
    public static void OnEat(final LivingEntityUseItemEvent event) {
        if (event.getItem().isEdible() & event.getEntity() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) event.getEntity();
            player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                float foodAmnt = event.getItem().getItem().getFoodProperties().getNutrition();
                if (skills.getMana() + (((foodAmnt / 20f) * skills.getMaxMana()) * (((((float) (skills.getMaxMana())) / (((float) (skills.getMaxMana())) + ((float) (skills.getBaseMaxMana())))) * -1f) + 1.5f)) > skills.getMaxMana()) {
                    skills.setMana(skills.getMaxMana());
                } else {
                    skills.setMana(Math.round(skills.getMana() + (((foodAmnt / 20f) * skills.getMaxMana()) * (((((float) (skills.getMaxMana())) / (((float) (skills.getMaxMana())) + ((float) (skills.getBaseMaxMana())))) * -1f) + 1.5f))));
                }
            });
        }
    }

}
