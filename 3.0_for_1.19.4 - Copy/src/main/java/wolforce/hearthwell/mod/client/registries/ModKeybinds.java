package wolforce.hearthwell.mod.client.registries;

import org.lwjgl.glfw.GLFW;
import wolforce.hearthwell.lib.client.registries.RegisterKeybinds;

import static wolforce.hearthwell.lib.client.registries.RegisterKeybinds.keybind;

public class ModKeybinds {

    public static RegisterKeybinds.RegisterKeybindPoint
            open_quick_menu = keybind("open_quick_menu", GLFW.GLFW_KEY_UNKNOWN).inGame();

}
