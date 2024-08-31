package wolforce.hearthwell.mod.registries;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import wolforce.hearthwell.mod.Hearthwell;
import wolforce.hearthwell.mod.ModResources;

public class ModCreativeTabs {
	
	public static final CreativeTab tab = new CreativeTab();
	
	public static class CreativeTab extends CreativeModeTab {
		
		private CreativeTab() {
			super(Hearthwell.MODID);
			setBackgroundImage(ModResources.TAB_TEXTURE);
			hideTitle();
		}
		
		@Override
		public boolean hasSearchBar() {
			return true;
		}
		
		@Override
		public int getSearchbarWidth() {
			return 100;
		}
		
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ModItems.myst_dust.get());
		}
	}
}
