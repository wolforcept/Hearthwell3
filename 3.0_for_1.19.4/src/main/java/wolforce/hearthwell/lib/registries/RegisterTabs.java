package wolforce.hearthwell.lib.registries;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import wolforce.hearthwell.mod.Hearthwell;
import wolforce.hearthwell.mod.ModResources;

@Mod.EventBusSubscriber(modid = Hearthwell.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterTabs {

    // Registered on the MOD event bus
    // Assume we have RegistryObject<Item> and RegistryObject<Block> called ITEM and BLOCK
    @SubscribeEvent
    public void buildContents(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(Hearthwell.MODID, "name"), builder ->
                // Set name of tab to display
                builder.title(Component.translatable("item_group." + Hearthwell.MODID + ".name"))
                        // Set icon of creative tab
                        .icon(() -> new ItemStack(ModResources..get()))
                        // Add default items to tab
                        .displayItems((params, output) -> {
                            output.accept(ITEM.get());
                            output.accept(BLOCK.get());
                        })
        );
    }
}
