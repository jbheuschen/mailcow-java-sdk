package de.fheuschen.mailcow.sdk.builder.helper;

import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.model.MailcowModel;

/**
 * CreationEndpoint
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface CreationEndpoint<T extends MailcowModel> extends BaseClient.Endpoint<T> {
    @Override
    default String getDeleteEndpointUrl() {
        return "";
    }

    @Override
    default String getEditEndpointUrl() {
        return "";
    }
}
