package de.fheuschen.mailcow.sdk.model;

import com.fasterxml.jackson.annotation.*;
import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.client.BaseClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Domain
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "max_new_mailbox_quota",
        "def_new_mailbox_quota",
        "quota_used_in_domain",
        "bytes_total",
        "msgs_total",
        "mboxes_in_domain",
        "mboxes_left",
        "domain_name",
        "description",
        "max_num_aliases_for_domain",
        "max_num_mboxes_for_domain",
        "def_quota_for_mbox",
        "max_quota_for_mbox",
        "max_quota_for_domain",
        "relayhost",
        "backupmx",
        "gal",
        "backupmx_int",
        "gal_int",
        "rl",
        "active",
        "active_int",
        "relay_all_recipients",
        "relay_unknown_only",
        "relay_all_recipients_int",
        "relay_unknown_only_int",
        "aliases_in_domain",
        "aliases_left",
        "domain_admins"
})
public class Domain extends MailcowModel {

    public static final BaseClient.Endpoint<Domain> ENDPOINT = new BaseClient.Endpoint<Domain>() {
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
    };

    @JsonProperty("max_new_mailbox_quota")
    private Integer maxNewMailboxQuota;
    @JsonProperty("def_new_mailbox_quota")
    private Integer defNewMailboxQuota;
    @JsonProperty("quota_used_in_domain")
    private String quotaUsedInDomain;
    @JsonProperty("bytes_total")
    private Integer bytesTotal;
    @JsonProperty("msgs_total")
    private Integer msgsTotal;
    @JsonProperty("mboxes_in_domain")
    private Integer mboxesInDomain;
    @JsonProperty("mboxes_left")
    private Integer mboxesLeft;
    @JsonProperty("domain_name")
    private String domainName;
    @JsonProperty("description")
    private String description;
    @JsonProperty("max_num_aliases_for_domain")
    private Integer maxNumAliasesForDomain;
    @JsonProperty("max_num_mboxes_for_domain")
    private Integer maxNumMboxesForDomain;
    @JsonProperty("def_quota_for_mbox")
    private Integer defQuotaForMbox;
    @JsonProperty("max_quota_for_mbox")
    private Integer maxQuotaForMbox;
    @JsonProperty("max_quota_for_domain")
    private Integer maxQuotaForDomain;
    @JsonProperty("relayhost")
    private String relayhost;
    @JsonProperty("backupmx")
    private String backupmx;
    @JsonProperty("gal")
    private String gal;
    @JsonProperty("backupmx_int")
    private Integer backupmxInt;
    @JsonProperty("gal_int")
    private Integer galInt;
    @JsonProperty("rl")
    private Boolean rl;
    @JsonProperty("active")
    private String active;
    @JsonProperty("active_int")
    private Integer activeInt;
    @JsonProperty("relay_all_recipients")
    private String relayAllRecipients;
    @JsonProperty("relay_unknown_only")
    private String relayUnknownOnly;
    @JsonProperty("relay_all_recipients_int")
    private Integer relayAllRecipientsInt;
    @JsonProperty("relay_unknown_only_int")
    private Integer relayUnknownOnlyInt;
    @JsonProperty("aliases_in_domain")
    private Integer aliasesInDomain;
    @JsonProperty("aliases_left")
    private Integer aliasesLeft;
    @JsonProperty("domain_admins")
    private String domainAdmins;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Domain(Integer maxNewMailboxQuota, Integer defNewMailboxQuota, String quotaUsedInDomain, Integer bytesTotal, Integer msgsTotal, Integer mboxesInDomain, Integer mboxesLeft, String domainName, String description, Integer maxNumAliasesForDomain, Integer maxNumMboxesForDomain, Integer defQuotaForMbox, Integer maxQuotaForMbox, Integer maxQuotaForDomain, String relayhost, String backupmx, String gal, Integer backupmxInt, Integer galInt, Boolean rl, String active, Integer activeInt, String relayAllRecipients, String relayUnknownOnly, Integer relayAllRecipientsInt, Integer relayUnknownOnlyInt, Integer aliasesInDomain, Integer aliasesLeft, String domainAdmins, Map<String, Object> additionalProperties) {
        super(ENDPOINT);
        this.maxNewMailboxQuota = maxNewMailboxQuota;
        this.defNewMailboxQuota = defNewMailboxQuota;
        this.quotaUsedInDomain = quotaUsedInDomain;
        this.bytesTotal = bytesTotal;
        this.msgsTotal = msgsTotal;
        this.mboxesInDomain = mboxesInDomain;
        this.mboxesLeft = mboxesLeft;
        this.domainName = domainName;
        this.description = description;
        this.maxNumAliasesForDomain = maxNumAliasesForDomain;
        this.maxNumMboxesForDomain = maxNumMboxesForDomain;
        this.defQuotaForMbox = defQuotaForMbox;
        this.maxQuotaForMbox = maxQuotaForMbox;
        this.maxQuotaForDomain = maxQuotaForDomain;
        this.relayhost = relayhost;
        this.backupmx = backupmx;
        this.gal = gal;
        this.backupmxInt = backupmxInt;
        this.galInt = galInt;
        this.rl = rl;
        this.active = active;
        this.activeInt = activeInt;
        this.relayAllRecipients = relayAllRecipients;
        this.relayUnknownOnly = relayUnknownOnly;
        this.relayAllRecipientsInt = relayAllRecipientsInt;
        this.relayUnknownOnlyInt = relayUnknownOnlyInt;
        this.aliasesInDomain = aliasesInDomain;
        this.aliasesLeft = aliasesLeft;
        this.domainAdmins = domainAdmins;
        this.additionalProperties = additionalProperties;
    }

