package de.fheuschen.mailcow.sdk.annotation.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * NotRequiredField
 * Marks that a field within a Validatable can be null.
 * Should, for obvious reasons, not be combined with RequiredField. If done so, the latter will be prevail.
 * Note: in order to give this annotation a real effect (except for marking fields), you can specify several conditions in which
 * a field can(not) be null. All String[]-fields within this annotation expect an array of actual field-names (accessible via reflection)
 * as their content, NOT actual values!
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
