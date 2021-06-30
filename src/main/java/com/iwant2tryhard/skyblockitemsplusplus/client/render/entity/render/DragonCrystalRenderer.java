package com.iwant2tryhard.skyblockitemsplusplus.client.render.entity.render;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.DragonCrystalEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;

import java.util.Random;

public class DragonCrystalRenderer extends EntityRenderer<DragonCrystalEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SkyblockItemsPlusPlus.MOD_ID, "textures/entities/dragon_crystal_entity.png");
    private static final Random random = new Random();

    public DragonCrystalRenderer(EntityRendererManager rendererManager) {
        super(rendererManager);

    }

    public void render(DragonCrystalEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
        super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
    }

    public static float getY(DragonCrystalEntity p_229051_0_, float p_229051_1_) {
        float lvt_2_1_ = (float)p_229051_0_.time + p_229051_1_;
        float lvt_3_1_ = MathHelper.sin(lvt_2_1_ * 0.2F) / 2.0F + 0.5F;
        lvt_3_1_ = (lvt_3_1_ * lvt_3_1_ + lvt_3_1_) * 0.4F;
        return lvt_3_1_ - 1.4F;
    }

    public ResourceLocation getTextureLocation(DragonCrystalEntity p_110775_1_) {
        return TEXTURE;
    }

    public Vector3d getRenderOffset(DragonCrystalEntity p_225627_1_, float p_225627_2_) {
            return super.getRenderOffset(p_225627_1_, p_225627_2_);
    }
}
