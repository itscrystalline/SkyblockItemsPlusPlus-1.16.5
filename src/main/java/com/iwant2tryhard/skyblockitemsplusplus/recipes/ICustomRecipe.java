package com.iwant2tryhard.skyblockitemsplusplus.recipes;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nonnull;
import java.util.Objects;

public interface ICustomRecipe extends IRecipe<RecipeWrapper> {

    ResourceLocation RECIPE_TYPE_ID = new ResourceLocation(SkyblockItemsPlusPlus.MOD_ID, "custom");

    @Nonnull
    @Override
    default IRecipeType<?> getType()
    {
        return Objects.requireNonNull(Registry.RECIPE_TYPE.get(RECIPE_TYPE_ID));
    }

    @Override
    default boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_)
    {
        return false;
    }

    Ingredient[] getInput();
}
