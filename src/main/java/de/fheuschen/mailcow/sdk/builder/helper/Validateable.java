package de.fheuschen.mailcow.sdk.builder.helper;

import de.fheuschen.mailcow.sdk.exception.ValidationException;
import de.fheuschen.mailcow.sdk.util.ValidatorRegistry;

/**
 * Validateable
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface Validateable {

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
