package org.geolocation.config;

public class EnvVariablesConfigCollector {

    public Config getConfig() {
        return new Config.Builder()
                .buildIpApiUrl(EnvVariables.ENV_IP_API_URL.getVal())
                .build();
    }
}
