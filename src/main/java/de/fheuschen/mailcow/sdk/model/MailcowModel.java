package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.marker.Deletable;
import de.fheuschen.mailcow.sdk.marker.Updateable;
import de.fheuschen.mailcow.sdk.model.outward.ODeletePacket;
import de.fheuschen.mailcow.sdk.model.outward.OMailcowModel;
import de.fheuschen.mailcow.sdk.util.RequestType;

/**
 * MailcowModel
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public abstract class MailcowModel implements Deletable, Updateable {

    final transient BaseClient.Endpoint<?> endpoint;

    public static BaseClient.Endpoint ENDPOINT = null;

    public MailcowModel(BaseClient.Endpoint<?> endpoint) {
        this.endpoint = endpoint;
    }

    public BaseClient.Endpoint<?> getEndpoint() {
        return endpoint;
    }

    public abstract String getId();

    @Override
    public boolean delete(Mailcow m) {
        return m.getClient().performDelete(this, null, this.getDeletePacketById());
    }

    @Override
    public boolean update(Mailcow m) {
        return m.getClient().performPostRequest(endpoint, RequestType.UPDATE, null, this.toOModel(), this.getId()).getStatus() < 400;
    }

    public abstract OMailcowModel toOModel();

    protected ODeletePacket getDeletePacketById() {
        return new ODeletePacket(this.getId());
    }

    protected ODeletePacket mergeOwnDeletePacket(ODeletePacket with) {
        return with.mergeWith(this.getDeletePacketById());
    }

}
