package de.fheuschen.mailcow.sdk.builder.helper;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.exception.MailcowException;

/**
 * ExistenceCheckingBuilder
 * A builder with the ability to check for the existence of items (by their id).
 * @param <I> the type of identification used for this kind of object.
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface ExistenceCheckingBuilder<I> {

    /**
     * Checks whether an item with the given id exists.
     * @param id the id. Refer to the model's documentation for more information on the type of identification required.
     * @param m the mailcow api object. Required to contact the api.
     * @throws MailcowException any exception thrown during the check (except for ItemNotFoundException) is rethrown as its not
     * this methods responsibility to test for network issues or similar.
     * @return true if the item exists, otherwise false.
     */
    boolean exists(Mailcow m, I id) throws MailcowException;

}
