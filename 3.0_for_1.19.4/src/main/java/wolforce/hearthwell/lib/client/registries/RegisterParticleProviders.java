package wolforce.hearthwell.lib.client.registries;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterParticleProviders {
	
	@SubscribeEvent
	public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
//		ParticleEngine particleEngine = ClientProxy.MC.particleEngine;
//		particleEngine.register(ParticleEnergyData.TYPE, ParticleEnergy.Factory::new);
	}
}
