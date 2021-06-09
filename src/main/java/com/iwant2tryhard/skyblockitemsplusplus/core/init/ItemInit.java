package com.iwant2tryhard.skyblockitemsplusplus.core.init;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Boots;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Chestplate;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Helmet;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Leggings;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.materials.blockitems.*;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.materials.items.*;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.weapons.*;
import com.iwant2tryhard.skyblockitemsplusplus.common.materials.armor.FarmSuitSource;
import com.iwant2tryhard.skyblockitemsplusplus.common.materials.items.*;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SkyblockItemsPlusPlus.MOD_ID);

    //items
        //material items
    public static final RegistryObject<RefinedNetheriteIngot> REFINED_NETHERITE_INGOT = ITEMS.register("refined_netherite_ingot",
            () -> new RefinedNetheriteIngot(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedDiamond> REFINED_DIAMOND = ITEMS.register("refined_diamond",
            () -> new RefinedDiamond(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedGoldIngot> REFINED_GOLD_INGOT = ITEMS.register("refined_gold_ingot",
            () -> new RefinedGoldIngot(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedIronIngot> REFINED_IRON_INGOT = ITEMS.register("refined_iron_ingot",
            () -> new RefinedIronIngot(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedCoal> REFINED_COAL = ITEMS.register("refined_coal",
            () -> new RefinedCoal(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));

    public static final RegistryObject<Mithril> MITHRIL = ITEMS.register("mithril",
            () -> new Mithril(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedMithril> REFINED_MITHRIL = ITEMS.register("refined_mithril",
            () -> new RefinedMithril(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<ConcentratedRefinedMithril> CONCENTRATED_REFINED_MITHRIL = ITEMS.register("concentrated_refined_mithril",
            () -> new ConcentratedRefinedMithril(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<Titanium> TITANIUM = ITEMS.register("titanium",
            () -> new Titanium(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedTitanium> REFINED_TITANIUM = ITEMS.register("refined_titanium",
            () -> new RefinedTitanium(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedEnderpearl> REFINED_ENDER_PEARL = ITEMS.register("refined_ender_pearl",
            () -> new RefinedEnderpearl(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));

    //swords
    public static final RegistryObject<Aspect_Of_The_Jerry> ASPECT_OF_THE_JERRY = ITEMS.register("aspect_of_the_jerry",
            () -> new Aspect_Of_The_Jerry(new AspectOfTheJerrySource(), 1, -2.4f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)));
    public static final RegistryObject<Rogue_Sword> ROGUE_SWORD = ITEMS.register("rogue_sword",
            () -> new Rogue_Sword(new RogueSwordSource(), 20, -2.4f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)));
    public static final RegistryObject<Hardened_Refined_Netherite_Sword> HARDENED_REFINED_NETHERITE_SWORD = ITEMS.register("hardened_refined_netherite_sword",
            () -> new Hardened_Refined_Netherite_Sword(new HardenedRefinedNetheriteSwordSorce(), 350, -3.5f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)));
    public static final RegistryObject<Aspect_Of_The_End> ASPECT_OF_THE_END = ITEMS.register("aspect_of_the_end",
            () -> new Aspect_Of_The_End(new AspectOfTheEndSource(), 100, -2.4f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)));
    public static final RegistryObject<Undead_Sword> UNDEAD_SWORD = ITEMS.register("undead_sword",
            () -> new Undead_Sword(new UndeadSwordSource(), 30, -2.4f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)));

    //armor
    public static final RegistryObject<Farm_Suit_Helmet> FARM_SUIT_HELMET = ITEMS.register("farm_suit_helmet",
            () -> new Farm_Suit_Helmet(new FarmSuitSource(), EquipmentSlotType.HEAD, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Armors)));
    public static final RegistryObject<Farm_Suit_Chestplate> FARM_SUIT_CHESTPLATE = ITEMS.register("farm_suit_chestplate",
            () -> new Farm_Suit_Chestplate(new FarmSuitSource(), EquipmentSlotType.CHEST, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Armors)));
    public static final RegistryObject<Farm_Suit_Leggings> FARM_SUIT_LEGGINGS = ITEMS.register("farm_suit_leggings",
            () -> new Farm_Suit_Leggings(new FarmSuitSource(), EquipmentSlotType.LEGS, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Armors)));
    public static final RegistryObject<Farm_Suit_Boots> FARM_SUIT_BOOTS = ITEMS.register("farm_suit_boots",
            () -> new Farm_Suit_Boots(new FarmSuitSource(), EquipmentSlotType.FEET, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Armors)));


    //Block items
        //Material Blocks
    public static final RegistryObject<RefinedNetheriteBlockItem> REFINED_NETHERITE_BLOCK = ITEMS.register("refined_netherite_block",
            () -> new RefinedNetheriteBlockItem(BlockInit.REFINED_NETHERITE_BLOCK.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedDiamondBlockItem> REFINED_DIAMOND_BLOCK = ITEMS.register("refined_diamond_block",
            () -> new RefinedDiamondBlockItem(BlockInit.REFINED_DIAMOND_BLOCK.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedGoldBlockItem> REFINED_GOLD_BLOCK = ITEMS.register("refined_gold_block",
            () -> new RefinedGoldBlockItem(BlockInit.REFINED_GOLD_BLOCK.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedIronBlockItem> REFINED_IRON_BLOCK = ITEMS.register("refined_iron_block",
            () -> new RefinedIronBlockItem(BlockInit.REFINED_IRON_BLOCK.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedCoalBlockItem> REFINED_COAL_BLOCK = ITEMS.register("refined_coal_block",
            () -> new RefinedCoalBlockItem(BlockInit.REFINED_COAL_BLOCK.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<MithrilBlockItem> MITHRIL_BLOCK = ITEMS.register("mithril_block",
            () -> new MithrilBlockItem(BlockInit.MITHRIL_BLOCK.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedMithrilBlockItem> REFINED_MITHRIL_BLOCK = ITEMS.register("refined_mithril_block",
            () -> new RefinedMithrilBlockItem(BlockInit.REFINED_MITHRIL_BLOCK.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<ConcentratedRefinedMithrilBlockItem> CONCENTRATED_REFINED_MITHRIL_BLOCK = ITEMS.register("concentrated_refined_mithril_block",
            () -> new ConcentratedRefinedMithrilBlockItem(BlockInit.CONCENTRATED_REFINED_MITHRIL_BLOCK.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<TitaniumBlockItem> TITANIUM_BLOCK = ITEMS.register("titanium_block",
            () -> new TitaniumBlockItem(BlockInit.TITANIUM_BLOCK.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedTitaniumBlockItem> REFINED_TITANIUM_BLOCK = ITEMS.register("refined_titanium_block",
            () -> new RefinedTitaniumBlockItem(BlockInit.REFINED_TITANIUM_BLOCK.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));

        //Ore Blocks
        public static final RegistryObject<MithrilOreBlockItem> MITHRIL_ORE = ITEMS.register("mithril_ore",
                () -> new MithrilOreBlockItem(BlockInit.MITHRIL_ORE.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
        public static final RegistryObject<TitaniumOreBlockItem> TITANIUM_ORE = ITEMS.register("titanium_ore",
                () -> new TitaniumOreBlockItem(BlockInit.TITANIUM_ORE.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
}
