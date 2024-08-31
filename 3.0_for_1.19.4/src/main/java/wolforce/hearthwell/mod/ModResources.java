package wolforce.hearthwell.mod;

import net.minecraft.resources.ResourceLocation;

public class ModResources extends ResourceLocation {

	private ModResources(String s1, String s2) {
		super(s1, s2);
	}

	// public static final ModResources
	//
	// /* */ gui = res("textures/gui"),
	// entities = res("textures/entities"),
	// blocks = res("textures/blocks"),
	// items = res("textures/items")
	//
	// ;

	public static final ModResources hearthwell = res("hearthwell"), golem = res("golem");

	public static final ModResources TAB_TEXTURE = res("tab.png").gui().texture();

	public static final ModResources customChestLoot = res("chests/custom_chest_loot");

	// transformations

	public ModResources texture() {
		return new ModResources(namespace, "textures/" + path);
	}

	private ModResources gui() {
		return new ModResources(namespace, "gui/" + path);
	}

	public ModResources block() {
		return new ModResources(namespace, "block/" + path);
	}

	public ModResources item() {
		return new ModResources(namespace, "item/" + path);
	}
	public ModResources keybind() {
		return new ModResources(namespace, "keybind_" + path);
	}

	public ModResources entityTexture() {
		return new ModResources(namespace, "entity/" + path);
	}

	public ModResources modelLayer() {
		return new ModResources(namespace, "modelLayer" + path);
	}

	//

	public static ModResources res(String... s) {
		String finalS = "";
		for (int i = 0; i < s.length; i++)
			finalS += s[i] + (i == s.length - 1 ? "" : "/");
		return new ModResources(Hearthwell.MODID, finalS);
	}

}
