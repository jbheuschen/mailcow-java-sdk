package de.fheuschen.mailcow.sdk.exception;

/**
 * ItemCreationFailedException
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class ItemCreationFailedException extends MailcowException {
    public ItemCreationFailedException(String message) {
        super(message);
    }
}
