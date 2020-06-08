package de.fheuschen.mailcow.sdk.exception;

/**
 * ValidationException
 * Indicates that the validation failed on an object.
 * @see de.fheuschen.mailcow.sdk.validation.RequirementValidator
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class ValidationException extends MailcowException {
    public ValidationException(String message) {
        super(message);
    }
}
