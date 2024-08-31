package wolforce.hearthwell.lib.registries;

import java.util.Collection;
import java.util.HashMap;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import wolforce.hearthwell.mod.Hearthwell;
import wolforce.hearthwell.mod.registries.ModCreativeTabs;

public class RegisterItems {
	
//	@Mod.EventBusSubscriber(modid = Hearthwell.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
//	public static class ClientModEvents {
//		@SubscribeEvent
//		public static void onClientSetup(FMLClientSetupEvent event) {
//		}
//	}
	
	public static final DeferredRegister<Item> registry = DeferredRegister.create(ForgeRegistries.ITEMS, Hearthwell.MODID);
	private static final HashMap<String, RegisterItemPoint> ITEMS = new HashMap<>();
	
	public static RegisterItemPoint item(String regName) {
		return new RegisterItemPoint(regName);
	}
	
	public static Collection<RegisterItemPoint> getAll() {
		return ITEMS.values();
	}
	
	public static class RegisterItemPoint {
		
		public final String id;
		public boolean hasCustomModel;
		private CreativeModeTab tab;
		
		private RegistryObject<Item> regObj;
		
		public RegisterItemPoint(String regName) {
			this.id = regName;
			ITEMS.put(regName, this);
		}
		
		// actual methods
		
		public RegisterItemPoint tab(CreativeModeTab tab) {
			this.tab = tab;
			return this;
		}
		
		// final registry
		
		Properties makeItemProps() {
			Properties props = new Properties();
			if (tab == null)
				props.tab(ModCreativeTabs.tab);
			else
				props.tab(tab);
			return props;
		}
		
		public RegistryObject<Item> reg(ItemSupplier itemSupplier) {
			this.regObj = registry.register(id, () -> itemSupplier.getItem(makeItemProps()));
			return regObj;
		}
		
		public RegistryObject<Item> reg() {
			this.regObj = registry.register(id, () -> new Item(makeItemProps()));
			return regObj;
		}
		
		public void hasCustomModel() {
			this.hasCustomModel = true;
		}
		
		// getters
		
		public Item get() {
			return regObj.get();
		}
		
	}
	
	public static interface ItemSupplier {
		Item getItem(Properties props);
	}
	
}
