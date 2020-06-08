package de.fheuschen.mailcow.sdk.exception;

/**
 * MailcowException
 * Exceptions of this kind indicated that something has gone wrong, though not necessarily unexpectedly.
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class MailcowException extends Exception {

    private String message;

    public MailcowException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
