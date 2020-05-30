package de.fheuschen.mailcow.sdk.marker;

import de.fheuschen.mailcow.sdk.Mailcow;

/**
 * Updateable
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface Updateable {
    boolean update(Mailcow m);
}
