package de.fheuschen.mailcow.sdk.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Registry
 * An abstract registry implementation.
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public abstract class Registry<K, V> {

    protected Map<K, V> registry = new HashMap<>();

    protected abstract V getDefaultValue();

    public V get(K k) {
        if(registry.containsKey(k))
            return registry.getOrDefault(k, getDefaultValue());
        registry.put(k, getDefaultValue());
        return get(k);
    }

    public void set(K k, V v) {
        registry.put(k, v);
    }

    public void remove(K k) {
        registry.remove(k);
    }

    public void clear() {
        registry.clear();
    }

}
