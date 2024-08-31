package wolforce.hearthwell.lib.client.registries;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import wolforce.hearthwell.mod.Hearthwell;
import wolforce.hearthwell.mod.client.registries.ModEntityRenderers;

@Mod.EventBusSubscriber(modid = Hearthwell.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterEntityRenderers {
	
	@SubscribeEvent
	public static void entityRenderers(EntityRenderersEvent.RegisterRenderers ev) {
		ModEntityRenderers.registerEntityRenders(ev);
	}
	
////@SubscribeEvent
////public static void registerBlockColors(ColorHandlerEvent.Block event) {
////	event.getBlockColors().register(HearthWell.spireColor, HearthWell.spire);
////}
//
//public static <T extends Entity> RegisterEntityRendererPoint<T> start() {
//	return new RegisterEntityRendererPoint<>();
//}
//
//public static class RegisterEntityRendererPoint<T extends Entity> {
//	EntityType<T> type;
//	EntityRendererProvider<T> renderer;
//	
//	public RegisterEntityRendererPoint<T> type(EntityType<T> type) {
//		this.type = type;
//		return this;
//	}
//	
//	public RegisterEntityRendererPoint<T> renderer(EntityRendererProvider<T> renderer) {
//		this.renderer = renderer;
//		return this;
//	}
//	
//	void register(EntityRenderersEvent.RegisterRenderers event) {
//		event.registerEntityRenderer(type, renderer);
//	}
//}
}
