package com.iwant2tryhard.skyblockitemsplusplus.core.init;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.recipes.CustomRecipe;
import com.iwant2tryhard.skyblockitemsplusplus.recipes.CustomRecipeSerializer;
import com.iwant2tryhard.skyblockitemsplusplus.recipes.ICustomRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RecipeSerializerInit {
    public static final IRecipeSerializer<CustomRecipe> CUSTOM_RECIPE_SERIALIZER = new CustomRecipeSerializer();
    public static final IRecipeType<ICustomRecipe> CUSTOM_TYPE = registerType(ICustomRecipe.RECIPE_TYPE_ID);

    public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, SkyblockItemsPlusPlus.MOD_ID);

    public static final RegistryObject<IRecipeSerializer<?>> CUSTOM_SERIALIZER = RECIPE_SERIALIZERS.register("custom",
            () -> CUSTOM_RECIPE_SERIALIZER);

    private static <T extends IRecipeType> T registerType(ResourceLocation recipeTypeId) {
        return (T) Registry.register(Registry.RECIPE_TYPE, recipeTypeId, new RegistryType<>());
    }

    private static class RegistryType<T extends IRecipe<?>> implements IRecipeType<T>
    {
        @Override
        public String toString() {
            return Registry.RECIPE_TYPE.getKey(this).toString();
        }
    }
}
