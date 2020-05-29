package de.fheuschen.mailcow.sdk.model.outward;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.model.MailcowModel;

import java.util.Arrays;

/**
 * OMailcowModel
 * Classes extending this class are intended to be sent to the server (e.g., as part of an update request). This additional layer is required as
 * some fields, unfortunately, have different names than when retrieving them from the server. The use of GSONs alternative names is not possible though,
 * as some of those names collide with others (<i>e.g., 'active' (int) vs 'active' (string) and 'active_int' (int, the actual active)</i>).
 * Moreover, the subclasses only contain properties that can be updated (property such as the used quota - of course - cannot be updated manually).
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public abstract class OMailcowModel<T extends MailcowModel> extends MailcowModel {

    protected T m;

    public OMailcowModel(T m)
    {
        super(m.getEndpoint());
        this.m = m;
    }

    @Override
    public boolean update(Mailcow m) {
        throw new UnsupportedOperationException("Cannot perform this action on OModel!");
    }

    @Override
    public boolean delete(Mailcow m) {
        throw new UnsupportedOperationException("Cannot perform this action on OModel!");
    }

    @Override
    public int getId() {
        return m.getId();
    }

    @Override
    public OMailcowModel<T> toOModel() {
        return this;
    }

    public abstract OWrapper<? extends OMailcowModel<T>> wrap(String... items);
}
