package de.fheuschen.mailcow.sdk.annotation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * APISerialization
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface APISerialization {

    String name();
    String updateName();
    String createName();

}
