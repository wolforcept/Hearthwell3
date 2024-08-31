package wolforce.hearthwell.lib.datagen;

import org.jetbrains.annotations.Nullable;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import wolforce.hearthwell.lib.registries.RegisterBlocks;
import wolforce.hearthwell.lib.registries.RegisterBlocks.RegisterBlockPoint;

public class GenBlockTagsProvider extends BlockTagsProvider {
	
	public GenBlockTagsProvider(DataGenerator generator, String modId, @Nullable ExistingFileHelper existingFileHelper) {
		super(generator, modId, existingFileHelper);
	}
	
	@Override
	protected void addTags() {
		for (RegisterBlockPoint block : RegisterBlocks.getAll()) {
			for (TagKey<Block> tag : block.tags) {
				tag(tag).add(block.get());
			}
		}
	}
	
}
