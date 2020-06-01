package de.fheuschen.mailcow.sdk.annotation.constraint;

import de.fheuschen.mailcow.sdk.validation.RequirementValidator;

/**
 * Max
 * Marks that a numeric field within a Validateable must have a value smaller than max.
 * @see RequirementValidator
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public @interface Max {
    double max() default Double.MAX_VALUE;
}
