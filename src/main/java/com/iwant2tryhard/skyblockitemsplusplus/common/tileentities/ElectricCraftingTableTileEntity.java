package com.iwant2tryhard.skyblockitemsplusplus.common.tileentities;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.common.containers.ElectricCraftingTableContainer;
import com.iwant2tryhard.skyblockitemsplusplus.common.util.CustomItemHandler;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.RecipeSerializerInit;
import com.iwant2tryhard.skyblockitemsplusplus.core.init.TileEntityTypeInit;
import com.iwant2tryhard.skyblockitemsplusplus.recipes.CustomRecipe;
import com.iwant2tryhard.skyblockitemsplusplus.recipes.ICustomRecipe;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ElectricCraftingTableTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
    private ITextComponent customName;
    public int currentSmeltTime;
    public final int maxSmeltTime = 200;
    private final CustomItemHandler inventory;

    public ElectricCraftingTableTileEntity(TileEntityType<?> tileEntityType) {
        super(tileEntityType);

        this.inventory = new CustomItemHandler(10);
    }
    public ElectricCraftingTableTileEntity()
    {
        this(TileEntityTypeInit.ELECTRIC_CRAFTING_TABLE.get());
    }

    @Nullable
    @Override
    public Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerIn) {
        return new ElectricCraftingTableContainer(windowID, playerIn.level, this.worldPosition, playerInv, playerIn);
    }

    @Override
    public void tick() {
        boolean dirty = false;

        if (this.level != null && this.level.isClientSide())
        {
            if (this.getRecipe(this.inventory.getStackInSlot(0), this.inventory.getStackInSlot(1), this.inventory.getStackInSlot(2),
                               this.inventory.getStackInSlot(3), this.inventory.getStackInSlot(4), this.inventory.getStackInSlot(5),
                               this.inventory.getStackInSlot(6), this.inventory.getStackInSlot(7), this.inventory.getStackInSlot(8)) != null)
            {

                    if (this.currentSmeltTime != this.maxSmeltTime)
                    {
                        this.currentSmeltTime++;
                        dirty = true;
                    }
                    else
                    {
                        this.currentSmeltTime = 0;
                        ItemStack output = this.getRecipe(  this.inventory.getStackInSlot(0), this.inventory.getStackInSlot(1), this.inventory.getStackInSlot(2),
                                                            this.inventory.getStackInSlot(3), this.inventory.getStackInSlot(4), this.inventory.getStackInSlot(5),
                                                            this.inventory.getStackInSlot(6), this.inventory.getStackInSlot(7), this.inventory.getStackInSlot(8)).getResultItem();
                        this.inventory.insertItem(1, output.copy(), false);
                        this.inventory.decrStackSize(0, 1);
                        dirty = true;
                    }
            }

        }

        if (dirty)
        {
            this.level.setBlocksDirty(getBlockPos(), this.getBlockState(), this.getBlockState());
            this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
        }
    }

    public void setCustomName(ITextComponent name)
    {
        this.customName = name;
    }

    public ITextComponent getName()
    {
        return this.customName != null ? this.customName : this.getDefaultName();
    }

    private ITextComponent getDefaultName() {
        return new TranslationTextComponent("container." + SkyblockItemsPlusPlus.MOD_ID + ".electric_crafting_table");
    }

    @Override
    public ITextComponent getDisplayName() {
        return this.getName();
    }

    @Nullable
    public ITextComponent getCustomName() {
        return this.customName;
    }

    @Override
    public void load(BlockState state, CompoundNBT compoundNBT) {
        super.load(state, compoundNBT);
        if (compoundNBT.contains("CustomName", Constants.NBT.TAG_STRING))
        {
            this.customName = ITextComponent.Serializer.fromJson(compoundNBT.getString("CustomName"));
        }

        NonNullList<ItemStack> inv = NonNullList.withSize(this.inventory.getSlots(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compoundNBT, inv);
        this.inventory.setNonNullList(inv);

        this.currentSmeltTime = compoundNBT.getInt("CurrentSmeltTime");
    }

    @Override
    public CompoundNBT save(CompoundNBT compoundNBT) {
        super.save(compoundNBT);
        if (this.customName != null)
        {
            compoundNBT.putString("CustomName", ITextComponent.Serializer.toJson(this.customName));
        }

        ItemStackHelper.saveAllItems(compoundNBT, this.inventory.toNonNullList());

        compoundNBT.putInt("CurrentSmeltTime", this.currentSmeltTime);

        return compoundNBT;
    }

    @Nullable
    private CustomRecipe getRecipe(ItemStack input1, ItemStack input2, ItemStack input3,
                                   ItemStack input4, ItemStack input5, ItemStack input6,
                                   ItemStack input7, ItemStack input8, ItemStack input9)
    {
        if (input1 == null) { return null; }
        if (input2 == null) { return null; }
        if (input3 == null) { return null; }
        if (input4 == null) { return null; }
        if (input5 == null) { return null; }
        if (input6 == null) { return null; }
        if (input7 == null) { return null; }
        if (input8 == null) { return null; }
        if (input9 == null) { return null; }

        Set<IRecipe<?>> recipes = findRecipesByType(RecipeSerializerInit.CUSTOM_TYPE, this.level);
        for(IRecipe<?> iRecipe : recipes)
        {
            CustomRecipe recipe = (CustomRecipe) iRecipe;
            if (recipe.matches(new RecipeWrapper(this.inventory), this.level))
            {
                return recipe;
            }
        }
        return null;
    }

    private static Set<IRecipe<?>> findRecipesByType(IRecipeType<?> customType, World level) {
        return level != null ? level.getRecipeManager().getRecipes().stream()
                .filter(recipe -> recipe.getType() == customType).collect(Collectors.toSet()) : Collections.emptySet();
    }

    @OnlyIn(Dist.CLIENT)
    private static Set<IRecipe<?>> findRecipesByType(IRecipeType<?> customType) {
        ClientWorld level = Minecraft.getInstance().level;
        return level != null ? level.getRecipeManager().getRecipes().stream()
                .filter(recipe -> recipe.getType() == customType).collect(Collectors.toSet()) : Collections.emptySet();
    }

    public static Set<ItemStack> getAllRecipeInputs(IRecipeType<?> typeIn, World level)
    {
        Set<ItemStack> inputs = new HashSet<ItemStack>();
        Set<IRecipe<?>> recipes = findRecipesByType(typeIn, level);

        for (IRecipe<?> recipe : recipes)
        {
            NonNullList<Ingredient> ingredients = recipe.getIngredients();
            ingredients.forEach(ingredient -> {
                for (ItemStack stack : ingredient.getItems())
                {
                    inputs.add(stack);
                }
            });
        }
        return inputs;
    }

    public final IItemHandlerModifiable getInventory()
    {
        return this.inventory;
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT nbt = new CompoundNBT();
        this.save(nbt);
        return new SUpdateTileEntityPacket(this.worldPosition, 0, nbt);
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        this.load(this.getBlockState(), pkt.getTag());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT nbt = new CompoundNBT();
        this.save(nbt);
        return nbt;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.orEmpty(cap, LazyOptional.of(() -> this.inventory));
    }
}
