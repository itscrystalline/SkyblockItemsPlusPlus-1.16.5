package com.iwant2tryhard.skyblockitemsplusplus.common.blocks;

import com.iwant2tryhard.skyblockitemsplusplus.common.tileentities.ElectricCraftingTableTileEntity;
import com.iwant2tryhard.skyblockitemsplusplus.common.util.CustomItemHandler;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.TileEntityTypeInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ElectricCraftingTableBlock extends Block {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public ElectricCraftingTableBlock(Properties properties) {
        super(properties);
        //this.registerDefaultState(this.getStateDefinition().getOwner().defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypeInit.ELECTRIC_CRAFTING_TABLE.get().create();
    }


    /*@Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return super.rotate(state, rot);
    }*/

    /*@Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getStateDefinition().getOwner().defaultBlockState()
                .setValue(FACING, context.getHorizontalDirection().getOpposite());
    }*/

    @Override
    public void setPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(world, pos, state, placer, stack);
        if  (!stack.getDisplayName().equals(ITextComponent.nullToEmpty("")))
        {
            TileEntity tile = world.getBlockEntity(pos);
            if (tile instanceof ElectricCraftingTableTileEntity)
            {
                ((ElectricCraftingTableTileEntity) tile).setCustomName(stack.getDisplayName());
            }
        }
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, World world, BlockPos pos) {
        return Container.getRedstoneSignalFromBlockEntity(world.getBlockEntity(pos));
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockRayTraceResult hit) {
        if (world.isClientSide) {
            return ActionResultType.SUCCESS;
        } else {
            TileEntity tile = world.getBlockEntity(blockPos);
            if (tile instanceof ElectricCraftingTableTileEntity) {
                playerEntity.openMenu((ElectricCraftingTableTileEntity)tile);
            }

            return ActionResultType.CONSUME;
        }
    }

    @Override
    public void onRemove(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
        TileEntity tile = world.getBlockEntity(pos);
        if (tile instanceof ElectricCraftingTableTileEntity)
        {
            ElectricCraftingTableTileEntity table = (ElectricCraftingTableTileEntity)tile;
            ((CustomItemHandler)table.getInventory()).toNonNullList().forEach(item -> {
                ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), item);
                world.addFreshEntity(itemEntity);
            });
        }

        if (state.hasTileEntity() && state.getBlock() != newState.getBlock())
        {
            world.removeBlockEntity(pos);
        }
    }
}
