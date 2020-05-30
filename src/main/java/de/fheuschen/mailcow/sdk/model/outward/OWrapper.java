package de.fheuschen.mailcow.sdk.model.outward;

import de.fheuschen.mailcow.sdk.model.MailcowModel;

import java.util.Collection;

/**
 * OWrapper
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class OWrapper<T extends OMailcowModel<? extends MailcowModel>> extends OMailcowModel<T> implements Wrapper<OWrapper<T>> {

    public Collection<String> items;
    public T attr;

    public OWrapper(Collection<String> items, T m) {
        super(m);
        this.attr = m;
        this.items = items;
    }


    @Override
    public OWrapper<? extends OMailcowModel<T>> wrap(String... items) {
        return (OWrapper<? extends OMailcowModel<T>>) this;
    }

    @Override
    public OWrapper<T> getObjectForSerialization() {
        return this;
    }
}
