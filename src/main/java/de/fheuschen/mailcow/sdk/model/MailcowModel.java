package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.client.BaseClient;

/**
 * MailcowModel
 * (Marker Class)
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public abstract class MailcowModel {

    final BaseClient.Endpoint<?> endpoint;

    MailcowModel(BaseClient.Endpoint<?> endpoint) {
        this.endpoint = endpoint;
    }

    public BaseClient.Endpoint<?> getEndpoint() {
        return endpoint;
    }

}
