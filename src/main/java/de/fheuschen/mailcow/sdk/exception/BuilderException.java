package de.fheuschen.mailcow.sdk.exception;

/**
 * BuilderException
 * Indicates that an error occurred within a builder.
 * @see de.fheuschen.mailcow.sdk.builder.helper.Builder
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class BuilderException extends MailcowRuntimeException {
    public BuilderException(String message) {
        super(message);
    }
}
