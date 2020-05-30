package de.fheuschen.mailcow.sdk.exception;

/**
 * UnsupportedAPIActionException
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class UnsupportedAPIActionException extends MailcowRuntimeException {
    public UnsupportedAPIActionException(String message) {
        super(message);
    }
}
