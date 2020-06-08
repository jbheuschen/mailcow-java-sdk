package de.fheuschen.mailcow.sdk.exception;

/**
 * AuthenticationFailedException
 * Runtime exception as this should not happen.
 * Indicates that the authentication with the mailcow api failed thus rendering this library useless. This error is usually
 * caused by typos or other mistakes in the authentication data provided to this library.
 * @see de.fheuschen.mailcow.sdk.Mailcow
 * @see de.fheuschen.mailcow.sdk.builder.APIBuilder
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class AuthenticationFailedException extends MailcowRuntimeException {
    public AuthenticationFailedException(String message) {
        super(message);
    }
}
