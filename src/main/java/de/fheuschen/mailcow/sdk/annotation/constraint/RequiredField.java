package de.fheuschen.mailcow.sdk.annotation.constraint;

import de.fheuschen.mailcow.sdk.validation.RequirementValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RequiredField
 * Marks a field within a Validatable as required (i.e., it must not be null).
 * Moreover, conditions to be checked can be specified.
 * @see NotRequiredField
 * @author Julian B. Heuschen <julian@fheuschen.de>
 * @see RequirementValidator
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredField {
    /**
     * The annotated field is required unless any of these is null.
     * @return
     */
    String[] unlessNull() default {};

    /**
     * The annotated field is required unless all of these all null.
     * @return
     */
    String[] unlessAllNull() default {};

    /**
     * The annotated field is required as long as any of these is null.
     * @return
     */
    String[] asLongAsNull() default {};

    /**
     * The annotated field is required as long as all of these are null.
     * @return
     */
    String[] asLongAsAllNull() default {};
}
