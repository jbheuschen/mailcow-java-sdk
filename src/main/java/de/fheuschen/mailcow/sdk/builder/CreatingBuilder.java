package de.fheuschen.mailcow.sdk.builder;

import de.fheuschen.mailcow.sdk.util.Util;

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

    Object[] getRequiredFields();
    default boolean requirementsFulfilled() {
        return !Util.isAnyNull(getRequiredFields());
    }
}
