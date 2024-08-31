package wolforce.hearthwell.lib.registries;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import wolforce.hearthwell.lib.registries.RegisterItems.RegisterItemPoint;
import wolforce.hearthwell.mod.Hearthwell;

public class RegisterBlocks {

//	@Mod.EventBusSubscriber(modid = Hearthwell.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
//	public static class ClientModEvents {
//		@SubscribeEvent
//		public static void onClientSetup(FMLClientSetupEvent event) {
//		}
//	}

    public static final DeferredRegister<Block> registry = DeferredRegister.create(ForgeRegistries.BLOCKS, Hearthwell.MODID);
    private static final HashMap<String, RegisterBlockPoint> BLOCKS = new HashMap<>();

    public static RegisterBlockPoint block(String regName) {
        return new RegisterBlockPoint(regName);
    }

    public static Collection<RegisterBlockPoint> getAll() {
        return BLOCKS.values();
    }

    public static class RegisterBlockPoint {

        public final String id;
        public final LinkedList<TagKey<Block>> tags = new LinkedList<>();

        public boolean hasCustomModel = false;

        private RegistryObject<Block> regObj;
        private RegisterItemPoint regItem;
        private float res = 1, str = 1;
        private Material material;
        private SoundType soundType;

        public RegisterBlockPoint(String regName) {
            this.id = regName;
            BLOCKS.put(regName, this);
            regItem = RegisterItems.item(regName);
        }

        // actual methods

        public RegisterBlockPoint item(RegItemSupplier regItemSupplier) {
            this.regItem = regItemSupplier.item(regItem);
            return this;
        }

        public RegisterBlockPoint sound(SoundType soundType) {
            this.soundType = soundType;
            return this;
        }

        public RegisterBlockPoint hasCustomModel() {
            this.hasCustomModel = true;
            return this;
        }

        public RegisterBlockPoint str(int str) {
            this.res = str;
            this.str = str;
            return this;
        }

        public RegisterBlockPoint str(float res, float str) {
            this.res = res;
            this.str = str;
            return this;
        }

        public RegisterBlockPoint pickaxe() {
            this.tags.add(BlockTags.MINEABLE_WITH_PICKAXE);
            return this;
        }

        public RegisterBlockPoint axe() {
            this.tags.add(BlockTags.MINEABLE_WITH_AXE);
            return this;
        }

        public RegisterBlockPoint shovel() {
            this.tags.add(BlockTags.MINEABLE_WITH_SHOVEL);
            return this;
        }

        public RegisterBlockPoint hoe() {
            this.tags.add(BlockTags.MINEABLE_WITH_HOE);
            return this;
        }

        // final registry

        private Properties makeBlockProps() {
            Block.Properties blockProps = Block.Properties.of((material == null) ? Material.STONE : material);
            blockProps.sound(soundType);
            blockProps.explosionResistance(res);
            blockProps.strength(str);
            return blockProps;
        }

        public RegistryObject<Block> reg(BlockSupplier blockSupplier) {
            this.regObj = registry.register(id, () -> blockSupplier.getBlock(makeBlockProps()));
            return regObj;
        }

        public RegistryObject<Block> reg() {
            this.regObj = registry.register(id, () -> new Block(makeBlockProps()));
            this.regItem.reg(x -> new BlockItem(get(), this.regItem.makeItemProps()));
            return regObj;
        }

        // getters

        public Block get() {
            return regObj.get();
        }

        public boolean isDropSelf() {
            return true;
        }

        public boolean isDefaultBlockModel() {
            return true;
        }

        public boolean isDefaultBlockItemModel() {
            return true;
        }
    }

    public static interface BlockSupplier {
        Block getBlock(Block.Properties props);
    }

    public static interface RegItemSupplier {
        RegisterItemPoint item(RegisterItemPoint rip);
    }

}
