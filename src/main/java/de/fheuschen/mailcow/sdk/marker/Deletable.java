package de.fheuschen.mailcow.sdk.marker;

import de.fheuschen.mailcow.sdk.Mailcow;

/**
 * Deletable
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface Deletable {
    boolean delete(Mailcow m);
}
