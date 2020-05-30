package de.fheuschen.mailcow.sdk.model.outward;

import com.google.gson.Gson;

/**
 * Wrapper
 * (marker interface)
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface Wrapper<S> {
    S getObjectForSerialization();

    default String serialize() {
        return new Gson().toJson(getObjectForSerialization());
    }
}
