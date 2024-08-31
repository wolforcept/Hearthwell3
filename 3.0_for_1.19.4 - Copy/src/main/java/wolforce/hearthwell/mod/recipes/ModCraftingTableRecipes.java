package wolforce.hearthwell.mod.recipes;

import java.util.Collection;
import java.util.LinkedList;

import net.minecraft.world.level.ItemLike;
import wolforce.hearthwell.lib.datagen.GenRecipeProvider.CraftingTableRecipe;
import wolforce.hearthwell.lib.datagen.GenRecipeProvider.ShapedCraftingTableRecipe;
import wolforce.hearthwell.lib.datagen.GenRecipeProvider.ShapelessCraftingTableRecipe;
import wolforce.hearthwell.mod.registries.ModBlocks;
import wolforce.hearthwell.mod.registries.ModItems;

public class ModCraftingTableRecipes {
	
	private static final Collection<CraftingTableRecipe> recipes = new LinkedList<>();
	
	public static Collection<CraftingTableRecipe> getAllRecipes() {
		
		shaped(ModBlocks.myst_dust_block.get(), 1, "AA,AA", ModItems.myst_dust.get());
		shapeless(ModItems.myst_dust.get(), 4, ModBlocks.myst_dust_block.get());
		
		return recipes;
	}
	
	//
	
	private static void shaped(ItemLike output, int outputNumber, String pattern, Object... inputs) {
		recipes.add(new ShapedCraftingTableRecipe(output, pattern, inputs));
	}
	
	private static void shapeless(ItemLike output, int outputNumber, Object... inputs) {
		recipes.add(new ShapelessCraftingTableRecipe(output, outputNumber, inputs));
	}
	
}
