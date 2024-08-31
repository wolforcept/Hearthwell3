package wolforce.hearthwell.mod.client.entity.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import wolforce.hearthwell.mod.entities.GolemEntity;

// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class GolemEntityModel extends EntityModel<GolemEntity> {
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ModResources.golem.modelLayer(), "main");
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("hearthwell", "modelgolem"), "main");
	
	private final ModelPart bb_main;
	
	public GolemEntityModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}
	
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		
//		PartDefinition bb_main = 
		partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 18).addBox(1.0F, -3.0F, -0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(10, 18).addBox(-3.0F, -3.0F, -0.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(8, 9).addBox(-5.0F, -7.75F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(20, 0).addBox(-2.0F, -12.0F, -2.25F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 18).addBox(-2.0F, -12.0F, -3.25F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-3.0F, -8.0F, -2.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 9).addBox(3.0F, -7.75F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
		
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	
	@Override
	public void setupAnim(GolemEntity p_102618_, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		
	}
	
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}

//import com.mojang.blaze3d.platform.GlStateManager;
//
//import net.minecraft.Util;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.model.HierarchicalModel;
//import net.minecraft.client.model.geom.ModelPart;
//import net.minecraft.client.model.geom.builders.MeshDefinition;
//import net.minecraft.client.model.geom.builders.PartDefinition;
//import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
//import net.minecraft.client.renderer.entity.ItemRenderer;
//import net.minecraft.world.entity.Entity;
//import net.minecraft.world.item.ItemStack;
//import wolforce.hearthwell.mod.entities.GolemEntity;
//
//public class GolemEntityModel extends HierarchicalModel<GolemEntity> {
//	
//	private final PartDefinition bb_main;
//	private final PartDefinition head, testa, leftArm, rightArm, body, leftLeg, rightLeg;
//	
//	public GolemEntityModel() {
//		textureWidth = 64;
//		textureHeight = 64;
//		
//		MeshDefinition _bb_main = new MeshDefinition();
//		PartDefinition bb_main = meshdefinition.getRoot();
//		bb_main.setRotationPoint(0.0f, 24.0f, 0.0f);
//		
//		head = new ModelRenderer(this, "head");
//		head.rotationPointY = -10f;
//		head.rotationPointZ = -.75f;
//		head.cubeList.add(new ModelBox(head, 20, 0, -2.0f, -2.0f, -2.25f, 4, 4, 4, 0.0f, false));
//		bb_main.addChild(head);
//		testa = new ModelRenderer(this, "testa");
//		testa.cubeList.add(new ModelBox(testa, 0, 18, -2.0f, -2.0f, -3.25f, 4, 2, 1, 0.0f, false));
//		head.addChild(testa);
//		
//		body = new ModelRenderer(this, "body");
//		body.cubeList.add(new ModelBox(body, 0, 0, -3.0f, -8.0f, -2.0f, 6, 5, 4, 0.0f, false));
//		bb_main.addChild(body);
//		
//		leftArm = new ModelRenderer(this, "part3");
//		rightArm = new ModelRenderer(this, "part4");
//		leftArm.cubeList.add(new ModelBox(leftArm, 0, 9, 3.0f, -7.75f, -1.0f, 2, 7, 2, 0.0f, false));
//		rightArm.cubeList.add(new ModelBox(rightArm, 8, 9, -5.0f, -7.75f, -1.0f, 2, 7, 2, 0.0f, false));
//		leftArm.rotationPointY = -7.8f;
//		rightArm.rotationPointY = -7.8f;
//		bb_main.addChild(leftArm);
//		bb_main.addChild(rightArm);
//		
//		leftLeg = new ModelRenderer(this, "leftLeg");
//		rightLeg = new ModelRenderer(this, "part7");
//		leftLeg.rotationPointY = -3f;
//		rightLeg.rotationPointY = -3f;
//		leftLeg.cubeList.add(new ModelBox(leftLeg, 18, 18, 1.0f, -3.0f, -0.5f, 2, 3, 2, 0.0f, false));
//		bb_main.addChild(leftLeg);
//		rightLeg.cubeList.add(new ModelBox(rightLeg, 10, 18, -3.0f, -3.0f, -0.5f, 2, 3, 2, 0.0f, false));
//		bb_main.addChild(rightLeg);
//	}
//	
//	@Override
//	public void render(GolemEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
//		bb_main.render(f5);
//		ItemRenderer renderItem = Minecraft.getInstance().getItemRenderer();
//		
//		ItemStack target = entity.getTarget();
//		if (Util.isValid(target)) {
//			GlStateManager.pushMatrix();
//			GlStateManager.rotate(180, 1, 0, 0);
//			
//			GlStateManager.translate(0, -.6, 0);
//			GlStateManager.scale(.4, .4, .4);
//			float angle = 10 * (entity.ticksExisted % 360);
//			GlStateManager.rotate(angle, 0, 1, 0);
//			renderItem.renderItem(target, TransformType.FIXED);
//			GlStateManager.popMatrix();
//		}
//		
//		ItemStack stack = entity.getStack();
//		if (Util.isValid(stack)) {
//			GlStateManager.pushMatrix();
//			GlStateManager.translate(0, 1.2, -0.4);
//			GlStateManager.scale(0.8, 0.8, 0.8);
//			renderItem.renderItem(stack, TransformType.FIXED);
//			GlStateManager.popMatrix();
//		}
//	}
//	
//	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
//			float headPitch, float scaleFactor, Entity entityIn) {
//		head.rotateAngleY = netHeadYaw * 0.017453292F;
//		head.rotateAngleX = headPitch * 0.017453292F;
//	}
//	
//	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
//		modelRenderer.rotateAngleX = x;
//		modelRenderer.rotateAngleY = y;
//		modelRenderer.rotateAngleZ = z;
//	}
//	
//	@Override
//	public ModelPart root() {
//		return null;
//	}
//	
//	@Override
//	public void setupAnim(GolemEntity miner, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {
//		
////	public void setLivingAnimations(EntityLivingBase entity, float limbSwing, float limbSwingAmount,
////			float partialTickTime) {
//	
////		EntityMiner miner = (EntityMiner) entity;
//		
//		if (miner.isAsking()) {
//			rightArm.rotateAngleX = (float) (Math.PI * 5.0 / 2.0);
//		}
//		
//		ItemStack stack = miner.getStack();
//		
//		int mining = miner.getMining();
//		if (mining > 0) {
//			leftArm.rotateAngleX = (float) (Math.sin(mining) / 2.0 + 1.5);
//			rightArm.rotateAngleX = (float) (Math.cos(mining) / 2.0 + 1.5);
//		} else if (Util.isValid(stack)) {
//			leftArm.rotateAngleX = (float) (Math.PI * 0.7);
//			rightArm.rotateAngleX = (float) (Math.PI * 0.7);
//		} else {
//			leftArm.rotateAngleX = (float) (Math.PI
//					+ (-0.2 + 1.5 * this.triangleWave(limbSwing, 13.0)) * limbSwingAmount);
//			if (!miner.isAsking())
//				rightArm.rotateAngleX = (float) (Math.PI
//						+ (-0.2 - 1.5 * this.triangleWave(limbSwing, 13.0)) * limbSwingAmount);
//		}
//		rightLeg.rotateAngleX = (float) (Math.PI + (-0.2 + 1.5 * this.triangleWave(limbSwing, 13.0)) * limbSwingAmount);
//		leftLeg.rotateAngleX = (float) (Math.PI + (-0.2 - 1.5 * this.triangleWave(limbSwing, 13.0)) * limbSwingAmount);
//		
//	}
//	
//	private double triangleWave(double base, double mult) {
//		return (Math.abs(base % mult - mult * 0.5f) - mult * 0.25f) / (mult * 0.25f);
//	}
//	

//	private final ModelPart root;
//	private final ModelPart head;
//	private final ModelPart rightArm;
//	private final ModelPart leftArm;
//	private final ModelPart rightLeg;
//	private final ModelPart leftLeg;
//	
//	public GolemEntityModel(ModelPart p_170697_) {
//		this.root = p_170697_;
//		this.head = p_170697_.getChild("head");
//		this.rightArm = p_170697_.getChild("right_arm");
//		this.leftArm = p_170697_.getChild("left_arm");
//		this.rightLeg = p_170697_.getChild("right_leg");
//		this.leftLeg = p_170697_.getChild("left_leg");
//	}
//	
//	public static LayerDefinition createBodyLayer() {
//		MeshDefinition meshdefinition = new MeshDefinition();
//		PartDefinition partdefinition = meshdefinition.getRoot();
//		partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -12.0F, -5.5F, 8.0F, 10.0F, 8.0F).texOffs(24, 0).addBox(-1.0F, -5.0F, -7.5F, 2.0F, 4.0F, 2.0F),
//				PartPose.offset(0.0F, -7.0F, -2.0F));
//		partdefinition.addOrReplaceChild("body",
//				CubeListBuilder.create().texOffs(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F).texOffs(0, 70).addBox(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.5F)),
//				PartPose.offset(0.0F, -7.0F, 0.0F));
//		partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(60, 21).addBox(-13.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F), PartPose.offset(0.0F, -7.0F, 0.0F));
//		partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(60, 58).addBox(9.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F), PartPose.offset(0.0F, -7.0F, 0.0F));
//		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F), PartPose.offset(-4.0F, 11.0F, 0.0F));
//		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(60, 0).mirror().addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F), PartPose.offset(5.0F, 11.0F, 0.0F));
//		return LayerDefinition.create(meshdefinition, 128, 128);
//	}
//	
//	public ModelPart root() {
//		return this.root;
//	}
//	
//	public void setupAnim(GolemEntity p_102962_, float p_102963_, float p_102964_, float p_102965_, float p_102966_, float p_102967_) {
//		this.head.yRot = p_102966_ * ((float) Math.PI / 180F);
//		this.head.xRot = p_102967_ * ((float) Math.PI / 180F);
//		this.rightLeg.xRot = -1.5F * Mth.triangleWave(p_102963_, 13.0F) * p_102964_;
//		this.leftLeg.xRot = 1.5F * Mth.triangleWave(p_102963_, 13.0F) * p_102964_;
//		this.rightLeg.yRot = 0.0F;
//		this.leftLeg.yRot = 0.0F;
//	}
//	
//	public void prepareMobModel(GolemEntity p_102957_, float p_102958_, float p_102959_, float p_102960_) {
////		int i = p_102957_.getAttackAnimationTick();
////		if (i > 0) {
//		this.rightArm.xRot = -2.0F + 1.5F * Mth.triangleWave(-p_102960_, 10.0F);
//		this.leftArm.xRot = -2.0F + 1.5F * Mth.triangleWave(-p_102960_, 10.0F);
////		} else {
////			int j = p_102957_.getOfferFlowerTick();
////			if (j > 0) {
////				this.rightArm.xRot = -0.8F + 0.025F * Mth.triangleWave((float) j, 70.0F);
////				this.leftArm.xRot = 0.0F;
////			} else {
////				this.rightArm.xRot = (-0.2F + 1.5F * Mth.triangleWave(p_102958_, 13.0F)) * p_102959_;
////				this.leftArm.xRot = (-0.2F - 1.5F * Mth.triangleWave(p_102958_, 13.0F)) * p_102959_;
////			}
////		}
//		
//	}

//}
