package de.fheuschen.mailcow.sdk.model;

import com.fasterxml.jackson.annotation.*;
import com.google.gson.annotations.SerializedName;
import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.model.outward.ODomain;
import de.fheuschen.mailcow.sdk.model.outward.OMailcowModel;
import de.fheuschen.mailcow.sdk.util.RequestType;

import javax.ws.rs.core.Response;
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

    public Domain(long maxNewMailboxQuota, long defNewMailboxQuota, String quotaUsedInDomain, long bytesTotal, int msgsTotal, int mboxesInDomain, int mboxesLeft, String domainName, String description, int maxNumAliasesForDomain, int maxNumMboxesForDomain, long defQuotaForMbox, int maxQuotaForMbox, int maxQuotaForDomain, String relayhost, String backupmx, String gal, int backupmxInt, int galInt, Boolean rl, String active, int activeInt, String relayAllRecipients, String relayUnknownOnly, int relayAllRecipientsInt, int relayUnknownOnlyInt, int aliasesInDomain, int aliasesLeft, String domainAdmins, Map<String, Object> additionalProperties) {
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

    @JsonProperty("max_new_mailbox_quota")
    @SerializedName(value = "max_new_mailbox_quota", alternate = {})
    private long maxNewMailboxQuota;
    @JsonProperty("def_new_mailbox_quota")
    @SerializedName(value = "def_new_mailbox_quota", alternate = {})
    private long defNewMailboxQuota;
    @JsonProperty("quota_used_in_domain")
    @SerializedName(value = "quota_used_in_domain", alternate = {})
    private String quotaUsedInDomain;
    @JsonProperty("bytes_total")
    @SerializedName(value = "bytes_total", alternate = {})
    private long bytesTotal;
    @JsonProperty("msgs_total")
    @SerializedName(value = "msgs_total", alternate = {})
    private int msgsTotal;
    @JsonProperty("mboxes_in_domain")
    @SerializedName(value = "mboxes_in_domain", alternate = {})
    private int mboxesInDomain;
    @JsonProperty("mboxes_left")
    @SerializedName(value = "mboxes_left", alternate = {})
    private int mboxesLeft;
    @JsonProperty("domain_name")
    @SerializedName(value = "domain_name", alternate = {})
    private String domainName;
    @JsonProperty("description")
    @SerializedName(value = "description", alternate = {})
    private String description;
    @JsonProperty("max_num_aliases_for_domain")
    @SerializedName(value = "max_num_aliases_for_domain", alternate = {})
    private int maxNumAliasesForDomain;
    @JsonProperty("max_num_mboxes_for_domain")
    @SerializedName(value = "max_num_mboxes_for_domain", alternate = {})
    private int maxNumMboxesForDomain;
    @JsonProperty("def_quota_for_mbox")
    @SerializedName(value = "def_quota_for_mbox", alternate = {})
    private long defQuotaForMbox;
    @JsonProperty("max_quota_for_mbox")
    @SerializedName(value = "max_quota_for_mbox", alternate = {})
    private long maxQuotaForMbox;
    @JsonProperty("max_quota_for_domain")
    @SerializedName(value = "max_quota_for_domain", alternate = {})
    private long maxQuotaForDomain;
    @JsonProperty("relayhost")
    @SerializedName(value = "relayhost", alternate = {})
    private String relayhost;
    @JsonProperty("backupmx")
    @SerializedName(value = "backupmx", alternate = {})
    private String backupmx;
    @JsonProperty("gal")
    @SerializedName(value = "gal", alternate = {})
    private String gal;
    @JsonProperty("backupmx_int")
    @SerializedName(value = "backupmx_int", alternate = {})
    private int backupmxInt;
    @JsonProperty("gal_int")
    @SerializedName(value = "gal_int", alternate = {})
    private int galInt;
    @JsonProperty("rl")
    @SerializedName(value = "rl", alternate = {})
    private Boolean rl;
    @JsonProperty("active")
    @SerializedName(value = "active", alternate = {})
    private String active;
    @JsonProperty("active_int")
    @SerializedName(value = "active_int", alternate = {})
    private int activeInt;
    @JsonProperty("relay_all_recipients")
    @SerializedName(value = "relay_all_recipients", alternate = {})
    private String relayAllRecipients;
    @JsonProperty("relay_unknown_only")
    @SerializedName(value = "relay_unknown_only", alternate = {})
    private String relayUnknownOnly;
    @JsonProperty("relay_all_recipients_int")
    @SerializedName(value = "relay_all_recipients_int", alternate = {})
    private int relayAllRecipientsInt;
    @JsonProperty("relay_unknown_only_int")
    @SerializedName(value = "relay_unknown_only_int", alternate = {})
    private int relayUnknownOnlyInt;
    @JsonProperty("aliases_in_domain")
    @SerializedName(value = "aliases_in_domain", alternate = {})
    private int aliasesInDomain;
    @JsonProperty("aliases_left")
    @SerializedName(value = "aliases_left", alternate = {})
    private int aliasesLeft;
    @JsonProperty("domain_admins")
    @SerializedName(value = "domain_admins", alternate = {})
    private String domainAdmins;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @Deprecated
    public Domain() {
        super(ENDPOINT);
    }

    @JsonProperty("max_new_mailbox_quota")
    public long getMaxNewMailboxQuota() {
        return maxNewMailboxQuota;
    }

    @JsonProperty("max_new_mailbox_quota")
    public void setMaxNewMailboxQuota(long maxNewMailboxQuota) {
        this.maxNewMailboxQuota = maxNewMailboxQuota;
    }

    @JsonProperty("def_new_mailbox_quota")
    public long getDefNewMailboxQuota() {
        return defNewMailboxQuota;
    }

    @JsonProperty("def_new_mailbox_quota")
    public void setDefNewMailboxQuota(long defNewMailboxQuota) {
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
    public long getBytesTotal() {
        return bytesTotal;
    }

    @JsonProperty("bytes_total")
    public void setBytesTotal(long bytesTotal) {
        this.bytesTotal = bytesTotal;
    }

    @JsonProperty("msgs_total")
    public int getMsgsTotal() {
        return msgsTotal;
    }

    @JsonProperty("msgs_total")
    public void setMsgsTotal(int msgsTotal) {
        this.msgsTotal = msgsTotal;
    }

    @JsonProperty("mboxes_in_domain")
    public int getMboxesInDomain() {
        return mboxesInDomain;
    }

    @JsonProperty("mboxes_in_domain")
    public void setMboxesInDomain(int mboxesInDomain) {
        this.mboxesInDomain = mboxesInDomain;
    }

    @JsonProperty("mboxes_left")
    public int getMboxesLeft() {
        return mboxesLeft;
    }

    @JsonProperty("mboxes_left")
    public void setMboxesLeft(int mboxesLeft) {
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
    public int getMaxNumAliasesForDomain() {
        return maxNumAliasesForDomain;
    }

    @JsonProperty("max_num_aliases_for_domain")
    public void setMaxNumAliasesForDomain(int maxNumAliasesForDomain) {
        this.maxNumAliasesForDomain = maxNumAliasesForDomain;
    }

    @JsonProperty("max_num_mboxes_for_domain")
    public int getMaxNumMboxesForDomain() {
        return maxNumMboxesForDomain;
    }

    @JsonProperty("max_num_mboxes_for_domain")
    public void setMaxNumMboxesForDomain(int maxNumMboxesForDomain) {
        this.maxNumMboxesForDomain = maxNumMboxesForDomain;
    }

    @JsonProperty("def_quota_for_mbox")
    public long getDefQuotaForMbox() {
        return defQuotaForMbox;
    }

    @JsonProperty("def_quota_for_mbox")
    public void setDefQuotaForMbox(long defQuotaForMbox) {
        this.defQuotaForMbox = defQuotaForMbox;
    }

    @JsonProperty("max_quota_for_mbox")
    public long getMaxQuotaForMbox() {
        return maxQuotaForMbox;
    }

    @JsonProperty("max_quota_for_mbox")
    public void setMaxQuotaForMbox(long maxQuotaForMbox) {
        this.maxQuotaForMbox = maxQuotaForMbox;
    }

    @JsonProperty("max_quota_for_domain")
    public long getMaxQuotaForDomain() {
        return maxQuotaForDomain;
    }

    @JsonProperty("max_quota_for_domain")
    public void setMaxQuotaForDomain(long maxQuotaForDomain) {
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
    public int getBackupmxInt() {
        return backupmxInt;
    }

    @JsonProperty("backupmx_int")
    public void setBackupmxInt(int backupmxInt) {
        this.backupmxInt = backupmxInt;
    }

    @JsonProperty("gal_int")
    public int getGalInt() {
        return galInt;
    }

    @JsonProperty("gal_int")
    public void setGalInt(int galInt) {
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
    public int getActiveInt() {
        return activeInt;
    }

    @JsonProperty("active_int")
    public void setActiveInt(int activeInt) {
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
    public int getRelayAllRecipientsInt() {
        return relayAllRecipientsInt;
    }

    @JsonProperty("relay_all_recipients_int")
    public void setRelayAllRecipientsInt(int relayAllRecipientsInt) {
        this.relayAllRecipientsInt = relayAllRecipientsInt;
    }

    @JsonProperty("relay_unknown_only_int")
    public int getRelayUnknownOnlyInt() {
        return relayUnknownOnlyInt;
    }

    @JsonProperty("relay_unknown_only_int")
    public void setRelayUnknownOnlyInt(int relayUnknownOnlyInt) {
        this.relayUnknownOnlyInt = relayUnknownOnlyInt;
    }

    @JsonProperty("aliases_in_domain")
    public int getAliasesInDomain() {
        return aliasesInDomain;
    }

    @JsonProperty("aliases_in_domain")
    public void setAliasesInDomain(int aliasesInDomain) {
        this.aliasesInDomain = aliasesInDomain;
    }

    @JsonProperty("aliases_left")
    public int getAliasesLeft() {
        return aliasesLeft;
    }

    @JsonProperty("aliases_left")
    public void setAliasesLeft(int aliasesLeft) {
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
        return m.getClient().performDelete(this, null).getStatus() < 400;
    }

    @Override
    public boolean update(Mailcow m) {
        return m.getClient().performPostRequest(ENDPOINT, RequestType.UPDATE, null, this.toOModel(), domainName).getStatus() < 400;
    }

    @Override
    public ODomain toOModel() {
        return new ODomain(this);
    }


    @Override
    public String toString() {
        return "Domain{" +
                "maxNewMailboxQuota=" + maxNewMailboxQuota +
                ", defNewMailboxQuota=" + defNewMailboxQuota +
                ", quotaUsedInDomain='" + quotaUsedInDomain + '\'' +
                ", bytesTotal=" + bytesTotal +
                ", msgsTotal=" + msgsTotal +
                ", mboxesInDomain=" + mboxesInDomain +
                ", mboxesLeft=" + mboxesLeft +
                ", domainName='" + domainName + '\'' +
                ", description='" + description + '\'' +
                ", maxNumAliasesForDomain=" + maxNumAliasesForDomain +
                ", maxNumMboxesForDomain=" + maxNumMboxesForDomain +
                ", defQuotaForMbox=" + defQuotaForMbox +
                ", maxQuotaForMbox=" + maxQuotaForMbox +
                ", maxQuotaForDomain=" + maxQuotaForDomain +
                ", relayhost='" + relayhost + '\'' +
                ", backupmx='" + backupmx + '\'' +
                ", gal='" + gal + '\'' +
                ", backupmxInt=" + backupmxInt +
                ", galInt=" + galInt +
                ", rl=" + rl +
                ", active='" + active + '\'' +
                ", activeInt=" + activeInt +
                ", relayAllRecipients='" + relayAllRecipients + '\'' +
                ", relayUnknownOnly='" + relayUnknownOnly + '\'' +
                ", relayAllRecipientsInt=" + relayAllRecipientsInt +
                ", relayUnknownOnlyInt=" + relayUnknownOnlyInt +
                ", aliasesInDomain=" + aliasesInDomain +
                ", aliasesLeft=" + aliasesLeft +
                ", domainAdmins='" + domainAdmins + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
