package com.iwant2tryhard.skyblockitemsplusplus.common.containers;

import com.iwant2tryhard.skyblockitemsplusplus.client.gui.ElectricCraftingTableScreen;
import com.iwant2tryhard.skyblockitemsplusplus.common.tileentities.ElectricCraftingTableTileEntity;
import com.iwant2tryhard.skyblockitemsplusplus.common.util.FunctionalIntReferenceHolder;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.BlockInit;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.ContainerInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;
import java.util.Objects;

public class ElectricCraftingTableContainer extends Container {
    private ElectricCraftingTableTileEntity tileEntity;
    private IWorldPosCallable canInteractWithCallable;
    public FunctionalIntReferenceHolder currentSmeltTime;

    //Server
    public ElectricCraftingTableContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInv, PlayerEntity player) {
        super(ContainerInit.ELECTRIC_CRAFTING_TABLE.get(), windowId);

        ElectricCraftingTableTileEntity tile = (ElectricCraftingTableTileEntity) world.getBlockEntity(pos);

        this.tileEntity = tile;
        this.canInteractWithCallable = IWorldPosCallable.create(tile.getLevel(), tile.getBlockPos());

        //hotbar
        final int slotSizePlus2 = 18;
        final int startX = 8;
        int hotbarY = 142;
        for (int column = 0; column < 9; column++)
        {
            this.addSlot(new Slot(playerInv, column, startX + (column * slotSizePlus2), hotbarY));
        }

        //inv
        final int startY = 84;
        for (int row = 0; row < 3; row++)
        {
            for (int column = 0; column < 9; column++)
            {
                this.addSlot(new Slot(playerInv, 9 + (row * 9) + column, startX + (column * slotSizePlus2), startY + (row * slotSizePlus2)));
            }
        }

        //ui
        this.addSlot(new SlotItemHandler(tile.getInventory(), 0, 30, 17));
        this.addSlot(new SlotItemHandler(tile.getInventory(), 1, 48, 17));
        this.addSlot(new SlotItemHandler(tile.getInventory(), 2, 66, 17));
        this.addSlot(new SlotItemHandler(tile.getInventory(), 3, 30, 35));
        this.addSlot(new SlotItemHandler(tile.getInventory(), 4, 48, 35));
        this.addSlot(new SlotItemHandler(tile.getInventory(), 5, 66, 35));
        this.addSlot(new SlotItemHandler(tile.getInventory(), 6, 30, 53));
        this.addSlot(new SlotItemHandler(tile.getInventory(), 7, 48, 53));
        this.addSlot(new SlotItemHandler(tile.getInventory(), 8, 66, 53));

        this.addSlot(new SlotItemHandler(tile.getInventory(), 8, 124, 35));

        this.addDataSlot(currentSmeltTime = new FunctionalIntReferenceHolder(() -> this.tileEntity.currentSmeltTime,
                value -> this.tileEntity.currentSmeltTime = value));

    }

    /*//Client
    public ElectricCraftingTableContainer(int windowID, PlayerInventory playerInv, PacketBuffer data) {
        this(windowID, playerInv, getTileEntity(playerInv, data));
    }*/

    /*public ElectricCraftingTableContainer(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player) {
        super(ContainerInit.ELECTRIC_CRAFTING_TABLE.get(), windowId);
        tileEntity = (ElectricCraftingTableTileEntity) world.getBlockEntity(pos);
    }*/

    private ElectricCraftingTableTileEntity getTileEntity() {
        return this.tileEntity;
    }

    @Override
    public boolean stillValid(PlayerEntity playerEntity) {
        return stillValid(canInteractWithCallable, playerEntity, BlockInit.ELECTRIC_CRAFTING_TABLE.get());
    }

    @Nonnull
    @Override
    public ItemStack quickMoveStack(final PlayerEntity player, final int index) {
        ItemStack returnStack = ItemStack.EMPTY;
        final Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            final ItemStack slotStack = slot.getItem();
            returnStack = slotStack.copy();

            final int containerSlots = this.slots.size() - player.inventory.getContainerSize();
            if (index < containerSlots) {
                if (!moveItemStackTo(slotStack, containerSlots, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!moveItemStackTo(slotStack, 0, containerSlots, false)) {
                return ItemStack.EMPTY;
            }
            if (slotStack.getCount() == 0) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
            if (slotStack.getCount() == returnStack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, slotStack);
        }
        return returnStack;
    }

    @OnlyIn(Dist.CLIENT)
    public int getSmeltProgressionScaled()
    {
        return this.currentSmeltTime.get() != 0 && this.tileEntity.maxSmeltTime != 0 ?
                this.currentSmeltTime.get() * 24 / this.tileEntity.maxSmeltTime :
                0;
    }
}
