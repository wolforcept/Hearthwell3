package wolforce.hearthwell.mod;

public class ModTranslations {

    private static final String modid = Hearthwell.MODID;

    public static String keybind(String id) {
        return "key." + modid + "." + id;
    }

    public static String keybindCategory() {
        return "key.categories." + modid;
    }

}
