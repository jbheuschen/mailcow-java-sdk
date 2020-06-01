package de.fheuschen.mailcow.sdk.annotation.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * NotRequiredField
 * Has no special effect on validation but to mark a field for documentary purposes.
 * Marks that a field within a Validateable can be null.
 * Should, for obvious reasons, not be combined with RequiredField. If done so, the latter will be prevail.
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotRequiredField {
}
