package wolforce.hearthwell.mod.client.registries;

import net.minecraftforge.client.event.EntityRenderersEvent.RegisterLayerDefinitions;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import wolforce.hearthwell.mod.client.entity.models.GolemEntityModel;
import wolforce.hearthwell.mod.client.entity.models.HearthwellEntityModel;
import wolforce.hearthwell.mod.client.entity.render.GolemEntityRenderer;
import wolforce.hearthwell.mod.client.entity.render.HearthwellEntityRenderer;
import wolforce.hearthwell.mod.registries.ModEntities;

public class ModEntityRenderers {
	
//	private static final EntityRendererProvider<Entity> a = c -> new HearthwellEntityRenderer(c);
//	public final RegisterEntityRendererPoint<Entity> hearthwell = start().renderer(a).<HearthwellEntity>type(ModEntities.entity_hearthwell.get());
	
	public static void registerEntityRenders(RegisterRenderers ev) {
		ev.registerEntityRenderer(ModEntities.golem.get(), GolemEntityRenderer::new);
		ev.registerEntityRenderer(ModEntities.hearthwell.get(), HearthwellEntityRenderer::new);
		
	}
	
	public static void registerLayerDefinitions(RegisterLayerDefinitions ev) {
		ev.registerLayerDefinition(GolemEntityModel.LAYER_LOCATION, GolemEntityModel::createBodyLayer);
		ev.registerLayerDefinition(HearthwellEntityModel.LAYER_LOCATION, HearthwellEntityModel::createBodyLayer);
	}
}
