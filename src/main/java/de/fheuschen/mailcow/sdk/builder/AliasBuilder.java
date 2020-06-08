package de.fheuschen.mailcow.sdk.builder;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.annotation.constraint.Length;
import de.fheuschen.mailcow.sdk.annotation.constraint.RequiredField;
import de.fheuschen.mailcow.sdk.builder.helper.ExistenceCheckingBuilder;
import de.fheuschen.mailcow.sdk.builder.helper.FetchableBuilder;
import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.exception.ItemCreationFailedException;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.model.Alias;
import de.fheuschen.mailcow.sdk.model.Mailbox;
import de.fheuschen.mailcow.sdk.util.Util;
import de.fheuschen.mailcow.sdk.validation.Validatable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * AliasBuilder
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class AliasBuilder implements FetchableBuilder<Alias, Integer, AliasBuilder>, ExistenceCheckingBuilder<Integer>, Validatable {

    @RequiredField
    @Length(min = 3)
    private String address;

    @RequiredField
    @Length(min = 3)
    private String goTo;

    @RequiredField
    private boolean active;

    // Learn incoming mails as spam...
    private boolean goToSpam = false;

    private int identification;

    public AliasBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * Attention: the address is NOT the target! This method only exists for mailbox-to-alias migrations!
     * @param m
     * @return
     */
    public AliasBuilder setAddress(Mailbox m) {
        return setAddress(m.getAddress());
    }

    public AliasBuilder setGoTo(String goTo) {
        this.goTo = goTo;
        return this;
    }

    public AliasBuilder setGoTo(Mailbox goTo) {
        this.goTo = goTo.getAddress();
        return this;
    }

    public AliasBuilder setActive(boolean active) {
        this.active = active;
        return this;
    }

    @Override
    public AliasBuilder withId(Integer id) {
        this.identification = id;
        return this;
    }

    @Override
    public Alias fetch(Mailcow m) throws MailcowException {
        return _fetch(m, Alias.ENDPOINT, identification, Alias.class);
    }

    @Override
    public Collection<Alias> fetchAll(Mailcow m) throws MailcowException {
        return null; // TODO
    }

    @Override
    public Alias create(Mailcow m) throws MailcowException {
        if(this._doCreation(m)) {
            Alias t = this.withId(identification).fetch(m);
            if(t == null)
                throw new ItemCreationFailedException("Item creation failed due to an unknown error.");
            return t;
        }
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
        return Alias.ENDPOINT;
    }

    @Override
    @Deprecated
    public Alias build() {
        return new Alias();
    }

    public Alias createSpamAlias(Mailcow m, String address) throws MailcowException {
        // TODO
        this.goToSpam = true;
        this.address = address;
        return this.create(m);
    }

    @Override
    public boolean exists(Mailcow m, Integer id) throws MailcowException {
        return Util.existenceDefImplementation(m, id, new AliasBuilder());
    }
}
