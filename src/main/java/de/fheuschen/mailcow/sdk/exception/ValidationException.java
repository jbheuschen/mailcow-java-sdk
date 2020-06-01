package de.fheuschen.mailcow.sdk.exception;

/**
 * ValidationException
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class ValidationException extends MailcowException {
    public ValidationException(String message) {
        super(message);
    }
}
