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
import wolforce.hearthwell.mod.ModResources;
import wolforce.hearthwell.mod.entities.HearthwellEntity;

//Made with Blockbench 4.2.4
//Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
//Paste this class into your mod and generate all required imports

public class HearthwellEntityModel extends EntityModel<HearthwellEntity> {
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ModResources.hearthwell.modelLayer(), "main");
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("hearthwell", "modelhearthwell"), "main");
	
	private final ModelPart center;
	private final ModelPart bone;
	private final ModelPart bone2;
	private final ModelPart bone3;
	
	public HearthwellEntityModel(ModelPart root) {
		this.center = root.getChild("center");
		this.bone = root.getChild("bone");
		this.bone2 = root.getChild("bone2");
		this.bone3 = root.getChild("bone3");
	}
	
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		
//		PartDefinition center = 
		partdefinition.addOrReplaceChild("center", CubeListBuilder.create().texOffs(7, 20).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		
		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		
//		PartDefinition cube1_r1 = 
		bone.addOrReplaceChild("cube1_r1", CubeListBuilder.create().texOffs(27, 43).addBox(-3.0F, -5.0F, -1.5F, 6.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 1.0472F, 3.1416F));
		
		PartDefinition bone2 = partdefinition.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		
//		PartDefinition cube2_r1 = 
		bone2.addOrReplaceChild("cube2_r1", CubeListBuilder.create().texOffs(18, 37).addBox(-3.0F, -5.0F, -1.5F, 6.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.0472F, 0.0F));
		
//		PartDefinition bone3 = 
		partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(9, 51).addBox(-3.0F, -5.0F, -1.5F, 6.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		
		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	
	@Override
	public void setupAnim(HearthwellEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		
	}
	
	@Override
	public void renderToBuffer(PoseStack pose, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		
		double time = (double) System.currentTimeMillis() / 50.0;
		double scale = .1;
		
		pose.pushPose();
		
		float dy = normalizeTime(time, 10, scale);
		pose.pushPose();
		pose.translate(0, dy, 0);
		center.render(pose, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		pose.popPose();
		
		dy = normalizeTime(time, 82, scale);
		pose.pushPose();
		pose.translate(0, dy, 0);
		bone.render(pose, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		pose.popPose();
		
		dy = normalizeTime(time, 43, scale);
		pose.pushPose();
		pose.translate(0, dy, 0);
		bone2.render(pose, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		pose.popPose();
		
		dy = normalizeTime(time, 31, scale);
		pose.pushPose();
		pose.translate(0, dy, 0);
		bone3.render(pose, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		pose.popPose();
		
		pose.popPose();
		
		// cube0.render(pose, buffer, packedLight, packedOverlay);
	}
	
	private float normalizeTime(double time, double phase, double multiplier) {
		return .6f + (float) (Math.cos(((time + phase) % 100) / 100 * 2 * Math.PI) * multiplier);
	}
}
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.blaze3d.vertex.VertexConsumer;
//
//import net.minecraft.client.model.EntityModel;
//import net.minecraft.client.model.geom.ModelLayerLocation;
//import net.minecraft.client.model.geom.ModelPart;
//import net.minecraft.client.model.geom.PartPose;
//import net.minecraft.client.model.geom.builders.CubeDeformation;
//import net.minecraft.client.model.geom.builders.CubeListBuilder;
//import net.minecraft.client.model.geom.builders.LayerDefinition;
//import net.minecraft.client.model.geom.builders.MeshDefinition;
//import net.minecraft.client.model.geom.builders.PartDefinition;
//import net.minecraft.client.renderer.RenderType;
//import wolforce.hearthwell.mod.ModResources;
//import wolforce.hearthwell.mod.entities.HearthwellEntity;
//
//public class ModelHearthWell extends EntityModel<HearthwellEntity> {
//	
//	public static final ModelLayerLocation LAYER_LOCATION = //
//			new ModelLayerLocation(ModResources.hearthwell.modelLayer(), "main");
//	
//	private ModelPart cube0, cube1, cube2, cube3;
//	
//	public ModelHearthWell(ModelPart root) {
//		super(a -> RenderType.entityTranslucent(ModResources.hearthwell.texture()));
////		super(ModelHearthWell::getHearthWellRenderType);
//		ModelPart group = root.getChild("group");
//		this.cube0 = group.getChild("cube0");
//		this.cube1 = group.getChild("cube1");
//		this.cube2 = group.getChild("cube1");
//		this.cube3 = group.getChild("cube3");
//	}
//	
//	public static LayerDefinition createBodyLayer() {
//		MeshDefinition meshdefinition = new MeshDefinition();
//		PartDefinition partdefinition = meshdefinition.getRoot();
//		
//		PartDefinition group = partdefinition.addOrReplaceChild("group",
//				CubeListBuilder.create().addBox(0, 0, 0, 0, 0, 0, new CubeDeformation(0)), PartPose.offset(0, 24, 0));
//		
//		group.addOrReplaceChild("cube0", CubeListBuilder.create().texOffs(9, 51)//
//				.addBox(-1, -7, -1, 2, 14, 2, new CubeDeformation(0)), PartPose.offsetAndRotation(0, 0, 0, 0, 0, 0));
//		
//		group.addOrReplaceChild("cube1", CubeListBuilder.create().texOffs(7, 20)//
//				.addBox(-3, -5, -1.5F, 6, 10, 3, new CubeDeformation(0)), PartPose.offsetAndRotation(0, 0, 0, -3.1416F, 1.0472F, 3.1416F));
//		
//		group.addOrReplaceChild("cube2", CubeListBuilder.create().texOffs(18, 37)//
//				.addBox(-3, -5, -1.5F, 6, 10, 3, new CubeDeformation(0)), PartPose.offsetAndRotation(0, 0, 0, 0, 1.0472F, 0));
//		
//		group.addOrReplaceChild("cube3", CubeListBuilder.create().texOffs(27, 43)//
//				.addBox(-3, -5, -1.5F, 6, 10, 3, new CubeDeformation(0)), PartPose.offsetAndRotation(0, 0, 0, 0, 0, 0));
//		
//		return LayerDefinition.create(meshdefinition, 64, 64);
//	}
//	
//	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
//		modelRenderer.xRot = x;
//		modelRenderer.yRot = y;
//		modelRenderer.zRot = z;
//	}
//	
////	public static RenderType getHearthWellRenderType(ResourceLocation locationIn) {
////		RenderType.CompositeState rendertype$compositestate = RenderType.CompositeState.builder()
////				.setShaderState(MyRenderStateShard.RENDERTYPE_ENTITY_TRANSLUCENT_SHADER)
////				.setTextureState(new RenderStateShard.TextureStateShard(locationIn, false, false))
////				.setTransparencyState(MyRenderStateShard.TRANSLUCENT_TRANSPARENCY).setCullState(MyRenderStateShard.NO_CULL)
////				.setLightmapState(MyRenderStateShard.LIGHTMAP).setOverlayState(MyRenderStateShard.OVERLAY).createCompositeState(true);
////		return RenderType.create("entity_translucent", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.QUADS, 256, true, true,
////				rendertype$compositestate);
//////		return RenderType.create("entity_cutout_no_cull", DefaultVertexFormat.NEW_ENTITY, VertexFormat.Mode.TRIANGLES, 256, true,
//////				RenderType.CompositeState.entityTranslucent(locationIn));
////	}
//	
//	private float normalizeTime(double time, double phase, double multiplier) {
//		return .6f + (float) (Math.cos(((time + phase) % 100) / 100 * 2 * Math.PI) * multiplier);
//	}
//	
//	@Override
//	public void renderToBuffer(PoseStack pose, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green,
//			float blue, float alpha) {
//		double time = (double) System.currentTimeMillis() / 50.0;
//		double scale = .1;
//		
//		pose.pushPose();
//		
//		float dy = normalizeTime(time, 10, scale);
//		pose.pushPose();
//		pose.translate(0, dy, 0);
//		cube0.render(pose, buffer, packedLight, packedOverlay);
//		pose.popPose();
//		
//		dy = normalizeTime(time, 82, scale);
//		pose.pushPose();
//		pose.translate(0, dy, 0);
//		cube1.render(pose, buffer, packedLight, packedOverlay);
//		pose.popPose();
//		
//		dy = normalizeTime(time, 43, scale);
//		pose.pushPose();
//		pose.translate(0, dy, 0);
//		cube2.render(pose, buffer, packedLight, packedOverlay);
//		pose.popPose();
//		
//		dy = normalizeTime(time, 31, scale);
//		pose.pushPose();
//		pose.translate(0, dy, 0);
//		cube3.render(pose, buffer, packedLight, packedOverlay);
//		pose.popPose();
//		
//		pose.popPose();
//		
//		// cube0.render(pose, buffer, packedLight, packedOverlay);
//		
//	}
//	
//	@Override
//	public void setupAnim(HearthwellEntity p_102618_, float p_102619_, float p_102620_, float p_102621_, float p_102622_, float p_102623_) {
//	}
//	
//}
