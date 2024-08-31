package wolforce.hearthwell.mod.registries;

import static wolforce.hearthwell.lib.registries.RegisterBlocks.block;

import net.minecraft.world.level.block.Block;

import static net.minecraft.world.level.block.SoundType.*;

import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static RegistryObject<Block>

            /*   */ myst_dust_block = block("myst_dust_block").str(1).shovel().sound(SAND).reg(),
            myst_rock = block("myst_rock").str(1).pickaxe().sound(BASALT).reg(),
            plinth_top = block("plinth_top").str(1).pickaxe().sound(BASALT).hasCustomModel().reg(),
            crystal = block("crystal").str(1).pickaxe().sound(BONE_BLOCK).hasCustomModel().reg();

}
