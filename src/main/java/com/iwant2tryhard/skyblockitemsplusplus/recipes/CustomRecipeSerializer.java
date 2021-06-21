package com.iwant2tryhard.skyblockitemsplusplus.recipes;

import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;

public class CustomRecipeSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<CustomRecipe> {
    @Override
    public CustomRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
        ItemStack output = CraftingHelper.getItemStack(JSONUtils.getAsJsonObject(json, "output"), true);
        Ingredient input1 = Ingredient.fromJson(JSONUtils.getAsJsonObject(json, "input1"));
        Ingredient input2 = Ingredient.fromJson(JSONUtils.getAsJsonObject(json, "input2"));
        Ingredient input3 = Ingredient.fromJson(JSONUtils.getAsJsonObject(json, "input3"));
        Ingredient input4 = Ingredient.fromJson(JSONUtils.getAsJsonObject(json, "input4"));
        Ingredient input5 = Ingredient.fromJson(JSONUtils.getAsJsonObject(json, "input5"));
        Ingredient input6 = Ingredient.fromJson(JSONUtils.getAsJsonObject(json, "input6"));
        Ingredient input7 = Ingredient.fromJson(JSONUtils.getAsJsonObject(json, "input7"));
        Ingredient input8 = Ingredient.fromJson(JSONUtils.getAsJsonObject(json, "input8"));
        Ingredient input9 = Ingredient.fromJson(JSONUtils.getAsJsonObject(json, "input9"));

        return new CustomRecipe(recipeId, input1, input2, input3,
                                          input4, input5, input6,
                                          input7, input8, input9, output);
    }

    @Nullable
    @Override
    public CustomRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
        ItemStack output = buffer.readItem();
        Ingredient input1 = Ingredient.fromNetwork(buffer);
        Ingredient input2 = Ingredient.fromNetwork(buffer);
        Ingredient input3 = Ingredient.fromNetwork(buffer);
        Ingredient input4 = Ingredient.fromNetwork(buffer);
        Ingredient input5 = Ingredient.fromNetwork(buffer);
        Ingredient input6 = Ingredient.fromNetwork(buffer);
        Ingredient input7 = Ingredient.fromNetwork(buffer);
        Ingredient input8 = Ingredient.fromNetwork(buffer);
        Ingredient input9 = Ingredient.fromNetwork(buffer);

        return new CustomRecipe(recipeId, input1, input2, input3,
                                          input4, input5, input6,
                                          input7, input8, input9, output);
    }

    @Override
    public void toNetwork(PacketBuffer buffer, CustomRecipe recipe) {
        Ingredient input1 = recipe.getIngredients().get(0);
        Ingredient input2 = recipe.getIngredients().get(1);
        Ingredient input3 = recipe.getIngredients().get(2);
        Ingredient input4 = recipe.getIngredients().get(3);
        Ingredient input5 = recipe.getIngredients().get(4);
        Ingredient input6 = recipe.getIngredients().get(5);
        Ingredient input7 = recipe.getIngredients().get(6);
        Ingredient input8 = recipe.getIngredients().get(7);
        Ingredient input9 = recipe.getIngredients().get(8);
        input1.toNetwork(buffer);
        input2.toNetwork(buffer);
        input3.toNetwork(buffer);
        input4.toNetwork(buffer);
        input5.toNetwork(buffer);
        input6.toNetwork(buffer);
        input7.toNetwork(buffer);
        input8.toNetwork(buffer);
        input9.toNetwork(buffer);

        buffer.writeItemStack(recipe.getResultItem(), false);
    }
}
