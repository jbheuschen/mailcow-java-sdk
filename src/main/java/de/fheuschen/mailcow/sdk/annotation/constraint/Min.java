package de.fheuschen.mailcow.sdk.annotation.constraint;

import de.fheuschen.mailcow.sdk.validation.RequirementValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Min
 * Marks that a numeric field within a Validateable must have a value higher than min.
 * @see RequirementValidator
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Min {
    double min() default Double.MIN_VALUE;
}
