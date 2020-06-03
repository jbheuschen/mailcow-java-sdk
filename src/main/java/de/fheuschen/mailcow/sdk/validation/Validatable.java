package de.fheuschen.mailcow.sdk.validation;

import de.fheuschen.mailcow.sdk.exception.ValidationException;
import de.fheuschen.mailcow.sdk.util.ValidatorRegistry;

/**
 * Validatable
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface Validatable {

    /**
     * Self validates this object. Should only be called from within the object.
     * @return true/false
     */
    default boolean _selfValidate() {
        RequirementValidator val = ValidatorRegistry.get(this.getClass());
        try {
            return val.validate(this);
        } catch (ValidationException e) {
            System.err.println("Validation failed: " + e.getMessage());
            return false;
        }
    }

}
