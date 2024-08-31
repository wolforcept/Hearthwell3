package wolforce.hearthwell.lib.datagen.models;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import wolforce.hearthwell.lib.registries.RegisterBlocks;
import wolforce.hearthwell.lib.registries.RegisterBlocks.RegisterBlockPoint;
import wolforce.hearthwell.mod.Hearthwell;
import wolforce.hearthwell.mod.ModResources;

public class GenBlockModelProvider extends BlockModelProvider {
	
	public GenBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Hearthwell.MODID, existingFileHelper);
	}
	
	@Override
	protected void registerModels() {
		
		for (RegisterBlockPoint reg : RegisterBlocks.getAll()) {
			if (reg.hasCustomModel)
				continue;
			simpleBlock(reg);
		}
	}
	
	private BlockModelBuilder simpleBlock(RegisterBlockPoint reg) {
		return withExistingParent(reg.id, new ResourceLocation("item/generated"))//
				.texture("all", ModResources.res(reg.id).block());
	}
	
}
