package de.fheuschen.mailcow.sdk.builder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.model.Domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * DomainBuilder
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class DomainBuilder implements FetchableBuilder<Domain, String, DomainBuilder> {

    private Integer maxNewMailboxQuota;
    private Integer defNewMailboxQuota;
    private String quotaUsedInDomain;
    private Integer bytesTotal;
    private Integer msgsTotal;
    private Integer mboxesInDomain;
    private Integer mboxesLeft;
    private String domainName;
    private String description;
    private Integer maxNumAliasesForDomain;
    private Integer maxNumMboxesForDomain;
    private Integer defQuotaForMbox;
    private Integer maxQuotaForMbox;
    private Integer maxQuotaForDomain;
    private String relayhost;
    private String backupmx;
    private String gal;
    private Integer backupmxInt;
    private Integer galInt;
    private Boolean rl;
    private String active;
    private Integer activeInt;
    private String relayAllRecipients;
    private String relayUnknownOnly;
    private Integer relayAllRecipientsInt;
    private Integer relayUnknownOnlyInt;
    private Integer aliasesInDomain;
    private Integer aliasesLeft;
    private String domainAdmins;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private String identification = Mailcow.ID_ALL;

    public DomainBuilder setMaxNewMailboxQuota(Integer maxNewMailboxQuota) {
        this.maxNewMailboxQuota = maxNewMailboxQuota;
        return this;
    }

    public DomainBuilder setDefNewMailboxQuota(Integer defNewMailboxQuota) {
        this.defNewMailboxQuota = defNewMailboxQuota;
        return this;
    }

    public DomainBuilder setQuotaUsedInDomain(String quotaUsedInDomain) {
        this.quotaUsedInDomain = quotaUsedInDomain;
        return this;
    }

    public DomainBuilder setBytesTotal(Integer bytesTotal) {
        this.bytesTotal = bytesTotal;
        return this;
    }

    public DomainBuilder setMsgsTotal(Integer msgsTotal) {
        this.msgsTotal = msgsTotal;
        return this;
    }

    public DomainBuilder setMboxesInDomain(Integer mboxesInDomain) {
        this.mboxesInDomain = mboxesInDomain;
        return this;
    }

    public DomainBuilder setMboxesLeft(Integer mboxesLeft) {
        this.mboxesLeft = mboxesLeft;
        return this;
    }

    public DomainBuilder setDomainName(String domainName) {
        this.domainName = domainName;
        return this;
    }

    public DomainBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public DomainBuilder setMaxNumAliasesForDomain(Integer maxNumAliasesForDomain) {
        this.maxNumAliasesForDomain = maxNumAliasesForDomain;
        return this;
    }

    public DomainBuilder setMaxNumMboxesForDomain(Integer maxNumMboxesForDomain) {
        this.maxNumMboxesForDomain = maxNumMboxesForDomain;
        return this;
    }

    public DomainBuilder setDefQuotaForMbox(Integer defQuotaForMbox) {
        this.defQuotaForMbox = defQuotaForMbox;
        return this;
    }

    public DomainBuilder setMaxQuotaForMbox(Integer maxQuotaForMbox) {
        this.maxQuotaForMbox = maxQuotaForMbox;
        return this;
    }

    public DomainBuilder setMaxQuotaForDomain(Integer maxQuotaForDomain) {
        this.maxQuotaForDomain = maxQuotaForDomain;
        return this;
    }

    public DomainBuilder setRelayhost(String relayhost) {
        this.relayhost = relayhost;
        return this;
    }

    public DomainBuilder setBackupmx(String backupmx) {
        this.backupmx = backupmx;
        return this;
    }

    public DomainBuilder setGal(String gal) {
        this.gal = gal;
        return this;
    }

    public DomainBuilder setBackupmxInt(Integer backupmxInt) {
        this.backupmxInt = backupmxInt;
        return this;
    }

    public DomainBuilder setGalInt(Integer galInt) {
        this.galInt = galInt;
        return this;
    }

    public DomainBuilder setRl(Boolean rl) {
        this.rl = rl;
        return this;
    }

    public DomainBuilder setActive(String active) {
        this.active = active;
        return this;
    }

    public DomainBuilder setActiveInt(Integer activeInt) {
        this.activeInt = activeInt;
        return this;
    }

    public DomainBuilder setRelayAllRecipients(String relayAllRecipients) {
        this.relayAllRecipients = relayAllRecipients;
        return this;
    }

    public DomainBuilder setRelayUnknownOnly(String relayUnknownOnly) {
        this.relayUnknownOnly = relayUnknownOnly;
        return this;
    }

    public DomainBuilder setRelayAllRecipientsInt(Integer relayAllRecipientsInt) {
        this.relayAllRecipientsInt = relayAllRecipientsInt;
        return this;
    }

    public DomainBuilder setRelayUnknownOnlyInt(Integer relayUnknownOnlyInt) {
        this.relayUnknownOnlyInt = relayUnknownOnlyInt;
        return this;
    }

    public DomainBuilder setAliasesInDomain(Integer aliasesInDomain) {
        this.aliasesInDomain = aliasesInDomain;
        return this;
    }

    public DomainBuilder setAliasesLeft(Integer aliasesLeft) {
        this.aliasesLeft = aliasesLeft;
        return this;
    }

    public DomainBuilder setDomainAdmins(String domainAdmins) {
        this.domainAdmins = domainAdmins;
        return this;
    }

    public DomainBuilder setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    @Override
    public Domain build() {
        return new Domain(maxNewMailboxQuota, defNewMailboxQuota, quotaUsedInDomain, bytesTotal, msgsTotal, mboxesInDomain, mboxesLeft, domainName, description, maxNumAliasesForDomain, maxNumMboxesForDomain, defQuotaForMbox, maxQuotaForMbox, maxQuotaForDomain, relayhost, backupmx, gal, backupmxInt, galInt, rl, active, activeInt, relayAllRecipients, relayUnknownOnly, relayAllRecipientsInt, relayUnknownOnlyInt, aliasesInDomain, aliasesLeft, domainAdmins, additionalProperties);
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
        Collection<Domain> c = m.getClient().performMultiGetRequest(Domain.ENDPOINT, null, Domain.class, Mailcow.ID_ALL);
        return c;
    }

    @Override
    public Domain create() {
        return null;
    }
}
