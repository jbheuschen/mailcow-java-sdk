package de.fheuschen.mailcow.sdk.exception;

/**
 * UnsupportedAPIActionException
 * Indicates that the action you're trying to perform is either not supported (yet) or is not performable in the current
 * environment (e.g., you cannot perform write-actions whilst the api is in read-only mode).
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class UnsupportedAPIActionException extends MailcowRuntimeException {
    public UnsupportedAPIActionException(String message) {
        super(message);
        super.userCaused = true;
    }
}
