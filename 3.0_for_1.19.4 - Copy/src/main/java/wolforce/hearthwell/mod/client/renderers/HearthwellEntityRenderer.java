package wolforce.hearthwell.mod.client.renderers;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import wolforce.hearthwell.mod.ModResources;
import wolforce.hearthwell.mod.entities.HearthwellEntity;

public class HearthwellEntityRenderer extends EntityRenderer<HearthwellEntity> {
	
	public HearthwellEntityRenderer(Context c) {
		super(c);
	}
	
	@Override
	public ResourceLocation getTextureLocation(HearthwellEntity entity) {
		return ModResources.hearthwell.entityTexture();
	}
	
}
