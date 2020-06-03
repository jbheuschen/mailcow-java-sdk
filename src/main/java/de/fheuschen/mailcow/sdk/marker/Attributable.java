package de.fheuschen.mailcow.sdk.marker;

/**
 * Attributable
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface Attributable<K, V> {

    boolean hasAttribute(K key);
    String getAttribute(K key);
    String getAttribute(K key, V def);
    void setAttribute(K key, V value);

}
