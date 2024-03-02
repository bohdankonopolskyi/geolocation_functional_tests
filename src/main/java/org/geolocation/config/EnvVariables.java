package org.geolocation.config;

import org.geolocation.helpers.EnvVariableHelper;

public enum EnvVariables {

    ENV_IP_API_URL("ENV_IP_API_URL", "http://ip-api.com");

    private String key;
    private String val;

    EnvVariables(String key, String value) {
        this.key = key;
        this.val = value;
    }

    public String getKey() {
        return key;
    }

    public EnvVariables setKey(String key) {
        this.key = key;
        return this;
    }

    public String getVal() {
        return EnvVariableHelper.getEnvOrDefault(key, val);
    }

    public EnvVariables setVal(String val) {
        this.val = val;
        return this;
    }
}
