package wolforce.hearthwell.lib.datagen.models;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import wolforce.hearthwell.lib.registries.RegisterItems;
import wolforce.hearthwell.lib.registries.RegisterItems.RegisterItemPoint;
import wolforce.hearthwell.mod.Hearthwell;
import wolforce.hearthwell.mod.ModResources;

public class GenItemModelProvider extends ItemModelProvider {
	
	public GenItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Hearthwell.MODID, existingFileHelper);
	}
	
	@Override
	protected void registerModels() {
		
		for (RegisterItemPoint reg : RegisterItems.getAll()) {
			if (reg.hasCustomModel)
				continue;
			if (reg.get() instanceof BlockItem)
				simpleBlockItem(reg);
			else
				simpleItem(reg);
		}
	}
	
	private ItemModelBuilder simpleItem(RegisterItemPoint reg) {
		return withExistingParent(reg.id, "item/generated")//
				.texture("layer0", ModResources.res(reg.id).item());
	}
	
	private ItemModelBuilder simpleBlockItem(RegisterItemPoint reg) {
		return withExistingParent(reg.id, ModResources.res(reg.id).block());
	}
	
}
