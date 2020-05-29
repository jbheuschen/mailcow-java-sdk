package de.fheuschen.mailcow.sdk.exception;

/**
 * MailcowException
 *
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
