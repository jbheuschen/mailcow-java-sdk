package de.fheuschen.mailcow.sdk.builder;

import de.fheuschen.mailcow.sdk.Mailcow;
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
    B withId(I id);
    P fetch(Mailcow m) throws MailcowException;
    Collection<P> fetchAll(Mailcow m) throws MailcowException;
}
