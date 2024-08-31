package wolforce.hearthwell.lib.events;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import wolforce.hearthwell.lib.registries.RegisterEntities;
import wolforce.hearthwell.lib.registries.RegisterEntities.RegisterEntityPoint;
import wolforce.hearthwell.lib.registries.RegisterEntities.RegisterLivingEntityPoint;
import wolforce.hearthwell.mod.Hearthwell;

@Mod.EventBusSubscriber(modid = Hearthwell.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityEvents {
	
	@SubscribeEvent
	public static void entityAttributes(EntityAttributeCreationEvent ev) {
		
		for (RegisterEntityPoint<? extends Entity> ent : RegisterEntities.getAll()) {
			if (ent instanceof RegisterLivingEntityPoint<?> livEnt)
				ev.put(livEnt.get(), livEnt.getAttributes());
		}
	}
}
