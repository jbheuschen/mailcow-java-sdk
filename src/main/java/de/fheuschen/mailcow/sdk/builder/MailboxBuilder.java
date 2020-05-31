package de.fheuschen.mailcow.sdk.builder;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.model.Mailbox;

import java.util.Collection;
import java.util.Map;

/**
 * MailboxBuilder
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class MailboxBuilder implements FetchableBuilder<Mailbox, String, MailboxBuilder> {

    private int maxNewQuota, isRelayed, activeInt, quotaUsed, percentInUse, messages, spamAliases;
    private long quota;
    private boolean rl;
    private String username, name, active, domain, local_part, percentClass;
    private Map<String, String> attributes;

    private String identification = Mailcow.ID_ALL;

    public MailboxBuilder setMaxNewQuota(int maxNewQuota) {
        this.maxNewQuota = maxNewQuota;
        return this;
    }

    public MailboxBuilder setIsRelayed(int isRelayed) {
        this.isRelayed = isRelayed;
        return this;
    }

    public MailboxBuilder setActiveInt(int activeInt) {
        this.activeInt = activeInt;
        return this;
    }

    public MailboxBuilder setQuotaUsed(int quotaUsed) {
        this.quotaUsed = quotaUsed;
        return this;
    }

    public MailboxBuilder setPercentInUse(int percentInUse) {
        this.percentInUse = percentInUse;
        return this;
    }

    public MailboxBuilder setMessages(int messages) {
        this.messages = messages;
        return this;
    }

    public MailboxBuilder setSpamAliases(int spamAliases) {
        this.spamAliases = spamAliases;
        return this;
    }

    public MailboxBuilder setQuota(long quota) {
        this.quota = quota;
        return this;
    }

    public MailboxBuilder setRl(boolean rl) {
        this.rl = rl;
        return this;
    }

    public MailboxBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public MailboxBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MailboxBuilder setActive(String active) {
        this.active = active;
        return this;
    }

    public MailboxBuilder setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public MailboxBuilder setLocal_part(String local_part) {
        this.local_part = local_part;
        return this;
    }

    public MailboxBuilder setPercentClass(String percentClass) {
        this.percentClass = percentClass;
        return this;
    }

    public MailboxBuilder setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
        return this;
    }

    @Override
    public Mailbox build() {
        return new Mailbox(maxNewQuota, isRelayed, activeInt, quotaUsed, percentInUse, messages, spamAliases, quota, rl, username, name, active, domain, local_part, percentClass, attributes);
    }

    @Override
    public MailboxBuilder withId(String id) {
        this.identification = id;
        return this;
    }

    @Override
    public Mailbox fetch(Mailcow m) throws MailcowException {
        if(this.identification == null)
            throw new IllegalStateException("You must provide an id you want to fetch.");
        return null;
    }

    @Override
    public Collection<Mailbox> fetchAll(Mailcow m) throws MailcowException {
        return null;
    }

    @Override
    public Mailbox create(Mailcow m) {
        return null;
    }

    @Override
    public Object[] getRequiredFields() {
        return new Object[0];
    }

    @Override
    public Map<String, Object> getCreationMap() {
        return null;
    }

    @Override
    public BaseClient.Endpoint<?> getEndpoint() {
        return null;
    }
}
