package de.fheuschen.mailcow.sdk.builder.helper;

import de.fheuschen.mailcow.sdk.validation.Validatable;

/**
 * ValidatedCreatingBuilder
 * This particular interface is a creating builder that uses the built-in validation framework for it's validation.
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface ValidatedCreatingBuilder<P> extends CreatingBuilder<P>, Validatable {

    /**
     * This instance implements {@code ValidatedCreatingBuilder<P>}; thus, this method is obsolete and hence deprecated as this objects uses the new validation framework.
     * @return an empty object array.
     */
    @Override
    @Deprecated
    default Object[] getRequiredFields() {
        return new Object[] {}; //Not required anymore
    }

    /**
     * Self-validates this object.
     * @return true if all constraints are fulfilled.
     */
    @Override
    default boolean requirementsFulfilled() {
        return this._selfValidate();
    }
}
