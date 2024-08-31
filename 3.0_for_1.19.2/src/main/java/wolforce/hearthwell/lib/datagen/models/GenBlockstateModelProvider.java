package wolforce.hearthwell.lib.datagen.models;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import wolforce.hearthwell.lib.registries.RegisterBlocks;
import wolforce.hearthwell.lib.registries.RegisterBlocks.RegisterBlockPoint;
import wolforce.hearthwell.mod.Hearthwell;

public class GenBlockstateModelProvider extends BlockStateProvider {
	
	public GenBlockstateModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Hearthwell.MODID, existingFileHelper);
	}
	
	@Override
	protected void registerStatesAndModels() {
		for (RegisterBlockPoint reg : RegisterBlocks.getAll()) {
			if (reg.isDefaultBlockModel()) { simpleBlock(reg.get()); }
		}
	}
	
//	private BlockModelBuilder simpleBlock(RegisterBlockPoint reg) {
//		return withExistingParent(reg.id, new ResourceLocation("item/generated"))//
//				.texture("all", new ResourceLocation(Hearthwell.MODID, "block/" + reg.id));
//	}
	
}
