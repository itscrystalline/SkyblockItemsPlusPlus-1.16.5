package com.iwant2tryhard.skyblockitemsplusplus.core.init;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.common.blocks.ElectricCraftingTableBlock;
import com.iwant2tryhard.skyblockitemsplusplus.common.blocks.MithrilOreBlock;
import com.iwant2tryhard.skyblockitemsplusplus.common.blocks.TitaniumOreBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SkyblockItemsPlusPlus.MOD_ID);

    //Material Blocks
    public static final RegistryObject<Block> REFINED_NETHERITE_BLOCK = BLOCKS.register("refined_netherite_block",
            () -> new Block(AbstractBlock.Properties.of(Material.HEAVY_METAL, MaterialColor.NETHER)
                            .strength(75f, 1500f)
                            .harvestTool(ToolType.PICKAXE)
                            .harvestLevel(4)
                            .sound(SoundType.NETHERITE_BLOCK)
                            .requiresCorrectToolForDrops()
                            ));
    public static final RegistryObject<Block> REFINED_DIAMOND_BLOCK = BLOCKS.register("refined_diamond_block",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.DIAMOND)
                    .strength(7f, 10f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(3)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    ));
    public static final RegistryObject<Block> REFINED_EMERALD_BLOCK = BLOCKS.register("refined_emerald_block",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.EMERALD)
                    .strength(7f, 10f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(3)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    ));
    public static final RegistryObject<Block> REFINED_GOLD_BLOCK = BLOCKS.register("refined_gold_block",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.GOLD)
                    .strength(5f, 10f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(2)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    ));
    public static final RegistryObject<Block> REFINED_IRON_BLOCK = BLOCKS.register("refined_iron_block",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL)
                    .strength(5f, 10f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(2)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    ));
    public static final RegistryObject<Block> REFINED_COAL_BLOCK = BLOCKS.register("refined_coal_block",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.STONE)
                    .strength(4f, 9f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(1)
                    .sound(SoundType.STONE)
                    .requiresCorrectToolForDrops()
                    ));
    public static final RegistryObject<Block> MITHRIL_BLOCK = BLOCKS.register("mithril_block",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL)
                    .strength(7f, 11f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(2)
                    .sound(SoundType.CHAIN)
                    .requiresCorrectToolForDrops()
                    ));
    public static final RegistryObject<Block> REFINED_MITHRIL_BLOCK = BLOCKS.register("refined_mithril_block",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL)
                    .strength(8f, 11f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(2)
                    .sound(SoundType.CHAIN)
                    .requiresCorrectToolForDrops()
                    ));
    public static final RegistryObject<Block> CONCENTRATED_REFINED_MITHRIL_BLOCK = BLOCKS.register("concentrated_refined_mithril_block",
            () -> new Block(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL)
                    .strength(10f, 11f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(2)
                    .sound(SoundType.CHAIN)
                    .requiresCorrectToolForDrops()
                    ));
    public static final RegistryObject<Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block",
            () -> new Block(AbstractBlock.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL)
                    .strength(40f, 550f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(3)
                    .sound(SoundType.NETHERITE_BLOCK)
                    .requiresCorrectToolForDrops()
                    ));
    public static final RegistryObject<Block> REFINED_TITANIUM_BLOCK = BLOCKS.register("refined_titanium_block",
            () -> new Block(AbstractBlock.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL)
                    .strength(50f, 600f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(3)
                    .sound(SoundType.NETHERITE_BLOCK)
                    .requiresCorrectToolForDrops()
                    ));

    //Ore Blocks
    public static final RegistryObject<MithrilOreBlock> MITHRIL_ORE = BLOCKS.register("mithril_ore",
            () -> new MithrilOreBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE)
                    .strength(6f, 11f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(2)
                    .sound(SoundType.NETHER_GOLD_ORE)
                    .requiresCorrectToolForDrops()
                    ));
    public static final RegistryObject<TitaniumOreBlock> TITANIUM_ORE = BLOCKS.register("titanium_ore",
            () -> new TitaniumOreBlock(AbstractBlock.Properties.of(Material.HEAVY_METAL, MaterialColor.METAL)
                    .strength(35f, 500f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(3)
                    .sound(SoundType.NETHERITE_BLOCK)
                    .requiresCorrectToolForDrops()
                    ));

    //Tile Entities
    public static final RegistryObject<Block> ELECTRIC_CRAFTING_TABLE = BLOCKS.register("electric_crafting_table",
            () -> new ElectricCraftingTableBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.STONE)
                    .strength(5f, 10f)
                    .harvestTool(ToolType.PICKAXE)
                    .harvestLevel(2)
                    .sound(SoundType.STONE)
                    ));
}
