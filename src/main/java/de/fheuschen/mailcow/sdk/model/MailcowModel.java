package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.marker.Deletable;
import de.fheuschen.mailcow.sdk.marker.Updateable;
import de.fheuschen.mailcow.sdk.model.outward.ODeletePacket;
import de.fheuschen.mailcow.sdk.model.outward.OMailcowModel;
import de.fheuschen.mailcow.sdk.util.RequestType;

/**
 * MailcowModel
 * This class is the super-class to all mailcow models and one of the fundamental classes of this sdk. It contains several
 * abstract methods for all models to implement (e.g., identification or deletion) as well as pre-implemented methods for item
 * deletion and updating.
 * All non-private, non-static fields within this class are marked as transient, and thus not affecting serialization.
 * This class implements the {@code Deletable} and {@code Updateable} interfaces which makes it possible to pass mailcow models
 * of any kind just as Deletable, Updateable (or MailcowModel), depending on what you need it for.
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

    /**
     * Sends a delete request for this object. Note: deleting fundamental objects such as domains will result in the deletion of their related "child-objects" (such as mailboxes) as well.
     * @param m the mailcow api
     * @return true/false
     * @throws MailcowException if an error occurs.
     */
    @Override
    public boolean delete(Mailcow m) throws MailcowException {
        return m.getClient().performDelete(this, null, this.getDeletePacketById());
    }

    /**
     * Sends an update request for all writeable properties to the server.
     * @param m the mailcow api.
     * @return true/false
     * @throws MailcowException if an error occurs.
     */
    @Override
    public boolean update(Mailcow m) throws MailcowException {
        return m.getClient().performPostRequest(endpoint, RequestType.UPDATE, null, this.toOModel(), this.getId()).getStatus() < BaseClient.ERROR_THRESHOLD;
    }

    /**
     * Converts this model into a serializable output model. You should not be required to call this method manually unless you want to
     * write your own client implementation!
     * @return an OMailcowModel<T>
     */
    public abstract OMailcowModel toOModel();

    /**
     * Generates a deletion packet for this model.
     * @return a deletion packet.
     */
    protected ODeletePacket getDeletePacketById() {
        return new ODeletePacket(this.getId());
    }

    /**
     * Merges this instance's deletion packet with the given packet. Useful for batch deletions (i.e., deleting many items at once).
     * @param with an existing deletion packet.
     * @return the merged packet.
     */
    protected ODeletePacket mergeOwnDeletePacket(ODeletePacket with) {
        return with.mergeWith(this.getDeletePacketById());
    }

}
