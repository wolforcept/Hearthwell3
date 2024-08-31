package wolforce.hearthwell.lib.client.registries;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import wolforce.hearthwell.mod.Hearthwell;
import wolforce.hearthwell.mod.client.registries.ModEntityRenderers;

@Mod.EventBusSubscriber(modid = Hearthwell.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterLayerDefinitions {
	
	@SubscribeEvent
	public static void entityRenderers(EntityRenderersEvent.RegisterLayerDefinitions ev) {
		ModEntityRenderers.registerLayerDefinitions(ev);
	}
	
}
