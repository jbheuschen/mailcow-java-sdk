package de.fheuschen.mailcow.sdk.annotation.constraint;

/**
 * Max
 * Marks that a numeric field within a Validateable must have a value smaller than max.
 * @see de.fheuschen.mailcow.sdk.builder.helper.RequirementValidator
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public @interface Max {
    double max() default Double.MAX_VALUE;
}
