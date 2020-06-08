package de.fheuschen.mailcow.sdk.builder;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.annotation.constraint.Length;
import de.fheuschen.mailcow.sdk.annotation.constraint.Min;
import de.fheuschen.mailcow.sdk.annotation.constraint.NotRequiredField;
import de.fheuschen.mailcow.sdk.annotation.constraint.RequiredField;
import de.fheuschen.mailcow.sdk.builder.helper.ExistenceCheckingBuilder;
import de.fheuschen.mailcow.sdk.builder.helper.FetchableBuilder;
import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.exception.ItemCreationFailedException;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.model.Domain;
import de.fheuschen.mailcow.sdk.model.Mailbox;
import de.fheuschen.mailcow.sdk.util.Util;
import de.fheuschen.mailcow.sdk.validation.Validatable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * MailboxBuilder
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class MailboxBuilder implements FetchableBuilder<Mailbox, String, MailboxBuilder>, ExistenceCheckingBuilder<String>, Validatable {

    @RequiredField
    private String localPart;

    @RequiredField
    private String domain;

    @NotRequiredField
    private String fullName;

    @Length(min = 8)
    private String password;

    @Length(min = 8)
    private String password2;

    @RequiredField
    private boolean active = true;

    @RequiredField
    @Min(min = 1)
    private long quota;


    private String identification = Mailcow.ID_ALL;

    public MailboxBuilder setLocalPart(String localPart) {
        this.localPart = localPart;
        return this;
    }

    public MailboxBuilder setDomain(Domain d) {
        return this.setDomain(d.getId());
    }

    public MailboxBuilder setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public MailboxBuilder setPassword(String password) {
        this.password = password;
        this.password2 = password;
        return this;
    }

    public MailboxBuilder setActive(boolean active) {
        this.active = active;
        return this;
    }

    public MailboxBuilder setQuota(long quota) {
        this.quota = quota;
        return this;
    }

    @Override
    @Deprecated
    public Mailbox build() {
        return new Mailbox();
    }

    @Override
    public MailboxBuilder withId(String id) {
        this.identification = id;
        return this;
    }

    @Override
    public Mailbox fetch(Mailcow m) throws MailcowException {
        return _fetch(m, Mailbox.ENDPOINT, identification, Mailbox.class);
    }

    @Override
    public Collection<Mailbox> fetchAll(Mailcow m) throws MailcowException {
        return m.getClient().performMultiGetRequest(Mailbox.ENDPOINT, null, Mailbox.class, Mailcow.ID_ALL);
    }

    @Override
    public Mailbox create(Mailcow m) throws MailcowException {
        if(this._doCreation(m)) {
            Mailbox t = this.withId(localPart + "@" + domain).fetch(m);
            if(t == null)
                throw new ItemCreationFailedException("Item creation failed due to an unknown error.");
            return t;
        }
        return null;
    }

    @Override
    public Map<String, Object> getCreationMap() {
        Map<String, Object> m = new HashMap<>();

        m.put("local_part", this.localPart);
        m.put("domain", this.domain);
        m.put("quota", this.quota);
        m.put("password", this.password);
        m.put("password2", this.password2);
        m.put("active", Util.b2mB(this.active));

        return m;
    }

    @Override
    public BaseClient.Endpoint<?> getEndpoint() {
        return Mailbox.ENDPOINT;
    }

    @Override
    public boolean exists(Mailcow m, String id) throws MailcowException {
        return Util.existenceDefImplementation(m, id, new MailboxBuilder());
    }
}
