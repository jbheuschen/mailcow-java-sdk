package de.fheuschen.mailcow.sdk.builder.helper;

import de.fheuschen.mailcow.sdk.annotation.RequiredField;
import de.fheuschen.mailcow.sdk.exception.ValidationException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * RequirementValidator
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class RequirementValidator<T extends Validateable> {

    private final Class<T> clazz;
    private Map<Class<? extends Annotation>, Validator<T, Annotation>> validators;

    public RequirementValidator(Class<T> clazz) {
        this.clazz = clazz;
        init();
    }

    private void init() {
        validators = new HashMap<>();
        validators.put(RequiredField.class, (t, annotation, f, clazz) -> {

            try {
                return f.get(t) != null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return false;
        });
    }

    public boolean validate(T t) throws ValidationException {

        for(Field f : clazz.getDeclaredFields()) {
            for(Class<? extends Annotation> cl : validators.keySet()) {
                if(f.isAnnotationPresent(cl)) {
                    f.setAccessible(true);
                    if(!validators.get(cl).validate(t, f.getDeclaredAnnotation(cl), f, clazz)) {
                        throw new ValidationException("\"" + f.getName() + "\" does not meet all requirements!");
                    }
                }
            }
        }

        return true;
    }

}
