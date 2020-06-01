package de.fheuschen.mailcow.sdk.builder;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.builder.helper.FetchableBuilder;
import de.fheuschen.mailcow.sdk.validation.Validateable;
import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.model.Domain;
import de.fheuschen.mailcow.sdk.util.QuotaUnit;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * DomainBuilder
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class DomainBuilder implements FetchableBuilder<Domain, String, DomainBuilder>, Validateable {




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

    /*
    More fluent methods
     */

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

    public DomainBuilder setMaxMailboxQuota(long value, QuotaUnit unit) {

        return this;
    }

    public DomainBuilder setDefaultMailboxQuota(long value, QuotaUnit unit) {

        return this;
    }

    public DomainBuilder setDomain(Domain domain) {
        return setDomain(domain.getId());
    }

    public DomainBuilder setDomain(String identification) {

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
        return m.getClient().performMultiGetRequest(Domain.ENDPOINT, null, Domain.class, Mailcow.ID_ALL);
    }

    @Override
    public Domain create(Mailcow m) throws MailcowException {
        if(this._doCreation(m)) {
            return this.withId(domainName).fetch(m);
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

        /*
            Minimal setup:
                {
                    "domain":"domain.tld6",
                    "description":"some decsription", //probably not...
                    "aliases":"400",
                    "mailboxes":"10",
                    "defquota":"3072",
                    "maxquota":"10240",
                    "quota":"10240",
                    "active":"1"
                }

         */

        return new Object[] {this.domainName, this.maxNumAliasesForDomain, this.maxNumMboxesForDomain, this.defQuotaForMbox, this.maxQuotaForMbox, this.activeInt, this.maxQuotaForDomain};
    }

    @Override
    public Map<String, Object> getCreationMap() {
        Map<String, Object> m = new HashMap<>();
        m.put("domain", this.domainName);
        m.put("description", this.description);
        m.put("aliases", this.maxNumAliasesForDomain);
        m.put("mailboxes", this.maxNumMboxesForDomain);
        m.put("defquota", this.defQuotaForMbox);
        m.put("maxquota", this.maxQuotaForMbox);
        m.put("quota", this.maxQuotaForDomain);
        m.put("active", this.activeInt);
        return m;
    }

    @Override
    public BaseClient.Endpoint<?> getEndpoint() {
        return Domain.ENDPOINT;
    }
}
