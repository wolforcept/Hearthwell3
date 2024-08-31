package wolforce.hearthwell.lib.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.data.DataGenerator;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import wolforce.hearthwell.lib.registries.RegisterBlocks;
import wolforce.hearthwell.lib.registries.RegisterBlocks.RegisterBlockPoint;

import java.util.concurrent.CompletableFuture;

public class GenBlockTagsProvider extends BlockTagsProvider {

    public GenBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        for (RegisterBlockPoint block : RegisterBlocks.getAll()) {
            for (TagKey<Block> tag : block.tags) {
                tag(tag).add(block.get());
            }
        }
    }
}
