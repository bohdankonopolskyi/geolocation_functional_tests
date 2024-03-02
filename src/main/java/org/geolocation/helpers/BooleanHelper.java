package org.geolocation.helpers;

public class BooleanHelper {

    public static boolean isNotNullAndNotBlank(Object obj) {
        return obj != null && !obj.toString().isBlank();
    }
}
