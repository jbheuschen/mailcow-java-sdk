package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.model.outward.OMailcowModel;

/**
 * Alias
 * An alias is an alternative mail-address for a mailbox.
 * @see de.fheuschen.mailcow.sdk.builder.AliasBuilder
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class Alias extends MailcowModel {

    public static final BaseClient.Endpoint<Alias> ENDPOINT = new BaseClient.Endpoint<Alias>() {
        @Override
        public String getEndpointUrl() {
            return "null";
        }

        @Override
        public String getEditEndpointUrl() {
            return "null";
        }

        @Override
        public String getDeleteEndpointUrl() {
            return "null";
        }

        @Override
        public String getAddEndpointUrl() {
            return "null";
        }
    };

    public Alias() {
        super(ENDPOINT);
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public OMailcowModel toOModel() {
        return null;
    }
}
