package de.fheuschen.mailcow.sdk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ReadOnly
 * This, actually, only is a marker annotation (as we cannot really prevent writing). But it can be useful during development,
 * especially in large classes where it can be confusing which fields should or should not be written to.
 * But keep in mind: since this annotation has only a marking function, it's presence neither guarantees that a field should not be
 * written to under any conditions nor does it's absence guarantee that a field may be written to! You should always double-check
 * such cases.
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadOnly {
}
