package com.iwant2tryhard.skyblockitemsplusplus.client.render.entity.render;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.DragonCrystalEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.EnderDragonRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.item.EnderCrystalEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;

public class DragonCrystalRenderer extends EntityRenderer<DragonCrystalEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SkyblockItemsPlusPlus.MOD_ID, "textures/entities/dragon_crystal_entity.png");
    private static final RenderType RENDER_TYPE;
    private static final float SIN_45;
    private final ModelRenderer cube;
    private final ModelRenderer glass;
    private final ModelRenderer base;

    public DragonCrystalRenderer(EntityRendererManager p_i46184_1_) {
        super(p_i46184_1_);
        this.shadowRadius = 0.5F;
        this.glass = new ModelRenderer(64, 32, 0, 0);
        this.glass.addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F);
        this.cube = new ModelRenderer(64, 32, 32, 0);
        this.cube.addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F);
        this.base = new ModelRenderer(64, 32, 0, 16);
        this.base.addBox(-6.0F, 0.0F, -6.0F, 12.0F, 4.0F, 12.0F);
    }

    public void render(DragonCrystalEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
        p_225623_4_.pushPose();
        float lvt_7_1_ = getY(p_225623_1_, p_225623_3_);
        float lvt_8_1_ = ((float)p_225623_1_.time + p_225623_3_) * 3.0F;
        IVertexBuilder lvt_9_1_ = p_225623_5_.getBuffer(RENDER_TYPE);
        p_225623_4_.pushPose();
        p_225623_4_.scale(2.0F, 2.0F, 2.0F);
        p_225623_4_.translate(0.0D, -0.5D, 0.0D);
        int lvt_10_1_ = OverlayTexture.NO_OVERLAY;
        if (p_225623_1_.showsBottom()) {
            this.base.render(p_225623_4_, lvt_9_1_, p_225623_6_, lvt_10_1_);
        }

        p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(lvt_8_1_));
        p_225623_4_.translate(0.0D, (double)(1.5F + lvt_7_1_ / 2.0F), 0.0D);
        p_225623_4_.mulPose(new Quaternion(new Vector3f(SIN_45, 0.0F, SIN_45), 60.0F, true));
        this.glass.render(p_225623_4_, lvt_9_1_, p_225623_6_, lvt_10_1_);
        float lvt_11_1_ = 0.875F;
        p_225623_4_.scale(0.875F, 0.875F, 0.875F);
        p_225623_4_.mulPose(new Quaternion(new Vector3f(SIN_45, 0.0F, SIN_45), 60.0F, true));
        p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(lvt_8_1_));
        this.glass.render(p_225623_4_, lvt_9_1_, p_225623_6_, lvt_10_1_);
        p_225623_4_.scale(0.875F, 0.875F, 0.875F);
        p_225623_4_.mulPose(new Quaternion(new Vector3f(SIN_45, 0.0F, SIN_45), 60.0F, true));
        p_225623_4_.mulPose(Vector3f.YP.rotationDegrees(lvt_8_1_));
        this.cube.render(p_225623_4_, lvt_9_1_, p_225623_6_, lvt_10_1_);
        p_225623_4_.popPose();
        p_225623_4_.popPose();
        BlockPos lvt_12_1_ = p_225623_1_.getBeamTarget();
        if (lvt_12_1_ != null) {
            float lvt_13_1_ = (float)lvt_12_1_.getX() + 0.5F;
            float lvt_14_1_ = (float)lvt_12_1_.getY() + 0.5F;
            float lvt_15_1_ = (float)lvt_12_1_.getZ() + 0.5F;
            float lvt_16_1_ = (float)((double)lvt_13_1_ - p_225623_1_.getX());
            float lvt_17_1_ = (float)((double)lvt_14_1_ - p_225623_1_.getY());
            float lvt_18_1_ = (float)((double)lvt_15_1_ - p_225623_1_.getZ());
            p_225623_4_.translate((double)lvt_16_1_, (double)lvt_17_1_, (double)lvt_18_1_);
            EnderDragonRenderer.renderCrystalBeams(-lvt_16_1_, -lvt_17_1_ + lvt_7_1_, -lvt_18_1_, p_225623_3_, p_225623_1_.time, p_225623_4_, p_225623_5_, p_225623_6_);
        }

        super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
    }

    @Override
    public ResourceLocation getTextureLocation(DragonCrystalEntity dragonCrystalEntity) {
        return TEXTURE;
    }

    public static float getY(DragonCrystalEntity p_229051_0_, float p_229051_1_) {
        float lvt_2_1_ = (float)p_229051_0_.time + p_229051_1_;
        float lvt_3_1_ = MathHelper.sin(lvt_2_1_ * 0.2F) / 2.0F + 0.5F;
        lvt_3_1_ = (lvt_3_1_ * lvt_3_1_ + lvt_3_1_) * 0.4F;
        return lvt_3_1_ - 1.4F;
    }

    public boolean shouldRender(DragonCrystalEntity p_225626_1_, ClippingHelper p_225626_2_, double p_225626_3_, double p_225626_5_, double p_225626_7_) {
        return super.shouldRender(p_225626_1_, p_225626_2_, p_225626_3_, p_225626_5_, p_225626_7_) || p_225626_1_.getBeamTarget() != null;
    }

    static {
        RENDER_TYPE = RenderType.entityCutoutNoCull(TEXTURE);
        SIN_45 = (float)Math.sin(0.7853981633974483D);
    }
}
