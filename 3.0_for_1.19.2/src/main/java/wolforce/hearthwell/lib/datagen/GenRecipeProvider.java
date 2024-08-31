package wolforce.hearthwell.lib.datagen;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;

import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import wolforce.hearthwell.mod.recipes.ModCraftingTableRecipes;

public class GenRecipeProvider extends RecipeProvider implements IConditionBuilder {
	
	public GenRecipeProvider(DataGenerator pGen) {
		super(pGen);
	}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		
		for (CraftingTableRecipe recipe : ModCraftingTableRecipes.getAllRecipes()) {
			
			if (recipe instanceof ShapedCraftingTableRecipe shaped) {
				ShapedRecipeBuilder builder = ShapedRecipeBuilder.shaped(recipe.output, recipe.outputNumber);
				CriterionTriggerInstance crit = inventoryTrigger(ItemPredicate.Builder.item().of(recipe.getTrigger()).build());
				builder = builder.unlockedBy("recipe_" + recipe.getTrigger().toString(), crit);
				
				for (Entry<Character, ItemLike> item : shaped.getInputs()) {
					builder = builder.define(item.getKey(), item.getValue());
				}
				
				for (String patternLine : shaped.pattern.split("\\,")) {
					builder = builder.pattern(patternLine);
				}
				
				builder.save(consumer);
			}
			
			if (recipe instanceof ShapelessCraftingTableRecipe shapeless) {
				ShapelessRecipeBuilder builder = ShapelessRecipeBuilder.shapeless(shapeless.output, shapeless.outputNumber);
				 
				CriterionTriggerInstance crit = inventoryTrigger(ItemPredicate.Builder.item().of(recipe.getTrigger()).build());
				builder = builder.unlockedBy("recipe_" + recipe.getTrigger().toString(), crit);
				
				for (ItemLike itemLike : shapeless.inputs) {
					builder = builder.requires(itemLike);
				}
				builder.save(consumer);
			}
		}
	}
	
	//
	//
	
	public static abstract class CraftingTableRecipe {
		public ItemLike output;
		public int outputNumber = 1;
		public ItemLike trigger;
		
		public ItemLike getTrigger() {
			return trigger;
		}
	}
	
	public static class ShapelessCraftingTableRecipe extends CraftingTableRecipe {
		public LinkedList<ItemLike> inputs;
		
		public CraftingTableRecipe trigger(ItemLike trigger) {
			this.trigger = trigger;
			return this;
		}
		
		public ShapelessCraftingTableRecipe(ItemLike output, int outputNumber, Object... inputs) {
			this.output = output;
			this.outputNumber = outputNumber;
			this.inputs = new LinkedList<>();
			
			for (Object object : inputs) {
				if (object instanceof ItemLike itemLike) {
					if (this.trigger == null)
						this.trigger = itemLike;
					this.inputs.add(itemLike);
				}
			}
		}
		
		public LinkedList<ItemLike> getInputs() {
			return new LinkedList<ItemLike>(this.inputs);
		}
	}
	
	public static class ShapedCraftingTableRecipe extends CraftingTableRecipe {
		public String pattern;
		public HashMap<Character, ItemLike> inputs;
		
		public CraftingTableRecipe trigger(ItemLike trigger) {
			this.trigger = trigger;
			return this;
		}
		
		public ShapedCraftingTableRecipe(ItemLike output, String pattern, Object... inputs) {
			this.pattern = pattern;
			this.output = output;
			this.inputs = new HashMap<>();
			
			char nextChar = 'A';
			for (Object object : inputs) {
				if (object instanceof Character c)
					nextChar = c;
				if (object instanceof ItemLike itemLike) {
					if (this.trigger == null)
						this.trigger = itemLike;
					this.inputs.put(nextChar, itemLike);
				}
			}
		}
		
		public Set<Entry<Character, ItemLike>> getInputs() {
			return inputs.entrySet();
		}
		
	}
}
