package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.model.outward.OMailcowModel;

/**
 * MailcowLogEntry
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class MailcowLogEntry extends ReadOnlyModel {

    public static final BaseClient.Endpoint<MailcowLogEntry> ENDPOINT = new BaseClient.Endpoint<MailcowLogEntry>() {
        @Override
        public String getEndpointUrl() {
            return "";
        }

        @Override
        public String getEditEndpointUrl() {
            return "";
        }

        @Override
        public String getDeleteEndpointUrl() {
            return "";
        }

        @Override
        public String getAddEndpointUrl() {
            return "";
        }
    };

    public String type;
    public Object[] log;

    public MailcowLogEntry() {
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
