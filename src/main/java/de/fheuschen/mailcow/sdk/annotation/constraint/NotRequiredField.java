package de.fheuschen.mailcow.sdk.annotation.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * NotRequiredField
 * Has no special effect on validation but to mark a field for documentary purposes.
 * Marks that a field within a Validatable can be null.
 * Should, for obvious reasons, not be combined with RequiredField. If done so, the latter will be prevail.
 * @see de.fheuschen.mailcow.sdk.validation.Validatable
 * @see de.fheuschen.mailcow.sdk.validation.RequirementValidator
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotRequiredField {
    /**
     * The annotated field is not required unless any of these is null.
     * @return
     */
    String[] unlessNull() default {};

    /**
     * The annotated field is not required unless all of these all null.
     * @return
     */
    String[] unlessAllNull() default {};

    /**
     * The annotated field is not required as long as any of these is null.
     * @return
     */
    String[] asLongAsNull() default {};

    /**
     * The annotated field is not required as long as all of these are null.
     * @return
     */
    String[] asLongAsAllNull() default {};
}
