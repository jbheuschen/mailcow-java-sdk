package de.fheuschen.mailcow.sdk.marker;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.exception.MailcowException;

/**
 * Updateable
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface Updateable {
    boolean update(Mailcow m) throws MailcowException;
}
