package de.fheuschen.mailcow.sdk;

import de.fheuschen.mailcow.sdk.builder.APIBuilder;
import de.fheuschen.mailcow.sdk.builder.DomainBuilder;
import de.fheuschen.mailcow.sdk.exception.ItemNotFoundException;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.model.Domain;
import de.fheuschen.mailcow.sdk.util.QuotaUnit;

/**
 * MailcowProvider
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class MailcowProvider {

    private static Mailcow m;
    public static final String MCJ_API_KEY_ENV = "MCJ_KEY", MCJ_API_URL_ENV = "MCJ_URL";
    public static final String TEST_DOMAIN = "mjs.local";
    public static final String TEST_MAILBOX = "test@" + TEST_DOMAIN;
    public static final String TEST_ALIAS = "alias@" + TEST_DOMAIN;
    public static int TEST_ALIAS_ID = 1;
    public static final String TEST_MAILBOX_LOCAL = "test";
    public static final String TEST_MAILBOX_PASSWORD = "dacja39wj9wa";
    public static String API_KEY = "0FE593-F6ED2F-394793-0717CC-1E8A37";
    public static String API_URL = "http://localhost:82";

    static {
        if(System.getenv(MCJ_API_KEY_ENV) != null)
            API_KEY = System.getenv(MCJ_API_KEY_ENV);
        if(System.getenv(MCJ_API_URL_ENV) != null)
            API_URL = System.getenv(MCJ_API_URL_ENV); //Default test server is only accessible from within my local network -
        // therefore, we need to inject different values for other environments.
    }

    public static Mailcow getMailcowInstance() {
        if(m == null) {
            m = new APIBuilder()
                    .setServerURL(API_URL)
                    .setApiKey(API_KEY)
                    .build();
        }
        return m;
    }

    public static Domain createOrGetTestDomain() {
        try {
            return new DomainBuilder()
                    .withId(MailcowProvider.TEST_DOMAIN)
                    .fetch(getMailcowInstance());
        } catch (ItemNotFoundException e) {
            try {
                new DomainBuilder()
                        .setActive(true)
                        .setDomainName(MailcowProvider.TEST_DOMAIN)
                        .setDescription("Test")
                        .setMaxAliases(260)
                        .setMaxMailboxes(120)
                        .setMaxMailboxQuota(QuotaUnit.MB.toMiB(400))
                        .setDefaultMailboxQuota(QuotaUnit.MB.toMiB(300))
                        .setDomainQuota(QuotaUnit.GB.toMiB(5))
                        .create(m);
            } catch (MailcowException mailcowException) {
                mailcowException.printStackTrace();
                return null;
            }
            return createOrGetTestDomain();
        } catch (MailcowException e) {
            e.printStackTrace();

        }
        return null;
    }

}
