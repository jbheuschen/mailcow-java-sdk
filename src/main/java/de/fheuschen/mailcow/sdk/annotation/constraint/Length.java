package de.fheuschen.mailcow.sdk.annotation.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Length
 * Limits the length of a string. In order for this annotation to be useful, you have to provide either the min or the max property
 * with a value greater than zero.
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {

    int min() default -1;
    int max() default -1;

}
