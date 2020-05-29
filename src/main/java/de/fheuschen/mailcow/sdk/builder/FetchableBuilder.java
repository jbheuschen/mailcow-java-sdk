package de.fheuschen.mailcow.sdk.builder;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.exception.MailcowException;

/**
 * FetchableBuilder
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface FetchableBuilder<P, I, B> extends Builder<P> {
    B withId(I id);
    P fetch(Mailcow m) throws MailcowException;
}
