package org.geolocation.helpers;

import static org.geolocation.helpers.BooleanHelper.isNotNullAndNotBlank;

public class EnvVariableHelper {

    public static String getEnvOrDefault(String key, String defaultVal) {
        if (isNotNullAndNotBlank(System.getProperty(key)))
            return System.getProperty(key);
        else if (!isNotNullAndNotBlank(System.getProperty(key)) && isNotNullAndNotBlank(System.getenv(key)))
            return System.getenv(key);
        else
            return defaultVal;
    }
}
