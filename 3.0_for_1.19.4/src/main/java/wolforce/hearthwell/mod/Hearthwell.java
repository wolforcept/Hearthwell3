package wolforce.hearthwell.mod;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import wolforce.hearthwell.lib.registries.RegisterBlocks;
import wolforce.hearthwell.lib.registries.RegisterEntities;
import wolforce.hearthwell.lib.registries.RegisterItems;
import wolforce.hearthwell.mod.registries.ModBlocks;
import wolforce.hearthwell.mod.registries.ModEntities;
import wolforce.hearthwell.mod.registries.ModItems;
import wolforce.hearthwell.mod.client.registries.ModKeybinds;

@Mod(Hearthwell.MODID)
public class Hearthwell {
    public static final String MODID = "hearthwell";

    public Hearthwell() {
        new ModItems();
        new ModBlocks();
        new ModEntities();
        new ModKeybinds();
        new ModConfig();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
//		modEventBus.addListener(this::commonSetup);
        RegisterItems.registry.register(modEventBus);
        RegisterBlocks.registry.register(modEventBus);
        RegisterEntities.registry.register(modEventBus);
    }

}
