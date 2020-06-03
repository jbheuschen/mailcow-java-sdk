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
import de.fheuschen.mailcow.sdk.validation.Validateable;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * DomainBuilder
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class DomainBuilder implements FetchableBuilder<Domain, String, DomainBuilder>, Validateable {

    /**
     * Note: required fields are:
     * <ul>
     *     <li>domainName</li>
     *     <li>maxNumAliasesForDomain</li>
     *     <li>maxNumMboxesForDomain</li>
     *     <li>defQuotaForMbox</li>
     *     <li>maxQuotaForMbox</li>
     *     <li>maxQuotaForDomain</li>
     *     <li>activeInt</li>
     * </ul>
     * @return
     */

    @RequiredField
    @Length(min = 2)
    private String domain;

    private String description;

    @RequiredField
    private int aliases;

    @RequiredField
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

    public DomainBuilder setDomainName(String domain) {
        this.domain = domain;
        return this;
    }

    public DomainBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public DomainBuilder setMaxAliases(int aliases) {
        this.aliases = aliases;
        return this;
    }

    public DomainBuilder setMaxMailboxes(int mailboxes) {
        this.mailboxes = mailboxes;
        return this;
    }

    public DomainBuilder setDefaultMailboxQuota(long defaultQuota) {
        this.defaultQuota = defaultQuota;
        return this;
    }

    public DomainBuilder setMaxMailboxQuota(long maxQuota) {
        this.maxQuota = maxQuota;
        return this;
    }

    public DomainBuilder setDomainQuota(long domainQuota) {
        this.domainQuota = domainQuota;
        return this;
    }

    public DomainBuilder setActive(boolean active) {
        this.active = active;
        return this;
    }

    public DomainBuilder setRatelimit(Ratelimit r) {
        this.rlFrame = r.frame;
        this.rlValue = r.value;
        return this;
    }

    public DomainBuilder setBackupmx(boolean backupmx) {
        this.backupmx = backupmx;
        return this;
    }

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

    /**
     * Note: required fields are:
     * <ul>
     *     <li>domainName</li>
     *     <li>maxNumAliasesForDomain</li>
     *     <li>maxNumMboxesForDomain</li>
     *     <li>defQuotaForMbox</li>
     *     <li>maxQuotaForMbox</li>
     *     <li>maxQuotaForDomain</li>
     *     <li>activeInt</li>
     * </ul>
     * @return
     */
    @Override
    public Object[] getRequiredFields() {
        return new Object[0];
    }

    @Override
    public Map<String, Object> getCreationMap() {
        Map<String, Object> m = new HashMap<>();
        m.put("domain", this.domain);
        m.put("description", this.description);
        m.put("aliases", this.description);
        m.put("mailboxes", this.mailboxes);
        m.put("defquota", this.defaultQuota);
        m.put("maxquota", this.maxQuota);
        m.put("quota", this.domainQuota);
        m.put("active", Util.b2mB(this.active));
        return m;
    }

    @Override
    public BaseClient.Endpoint<?> getEndpoint() {
        return Domain.ENDPOINT;
    }
}
