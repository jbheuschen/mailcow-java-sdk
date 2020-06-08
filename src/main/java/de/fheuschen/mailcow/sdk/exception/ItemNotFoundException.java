package de.fheuschen.mailcow.sdk.exception;

/**
 * ItemNotFoundException
 * Indicates that the item you queried for is not available at this time. Maybe it was deleted in the meantime or it never existed.
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class ItemNotFoundException extends MailcowException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}