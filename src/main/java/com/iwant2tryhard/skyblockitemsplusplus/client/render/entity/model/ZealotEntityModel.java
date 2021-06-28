package com.iwant2tryhard.skyblockitemsplusplus.client.render.entity.model;// Made with Blockbench 3.8.4
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.iwant2tryhard.skyblockitemsplusplus.common.entities.ZealotEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ZealotEntityModel<T extends ZealotEntity> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer Legs;
	private final ModelRenderer LegsLeft;
	private final ModelRenderer LegsRight;
	private final ModelRenderer Arms;
	private final ModelRenderer ArmsLeft;
	private final ModelRenderer ArmsRight;
	private final ModelRenderer Head;

	public ZealotEntityModel() {
		texWidth = 64;
		texHeight = 64;

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 24.0F, 0.0F);
		Body.texOffs(24, 16).addBox(-4.0F, -37.0F, -1.0F, 8.0F, 11.0F, 2.0F, 0.0F, false);

		Legs = new ModelRenderer(this);
		Legs.setPos(0.0F, -26.0F, 0.0F);
		Body.addChild(Legs);
		

		LegsLeft = new ModelRenderer(this);
		LegsLeft.setPos(-2.0F, 0.0F, 0.0F);
		Legs.addChild(LegsLeft);
		LegsLeft.texOffs(16, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);

		LegsRight = new ModelRenderer(this);
		LegsRight.setPos(2.0F, 0.0F, 0.0F);
		Legs.addChild(LegsRight);
		LegsRight.texOffs(16, 16).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 26.0F, 2.0F, 0.0F, false);

		Arms = new ModelRenderer(this);
		Arms.setPos(0.0F, -36.0F, 0.0F);
		Body.addChild(Arms);
		

		ArmsLeft = new ModelRenderer(this);
		ArmsLeft.setPos(-5.0F, 0.0F, 0.0F);
		Arms.addChild(ArmsLeft);
		ArmsLeft.texOffs(0, 16).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, false);

		ArmsRight = new ModelRenderer(this);
		ArmsRight.setPos(5.0F, 0.0F, 0.0F);
		Arms.addChild(ArmsRight);
		ArmsRight.texOffs(8, 16).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 30.0F, 2.0F, 0.0F, false);

		Head = new ModelRenderer(this);
		Head.setPos(0.0F, -37.0F, 0.0F);
		Body.addChild(Head);
		Head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T t, float v, float v1, float v2, float v3, float v4) {

	}

	@Override
	public void prepareMobModel(T p_212843_1_, float p_212843_2_, float p_212843_3_, float p_212843_4_) {
		super.prepareMobModel(p_212843_1_, p_212843_2_, p_212843_3_, p_212843_4_);
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public ModelRenderer getBody() {
		return Body;
	}

	public ModelRenderer getHead() {
		return Head;
	}

	public ModelRenderer getArms() {
		return Arms;
	}

	public ModelRenderer getArmsLeft() {
		return ArmsLeft;
	}

	public ModelRenderer getArmsRight() {
		return ArmsRight;
	}

	public ModelRenderer getLegs() {
		return Legs;
	}

	public ModelRenderer getLegsLeft() {
		return LegsLeft;
	}

	public ModelRenderer getLegsRight() {
		return LegsRight;
	}
}