package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.client.BaseClient;

import java.util.Map;

/**
 * Mailbox
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class Mailbox extends MailcowModel {

    int maxNewQuota, isRelayed, activeInt, quotaUsed, percentInUse, messages, spamAliases;
    long quota;
    boolean rl;
    String username, name, active, domain, local_part, percentClass;
    Map<String, String> attributes;

    public Mailbox(int maxNewQuota, int isRelayed, int activeInt, int quotaUsed, int percentInUse, int messages, int spamAliases, long quota, boolean rl, String username, String name, String active, String domain, String local_part, String percentClass, Map<String, String> attributes) {
        super(new BaseClient.Endpoint<MailcowModel>() {
            @Override
            public String getEndpointUrl() {
                return "get/mailbox/";
            }

            @Override
            public String getEditEndpointUrl() {
                return "edit/mailbox/";
            }

            @Override
            public String getDeleteEndpointUrl() {
                return "delete/mailbox/";
            }

            @Override
            public String getAddEndpointUrl() {
                return "add/mailbox/";
            }
        });
        this.maxNewQuota = maxNewQuota;
        this.isRelayed = isRelayed;
        this.activeInt = activeInt;
        this.quotaUsed = quotaUsed;
        this.percentInUse = percentInUse;
        this.messages = messages;
        this.spamAliases = spamAliases;
        this.quota = quota;
        this.rl = rl;
        this.username = username;
        this.name = name;
        this.active = active;
        this.domain = domain;
        this.local_part = local_part;
        this.percentClass = percentClass;
        this.attributes = attributes;
    }

    public int getMaxNewQuota() {
        return maxNewQuota;
    }

    public void setMaxNewQuota(int maxNewQuota) {
        this.maxNewQuota = maxNewQuota;
    }

    public int getIsRelayed() {
        return isRelayed;
    }

    public void setIsRelayed(int isRelayed) {
        this.isRelayed = isRelayed;
    }

    public int getActiveInt() {
        return activeInt;
    }

    public void setActiveInt(int activeInt) {
        this.activeInt = activeInt;
    }

    public int getQuotaUsed() {
        return quotaUsed;
    }

    public void setQuotaUsed(int quotaUsed) {
        this.quotaUsed = quotaUsed;
    }

    public int getPercentInUse() {
        return percentInUse;
    }

    public void setPercentInUse(int percentInUse) {
        this.percentInUse = percentInUse;
    }

    public int getMessages() {
        return messages;
    }

    public void setMessages(int messages) {
        this.messages = messages;
    }

    public int getSpamAliases() {
        return spamAliases;
    }

    public void setSpamAliases(int spamAliases) {
        this.spamAliases = spamAliases;
    }

    public long getQuota() {
        return quota;
    }

    public void setQuota(long quota) {
        this.quota = quota;
    }

    public boolean isRl() {
        return rl;
    }

    public void setRl(boolean rl) {
        this.rl = rl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLocal_part() {
        return local_part;
    }

    public void setLocal_part(String local_part) {
        this.local_part = local_part;
    }

    public String getPercentClass() {
        return percentClass;
    }

    public void setPercentClass(String percentClass) {
        this.percentClass = percentClass;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }
}
