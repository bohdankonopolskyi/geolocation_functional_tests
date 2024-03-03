package org.geolocation.config;

public class ConfigContainer {

    private static Config config;

    public static synchronized Config getConfig() {
        if (config == null)
            config = buildConfig();

        return config;
    }

    private static Config buildConfig() {
        return new EnvVariablesConfigCollector().getConfig();
    }
}
