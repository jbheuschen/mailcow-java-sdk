package de.fheuschen.mailcow.sdk;

import de.fheuschen.mailcow.sdk.builder.APIBuilder;

/**
 * MailcowProvider
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class MailcowProvider {

    private static Mailcow m;
    public static final String MCJ_API_KEY_ENV = "MCJ_KEY", MCJ_API_URL_ENV = "MCJ_URL";
    public static final String TEST_DOMAIN = "mjs.local";
    public static final String TEST_MAILBOX = "test@mjs.local";
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

}
