package wolforce.hearthwell.lib.datagen;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTable.Builder;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import wolforce.hearthwell.lib.datagen.loot.ModBlockLootTables;

public class GenLootTableProvider extends LootTableProvider {
	
	private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> //
	subProviders = ImmutableList.of(//
			Pair.of(ModBlockLootTables::new, LootContextParamSets.BLOCK) //
//			Pair.of(ModEntityLootTables::new, LootContextParamSets.ENTITY), //
//			Pair.of(ModChestLootTables::new, LootContextParamSets.CHEST) //
	);
	
	public GenLootTableProvider(DataGenerator gen) {
		super(gen);
	}
	
	protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootContextParamSet>> getTables() {
		return subProviders;
	}
	
	@Override
	protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
		map.forEach((id, table) -> LootTables.validate(validationtracker, id, table));
	}
	
}