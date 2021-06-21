package com.iwant2tryhard.skyblockitemsplusplus.client.gui;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.common.containers.ElectricCraftingTableContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ElectricCraftingTableScreen extends ContainerScreen<ElectricCraftingTableContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SkyblockItemsPlusPlus.MOD_ID,
            "textures/guis/electric_crafting_table.png");
    private final ElectricCraftingTableContainer container;

    public ElectricCraftingTableScreen(ElectricCraftingTableContainer container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);

        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 176;
        this.imageHeight = 166;
        this.container = container;
    }

    @Override
    protected void renderBg(MatrixStack stack, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.textureManager.bind(TEXTURE);
        this.blit(stack, this.leftPos, this.topPos, 0, 0, imageWidth, imageHeight, 256, 256);

        this.blit(stack, this.leftPos + 89, this.topPos + 35, 176, 0, this.container.getSmeltProgressionScaled(), 16);
    }



    @Override
    public void render(MatrixStack stack, int mouseX, int mouseY, float partialTicks) {
        super.render(stack, mouseX, mouseY, partialTicks);
        this.font.draw(stack, this.title.getString(), 7f, 7f, 4210752);
        this.font.draw(stack, this.inventory.getDisplayName().getString(), 7f, 73f, 4210752);
        this.renderTooltip(stack, mouseX, mouseY);
    }
}
