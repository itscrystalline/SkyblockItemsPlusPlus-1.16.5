package com.iwant2tryhard.skyblockitemsplusplus.world;

import com.iwant2tryhard.skyblockitemsplusplus.core.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import org.apache.commons.compress.archivers.zip.UnsupportedZipFeatureException;

public class OreGeneration {
    public static void generateOres(final BiomeLoadingEvent event)
    {
        if (!event.getCategory().equals(Biome.Category.NETHER) ||
                !event.getCategory().equals(Biome.Category.THEEND))
        {
            genOre(event, OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.MITHRIL_ORE.get().defaultBlockState(), 5, 15, 30, 20);
            genOre(event, OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.TITANIUM_ORE.get().defaultBlockState(), 3, 5, 15, 5);
        }
    }
    private static void genOre(BiomeLoadingEvent event, RuleTest fillerType, BlockState state, int veinSize, int minHeight, int maxHeight, int amount)
    {
        event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreFeatureConfig(fillerType, state, veinSize))
                        .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                        .squared().count(amount));
    }
}
