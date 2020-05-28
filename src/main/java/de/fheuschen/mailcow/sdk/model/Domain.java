package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.client.BaseClient;

/**
 * Domain
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class Domain extends MailcowModel {
    int maxNewMailboxQuota, defNewMailboxQuota, quotaUsedInDomain, mboxesInDomain, mboxesLeft;
    int defQuotaForMbox, maxQuotaForMbox, maxQuotaForDomain, backupmxInt, galInt, activeInt, relayAllRecipientsInt,
        aliasesInDomain, aliasesLeft;
    String domainName, description, relayhost, backupmx, gal, lang, active, relayAllRecipients;
    boolean rl;

    public Domain(int maxNewMailboxQuota, int defNewMailboxQuota, int quotaUsedInDomain, int mboxesInDomain, int mboxesLeft, int defQuotaForMbox, int maxQuotaForMbox, int maxQuotaForDomain, int backupmxInt, int galInt, int activeInt, int relayAllRecipientsInt, int aliasesInDomain, int aliasesLeft, String domainName, String description, String relayhost, String backupmx, String gal, String lang, String active, String relayAllRecipients, boolean rl) {
        super(new BaseClient.Endpoint<MailcowModel>() {
            @Override
            public String getEndpointUrl() {
                return "get/domain/";
            }

            @Override
            public String getEditEndpointUrl() {
                return "edit/domain/";
            }

            @Override
            public String getDeleteEndpointUrl() {
                return "delete/domain/";
            }

            @Override
            public String getAddEndpointUrl() {
                return "add/domain/";
            }
        });
        this.maxNewMailboxQuota = maxNewMailboxQuota;
        this.defNewMailboxQuota = defNewMailboxQuota;
        this.quotaUsedInDomain = quotaUsedInDomain;
        this.mboxesInDomain = mboxesInDomain;
        this.mboxesLeft = mboxesLeft;
        this.defQuotaForMbox = defQuotaForMbox;
        this.maxQuotaForMbox = maxQuotaForMbox;
        this.maxQuotaForDomain = maxQuotaForDomain;
        this.backupmxInt = backupmxInt;
        this.galInt = galInt;
        this.activeInt = activeInt;
        this.relayAllRecipientsInt = relayAllRecipientsInt;
        this.aliasesInDomain = aliasesInDomain;
        this.aliasesLeft = aliasesLeft;
        this.domainName = domainName;
        this.description = description;
        this.relayhost = relayhost;
        this.backupmx = backupmx;
        this.gal = gal;
        this.lang = lang;
        this.active = active;
        this.relayAllRecipients = relayAllRecipients;
        this.rl = rl;
    }

    public int getMaxNewMailboxQuota() {
        return maxNewMailboxQuota;
    }

    public void setMaxNewMailboxQuota(int maxNewMailboxQuota) {
        this.maxNewMailboxQuota = maxNewMailboxQuota;
    }

    public int getDefNewMailboxQuota() {
        return defNewMailboxQuota;
    }

    public void setDefNewMailboxQuota(int defNewMailboxQuota) {
        this.defNewMailboxQuota = defNewMailboxQuota;
    }

    public int getQuotaUsedInDomain() {
        return quotaUsedInDomain;
    }

    public void setQuotaUsedInDomain(int quotaUsedInDomain) {
        this.quotaUsedInDomain = quotaUsedInDomain;
    }

    public int getMboxesInDomain() {
        return mboxesInDomain;
    }

    public void setMboxesInDomain(int mboxesInDomain) {
        this.mboxesInDomain = mboxesInDomain;
    }

    public int getMboxesLeft() {
        return mboxesLeft;
    }

    public void setMboxesLeft(int mboxesLeft) {
        this.mboxesLeft = mboxesLeft;
    }

    public int getDefQuotaForMbox() {
        return defQuotaForMbox;
    }

    public void setDefQuotaForMbox(int defQuotaForMbox) {
        this.defQuotaForMbox = defQuotaForMbox;
    }

    public int getMaxQuotaForMbox() {
        return maxQuotaForMbox;
    }

    public void setMaxQuotaForMbox(int maxQuotaForMbox) {
        this.maxQuotaForMbox = maxQuotaForMbox;
    }

    public int getMaxQuotaForDomain() {
        return maxQuotaForDomain;
    }

    public void setMaxQuotaForDomain(int maxQuotaForDomain) {
        this.maxQuotaForDomain = maxQuotaForDomain;
    }

    public int getBackupmxInt() {
        return backupmxInt;
    }

    public void setBackupmxInt(int backupmxInt) {
        this.backupmxInt = backupmxInt;
    }

    public int getGalInt() {
        return galInt;
    }

    public void setGalInt(int galInt) {
        this.galInt = galInt;
    }

    public int getActiveInt() {
        return activeInt;
    }

    public void setActiveInt(int activeInt) {
        this.activeInt = activeInt;
    }

    public int getRelayAllRecipientsInt() {
        return relayAllRecipientsInt;
    }

    public void setRelayAllRecipientsInt(int relayAllRecipientsInt) {
        this.relayAllRecipientsInt = relayAllRecipientsInt;
    }

    public int getAliasesInDomain() {
        return aliasesInDomain;
    }

    public void setAliasesInDomain(int aliasesInDomain) {
        this.aliasesInDomain = aliasesInDomain;
    }

    public int getAliasesLeft() {
        return aliasesLeft;
    }

    public void setAliasesLeft(int aliasesLeft) {
        this.aliasesLeft = aliasesLeft;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelayhost() {
        return relayhost;
    }

    public void setRelayhost(String relayhost) {
        this.relayhost = relayhost;
    }

    public String getBackupmx() {
        return backupmx;
    }

    public void setBackupmx(String backupmx) {
        this.backupmx = backupmx;
    }

    public String getGal() {
        return gal;
    }

    public void setGal(String gal) {
        this.gal = gal;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getRelayAllRecipients() {
        return relayAllRecipients;
    }

    public void setRelayAllRecipients(String relayAllRecipients) {
        this.relayAllRecipients = relayAllRecipients;
    }

    public boolean isRl() {
        return rl;
    }

    public void setRl(boolean rl) {
        this.rl = rl;
    }

    @Override
    public int getId() {
        // TODO
        return 0;
    }

    @Override
    public boolean delete(Mailcow m) {
        return false;
    }

    @Override
    public boolean update(Mailcow m) {
        return false;
    }
}
