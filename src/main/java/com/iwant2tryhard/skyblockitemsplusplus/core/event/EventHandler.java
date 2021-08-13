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
        /*World worldIn = event.getEntity().level;

        AtomicReference<Float> initialDamage = new AtomicReference<>(event.getAmount());


        //System.out.println("Hit " + target + " " + event.getSource());
        if (event.getSource().getEntity() instanceof PlayerEntity) {
            LivingEntity target = event.getEntityLiving();
            PlayerEntity player = (PlayerEntity) event.getSource().getEntity();
            player.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                boolean hasOneForAll = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ONE_FOR_ALL.get(), player.getMainHandItem()) > 0;
                int lifeStealLvl = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.LIFE_STEAL.get(), player.getMainHandItem());
                int lightlvl = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.LIGHT.get(), player.getMainHandItem());
                boolean hasEmeraldBlade = player.getMainHandItem().getItem() instanceof Emerald_Blade;

                //ClientUtils.SendPrivateMessage("ferocityCount1: " + ferocityCount);
                if (ferocityCount == 0) {
                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("initialDamage : " + event.getAmount()), false);
                    }

                    int headDefense;
                    int chestDefense;
                    int legsDefense;
                    int feetDefense;

                    if (target.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof ArmorItem) {
                        ArmorItem head = (ArmorItem) target.getItemBySlot(EquipmentSlotType.HEAD).getItem();
                        headDefense = head.getDefense();
                    } else {
                        headDefense = 0;
                    }

                    if (target.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof ArmorItem) {
                        ArmorItem chest = (ArmorItem) target.getItemBySlot(EquipmentSlotType.CHEST).getItem();
                        chestDefense = chest.getDefense();
                    } else {
                        chestDefense = 0;
                    }

                    if (target.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof ArmorItem) {
                        ArmorItem legs = (ArmorItem) target.getItemBySlot(EquipmentSlotType.LEGS).getItem();
                        legsDefense = legs.getDefense();
                    } else {
                        legsDefense = 0;
                    }

                    if (target.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof ArmorItem) {
                        ArmorItem feet = (ArmorItem) target.getItemBySlot(EquipmentSlotType.FEET).getItem();
                        feetDefense = feet.getDefense();
                    } else {
                        feetDefense = 0;
                    }

                    int totalDefense = headDefense + chestDefense + legsDefense + feetDefense;

                    if (!(player.getMainHandItem().getItem() instanceof TaggedSwordItem) | event.getSource().getDirectEntity() instanceof AbstractArrowEntity) {
                        event.setAmount(event.getAmount() * 12);
                        //ClientUtils.SendPrivateMessage("x12");
                    } else {
                        event.setAmount(event.getAmount());
                    }

                        if (target instanceof ZombieEntity) {
                            if (player.getMainHandItem().getItem() instanceof Undead_Sword) {
                                event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl())));
                                initialDamage.updateAndGet(v -> new Float(v * 2));
                            } else {
                                event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                            }
                        } else if (target instanceof SkeletonEntity) {
                            if (player.getMainHandItem().getItem() instanceof Undead_Sword) {
                                event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.SKELETON.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl())));
                                initialDamage.updateAndGet(v -> new Float(v * 2));
                            } else {
                                event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.SKELETON.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                            }
                        } else if (target instanceof EndermanEntity) {
                            if (player.getMainHandItem().getItem() instanceof End_Sword) {
                                event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ENDERMAN.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl())));
                                initialDamage.updateAndGet(v -> new Float(v * 2));
                            } else {
                                event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ENDERMAN.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                            }
                        } else if (target instanceof ZealotEntity) {
                            if (player.getMainHandItem().getItem() instanceof End_Sword) {
                                event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ZEALOT.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl())));
                                initialDamage.updateAndGet(v -> new Float(v * 2));
                            } else {
                                event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ZEALOT.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                            }
                        } else if (target instanceof EndermiteEntity) {
                            if (player.getMainHandItem().getItem() instanceof End_Sword) {
                                event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ENDERMITE.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl())));
                                initialDamage.updateAndGet(v -> new Float(v * 2));
                            } else {
                                event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ENDERMITE.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                            }
                        } else if (target instanceof CreeperEntity) {
                            event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.CREEPER.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                        } else if (target instanceof SlimeEntity) {
                            event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.SLIME.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                        } else if (target instanceof SpiderEntity) {
                            event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.SPIDER.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                        } else if (target instanceof CaveSpiderEntity) {
                            event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.CAVE_SPIDER.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                        } else if (target instanceof VillagerEntity) {
                            event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.VILLAGER.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                        } else if (target instanceof IronGolemEntity) {
                            event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.IRON_GOLEM.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                        } else if (target instanceof ZombifiedPiglinEntity) {
                            if (player.getMainHandItem().getItem() instanceof Undead_Sword) {
                                event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE_PIGMAN.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl())));
                                initialDamage.updateAndGet(v -> new Float(v * 2));
                            } else {
                                event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ZOMBIE_PIGMAN.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                            }
                        } else if (target instanceof WitherSkeletonEntity) {
                            if (player.getMainHandItem().getItem() instanceof Undead_Sword) {
                                event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER_SKELETON.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl())));
                                initialDamage.updateAndGet(v -> new Float(v * 2));
                            } else {
                                event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER_SKELETON.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                            }
                        } else if (target instanceof WitherEntity) {
                            if (player.getMainHandItem().getItem() instanceof Undead_Sword) {
                                event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl())));
                                initialDamage.updateAndGet(v -> new Float(v * 2));
                            } else {
                                event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.WITHER.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                            }
                        } else if (target instanceof EnderDragonEntity) {
                            if (player.getMainHandItem().getItem() instanceof End_Sword) {
                                event.setAmount(2 * (PlayerStats.damageEntity(event.getAmount(), MobStats.ENDER_DRAGON.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl())));
                                initialDamage.updateAndGet(v -> new Float(v * 2));
                            } else {
                                event.setAmount(PlayerStats.damageEntity(event.getAmount(), MobStats.ENDER_DRAGON.defense + totalDefense, target.getMaxHealth(), hasOneForAll, hasEmeraldBlade, skills.getStrength(), skills.getCoins(), skills.getCombatLvl()));
                            }
                        } else if (target instanceof PlayerEntity) {
                            event.setAmount(event.getAmount());
                        }

                        if (lifeStealLvl > 0) {
                            int rnd = MathHelper.nextInt(new Random(), 1, 40 - (lifeStealLvl * 10));

                            if (rnd == 1 && PlayerStats.isEnoughMana(6f, skills.getMana(), skills.getUltWiseLvl(), player)) {
                                float healAmnt = target.getHealth() * (lifeStealLvl * 0.05f * PlayerStats.getLifeStealDamageMultiplier((player.getArmorValue() / 3f) * 10f));
                                if (PlayerStats.debugLogging) {
                                    ClientUtils.SendPrivateMessage("armorVal: " + player.getArmorValue());
                                }
                                player.heal(healAmnt);
                                target.setHealth(target.getHealth() - (healAmnt / 2f));
                                int mana = PlayerStats.calcManaUsage(6f, skills.getMana(), skills.getUltWiseLvl());
                                player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - mana);
                                ClientUtils.SendPrivateMessage(ColorText.GREEN + "Your " + ColorText.GRAY + "Life Steal " + lifeStealLvl + ColorText.GREEN + " Stole " + ColorText.RED + Math.round(healAmnt / 2) + " health " + ColorText.GREEN + "from " + ColorText.GOLD + "PLACEHOLDER_ENTITY" + ColorText.GREEN + "! " + ColorText.AQUA + "(" + (mana * 5) + " Mana)");
                            }


                        }
                        //Refined netherite armor
                        if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Refined_Netherite_Helmet
                                & player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Refined_Netherite_Chestplate
                                & player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Refined_Netherite_Leggings
                                & player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Refined_Netherite_Boots) {
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
                                    (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Pickaxe)) {
                                if (PlayerStats.debugLogging) {
                                    ClientUtils.SendPrivateMessage("before: " + event.getAmount());
                                }
                                event.setAmount(event.getAmount() * 1.2f);
                                initialDamage.updateAndGet(v -> new Float(v * 1.2f));
                                if (PlayerStats.debugLogging) {
                                    ClientUtils.SendPrivateMessage("after: " + event.getAmount());
                                }
                                if (PlayerStats.debugLogging) {
                                    ClientUtils.SendPrivateMessage("from: 2/1");
                                }
                            }
                        }
                        //Hardened Refined netherite armor
                        else if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Hardened_Refined_Netherite_Helmet
                                & player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Hardened_Refined_Netherite_Chestplate
                                & player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Hardened_Refined_Netherite_Leggings
                                & player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Hardened_Refined_Netherite_Boots) {
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
                                    (player.getMainHandItem().getItem() instanceof Netherite_Plated_Diamond_Pickaxe)) {
                                if (PlayerStats.debugLogging) {
                                    ClientUtils.SendPrivateMessage("before: " + event.getAmount());
                                }
                                event.setAmount(event.getAmount() * 1.4f);
                                initialDamage.updateAndGet(v -> new Float(v * 1.4f));
                                if (PlayerStats.debugLogging) {
                                    ClientUtils.SendPrivateMessage("after: " + event.getAmount());
                                }
                                if (PlayerStats.debugLogging) {
                                    ClientUtils.SendPrivateMessage("from: 2/2");
                                }
                            }
                        }
                        //ClientUtils.SendPrivateMessage("damage: " + event.getAmount());
                        //ClientUtils.SendPrivateMessage("serength: " + skills.getStrength());



                    if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Mushroom_Helmet
                            & player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Mushroom_Chestplate
                            & player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Mushroom_Leggings
                            & player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Mushroom_Boots) {
                        if (player.level.getTimeOfDay(1f) > 13000 | player.level.getTimeOfDay(1f) < 1000) {
                            event.setAmount(event.getAmount() / 3f);
                        }
                    }

                    if (player.getMainHandItem().getItem() instanceof Flame_Sword) {
                        target.setSecondsOnFire(3);
                    }



                    event.setAmount(event.getAmount() * (1 - (totalDefense / (totalDefense + 20f))));
                    event.setAmount(event.getAmount() * ((10f - lightlvl) * 0.1f));
                    ArmorStandEntity dmgTag = new ArmorStandEntity(worldIn, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
                    //dmgTag.forceAddEffect(new EffectInstance(Effects.INVISIBILITY, 1000, 1));
                    dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + Math.round(10 * event.getAmount())));
                    dmgTag.setCustomNameVisible(true);
                    dmgTag.setInvulnerable(true);
                    dmgTag.noPhysics = true;
                    dmgTag.setInvisible(true);
                    worldIn.addFreshEntity(dmgTag);
                    //dmgTag.kill();

                    if (PlayerStats.debugLogging) {
                        Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calculatedDamage : " + event.getAmount()), false);
                    }
                    //ClientUtils.SendPrivateMessage("damage: " + event.getAmount());
                    //ferocity
                    int hits = (int) Math.floor(skills.getFerocity() / 100.0);
                    //ClientUtils.SendPrivateMessage("hits: " + hits);
                    int bonusChance = skills.getFerocity() - (hits * 100);
                    //ClientUtils.SendPrivateMessage("bonusChance: " + bonusChance);
                    int rnd = MathHelper.nextInt(new Random(), 1, 100);
                    if (rnd <= bonusChance) {
                        hits += 1;
                        //ClientUtils.SendPrivateMessage("bonus");
                    }
                    ferocityCount = hits;
                    //ClientUtils.SendPrivateMessage("ferocityCount: " + ferocityCount);
                    event.getEntityLiving().hurt(DamageSource.GENERIC, event.getAmount() * ((skills.getCombatLvl() * 0.01f) + 0.5f));
                    //ticksSinceHit = 0;
                    //ClientUtils.SendPrivateMessage("hit: " + event.getAmount() * ((skills.getCombatLvl() * 0.01f) + 0.5f));
                } else {
                    //int rnd1 = worldIn.random.nextInt(2) + 1;
                    //if (ticksSinceHit == rnd1){
                        //event.setAmount(event.getAmount() * ((skills.getCombatLvl() * 0.01f) + 0.5f));
                        //ClientUtils.SendPrivateMessage("ferocityHit: " + event.getAmount() * ((skills.getCombatLvl() * 0.01f) + 0.5f));
                        ferocityCount -= 1;
                        //ClientUtils.SendPrivateMessage("ferocity: " + ferocityCount);
                        //dmgTag.forceAddEffect(new EffectInstance(Effects.INVISIBILITY, 1000, 1));
                        ArmorStandEntity dmgTag = new ArmorStandEntity(worldIn, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
                    if ((5 * Math.round((initialDamage.get() * (skills.getStrength() / 100f) * (1 + (skills.getCombatLvl() * 0.04f))) + (hasEmeraldBlade ? PlayerStats.calcEmeraldBladeBoost(skills.getCoins()) : 0))) > 0) {
                        dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + (5 * Math.round((initialDamage.get() * (skills.getStrength() / 100f) * (1 + (skills.getCombatLvl() * 0.04f))) + (hasEmeraldBlade ? PlayerStats.calcEmeraldBladeBoost(skills.getCoins()) : 0)))));
                        dmgTag.setCustomNameVisible(true);
                        dmgTag.setInvulnerable(true);
                        dmgTag.noPhysics = true;
                        dmgTag.setInvisible(true);
                        worldIn.addFreshEntity(dmgTag);
                    }
                    int rnd = player.level.random.nextInt(5) + 1;
                    SoundEvent sound;
                    float pitch = 1f;
                    if (rnd >= 4) {
                        sound = SoundEvents.ZOMBIE_BREAK_WOODEN_DOOR;
                        pitch = 0.75f;
                    } else if (rnd >= 2) {
                        sound = SoundEvents.IRON_GOLEM_ATTACK;
                    } else {
                        sound = SoundEvents.FLINTANDSTEEL_USE;
                        pitch = 0.5f;
                    }
                    dmgTag.level.playSound(null, dmgTag, sound, SoundCategory.NEUTRAL, 1f, pitch);
                    //ticksSinceHit = 0;
                    event.getEntityLiving().hurt(DamageSource.playerAttack((PlayerEntity) event.getSource().getEntity()), event.getAmount() * ((skills.getCombatLvl() * 0.01f) + 0.5f));
                    MinecraftForge.EVENT_BUS.post(new LivingHurtEvent(event.getEntityLiving(), DamageSource.playerAttack((PlayerEntity) event.getSource().getEntity()), event.getAmount() * ((skills.getCombatLvl() * 0.01f) + 0.5f)));
                    //}

                }
            });
        }

        if (event.getEntity() instanceof PlayerEntity)
        {
            PlayerEntity target = (PlayerEntity) event.getEntity();
            target.getCapability(CapabilityPlayerSkills.PLAYER_STATS_CAPABILITY).ifPresent(skills -> {
                if (event.getSource() == DamageSource.FALL) {
                    ArmorStandEntity dmgTag = new ArmorStandEntity(worldIn, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
                    //dmgTag.forceAddEffect(new EffectInstance(Effects.INVISIBILITY, 1000, 1));
                    dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + (Math.round(initialDamage.get()) * 5)));
                    dmgTag.setCustomNameVisible(true);
                    dmgTag.setInvulnerable(true);
                    dmgTag.noPhysics = true;
                    dmgTag.setInvisible(true);
                    worldIn.addFreshEntity(dmgTag);
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

                    event.setAmount(event.getAmount() + event.getAmount() * fallDamageMultiplier);
                    event.setAmount((event.getAmount() / skills.getMaxHealth()) * 100);
                    //ClientUtils.SendPrivateMessage("fallMultiplier: " + fallDamageMultiplier);
                    //ClientUtils.SendPrivateMessage("final: " + event.getAmount());
                    target.level.playSound(null, target, SoundEvents.ANVIL_LAND, SoundCategory.NEUTRAL, 1.0f, 1.5f);

                } else if (event.getSource().isBypassArmor()) {
                    if (event.getSource() == DamageSource.WITHER | event.getSource() == DamageSource.MAGIC | event.getSource() == DamageSource.FLY_INTO_WALL | event.getSource() == DamageSource.ON_FIRE | event.getSource() == DamageSource.DRAGON_BREATH | event.getSource() == DamageSource.LAVA | event.getSource() == DamageSource.HOT_FLOOR | event.getSource() == DamageSource.indirectMagic(event.getSource().getEntity(), event.getEntity())) {
                        event.setAmount((event.getAmount() / skills.getMaxHealth()) * 20);
                    }

                }else{
                    ArmorStandEntity dmgTag = new ArmorStandEntity(worldIn, event.getEntity().position().x + (0.5f - Math.random()), event.getEntity().position().y + 0.5 + (0.5f - Math.random()), event.getEntity().position().z + (0.5f - Math.random()));
                    //dmgTag.forceAddEffect(new EffectInstance(Effects.INVISIBILITY, 1000, 1));
                    dmgTag.setCustomName(ITextComponent.nullToEmpty(ColorText.YELLOW.toString() + (Math.round(initialDamage.get()) * 5)));
                    dmgTag.setCustomNameVisible(true);
                    dmgTag.setInvulnerable(true);
                    dmgTag.noPhysics = true;
                    dmgTag.setInvisible(true);
                    worldIn.addFreshEntity(dmgTag);
                    if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("initialDamage: " + event.getAmount()), false);}
                    if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calc: " + "(1 - (event.getAmount() - (" + skills.getDefense() + " / (" + skills.getDefense() + " + 20f))))"), false);}
                    if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("calc: " + (1 - (event.getAmount() - (skills.getDefense() / (skills.getDefense() + 20f))))), false);}
                    //skills.setHealth(Math.round((event.getEntityLiving().getHealth() / event.getEntityLiving().getMaxHealth()) * skills.getMaxHealth()));
                    event.setAmount((event.getAmount() * (1 - (skills.getDefense() / (skills.getDefense() + 20f)))) / (skills.getMaxHealth() / 100));
                    if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("defense: " + skills.getDefense()), false);}
                    if (PlayerStats.debugLogging) {Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("damageTaken : " + event.getAmount()), false);}
                }
            });

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
        }*/

        World world = event.getEntityLiving().level;
        LivingEntity target = event.getEntityLiving();
        //int targetTotalDefense = 0;
        AtomicReference<Integer> targetTotalDefense = new AtomicReference<>(0);
        if (target != null) {
            targetTotalDefense.updateAndGet(v -> target.getArmorValue());
        }

        LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
        AtomicReference<Integer> attackerTotalDefense = new AtomicReference<>(0);
        if (attacker != null) {
            attackerTotalDefense.updateAndGet(v -> attacker.getArmorValue());
        }

        if (attacker != null) {
            if (!(attacker.getMainHandItem().getItem() instanceof TaggedSwordItem) | event.getSource().getDirectEntity() instanceof AbstractArrowEntity) {
                event.setAmount(event.getAmount() * 12);
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
                    if (event.getSource() == DamageSource.WITHER | event.getSource() == DamageSource.MAGIC | event.getSource() == DamageSource.FLY_INTO_WALL | event.getSource() == DamageSource.ON_FIRE | event.getSource() == DamageSource.DRAGON_BREATH | event.getSource() == DamageSource.LAVA | event.getSource() == DamageSource.HOT_FLOOR | event.getSource() == DamageSource.indirectMagic(event.getSource().getEntity(), event.getEntity())) {
                        event.setAmount(event.getAmount() * (target.getMaxHealth() / skills.getMaxHealth()));
                    }

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
                    event.setAmount((event.getAmount() * (1 - (skills.getDefense() / (skills.getDefense() + 20f)))) * (target.getMaxHealth() / skills.getMaxHealth()));
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
                    event.setAmount(event.getAmount() * (1 - (targetTotalDefense.get() / (targetTotalDefense.get() + 20f))) * (target.getMaxHealth() / (skills.getMobLevel() * 2.5f * target.getMaxHealth())));
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
                player.getFoodData().setFoodLevel(Math.round((((float) (skills.getMana())) / ((float) (skills.getMaxMana()))) * 20f));
                //end of mana regen

                int strengthAdder = 100;

                strengthAdder += player.experienceLevel / 5f;

                if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), player.getOffhandItem()) > 0) {
                    skills.setUltWiseLvl(EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), player.getOffhandItem()));
                } else if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), player.getMainHandItem()) > 0) {
                    skills.setUltWiseLvl(EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.ULTIMATE_WISE.get(), player.getMainHandItem()));
                } else {
                    skills.setUltWiseLvl(0);
                }

                //emeralds to coins
                skills.setCoins((player.inventory.countItem(Items.EMERALD) * 6) + (player.inventory.countItem(Items.EMERALD_BLOCK) * 54) + (player.inventory.countItem(ItemInit.REFINED_EMERALD.get()) * 960) + (player.inventory.countItem(ItemInit.REFINED_EMERALD_BLOCK.get()) * 8640));


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
                    player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 20, 0));
                }
                if (player.getMainHandItem().getItem() instanceof Ink_Wand || player.getOffhandItem().getItem() instanceof Ink_Wand) {
                    strengthAdder += 90;
                }
                if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.LIGHT.get(), player.getMainHandItem()) > 0) {
                    player.getAttribute(Attributes.ATTACK_SPEED).setBaseValue(player.getAttribute(Attributes.ATTACK_SPEED).getValue() * (1f + ((10f - EnchantmentHelper.getItemEnchantmentLevel(EnchantmentInit.LIGHT.get(), player.getMainHandItem())) * 0.1f)));
                }

                if (player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Refined_Netherite_Leggings
                        & player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Refined_Netherite_Boots) {
                    player.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20, 0));
                }
                if (player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Hardened_Refined_Netherite_Boots) {
                    player.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20, 0));
                }

                skills.setStrength(strengthAdder);
                skills.setMaxMana(100 + (Math.round(((float)(player.experienceLevel)) / 5f)) +
                        (player.getMainHandItem().getItem() instanceof Zombie_Sword || player.getOffhandItem().getItem() instanceof Zombie_Sword ? 50 : 0) +
                        (player.getMainHandItem().getItem() instanceof Ornate_Zombie_Sword || player.getOffhandItem().getItem() instanceof Ornate_Zombie_Sword ? 50 : 0) +
                        (player.getMainHandItem().getItem() instanceof Florid_Zombie_Sword || player.getOffhandItem().getItem() instanceof Florid_Zombie_Sword ? 100 : 0));
                skills.setMaxHealth((float) (100f + Math.floor(player.experienceLevel / 10D)));
                skills.setHealth(Math.round(((event.getEntityLiving().getHealth() + event.getEntityLiving().getAbsorptionAmount()) / event.getEntityLiving().getMaxHealth()) * skills.getMaxHealth()));
                skills.setFerocity((int) Math.floor(((double) (player.experienceLevel)) / 25D));

                ColorText color;
                if (player.hasEffect(Effects.WITHER)) {
                    color = ColorText.DARK_GRAY;
                }else if (player.hasEffect(Effects.ABSORPTION)){
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
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance()) &
                                player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance())) {
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 60) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 40);
                                    if (rnd == 10) {
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
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_INITIATE_BADGE.get().asItem().getDefaultInstance())) {
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 60) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 50);
                                    if (rnd == 10) {
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
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_ADAPT_BADGE.get().asItem().getDefaultInstance())) {
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 60) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 40);
                                    if (rnd == 10) {
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
                        } else if (player.inventory.contains(ItemInit.CAMPFIRE_SCION_BADGE.get().asItem().getDefaultInstance())) {
                            player.addEffect(new EffectInstance(Effects.REGENERATION, 40, 0));
                            if (player.isOnFire()) {
                                //ClientUtils.SendPrivateMessage("you are on fire!");
                                //ClientUtils.SendPrivateMessage("ticks:" + ticksSinceOnFire);
                                if (ticksSinceOnFire >= 40) {
                                    //ClientUtils.SendPrivateMessage("you are on fire mor than 3s!");
                                    int rnd = MathHelper.nextInt(new Random(), 1, 30);
                                    if (rnd == 10) {
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

                skills.setDefense(headDefense + chestDefense + legsDefense + feetDefense);


                //Armor abilities
                //farm suit
                //Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("armor: " + player.getItemBySlot(EquipmentSlotType.HEAD).getItem() + " ," + player.getItemBySlot(EquipmentSlotType.CHEST).getItem() + " ," + player.getItemBySlot(EquipmentSlotType.LEGS).getItem() + " ," + player.getItemBySlot(EquipmentSlotType.FEET).getItem()), false);
                if (player.getItemBySlot(EquipmentSlotType.HEAD).getItem() instanceof Farm_Suit_Helmet
                        & player.getItemBySlot(EquipmentSlotType.CHEST).getItem() instanceof Farm_Suit_Chestplate
                        & player.getItemBySlot(EquipmentSlotType.LEGS).getItem() instanceof Farm_Suit_Leggings
                        & player.getItemBySlot(EquipmentSlotType.FEET).getItem() instanceof Farm_Suit_Boots) {
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
                            feetBlock instanceof FarmlandBlock || belowFeetBlock instanceof FarmlandBlock || aboveFeetBlock instanceof FarmlandBlock) {
                        //Minecraft.getInstance().player.displayClientMessage(ITextComponent.nullToEmpty("on cropblock!"), false);
                        player.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 60, 2));
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

                //skills.setMana(manaReductionPercentAdder);

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
    public static void OnLeftClickBow(final PlayerInteractEvent.LeftClickEmpty event) {
        if (event.getPlayer().getMainHandItem().getItem() instanceof ShortBow) {
            ShortBow bow = (ShortBow) event.getPlayer().getMainHandItem().getItem();
            bow.use(event.getWorld(), event.getPlayer(), Hand.MAIN_HAND);
            ClientUtils.SendPrivateMessage("shot");
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
