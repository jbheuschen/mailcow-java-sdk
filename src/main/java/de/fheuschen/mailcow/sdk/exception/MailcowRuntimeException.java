package de.fheuschen.mailcow.sdk.exception;

/**
 * MailcowRuntimeException
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class MailcowRuntimeException extends RuntimeException {
    private String message;

    public MailcowRuntimeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
