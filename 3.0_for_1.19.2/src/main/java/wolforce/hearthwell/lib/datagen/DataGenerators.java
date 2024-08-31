package wolforce.hearthwell.lib.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import wolforce.hearthwell.lib.datagen.models.GenBlockModelProvider;
import wolforce.hearthwell.lib.datagen.models.GenBlockstateModelProvider;
import wolforce.hearthwell.lib.datagen.models.GenItemModelProvider;
import wolforce.hearthwell.mod.Hearthwell;

@Mod.EventBusSubscriber(modid = Hearthwell.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
	
	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();
		
		
		generator.addProvider(true, new GenBlockTagsProvider(generator, Hearthwell.MODID, fileHelper));
		generator.addProvider(true, new GenRecipeProvider(generator));
		generator.addProvider(true, new GenLootTableProvider(generator));
		generator.addProvider(true, new GenBlockModelProvider(generator, fileHelper));
		generator.addProvider(true, new GenItemModelProvider(generator, fileHelper));
		generator.addProvider(true, new GenBlockstateModelProvider(generator, fileHelper));
	}
}
