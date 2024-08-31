package wolforce.hearthwell.lib.datagen.loot;

import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import wolforce.hearthwell.lib.registries.RegisterBlocks;
import wolforce.hearthwell.lib.registries.RegisterBlocks.RegisterBlockPoint;

public class ModBlockLootTables extends BlockLoot {
	
	@Override
	protected void addTables() {
		
		for (RegisterBlockPoint reg : RegisterBlocks.getAll()) {
			if (reg.isDropSelf())
				this.dropSelf(reg.get());
//			this.add(ModBlocks.block2.get(), block -> createOreDrop(ModBlocks.block2.get(), ModItems.item2.get()));
		}
		
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks() {
		return RegisterBlocks.getAll().stream().map(RegisterBlockPoint::get)::iterator;
	}
}
