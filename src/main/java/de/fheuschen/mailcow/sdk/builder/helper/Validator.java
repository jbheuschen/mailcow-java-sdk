package de.fheuschen.mailcow.sdk.builder.helper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Validator
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface Validator<T, A extends Annotation> {

    boolean validate(T t, A a, Field f, Class<T> clazz);

}
