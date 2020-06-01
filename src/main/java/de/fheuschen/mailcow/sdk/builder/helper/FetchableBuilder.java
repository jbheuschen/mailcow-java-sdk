package de.fheuschen.mailcow.sdk.builder.helper;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.builder.helper.Builder;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.model.MailcowModel;

import java.util.Collection;

/**
 * Interface for builder classes that can also retrieve objects from the api.
 * @author Julian B. Heuschen <julian@fheuschen.de>
 * @param <P> the class of the object to be built. Equals to Builder<P>
 * @param <I> the type of identification used for this object. E.g., ids only consisting of numbers would be Integer whereas numbers and strings combined (or uuids) would be Strings.
 * @param <B> the implementing class. Required to build the correct builder-style method.
 */
public interface FetchableBuilder<P extends MailcowModel, I, B extends Builder<P>> extends Builder<P> {
    /**
     * Sets the id to be fetched.
     * @param id the id
     * @see #fetch(Mailcow)
     * @return the builder itself
     */
    B withId(I id);

    /**
     * Fetches a single item.
     * @param m the mailcow object
     * @return the item or null
     * @throws MailcowException if a severe error occurs
     */
    P fetch(Mailcow m) throws MailcowException;

    /**
     * Fetches multiple items.
     * @param m the mailcow object.
     * @return a(n empty) list of items.
     * @throws MailcowException if a severe error occurs.
     */
    Collection<P> fetchAll(Mailcow m) throws MailcowException;
}
