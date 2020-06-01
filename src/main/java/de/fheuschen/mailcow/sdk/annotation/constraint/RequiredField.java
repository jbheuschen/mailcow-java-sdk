package de.fheuschen.mailcow.sdk.annotation.constraint;

import de.fheuschen.mailcow.sdk.validation.RequirementValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RequiredField
 * Marks a field within a Validateable as required (i.e., it must not be null).
 * @author Julian B. Heuschen <julian@fheuschen.de>
 * @see RequirementValidator
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredField {
    String errorMessage() default "";
}
