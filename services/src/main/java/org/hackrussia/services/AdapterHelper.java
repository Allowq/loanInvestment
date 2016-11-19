package org.hackrussia.services;

public class AdapterHelper {
    public static <T> T adaptTo(Object data, Class<T> aClass) {
        return aClass.cast(data);
    }
}
