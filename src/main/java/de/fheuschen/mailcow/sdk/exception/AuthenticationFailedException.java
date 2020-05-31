package de.fheuschen.mailcow.sdk.exception;

/**
 * AuthenticationFailedException
 * Runtime exception as this should not happen.
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class AuthenticationFailedException extends MailcowRuntimeException {
    public AuthenticationFailedException(String message) {
        super(message);
    }
}
