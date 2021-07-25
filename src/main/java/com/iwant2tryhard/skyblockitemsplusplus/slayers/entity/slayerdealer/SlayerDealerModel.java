package com.iwant2tryhard.skyblockitemsplusplus.slayers.entity.slayerdealer;// Made with Blockbench 3.9.0
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SlayerDealerModel <T extends SlayerDealerEntity> extends EntityModel<T> {
	private final ModelRenderer Body;
	private final ModelRenderer head;
	private final ModelRenderer arms;
	private final ModelRenderer armsleft;
	private final ModelRenderer armsright;
	private final ModelRenderer legs;
	private final ModelRenderer legsleft;
	private final ModelRenderer legsright;

	public SlayerDealerModel() {
		texWidth = 64;
		texHeight = 64;

		Body = new ModelRenderer(this);
		Body.setPos(0.0F, 24.0F, 0.0F);
		Body.texOffs(0, 16).addBox(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setPos(0.0F, -25.0F, 0.0F);
		Body.addChild(head);
		head.texOffs(0, 0).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		arms = new ModelRenderer(this);
		arms.setPos(0.0F, -23.0F, 0.0F);
		Body.addChild(arms);
		

		armsleft = new ModelRenderer(this);
		armsleft.setPos(-6.0F, 0.0F, 0.0F);
		arms.addChild(armsleft);
		armsleft.texOffs(24, 16).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		armsright = new ModelRenderer(this);
		armsright.setPos(6.0F, 0.0F, 0.0F);
		arms.addChild(armsright);
		armsright.texOffs(0, 32).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		legs = new ModelRenderer(this);
		legs.setPos(0.0F, -11.0F, 0.0F);
		Body.addChild(legs);
		

		legsleft = new ModelRenderer(this);
		legsleft.setPos(-2.0F, 0.0F, 0.0F);
		legs.addChild(legsleft);
		legsleft.texOffs(16, 32).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		legsright = new ModelRenderer(this);
		legsright.setPos(2.0F, 0.0F, 0.0F);
		legs.addChild(legsright);
		legsright.texOffs(32, 0).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
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
}