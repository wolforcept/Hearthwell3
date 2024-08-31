package wolforce.hearthwell.lib.datagen;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
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

    public static final List<SubProviderEntry> //
            subProviders = ImmutableList.of(//
            new SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK) //
//			Pair.of(ModEntityLootTables::new, LootContextParamSets.ENTITY), //
//			Pair.of(ModChestLootTables::new, LootContextParamSets.CHEST) //
    );

    public GenLootTableProvider(PackOutput packOutput, Set<ResourceLocation> resourceLocations, List<LootTableProvider.SubProviderEntry> providers) {
        super(packOutput, resourceLocations, providers);
    }

    @Override
    public List<SubProviderEntry> getTables() {
        return subProviders;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationtracker) {
        map.forEach((id, table) -> LootTables.validate(validationtracker, id, table));
    }

}