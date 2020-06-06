package de.fheuschen.mailcow.sdk.builder;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.annotation.constraint.Length;
import de.fheuschen.mailcow.sdk.annotation.constraint.RequiredField;
import de.fheuschen.mailcow.sdk.builder.helper.FetchableBuilder;
import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.model.Alias;
import de.fheuschen.mailcow.sdk.model.Mailbox;
import de.fheuschen.mailcow.sdk.util.Util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * AliasBuilder
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class AliasBuilder implements FetchableBuilder<Alias, String, AliasBuilder> {

    @RequiredField
    @Length(min = 3)
    private String address;

    @RequiredField
    @Length(min = 3)
    private String goTo;

    @RequiredField
    private boolean active;

    private String identification;

    public AliasBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public AliasBuilder setAddress(Mailbox m) {
        return setAddress(m.getAddress());
    }

    public AliasBuilder setGoTo(String goTo) {
        this.goTo = goTo;
        return this;
    }

    public AliasBuilder setActive(boolean active) {
        this.active = active;
        return this;
    }

    @Override
    public AliasBuilder withId(String id) {
        this.identification = id;
        return this;
    }

    @Override
    public Alias fetch(Mailcow m) throws MailcowException {
        return null;
    }

    @Override
    public Collection<Alias> fetchAll(Mailcow m) throws MailcowException {
        return null;
    }

    @Override
    public Alias create(Mailcow m) throws MailcowException {
        return null;
    }

    @Override
    public Map<String, Object> getCreationMap() {
        Map<String, Object> m = new HashMap<>();
        
        m.put("address", this.address);
        m.put("goto", this.goTo);
        m.put("active", Util.b2mB(this.active));

        return m;
    }

    @Override
    public BaseClient.Endpoint<?> getEndpoint() {
        return null;
    }

    @Override
    public Alias build() {
        return null;
    }
}