    @Deprecated
    public Domain() {
        super(ENDPOINT);
    }

    @JsonProperty("max_new_mailbox_quota")
    public Integer getMaxNewMailboxQuota() {
        return maxNewMailboxQuota;
    }

    @JsonProperty("max_new_mailbox_quota")
    public void setMaxNewMailboxQuota(Integer maxNewMailboxQuota) {
        this.maxNewMailboxQuota = maxNewMailboxQuota;
    }

    @JsonProperty("def_new_mailbox_quota")
    public Integer getDefNewMailboxQuota() {
        return defNewMailboxQuota;
    }

    @JsonProperty("def_new_mailbox_quota")
    public void setDefNewMailboxQuota(Integer defNewMailboxQuota) {
        this.defNewMailboxQuota = defNewMailboxQuota;
    }

    @JsonProperty("quota_used_in_domain")
    public String getQuotaUsedInDomain() {
        return quotaUsedInDomain;
    }

    @JsonProperty("quota_used_in_domain")
    public void setQuotaUsedInDomain(String quotaUsedInDomain) {
        this.quotaUsedInDomain = quotaUsedInDomain;
    }

    @JsonProperty("bytes_total")
    public Integer getBytesTotal() {
        return bytesTotal;
    }

    @JsonProperty("bytes_total")
    public void setBytesTotal(Integer bytesTotal) {
        this.bytesTotal = bytesTotal;
    }

    @JsonProperty("msgs_total")
    public Integer getMsgsTotal() {
        return msgsTotal;
    }

    @JsonProperty("msgs_total")
    public void setMsgsTotal(Integer msgsTotal) {
        this.msgsTotal = msgsTotal;
    }

    @JsonProperty("mboxes_in_domain")
    public Integer getMboxesInDomain() {
        return mboxesInDomain;
    }

    @JsonProperty("mboxes_in_domain")
    public void setMboxesInDomain(Integer mboxesInDomain) {
        this.mboxesInDomain = mboxesInDomain;
    }

    @JsonProperty("mboxes_left")
    public Integer getMboxesLeft() {
        return mboxesLeft;
    }

    @JsonProperty("mboxes_left")
    public void setMboxesLeft(Integer mboxesLeft) {
        this.mboxesLeft = mboxesLeft;
    }

    @JsonProperty("domain_name")
    public String getDomainName() {
        return domainName;
    }

    @JsonProperty("domain_name")
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("max_num_aliases_for_domain")
    public Integer getMaxNumAliasesForDomain() {
        return maxNumAliasesForDomain;
    }

    @JsonProperty("max_num_aliases_for_domain")
    public void setMaxNumAliasesForDomain(Integer maxNumAliasesForDomain) {
        this.maxNumAliasesForDomain = maxNumAliasesForDomain;
    }

    @JsonProperty("max_num_mboxes_for_domain")
    public Integer getMaxNumMboxesForDomain() {
        return maxNumMboxesForDomain;
    }

    @JsonProperty("max_num_mboxes_for_domain")
    public void setMaxNumMboxesForDomain(Integer maxNumMboxesForDomain) {
        this.maxNumMboxesForDomain = maxNumMboxesForDomain;
    }

    @JsonProperty("def_quota_for_mbox")
    public Integer getDefQuotaForMbox() {
        return defQuotaForMbox;
    }

    @JsonProperty("def_quota_for_mbox")
    public void setDefQuotaForMbox(Integer defQuotaForMbox) {
        this.defQuotaForMbox = defQuotaForMbox;
    }

