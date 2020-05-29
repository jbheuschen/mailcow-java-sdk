package de.fheuschen.mailcow.sdk.exception;

/**
 * ItemNotFoundException
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class ItemNotFoundException extends MailcowException {
    public ItemNotFoundException(String message) {
        super(message);
    }
}
