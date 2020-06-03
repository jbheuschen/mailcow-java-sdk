package de.fheuschen.mailcow.sdk.model.outward;

import de.fheuschen.mailcow.sdk.model.Mailbox;
import de.fheuschen.mailcow.sdk.util.Attributes;

import java.util.Arrays;

/**
 * OMailbox
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class OMailbox extends OMailcowModel<Mailbox> {

    String name, quota, password, password2, active, force_pw_update, sogo_access;
    String[] sender_acl;

    public OMailbox(Mailbox m) {
        super(m);
        this.name = m.getName();
        this.quota = String.valueOf(m.getQuota());
        this.password = m.getChangedPassword();
        this.password2 = m.getChangedPassword();
        this.active = m.getActive();
        this.force_pw_update = m.getAttribute(Attributes.MB_FORCE_PW_UPDATE);
        this.sogo_access = m.getAttribute(Attributes.MB_SOGO_ACCESS);
        this.sender_acl = null;
    }

    @Override
    public OWrapper<? extends OMailcowModel<Mailbox>> wrap(String... items) {
        return new OWrapper<>(Arrays.asList(items), this);
    }
}
