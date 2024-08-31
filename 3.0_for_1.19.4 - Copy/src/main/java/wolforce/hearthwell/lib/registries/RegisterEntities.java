package wolforce.hearthwell.lib.registries;

import java.util.Collection;
import java.util.HashMap;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import wolforce.hearthwell.mod.Hearthwell;

public class RegisterEntities {
	
	public static final DeferredRegister<EntityType<?>> registry = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Hearthwell.MODID);
	private static final HashMap<String, RegisterEntityPoint<?>> ENTITIES = new HashMap<>();
	
	public static <T extends Entity> RegisterEntityPoint<T> entity(String regName) {
		return new RegisterEntityPoint<T>(regName);
	}
	
	public static <T extends LivingEntity> RegisterLivingEntityPoint<T> startLiving(String regName) {
		return new RegisterLivingEntityPoint<T>(regName);
	}
	
	public static Collection<RegisterEntityPoint<? extends Entity>> getAll() {
		return ENTITIES.values();
	}

	public static class RegisterLivingEntityPoint<T extends LivingEntity> extends RegisterEntityPoint<T> {
		
		public RegisterLivingEntityPoint(String regName) {
			super(regName);
		}
		
		private LivingEntityPointAttributeProvider attributes = null;
		
		public RegisterLivingEntityPoint<T> customAttributes(LivingEntityPointAttributeProvider attr) {
			this.attributes = attr;
			return this;
		}
		
		public RegisterLivingEntityPoint<T> basicAttributes() {
			this.attributes = () -> LivingEntity.createLivingAttributes().add(Attributes.FOLLOW_RANGE).build();
			return this;
		}
		
		public AttributeSupplier getAttributes() {
			return attributes.getAttributes();
		}
		
		public interface LivingEntityPointAttributeProvider {
			AttributeSupplier getAttributes();
		}
	}
	
	public static class RegisterEntityPoint<T extends Entity> {
		
		public final String regName;
		private MobCategory mobCategory;
		private int trackingRange = -1;
		private float sizeX = 1, sizeY = 1;
		private boolean isFireImmune = false;
		private RegistryObject<EntityType<T>> regObj;
		
		public RegisterEntityPoint(String regName) {
			this.regName = regName;
		}
		
		// actual methods
		
		public RegisterEntityPoint<T> mobCat(MobCategory mobcat) {
			this.mobCategory = mobcat;
			return this;
		}
		
		public RegisterEntityPoint<T> trackingRange(int range) {
			this.trackingRange = range;
			return this;
		}
		
		public RegisterEntityPoint<T> fireImmune() {
			this.isFireImmune = true;
			return this;
		}
		
		public RegisterEntityPoint<T> sized(float sizeX, float sizeY) {
			this.sizeX = sizeX;
			this.sizeY = sizeY;
			return this;
		}
		
		//
		
		public EntityType<T> get() {
			return regObj.get();
		}
		
		public RegistryObject<EntityType<T>> reg(EntityType.EntityFactory<T> entityFactory) {
			
			ENTITIES.put(regName, this);
			regObj = registry.register(regName, () -> {
				
				EntityType.Builder<T> e = EntityType.Builder.of(entityFactory, mobCategory);
				if (isFireImmune)
					e = e.fireImmune();
				if (trackingRange >= 0)
					e = e.setTrackingRange(trackingRange);
				e = e.sized(sizeX, sizeY);
				return e.build(regName);
			});
			
			return regObj;
		}
		
	}
	
}
