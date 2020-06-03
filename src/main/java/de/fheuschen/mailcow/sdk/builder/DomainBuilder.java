package de.fheuschen.mailcow.sdk.builder;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.annotation.constraint.Length;
import de.fheuschen.mailcow.sdk.annotation.constraint.Min;
import de.fheuschen.mailcow.sdk.annotation.constraint.RequiredField;
import de.fheuschen.mailcow.sdk.builder.helper.FetchableBuilder;
import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.model.Domain;
import de.fheuschen.mailcow.sdk.ratelimit.Ratelimit;
import de.fheuschen.mailcow.sdk.ratelimit.RatelimitFrame;
import de.fheuschen.mailcow.sdk.util.Util;
import de.fheuschen.mailcow.sdk.validation.Validatable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * DomainBuilder
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class DomainBuilder implements FetchableBuilder<Domain, String, DomainBuilder>, Validatable {

    @RequiredField
    @Length(min = 2)
    private String domain;

    private String description;

    @RequiredField
    @Min(min = 1)
    private int aliases;

    @RequiredField
    @Min(min = 1)
    private int mailboxes;

    @RequiredField
    private long defaultQuota;

    @RequiredField
    private long maxQuota;

    @RequiredField
    private long domainQuota;

    @RequiredField
    private boolean active;

    private RatelimitFrame rlFrame;

    private long rlValue;

    private boolean backupmx;

    private boolean relayAllRecipients;

    private String identification = Mailcow.ID_ALL;

    /*
    More fluent methods
     */

    /**
     * Sets the desired domain name. Must be a valid dns name (e.g., <i>google.com</i> or <i>test.fheuschen.de</i>). Must not be null.
     * Required.
     * @param domain the domain name
     * @return this
     */
    public DomainBuilder setDomainName(String domain) {
        this.domain = domain;
        return this;
    }

    /**
     * Sets the domain description.
     * @param description the description. Visible in the Mailcow UI.
     * @return this
     */
    public DomainBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Sets the max amount of aliases for this domain. Must be a value greater than zero.
     * Required.
     * @param aliases the max amount of aliases.
     * @return this
     */
    public DomainBuilder setMaxAliases(int aliases) {
        this.aliases = aliases;
        return this;
    }

    /**
     * Sets the max amount of mailboxes for this domain. Must be a value greater than zero.
     * Required.
     * @param mailboxes the max amount of mailboxes.
     * @return this
     */
    public DomainBuilder setMaxMailboxes(int mailboxes) {
        this.mailboxes = mailboxes;
        return this;
    }

    /**
     * Sets the default quota for a mailbox within this domain. Must be a value greater than zero but smaller or equal to the max quota.
     * @param defaultQuota the quota.
     * @see de.fheuschen.mailcow.sdk.util.QuotaUnit
     * @return this
     */
    public DomainBuilder setDefaultMailboxQuota(long defaultQuota) {
        this.defaultQuota = defaultQuota;
        return this;
    }

    /**
     * Sets the max quota for a mailbox within this domain. Must be a value greater than zero but smaller or equal to the max domain quota.
     * @param maxQuota the quota.
     * @see de.fheuschen.mailcow.sdk.util.QuotaUnit
     * @return this
     */
    public DomainBuilder setMaxMailboxQuota(long maxQuota) {
        this.maxQuota = maxQuota;
        return this;
    }

    /**
     * Sets the max quota for this domain. Must be a value greater than zero.
     * @param domainQuota the quota.
     * @see de.fheuschen.mailcow.sdk.util.QuotaUnit
     * @return this
     */
    public DomainBuilder setDomainQuota(long domainQuota) {
        this.domainQuota = domainQuota;
        return this;
    }

    /**
     * Sets whether this domain is active or inactive (i.e., mailboxes of this domain cannot be used and emails are rejected).
     * @param active true/false
     * @return this
     */
    public DomainBuilder setActive(boolean active) {
        this.active = active;
        return this;
    }

    /**
     * Sets the ratelimit for this domain. Use {@code Ratelimit.INFINITE} to disable the ratelimit.
     * @param r the ratelimit
     * @see Ratelimit#INFINITE
     * @see Ratelimit
     * @return this
     */
    public DomainBuilder setRatelimit(Ratelimit r) {
        this.rlFrame = r.frame;
        this.rlValue = r.value;
        return this;
    }

    /**
     * Sets whether this server functions as a backup mx.
     * @param backupmx true/false
     * @return this
     */
    public DomainBuilder setBackupmx(boolean backupmx) {
        this.backupmx = backupmx;
        return this;
    }

    /**
     *
     * @param relayAllRecipients true/false
     * @return this
     */
    public DomainBuilder setRelayAllRecipients(boolean relayAllRecipients) {
        this.relayAllRecipients = relayAllRecipients;
        return this;
    }

    @Override
    @Deprecated
    public Domain build() {
        return new Domain();
    }

    @Override
    public DomainBuilder withId(String id) {
        this.identification = id;
        return this;
    }

    @Override
    public Domain fetch(Mailcow m) throws MailcowException {
        if(this.identification == null)
            throw new IllegalStateException("You must provide an id you want to fetch.");
        return m.getClient().performGetRequest(Domain.ENDPOINT, null, Domain.class, this.identification);
    }

    @Override
    public Collection<Domain> fetchAll(Mailcow m) throws MailcowException {
        return m.getClient().performMultiGetRequest(Domain.ENDPOINT, null, Domain.class, Mailcow.ID_ALL);
    }

    @Override
    public Domain create(Mailcow m) throws MailcowException {
        if(this._doCreation(m)) {
            return this.withId(domain).fetch(m);
        }
        return null;
    }

    @Override
    public Map<String, Object> getCreationMap() {
        Map<String, Object> m = new HashMap<>();
        m.put("domain", this.domain);
        m.put("description", this.description);
        m.put("aliases", this.aliases);
        m.put("mailboxes", this.mailboxes);
        m.put("defquota", this.defaultQuota);
        m.put("maxquota", this.maxQuota);
        m.put("quota", this.domainQuota);
        m.put("active", Util.b2mB(this.active));
        m.put("rl_value", this.rlValue);
        m.put("rl_frame", this.rlFrame);
        m.put("backupmx", this.backupmx);
        m.put("relay_all_recipients", this.relayAllRecipients);
        return m;
    }

    @Override
    public BaseClient.Endpoint<?> getEndpoint() {
        return Domain.ENDPOINT;
    }
}
