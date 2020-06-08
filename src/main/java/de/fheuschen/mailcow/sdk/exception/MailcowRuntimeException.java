package de.fheuschen.mailcow.sdk.exception;

/**
 * MailcowRuntimeException
 * Exceptions of this kind indicate an unexpected error that should not have occurred. If such a runtime
 * exceptions is thrown, it usually contains enough information for you to decide whether the cause is on
 * your side or not.
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class MailcowRuntimeException extends RuntimeException {
    private String message;
    protected boolean userCaused = false;

    public MailcowRuntimeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message + ((userCaused) ? " Note: This exception does not seem to be caused by a bug or similar within this SDK but instead by a mistake, probably on your side." : " Note: if you think this error should not have occurred or that this is a bug within this library, feel free to open an issue on GitHub.");
    }
}
