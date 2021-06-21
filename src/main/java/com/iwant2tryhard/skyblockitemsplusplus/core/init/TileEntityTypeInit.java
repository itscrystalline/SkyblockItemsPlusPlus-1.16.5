package com.iwant2tryhard.skyblockitemsplusplus.core.init;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.common.tileentities.ElectricCraftingTableTileEntity;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeInit {

    public static DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, SkyblockItemsPlusPlus.MOD_ID);

    public static final RegistryObject<TileEntityType<ElectricCraftingTableTileEntity>> ELECTRIC_CRAFTING_TABLE = TILE_ENTITY_TYPES
            .register("electric_crafting_table", () -> TileEntityType.Builder
                    .of(ElectricCraftingTableTileEntity::new, BlockInit.ELECTRIC_CRAFTING_TABLE.get()).build(null));

}
