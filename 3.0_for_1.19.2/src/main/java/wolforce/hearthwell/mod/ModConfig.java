package wolforce.hearthwell.mod;

import wolforce.hearthwell.lib.registries.RegisterConfig;

import java.util.List;

public class ModConfig {

    public static RegisterConfig.RegisterConfigPoint<List<String>>
            sizes = RegisterConfig.list("sizes", List.of("foo", "bar"), "comment");

}
