package org.geolocation.helpers;

public class NullObjectHelper {

    public static boolean isNotNullAndNotBlank(Object obj) {
        return obj != null && !obj.toString().isBlank();
    }
}
