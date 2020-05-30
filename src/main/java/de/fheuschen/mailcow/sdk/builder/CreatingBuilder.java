package de.fheuschen.mailcow.sdk.builder;

/**
 * CreatingBuilder
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface CreatingBuilder<P> extends RawBuilder<P> {
    /**
     * Saves the object and returns the retrieved object.
     * @return
     */
    P create();
}
