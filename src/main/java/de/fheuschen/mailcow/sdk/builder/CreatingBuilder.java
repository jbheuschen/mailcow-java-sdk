package de.fheuschen.mailcow.sdk.builder;

import de.fheuschen.mailcow.sdk.exception.BuilderException;
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

    /**
     * Returns the values of all required fields. Used to check for requirement fulfillment.
     * @return
     */
    Object[] getRequiredFields();

    /**
     * Returns whether all required fields have non-null values.
     * @return
     */
    default boolean requirementsFulfilled() {
        return !Util.isAnyNull(getRequiredFields());
    }

    /**
     * Same as requirementsFulfilled() but throws a runtime exception if the requirements are not fulfilled.
     * @see #requirementsFulfilled()
     * @return true if fulfilled
     */
    default boolean hardRequirementsFulfilled() {
        if(!requirementsFulfilled())
            throw new BuilderException("Not all required fields have non-null values! To check which fields are required, please refer to the documentation.");
        return true;
    }
}
