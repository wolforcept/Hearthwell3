package wolforce.hearthwell.mod.registries;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.RegistryObject;
import wolforce.hearthwell.lib.registries.RegisterEntities;
import wolforce.hearthwell.mod.ModResources;
import wolforce.hearthwell.mod.entities.GolemEntity;
import wolforce.hearthwell.mod.entities.HearthwellEntity;

public class ModEntities {
	
	public static final RegistryObject<EntityType<HearthwellEntity>>//
	hearthwell = RegisterEntities.<HearthwellEntity>entity(ModResources.hearthwell.getPath())
			.fireImmune()
			.sized(1, 1)
			.reg(HearthwellEntity::new);
	
	public static final RegistryObject<EntityType<GolemEntity>> //
	golem = RegisterEntities.<GolemEntity>startLiving(ModResources.golem.getPath())
			.basicAttributes()
			.mobCat(MobCategory.CREATURE)
			.sized(1, 1)
			.reg(GolemEntity::new);
	
}
