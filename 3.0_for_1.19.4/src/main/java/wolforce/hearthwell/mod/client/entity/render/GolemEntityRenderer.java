package wolforce.hearthwell.mod.client.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import wolforce.hearthwell.mod.ModResources;
import wolforce.hearthwell.mod.client.entity.models.GolemEntityModel;
import wolforce.hearthwell.mod.entities.GolemEntity;

@OnlyIn(Dist.CLIENT)
public class GolemEntityRenderer extends MobRenderer<GolemEntity, GolemEntityModel> {
	
	public GolemEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new GolemEntityModel(context.bakeLayer(GolemEntityModel.LAYER_LOCATION)), 0.5f);
	}
	
	@Override
	public ResourceLocation getTextureLocation(GolemEntity entity) {
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
