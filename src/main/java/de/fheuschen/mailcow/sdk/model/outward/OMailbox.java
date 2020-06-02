package de.fheuschen.mailcow.sdk.model.outward;

import de.fheuschen.mailcow.sdk.model.Mailbox;

/**
 * OMailbox
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class OMailbox extends OMailcowModel<Mailbox> {
    public OMailbox(Mailbox m) {
        super(m);
    }

    @Override
    public OWrapper<? extends OMailcowModel<Mailbox>> wrap(String... items) {
        return null;
    }
}
