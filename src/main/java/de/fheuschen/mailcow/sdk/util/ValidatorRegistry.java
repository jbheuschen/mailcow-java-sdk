package de.fheuschen.mailcow.sdk.util;

import de.fheuschen.mailcow.sdk.validation.RequirementValidator;
import de.fheuschen.mailcow.sdk.validation.Validateable;

import java.util.HashMap;
import java.util.Map;

/**
 * ValidatorRegistry
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public final class ValidatorRegistry {

    @SuppressWarnings("rawtypes")
    private static final Map<Class, RequirementValidator> registry = new HashMap<>();

    @SuppressWarnings("unchecked")
    public static <T extends Validateable> RequirementValidator<T> get(Class<T> clazz) {
        if(!registry.containsKey(clazz))
        {
            registry.put(clazz, new RequirementValidator(clazz));
            return get(clazz);
        }
        return registry.get(clazz);
    }

    private ValidatorRegistry() {}

}
