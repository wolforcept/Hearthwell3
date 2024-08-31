package wolforce.hearthwell.mod.client.entity.render;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import wolforce.hearthwell.mod.ModResources;
import wolforce.hearthwell.mod.client.entity.models.HearthwellEntityModel;
import wolforce.hearthwell.mod.entities.HearthwellEntity;

@OnlyIn(Dist.CLIENT)
public class HearthwellEntityRenderer extends EntityRenderer<HearthwellEntity> {
	
	private HearthwellEntityModel model;
	
	public HearthwellEntityRenderer(EntityRendererProvider.Context context) {
		super(context);
		this.model = new HearthwellEntityModel(context.bakeLayer(HearthwellEntityModel.LAYER_LOCATION));
	}
	
//	@Override
//	public void render(HearthwellEntity entity, float p_114486_, float p_114487_, PoseStack pose, MultiBufferSource buffer, int p_114490_) {
//		super.render(entity, p_114486_, p_114487_, pose, buffer, p_114490_);
//		model.renderToBuffer(pose, null, p_114490_, p_114490_, p_114490_, p_114486_, p_114487_, p_114490_);
//	}
	
	@Override
	public void render(HearthwellEntity p_115308_, float p_115309_, float p_115310_, PoseStack p_115311_, MultiBufferSource p_115312_, int p_115313_) {
		p_115311_.pushPose();
//		this.model.attackTime = this.getAttackAnim(p_115308_, p_115310_);
		
		boolean shouldSit = p_115308_.isPassenger() && (p_115308_.getVehicle() != null && p_115308_.getVehicle().shouldRiderSit());
		this.model.riding = shouldSit;
//		float f = Mth.rotLerp(p_115310_, p_115308_.yBodyRotO, p_115308_.yBodyRot);
//		float f1 = Mth.rotLerp(p_115310_, p_115308_.yHeadRotO, p_115308_.yHeadRot);
		float f = Mth.rotLerp(p_115310_, 0, 0);
		float f1 = Mth.rotLerp(p_115310_, 0, 0);
		float f2 = f1 - f;
		if (shouldSit && p_115308_.getVehicle() instanceof LivingEntity) {
			LivingEntity livingentity = (LivingEntity) p_115308_.getVehicle();
			f = Mth.rotLerp(p_115310_, livingentity.yBodyRotO, livingentity.yBodyRot);
			f2 = f1 - f;
			float f3 = Mth.wrapDegrees(f2);
			if (f3 < -85.0F) {
				f3 = -85.0F;
			}
			
			if (f3 >= 85.0F) {
				f3 = 85.0F;
			}
			
			f = f1 - f3;
			if (f3 * f3 > 2500.0F) {
				f += f3 * 0.2F;
			}
			
			f2 = f1 - f;
		}
		
		float f6 = Mth.lerp(p_115310_, p_115308_.xRotO, p_115308_.getXRot());
		
		float f7 = 1;// this.getBob(p_115308_, p_115310_);
//		this.setupRotations(p_115308_, p_115311_, f7, f, p_115310_);
//		p_115311_.scale(-1.0F, -1.0F, 1.0F);
//		this.scale(p_115308_, p_115311_, p_115310_);
		p_115311_.translate(0.0D, (double) -1.501F, 0.0D);
		float f8 = 0.0F;
		float f5 = 0.0F;
		if (!shouldSit && p_115308_.isAlive()) {
//			f8 = Mth.lerp(p_115310_, p_115308_.animationSpeedOld, p_115308_.animationSpeed);
//			f5 = p_115308_.animationPosition - p_115308_.animationSpeed * (1.0F - p_115310_);
//			if (p_115308_.isBaby()) {
//				f5 *= 3.0F;
//			}
			
			if (f8 > 1.0F) {
				f8 = 1.0F;
			}
		}
		
		this.model.prepareMobModel(p_115308_, f5, f8, p_115310_);
		this.model.setupAnim(p_115308_, f5, f8, f7, f2, f6);
		Minecraft minecraft = Minecraft.getInstance();
		boolean flag = true;
		boolean flag1 = !flag && !p_115308_.isInvisibleTo(minecraft.player);
		boolean flag2 = minecraft.shouldEntityAppearGlowing(p_115308_);
		RenderType rendertype = this.getRenderType(p_115308_, flag, flag1, flag2);
		if (rendertype != null) {
			VertexConsumer vertexconsumer = p_115312_.getBuffer(rendertype);
//			int i = getOverlayCoords(p_115308_, this.getWhiteOverlayProgress(p_115308_, p_115310_));
			int i = 0;
			this.model.renderToBuffer(p_115311_, vertexconsumer, p_115313_, i, 1.0F, 1.0F, 1.0F, flag1 ? 0.15F : 1.0F);
		}
		
//		for (RenderLayer<T, M> renderlayer : this.layers) {
//			renderlayer.render(p_115311_, p_115312_, p_115313_, p_115308_, f5, f8, p_115310_, f7, f2, f6);
//		}
		
		p_115311_.popPose();
		super.render(p_115308_, p_115309_, p_115310_, p_115311_, p_115312_, p_115313_);
	}
	
	@Nullable
	protected RenderType getRenderType(HearthwellEntity entity, boolean p_115323_, boolean p_115324_, boolean p_115325_) {
		ResourceLocation resourcelocation = this.getTextureLocation(entity);
		if (p_115324_) {
			return RenderType.itemEntityTranslucentCull(resourcelocation);
		} else if (p_115323_) {
			return this.model.renderType(resourcelocation);
		} else {
			return p_115325_ ? RenderType.outline(resourcelocation) : null;
		}
	}
	
	@Override
	public ResourceLocation getTextureLocation(HearthwellEntity p_115812_) {
		return ModResources.golem.entityTexture();
	}
	
//   protected void setupRotations(IronGolem p_115014_, PoseStack p_115015_, float p_115016_, float p_115017_, float p_115018_) {
//      super.setupRotations(p_115014_, p_115015_, p_115016_, p_115017_, p_115018_);
//      if (!((double)p_115014_.animationSpeed < 0.01D)) {
//         float f = 13.0F;
//         float f1 = p_115014_.animationPosition - p_115014_.animationSpeed * (1.0F - p_115018_) + 6.0F;
//         float f2 = (Math.abs(f1 % 13.0F - 6.5F) - 3.25F) / 3.25F;
//         p_115015_.mulPose(Vector3f.ZP.rotationDegrees(6.5F * f2));
//      }
//   }
}
