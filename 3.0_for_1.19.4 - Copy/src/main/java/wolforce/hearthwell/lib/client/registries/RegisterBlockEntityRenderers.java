package wolforce.hearthwell.lib.client.registries;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterBlockEntityRenderers {
	
	@SubscribeEvent
	public static void registerBlockEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		
//		event.registerBlockEntityRenderer(TileEntities.burst_seed.get(), BlockEntityBurstSeed::new);
//		event.registerBlockEntityRenderer(TileEntities.spire_device.get(), BERSpireDeviceMutator::new);
	}
	
}
