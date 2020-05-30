package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.client.BaseClient;

/**
 * ReadOnlyModel
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public abstract class ReadOnlyModel extends MailcowModel {
    public ReadOnlyModel(BaseClient.Endpoint<?> endpoint) {
        super(endpoint);
    }

    @Override
    public boolean update(Mailcow m) {
        throw new UnsupportedOperationException("Read only model!");
    }

    @Override
    public boolean delete(Mailcow m) {
        throw new UnsupportedOperationException("Read only model!");
    }
}
