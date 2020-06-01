package de.fheuschen.mailcow.sdk.annotation.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Min
 * Marks that a numeric field within a Validateable must have a value higher than min.
 * @see de.fheuschen.mailcow.sdk.builder.helper.RequirementValidator
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Min {
    double min() default Double.MIN_VALUE;
}
