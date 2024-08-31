package wolforce.hearthwell.lib.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import wolforce.hearthwell.lib.registries.RegisterBlocks;
import wolforce.hearthwell.lib.registries.RegisterBlocks.RegisterBlockPoint;

import java.util.Collections;
import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        for (RegisterBlockPoint reg : RegisterBlocks.getAll()) {
            if (reg.isDropSelf())
                this.dropSelf(reg.get());
//			this.add(ModBlocks.block2.get(), block -> createOreDrop(ModBlocks.block2.get(), ModItems.item2.get()));
        }
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return RegisterBlocks.getAll().stream().map(RegisterBlockPoint::get)::iterator;
    }
}
