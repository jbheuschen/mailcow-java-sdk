package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.model.outward.OAlias;
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



    private String identification;

    /**
     * Marked as deprecated as no model should never be instantiated manually unless the resulting behavior is intended.
     * @see de.fheuschen.mailcow.sdk.builder.AliasBuilder
     */
    @Deprecated
    public Alias() {
        super(ENDPOINT);
    }

    @Override
    public String getId() {
        return identification;
    }

    @Override
    public OAlias toOModel() {
        return new OAlias(this);
    }
}
