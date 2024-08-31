package wolforce.hearthwell.lib.datagen.loot;

import java.util.function.BiConsumer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import wolforce.hearthwell.mod.ModResources;
import wolforce.hearthwell.mod.registries.ModBlocks;
import wolforce.hearthwell.mod.registries.ModItems;
/*
public class ModChestLootTables extends ChestLoot {
	
	@Override
	public void accept(BiConsumer<ResourceLocation, Builder> consumer) {
		consumer.accept(ModResources.customChestLoot, LootTable.lootTable() //
				.withPool( //
						LootPool.lootPool().setRolls(UniformGenerator.between(2.0f, 8.0f)) //
								.add(LootItem.lootTableItem(ModItems.myst_dust.get())) //
								.add(LootItem.lootTableItem(ModBlocks.myst_dust_block.get())) //
				) //
		);
	}
}
*/