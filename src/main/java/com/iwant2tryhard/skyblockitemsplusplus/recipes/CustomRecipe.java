package com.iwant2tryhard.skyblockitemsplusplus.recipes;

import com.iwant2tryhard.skyblockitemsplusplus.core.init.RecipeSerializerInit;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nonnull;

public class CustomRecipe implements ICustomRecipe{

    private final ResourceLocation id;

    private final Ingredient input1; private final Ingredient input2; private final Ingredient input3;
    private final Ingredient input4; private final Ingredient input5; private final Ingredient input6;
    private final Ingredient input7; private final Ingredient input8; private final Ingredient input9;

    private final ItemStack output;

    CustomRecipe(ResourceLocation id, Ingredient input1, Ingredient input2, Ingredient input3,
                                      Ingredient input4, Ingredient input5, Ingredient input6,
                                      Ingredient input7, Ingredient input8, Ingredient input9,    ItemStack output)
    {
        this.id = id;

        this.input1 = input1; this.input2 = input2; this.input3 = input3;
        this.input4 = input4; this.input5 = input5; this.input6 = input6;
        this.input7 = input7; this.input8 = input8; this.input9 = input9;

        this.output = output;
    }

    @Nonnull
    @Override
    public IRecipeType<?> getType() {
        return ICustomRecipe.super.getType();
    }

    @Override
    public boolean matches(RecipeWrapper inv, World worldIn) {
        return (this.input1.test(inv.getItem(0))) & (this.input1.test(inv.getItem(1))) & (this.input1.test(inv.getItem(2))) &
                (this.input4.test(inv.getItem(3))) & (this.input1.test(inv.getItem(4))) & (this.input1.test(inv.getItem(5))) &
                (this.input7.test(inv.getItem(6))) & (this.input1.test(inv.getItem(7))) & (this.input1.test(inv.getItem(8)));
    }

    @Override
    public ItemStack assemble(RecipeWrapper inv) {
        return this.output;
    }

    @Override
    public ItemStack getResultItem() {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return RecipeSerializerInit.CUSTOM_SERIALIZER.get();
    }

    @Override
    public Ingredient[] getInput() {
        return new Ingredient[]{
                input1, input2, input3,
                input4, input5, input6,
                input7, input8, input9
        };
    }
}
