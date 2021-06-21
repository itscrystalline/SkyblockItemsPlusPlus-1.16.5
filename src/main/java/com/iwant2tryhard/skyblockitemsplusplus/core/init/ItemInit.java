package com.iwant2tryhard.skyblockitemsplusplus.core.init;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Boots;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Chestplate;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Helmet;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.farm_suit.Farm_Suit_Leggings;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.netherite_plated_diamond_armor.Netherite_Plated_Diamond_Boots;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.netherite_plated_diamond_armor.Netherite_Plated_Diamond_Chestplate;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.netherite_plated_diamond_armor.Netherite_Plated_Diamond_Helmet;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.armoritems.netherite_plated_diamond_armor.Netherite_Plated_Diamond_Leggings;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.axes.Netherite_Plated_Diamond_Axe;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.hoes.Netherite_Plated_Diamond_Hoe;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.pickaxes.Netherite_Plated_Diamond_Pickaxe;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.shovels.Netherite_Plated_Diamond_Shovel;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.items.swords.*;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.materials.blockitems.*;
import com.iwant2tryhard.skyblockitemsplusplus.common.items.materials.items.*;
import com.iwant2tryhard.skyblockitemsplusplus.common.materials.armor.FarmSuitSource;
import com.iwant2tryhard.skyblockitemsplusplus.common.materials.armor.NetheritePlatedDiamondArmorSource;
import com.iwant2tryhard.skyblockitemsplusplus.common.materials.items.NetheritePlatedDiamondSource;
import com.iwant2tryhard.skyblockitemsplusplus.common.materials.tools.swords.*;
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
    public static final RegistryObject<RefinedRottenFlesh> REFINED_ROTTEN_FLESH = ITEMS.register("refined_rotten_flesh",
            () -> new RefinedRottenFlesh(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedInkSack> REFINED_INK_SACK = ITEMS.register("refined_ink_sack",
            () -> new RefinedInkSack(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
    public static final RegistryObject<RefinedGhastTear> REFINED_GHAST_TEAR = ITEMS.register("refined_ghast_tear",
            () -> new RefinedGhastTear(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));

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
    public static final RegistryObject<Netherite_Plated_Diamond_Sword> NETHERITE_PLATED_DIAMOND_SWORD = ITEMS.register("netherite_plated_diamond_sword",
            () -> new Netherite_Plated_Diamond_Sword(new NetheritePlatedDiamondSource(), 7, -2.4f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)));
    public static final RegistryObject<End_Sword> END_SWORD = ITEMS.register("end_sword",
            () -> new End_Sword(new EndSwordSource(), 35, -2.4f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)));
    public static final RegistryObject<Flame_Sword> FLAME_SWORD = ITEMS.register("flame_sword",
            () -> new Flame_Sword(new FlameSwordSource(), 50, -2.4f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)
                    .fireResistant()));
    public static final RegistryObject<Zombie_Sword> ZOMBIE_SWORD = ITEMS.register("zombie_sword",
            () -> new Zombie_Sword(new ZombieSwordSource(), 100, -2.4f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)));
    public static final RegistryObject<Ornate_Zombie_Sword> ORNATE_ZOMBIE_SWORD = ITEMS.register("ornate_zombie_sword",
            () -> new Ornate_Zombie_Sword(new ZombieSwordSource(), 110, -2.4f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)));
    public static final RegistryObject<Florid_Zombie_Sword> FLORID_ZOMBIE_SWORD = ITEMS.register("florid_zombie_sword",
            () -> new Florid_Zombie_Sword(new ZombieSwordSource(), 150, -2.4f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)));
    public static final RegistryObject<Hunter_Knife> HUNTER_KNIFE = ITEMS.register("hunter_knife",
            () -> new Hunter_Knife(new HunterKnifeSource(), 50, -2f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)));
    public static final RegistryObject<Ink_Wand> INK_WAND = ITEMS.register("ink_wand",
            () -> new Ink_Wand(new InkWandSource(), 130, -2.4f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)));
    public static final RegistryObject<Silver_Fang> SILVER_FANG = ITEMS.register("silver_fang",
            () -> new Silver_Fang(new SilverFangSource(), 100, -2.5f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)));

    //pickaxes
    public static final RegistryObject<Netherite_Plated_Diamond_Pickaxe> NETHERITE_PLATED_DIAMOND_PICKAXE = ITEMS.register("netherite_plated_diamond_pickaxe",
            () -> new Netherite_Plated_Diamond_Pickaxe(new NetheritePlatedDiamondSource(), 5, -2.6f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Tools)));

    //axes
    public static final RegistryObject<Netherite_Plated_Diamond_Axe> NETHERITE_PLATED_DIAMOND_AXE = ITEMS.register("netherite_plated_diamond_axe",
            () -> new Netherite_Plated_Diamond_Axe(new NetheritePlatedDiamondSource(), 9, -3f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Tools)));

    //shovels
    public static final RegistryObject<Netherite_Plated_Diamond_Shovel> NETHERITE_PLATED_DIAMOND_SHOVEL = ITEMS.register("netherite_plated_diamond_shovel",
            () -> new Netherite_Plated_Diamond_Shovel(new NetheritePlatedDiamondSource(), (int) 5.5f, -3f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Tools)));

    //hoes
    public static final RegistryObject<Netherite_Plated_Diamond_Hoe> NETHERITE_PLATED_DIAMOND_HOE = ITEMS.register("netherite_plated_diamond_hoe",
            () -> new Netherite_Plated_Diamond_Hoe(new NetheritePlatedDiamondSource(), 1, 0f, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Tools)));

    //bows
    //public static final RegistryObject<Wither_Bow> WITHER_BOW = ITEMS.register("wither_bow",
            //() -> new Wither_Bow(new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Combat)));

    //armor
    public static final RegistryObject<Farm_Suit_Helmet> FARM_SUIT_HELMET = ITEMS.register("farm_suit_helmet",
            () -> new Farm_Suit_Helmet(new FarmSuitSource(), EquipmentSlotType.HEAD, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Armors)));
    public static final RegistryObject<Farm_Suit_Chestplate> FARM_SUIT_CHESTPLATE = ITEMS.register("farm_suit_chestplate",
            () -> new Farm_Suit_Chestplate(new FarmSuitSource(), EquipmentSlotType.CHEST, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Armors)));
    public static final RegistryObject<Farm_Suit_Leggings> FARM_SUIT_LEGGINGS = ITEMS.register("farm_suit_leggings",
            () -> new Farm_Suit_Leggings(new FarmSuitSource(), EquipmentSlotType.LEGS, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Armors)));
    public static final RegistryObject<Farm_Suit_Boots> FARM_SUIT_BOOTS = ITEMS.register("farm_suit_boots",
            () -> new Farm_Suit_Boots(new FarmSuitSource(), EquipmentSlotType.FEET, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Armors)));

    public static final RegistryObject<Netherite_Plated_Diamond_Helmet> NETHERITE_PLATED_DIAMOND_HELMET = ITEMS.register("netherite_plated_diamond_helmet",
            () -> new Netherite_Plated_Diamond_Helmet(new NetheritePlatedDiamondArmorSource(), EquipmentSlotType.HEAD, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Armors)));
    public static final RegistryObject<Netherite_Plated_Diamond_Chestplate> NETHERITE_PLATED_DIAMOND_CHESTPLATE = ITEMS.register("netherite_plated_diamond_chestplate",
            () -> new Netherite_Plated_Diamond_Chestplate(new NetheritePlatedDiamondArmorSource(), EquipmentSlotType.CHEST, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Armors)));
    public static final RegistryObject<Netherite_Plated_Diamond_Leggings> NETHERITE_PLATED_DIAMOND_LEGGINGS = ITEMS.register("netherite_plated_diamond_leggings",
            () -> new Netherite_Plated_Diamond_Leggings(new NetheritePlatedDiamondArmorSource(), EquipmentSlotType.LEGS, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Armors)));
    public static final RegistryObject<Netherite_Plated_Diamond_Boots> NETHERITE_PLATED_DIAMOND_BOOTS = ITEMS.register("netherite_plated_diamond_boots",
            () -> new Netherite_Plated_Diamond_Boots(new NetheritePlatedDiamondArmorSource(), EquipmentSlotType.FEET, new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Armors)));


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
    public static final RegistryObject<ElectricCraftingTableBlockItem> ELECTRIC_CRAFTING_TABLE_BLOCK = ITEMS.register("electric_crafting_table",
            () -> new ElectricCraftingTableBlockItem(BlockInit.ELECTRIC_CRAFTING_TABLE.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Tools)));

        //Ore Blocks
        public static final RegistryObject<MithrilOreBlockItem> MITHRIL_ORE = ITEMS.register("mithril_ore",
                () -> new MithrilOreBlockItem(BlockInit.MITHRIL_ORE.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
        public static final RegistryObject<TitaniumOreBlockItem> TITANIUM_ORE = ITEMS.register("titanium_ore",
                () -> new TitaniumOreBlockItem(BlockInit.TITANIUM_ORE.get(), new Item.Properties().tab(SkyblockItemsPlusPlus.SkyblockItems_Materials)));
}
