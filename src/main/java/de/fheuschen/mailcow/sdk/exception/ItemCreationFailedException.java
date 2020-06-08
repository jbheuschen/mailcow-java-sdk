package de.fheuschen.mailcow.sdk.exception;

/**
 * ItemCreationFailedException
 * Indicates that the creation of an item failed. Refer to the your server logs and/or the exception message for further details.
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class ItemCreationFailedException extends MailcowException {
    public ItemCreationFailedException(String message) {
        super(message);
    }
}
