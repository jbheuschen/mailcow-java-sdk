package de.fheuschen.mailcow.sdk.builder.helper;

import de.fheuschen.mailcow.sdk.validation.Validateable;

/**
 * ValidatedCreatingBuilder
 * This particular interface is a creating builder that uses the built-in validation framework for it's validation.
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface ValidatedCreatingBuilder<P> extends CreatingBuilder<P>, Validateable {

    @Override
    default Object[] getRequiredFields() {
        return new Object[] {}; //Not required anymore
    }

    @Override
    default boolean requirementsFulfilled() {
        return this._selfValidate();
    }
}
