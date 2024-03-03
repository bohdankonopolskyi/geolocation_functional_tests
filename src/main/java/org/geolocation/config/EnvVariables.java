package org.geolocation.config;

import org.geolocation.constants.TestGroups;
import org.geolocation.helpers.EnvVariableHelper;

public enum EnvVariables {

    ENV_IP_API_URL("ENV_IP_API_URL", "http://ip-api.com"),
    ENV_INCLUDE_GROUPS("ENV_INCLUDE_GROUPS", TestGroups.ALL),
    ENV_EXCLUDE_GROUPS("ENV_EXCLUDE_GROUPS", ""),
    ENV_TREAD_COUNT("ENV_TREAD_COUNT", "3"),
    ENV_PARALLEL("ENV_PARALLEL", "methods");

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
