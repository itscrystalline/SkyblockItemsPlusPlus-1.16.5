package com.iwant2tryhard.skyblockitemsplusplus.client.render.entity.render;

import com.iwant2tryhard.skyblockitemsplusplus.SkyblockItemsPlusPlus;
import com.iwant2tryhard.skyblockitemsplusplus.client.render.entity.model.ZealotEntityModel;
import com.iwant2tryhard.skyblockitemsplusplus.common.entities.ZealotEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ZealotEntityRender extends MobRenderer<ZealotEntity, ZealotEntityModel<ZealotEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(SkyblockItemsPlusPlus.MOD_ID, "textures/entities/zealot_entity.png");

    public ZealotEntityRender(EntityRendererManager rendererManager)
    {
        super(rendererManager, new ZealotEntityModel<ZealotEntity>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ZealotEntity zealotEntity) {
        return TEXTURE;
    }
}
