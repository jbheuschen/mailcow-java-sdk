package de.fheuschen.mailcow.sdk.validation;

import de.fheuschen.mailcow.sdk.annotation.constraint.*;
import de.fheuschen.mailcow.sdk.exception.ValidationException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * RequirementValidator
 * This class has the ability to analyse instances of a class for constraint violation.
 * These constraints are located within the <i>annotation.constraint</i> package and can be applied to fields.
 * As this class uses reflection, there might be problems when using strict SecurityManagers.
 * Moreover, (for structural reasons which might be solved in later versions) each instance of this class holds its
 * own dedicated map of classes and validators; thus, it should be reused (e.g., by using the ValidatorRegistry class).
 *
 * @param <T> the type to perform checks on. Must implement Validateable.
 * @see Validateable
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class RequirementValidator<T extends Validateable> {

    private final Class<T> clazz;
    private Map<Class<? extends Annotation>, Validator<T, Annotation>> validators;

    /**
     *
     * @param clazz the class.
     */
    public RequirementValidator(Class<T> clazz) {
        this.clazz = clazz;
        init();
    }

    /**
     * Initializes the validator map.
     */
    private void init() {
        validators = new HashMap<>();
        validators.put(RequiredField.class, (t, annotation, f, clazz) -> f.get(t) != null);
        validators.put(Min.class, (t, annotation, f, clazz) -> {
            Min min = (Min) annotation;

            Object o = f.get(t);
            if(o instanceof Integer) {
                return ((int)o) > min.min();
            } else if(o instanceof Long) {
                return ((long)o) > min.min();
            } else if(o instanceof Double) {
                return ((double)o) > min.min();
            } else if(o instanceof Float) {
                return ((float)o) > min.min();
            } else if(o instanceof Short) {
                return ((short)o) > min.min();
            } else {
                System.err.println("Note: @Min was applied to a field containing neither int, long, double nor short.");
            }

            return false;
        });
        validators.put(Max.class, (t, annotation, f, clazz) -> {
            Max max = (Max) annotation;
            Object o = f.get(t);
            if(o instanceof Integer) {
                return ((int)o) < max.max();
            } else if(o instanceof Long) {
                return ((long)o) < max.max();
            } else if(o instanceof Double) {
                return ((double)o) < max.max();
            } else if(o instanceof Float) {
                return ((float)o) < max.max();
            } else if(o instanceof Short) {
                return ((short)o) < max.max();
            } else {
                System.err.println("Note: @Max was applied to a field containing neither int, long, double nor short.");
            }
            return false;
        });
        validators.put(StringBool.class, (t, annotation, f, clazz) -> f.get(t).toString().equalsIgnoreCase("true") || f.get(t).toString().equalsIgnoreCase("false") ||
                f.get(t).toString().equalsIgnoreCase("1") || f.get(t).toString().equalsIgnoreCase("0"));
        validators.put(Length.class, (t, annotation, f, clazz) -> {
            Length l = (Length) annotation;
            String s = f.get(t).toString();
            return ((l.equals() > -1) ? l.equals() == s.length() : (l.min() > -1 && l.max() > -1) ?
                    s.length() > l.min() && s.length() < l.max() : (l.min() > -1) ? s.length() > l.min()
                    : s.length() < l.max());
        });
        validators.put(RegExp.class, (t, annotation, f, clazz) -> {
            RegExp r = (RegExp) annotation;
            return f.get(t).toString().matches(r.regExp());
        });
    }

    /**
     * This method analyses the instances passed to it and throws a validation exception as soon as at least one constraint is violated.
     *
     * Note: If you have a SecurityManager that is configured to deny reflection-access to private members,
     * this class cannot perform the necessary checks on those fields. For said fields, this method will
     * assume that no constraints were violated and continue. It is your responsibility to verify that
     * these constraints are met anyways, in order to guarantee that no errors will occur later on.
     *
     * @param t the instance to be analysed. Must, obviously, not be null.
     * @return will (for convenience) always return true (as otherwise an exception is thrown)
     * @throws ValidationException if at least one constraint is violated. The exception contains an error message including details about the field
     * whose validation failed. The field's actual value is not disclosed.
     * @see SecurityException
     */
    public boolean validate(T t) throws ValidationException {
        for (Field f : clazz.getDeclaredFields()) {
            try {
                for (Class<? extends Annotation> cl : validators.keySet()) {
                    if (f.isAnnotationPresent(cl)) {
                        if(!f.canAccess(t))
                            f.setAccessible(true);
                        try {
                            if (!validators.get(cl).validate(t, f.getDeclaredAnnotation(cl), f, clazz)) {
                                throw new ValidationException("\"" + f.getName() + "\" does not meet all requirements!");
                            }
                        } catch(IllegalAccessException ignored) {
                        }
                    }
                }
            } catch(SecurityException e) {
                System.err.println("Cannot perform constraint validations on field " + f.getName() + " as access to private members is disabled" +
                        "in security manager! Assuming that no constraints were violated and continuing...");
            }
        }
        return true;
    }

}
