package wolforce.hearthwell.lib.registries;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RegisterConfig {

//    public static ForgeConfigSpec CONFIG_SPEC;
//    public static RegisterConfig CONFIG;

    private static final Set<RegisterConfigPoint<?>> configs = new HashSet<>();

    public static void init() {
        new ForgeConfigSpec.Builder().configure(RegisterConfig::new);
//        Pair<RegisterConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(RegisterConfig::new);
//        CONFIG_SPEC = specPair.getRight();
//        CONFIG = specPair.getLeft();
    }

    private RegisterConfig(ForgeConfigSpec.Builder builder) {
        for (RegisterConfigPoint<?> config : configs) {
            config.build(builder);
        }
    }

    public static <T> RegisterConfigPointList<T> list(String id, List<T> list, String comment) {
        RegisterConfigPointList<T> point = new RegisterConfigPointList<>(id, list, comment);
        configs.add(point);
        return point;
    }

    public static RegisterConfigPointInt integer(String id, Integer list, String comment) {
        RegisterConfigPointInt point = new RegisterConfigPointInt(id, list, comment);
        configs.add(point);
        return point;
    }

    //
    //

    public static abstract class RegisterConfigPoint<T> {

        final String id;
        final T defaultValue;
        final String comment;

        RegisterConfigPoint(String id, T defaultValue, String comment) {
            this.id = id;
            this.defaultValue = defaultValue;
            this.comment = comment;
        }

        public abstract T get();

        public abstract void set(T names);

        abstract void build(ForgeConfigSpec.Builder builder);
    }

    static class RegisterConfigPointInt extends RegisterConfigPoint<Integer> {

        public ConfigValue<Integer> config;

        RegisterConfigPointInt(String id, Integer defaultValue, String comment) {
            super(id, defaultValue, comment);
        }

        @Override
        public Integer get() {
            return config.get();
        }

        @Override
        public void set(Integer names) {
            config.set(names);
        }

        @Override
        void build(ForgeConfigSpec.Builder builder) {
            int defaultValue = this.defaultValue;
            this.config = builder.comment(comment).define(id, defaultValue, x -> true);
        }
    }

    static class RegisterConfigPointList<T> extends RegisterConfigPoint<List<T>> {

        public ConfigValue<List<? extends T>> config;

        RegisterConfigPointList(String id, List<T> defaultValue, String comment) {
            super(id, defaultValue, comment);
        }

        @Override
        public List<T> get() {
            return Collections.unmodifiableList(config.get());
        }

        @Override
        public void set(List<T> names) {
            config.set(names);
        }

        @Override
        void build(ForgeConfigSpec.Builder builder) {
            List<T> defaultValue = this.defaultValue;
            this.config = builder.comment(comment).defineList(id, defaultValue, x -> true);
        }
    }
}