    @JsonProperty("max_quota_for_mbox")
    public Integer getMaxQuotaForMbox() {
        return maxQuotaForMbox;
    }

    @JsonProperty("max_quota_for_mbox")
    public void setMaxQuotaForMbox(Integer maxQuotaForMbox) {
        this.maxQuotaForMbox = maxQuotaForMbox;
    }

    @JsonProperty("max_quota_for_domain")
    public Integer getMaxQuotaForDomain() {
        return maxQuotaForDomain;
    }

    @JsonProperty("max_quota_for_domain")
    public void setMaxQuotaForDomain(Integer maxQuotaForDomain) {
        this.maxQuotaForDomain = maxQuotaForDomain;
    }

    @JsonProperty("relayhost")
    public String getRelayhost() {
        return relayhost;
    }

    @JsonProperty("relayhost")
    public void setRelayhost(String relayhost) {
        this.relayhost = relayhost;
    }

    @JsonProperty("backupmx")
    public String getBackupmx() {
        return backupmx;
    }

    @JsonProperty("backupmx")
    public void setBackupmx(String backupmx) {
        this.backupmx = backupmx;
    }

    @JsonProperty("gal")
    public String getGal() {
        return gal;
    }

    @JsonProperty("gal")
    public void setGal(String gal) {
        this.gal = gal;
    }

    @JsonProperty("backupmx_int")
    public Integer getBackupmxInt() {
        return backupmxInt;
    }

    @JsonProperty("backupmx_int")
    public void setBackupmxInt(Integer backupmxInt) {
        this.backupmxInt = backupmxInt;
    }

    @JsonProperty("gal_int")
    public Integer getGalInt() {
        return galInt;
    }

    @JsonProperty("gal_int")
    public void setGalInt(Integer galInt) {
        this.galInt = galInt;
    }

    @JsonProperty("rl")
    public Boolean getRl() {
        return rl;
    }

    @JsonProperty("rl")
    public void setRl(Boolean rl) {
        this.rl = rl;
    }

    @JsonProperty("active")
    public String getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(String active) {
        this.active = active;
    }

    @JsonProperty("active_int")
    public Integer getActiveInt() {
        return activeInt;
    }

    @JsonProperty("active_int")
    public void setActiveInt(Integer activeInt) {
        this.activeInt = activeInt;
    }

    @JsonProperty("relay_all_recipients")
    public String getRelayAllRecipients() {
        return relayAllRecipients;
    }

    @JsonProperty("relay_all_recipients")
    public void setRelayAllRecipients(String relayAllRecipients) {
        this.relayAllRecipients = relayAllRecipients;
    }

    @JsonProperty("relay_unknown_only")
    public String getRelayUnknownOnly() {
        return relayUnknownOnly;
    }

    @JsonProperty("relay_unknown_only")
    public void setRelayUnknownOnly(String relayUnknownOnly) {
        this.relayUnknownOnly = relayUnknownOnly;
    }

    @JsonProperty("relay_all_recipients_int")
    public Integer getRelayAllRecipientsInt() {
        return relayAllRecipientsInt;
    }

    @JsonProperty("relay_all_recipients_int")
    public void setRelayAllRecipientsInt(Integer relayAllRecipientsInt) {
        this.relayAllRecipientsInt = relayAllRecipientsInt;
    }

    @JsonProperty("relay_unknown_only_int")
    public Integer getRelayUnknownOnlyInt() {
        return relayUnknownOnlyInt;
    }

    @JsonProperty("relay_unknown_only_int")
    public void setRelayUnknownOnlyInt(Integer relayUnknownOnlyInt) {
        this.relayUnknownOnlyInt = relayUnknownOnlyInt;
    }

    @JsonProperty("aliases_in_domain")
    public Integer getAliasesInDomain() {
        return aliasesInDomain;
    }

    @JsonProperty("aliases_in_domain")
    public void setAliasesInDomain(Integer aliasesInDomain) {
        this.aliasesInDomain = aliasesInDomain;
    }

    @JsonProperty("aliases_left")
    public Integer getAliasesLeft() {
        return aliasesLeft;
    }

    @JsonProperty("aliases_left")
    public void setAliasesLeft(Integer aliasesLeft) {
        this.aliasesLeft = aliasesLeft;
    }

    @JsonProperty("domain_admins")
    public String getDomainAdmins() {
        return domainAdmins;
    }

    @JsonProperty("domain_admins")
    public void setDomainAdmins(String domainAdmins) {
        this.domainAdmins = domainAdmins;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
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
