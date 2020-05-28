package de.fheuschen.mailcow.sdk.builder;

import de.fheuschen.mailcow.sdk.model.Domain;

/**
 * DomainBuilder
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class DomainBuilder implements Builder<Domain> {

    private int maxNewMailboxQuota, defNewMailboxQuota, quotaUsedInDomain, mboxesInDomain, mboxesLeft;
    private int defQuotaForMbox, maxQuotaForMbox, maxQuotaForDomain, backupmxInt, galInt, activeInt, relayAllRecipientsInt,
            aliasesInDomain, aliasesLeft;
    private String domainName, description, relayhost, backupmx, gal, lang, active, relayAllRecipients;
    private boolean rl;

    public DomainBuilder setMaxNewMailboxQuota(int maxNewMailboxQuota) {
        this.maxNewMailboxQuota = maxNewMailboxQuota;
        return this;
    }

    public DomainBuilder setDefNewMailboxQuota(int defNewMailboxQuota) {
        this.defNewMailboxQuota = defNewMailboxQuota;
        return this;
    }

    public DomainBuilder setQuotaUsedInDomain(int quotaUsedInDomain) {
        this.quotaUsedInDomain = quotaUsedInDomain;
        return this;
    }

    public DomainBuilder setMboxesInDomain(int mboxesInDomain) {
        this.mboxesInDomain = mboxesInDomain;
        return this;
    }

    public DomainBuilder setMboxesLeft(int mboxesLeft) {
        this.mboxesLeft = mboxesLeft;
        return this;
    }

    public DomainBuilder setDefQuotaForMbox(int defQuotaForMbox) {
        this.defQuotaForMbox = defQuotaForMbox;
        return this;
    }

    public DomainBuilder setMaxQuotaForMbox(int maxQuotaForMbox) {
        this.maxQuotaForMbox = maxQuotaForMbox;
        return this;
    }

    public DomainBuilder setMaxQuotaForDomain(int maxQuotaForDomain) {
        this.maxQuotaForDomain = maxQuotaForDomain;
        return this;
    }

    public DomainBuilder setBackupmxInt(int backupmxInt) {
        this.backupmxInt = backupmxInt;
        return this;
    }

    public DomainBuilder setGalInt(int galInt) {
        this.galInt = galInt;
        return this;
    }

    public DomainBuilder setActiveInt(int activeInt) {
        this.activeInt = activeInt;
        return this;
    }

    public DomainBuilder setRelayAllRecipientsInt(int relayAllRecipientsInt) {
        this.relayAllRecipientsInt = relayAllRecipientsInt;
        return this;
    }

    public DomainBuilder setAliasesInDomain(int aliasesInDomain) {
        this.aliasesInDomain = aliasesInDomain;
        return this;
    }

    public DomainBuilder setAliasesLeft(int aliasesLeft) {
        this.aliasesLeft = aliasesLeft;
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

    public DomainBuilder setLang(String lang) {
        this.lang = lang;
        return this;
    }

    public DomainBuilder setActive(String active) {
        this.active = active;
        return this;
    }

    public DomainBuilder setRelayAllRecipients(String relayAllRecipients) {
        this.relayAllRecipients = relayAllRecipients;
        return this;
    }

    public DomainBuilder setRl(boolean rl) {
        this.rl = rl;
        return this;
    }

    @Override
    public Domain build() {
        return new Domain(maxNewMailboxQuota, defNewMailboxQuota, quotaUsedInDomain, mboxesInDomain, mboxesLeft, defQuotaForMbox, maxQuotaForMbox, maxQuotaForDomain, backupmxInt, galInt, activeInt, relayAllRecipientsInt, aliasesInDomain, aliasesLeft, domainName, description, relayhost, backupmx, gal, lang, active, relayAllRecipients, rl);
    }
}
