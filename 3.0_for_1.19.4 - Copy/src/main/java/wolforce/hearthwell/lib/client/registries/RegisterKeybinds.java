package wolforce.hearthwell.lib.client.registries;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import wolforce.hearthwell.mod.Hearthwell;
import wolforce.hearthwell.mod.ModTranslations;

import java.util.Collection;
import java.util.HashMap;

@Mod.EventBusSubscriber(modid = Hearthwell.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterKeybinds {

    private static final HashMap<String, RegisterKeybindPoint> KEYBINDS = new HashMap<>();

    public static Collection<RegisterKeybindPoint> getAll() {
        return KEYBINDS.values();
    }

    public static RegisterKeybindPoint keybind(String regName, int key) {
        return new RegisterKeybindPoint(regName, key);
    }

    public static class RegisterKeybindPoint {

        public final String keyId;
        public final int defaultKey;
        public InputConstants.Type defaultOrigin = InputConstants.Type.KEYSYM;

        KeyConflictContext usage = KeyConflictContext.UNIVERSAL;

        public RegisterKeybindPoint(String regName, int key) {
            this.keyId = regName;
            this.defaultKey = key;
            KEYBINDS.put(regName, this);
        }

        public RegisterKeybindPoint inGame() {
            this.usage = KeyConflictContext.IN_GAME;
            return this;
        }

        public RegisterKeybindPoint gui() {
            this.usage = KeyConflictContext.GUI;
            return this;
        }

        public RegisterKeybindPoint mouse() {
            this.defaultOrigin = InputConstants.Type.MOUSE;
            return this;
        }

        public RegisterKeybindPoint scancode() {
            this.defaultOrigin = InputConstants.Type.SCANCODE;
            return this;
        }


    }

    @SubscribeEvent
    public static void registerKeymaps(RegisterKeyMappingsEvent ev) {
        getAll().forEach(point -> {
            ev.register(new KeyMapping(
                    ModTranslations.keybind(point.keyId),
                    point.usage,
                    point.defaultOrigin,
                    point.defaultKey,
                    ModTranslations.keybindCategory()
            ));
        });

    }
}
