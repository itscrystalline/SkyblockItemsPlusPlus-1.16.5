package com.iwant2tryhard.skyblockitemsplusplus.client.render.entity.model;

import com.iwant2tryhard.skyblockitemsplusplus.common.entities.DragonCrystalEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class DragonCrystalModel<T extends DragonCrystalEntity> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer CrystalOutline1;
	private final ModelRenderer cube_r1;
	private final ModelRenderer CrystalInline1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer CrystalOutline2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer CrystalInline2;
	private final ModelRenderer cube_r4;
	private final ModelRenderer bb_main;

	public DragonCrystalModel() {
		texWidth = 128;
		texHeight = 128;

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 24.0F, 0.0F);
		

		CrystalOutline1 = new ModelRenderer(this);
		CrystalOutline1.setPos(0.0F, 3.0F, 0.0F);
		

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.1194F, -2.1842F, 0.5071F);
		CrystalOutline1.addChild(cube_r1);
		setRotationAngle(cube_r1, -1.0821F, -0.4385F, -2.4625F);
		cube_r1.texOffs(0, 32).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);

		CrystalInline1 = new ModelRenderer(this);
		CrystalInline1.setPos(0.0F, 0.0F, 0.0F);
		CrystalOutline1.addChild(CrystalInline1);
		

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.1194F, -2.1842F, 0.5071F);
		CrystalInline1.addChild(cube_r2);
		setRotationAngle(cube_r2, -1.0821F, -0.4385F, -2.4625F);
		cube_r2.texOffs(50, 50).addBox(-7.0F, -7.0F, -7.0F, 14.0F, 14.0F, 14.0F, 0.0F, false);

		CrystalOutline2 = new ModelRenderer(this);
		CrystalOutline2.setPos(0.0597F, -1.5921F, 0.2536F);
		setRotationAngle(CrystalOutline2, 0.0F, -1.3526F, 0.0F);
		

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0597F, 0.4079F, 0.2536F);
		CrystalOutline2.addChild(cube_r3);
		setRotationAngle(cube_r3, -1.0821F, -0.4385F, -2.4625F);
		cube_r3.texOffs(0, 32).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, 0.0F, false);

		CrystalInline2 = new ModelRenderer(this);
		CrystalInline2.setPos(0.0597F, 0.4079F, 0.2536F);
		CrystalOutline2.addChild(CrystalInline2);
		

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(0.0F, 0.0F, 0.0F);
		CrystalInline2.addChild(cube_r4);
		setRotationAngle(cube_r4, -1.0821F, -0.4385F, -2.4625F);
		cube_r4.texOffs(50, 50).addBox(-7.0F, -7.0F, -7.0F, 14.0F, 14.0F, 14.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setPos(0.0F, 24.0F, 0.0F);
		bb_main.texOffs(0, 0).addBox(-12.0F, -8.0F, -12.0F, 24.0F, 8.0F, 24.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float v, float v1, float v2, float v3, float v4) {

	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		CrystalOutline1.render(matrixStack, buffer, packedLight, packedOverlay);
		CrystalOutline2.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public ModelRenderer getBody() {
		return Body;
	}

	public ModelRenderer getCrystalInline1() {
		return CrystalInline1;
	}

	public ModelRenderer getCrystalOutline1() {
		return CrystalOutline1;
	}

	public ModelRenderer getCrystalInline2() {
		return CrystalInline2;
	}

	public ModelRenderer getCrystalOutline2() {
		return CrystalOutline2;
	}
}