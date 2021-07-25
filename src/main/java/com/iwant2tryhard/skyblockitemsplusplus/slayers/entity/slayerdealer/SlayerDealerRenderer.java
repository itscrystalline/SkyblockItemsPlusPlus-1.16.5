package com.iwant2tryhard.skyblockitemsplusplus.slayers.entity.slayerdealer;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.client.render.entity.model.ZealotEntityModel;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.ZealotEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3d;

public class SlayerDealerRenderer extends MobRenderer<SlayerDealerEntity, SlayerDealerModel<SlayerDealerEntity>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(SkyblockItemsPlusPlus.MOD_ID, "textures/entities/slayer_dealer_entity.png");

    public SlayerDealerRenderer(EntityRendererManager rendererManager) {
        super(rendererManager, new SlayerDealerModel<SlayerDealerEntity>(), 0.5f);
    }

    public void render(SlayerDealerEntity p_225623_1_, float p_225623_2_, float p_225623_3_, MatrixStack p_225623_4_, IRenderTypeBuffer p_225623_5_, int p_225623_6_) {
        super.render(p_225623_1_, p_225623_2_, p_225623_3_, p_225623_4_, p_225623_5_, p_225623_6_);
    }

    public Vector3d getRenderOffset(SlayerDealerEntity p_225627_1_, float p_225627_2_) {
        return super.getRenderOffset(p_225627_1_, p_225627_2_);
    }

    @Override
    public ResourceLocation getTextureLocation(SlayerDealerEntity slayerDealerEntity) {
        return TEXTURE;
    }
}
