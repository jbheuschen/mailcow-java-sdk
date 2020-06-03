package de.fheuschen.mailcow.sdk;

import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.client.KeyClient;

import java.io.Serializable;

/**
 * The Mailcow Java SDK
 * This is the main class for the Mailcow Java SDK. Please do not instantiate this class directly, instead use
 * the {@code APIBuilder} class as there might be implementation-breaking changes to the constructors without
 * further notice!
 * This class acts as a bridge between the models (which themselves only contain data and are not bound to a
 * specific server, but don't have direct access to any api) and the client (which only has the ability to
 * communicate with the server but does not hold data on its own); thus, an instance of this class is often
 * required as an argument to persist changes to the api.
 * You should only need to have one instance of this class per mailcow server you want to communicate with.
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class Mailcow implements Serializable {

    public static final String ID_ALL = "all";
    public static final String UNKNOWN_DOMAIN = "unknown.local";

    public static final String VERSION = Mailcow.class.getPackage().getImplementationVersion();

    // Currently, the only supported authentication method is using an api key. In the future, it would be great to support OAuth authentication as well.

    private final String apiKey;
    private final String serverUrl;
    private final transient BaseClient client;
    private boolean readOnly = false, throwOnWrite = true;

    /**
     * Please, do not use this constructor directly unless you are sure you need it! Use {@code APIBuilder} instead.
     * @param apiKey the api key
     * @param serverUrl the server url
     * @param readOnly is this a read-only key? If so, write-access will be blocked.
     * @param throwOnWrite if set to true, read-only-write-access will throw a runtime exception.
     * @see de.fheuschen.mailcow.sdk.builder.APIBuilder
     */
    public Mailcow(String apiKey, String serverUrl, boolean readOnly, boolean throwOnWrite) {
        this.apiKey = apiKey;
        this.serverUrl = serverUrl;
        this.client = new KeyClient(serverUrl, apiKey);
        this.readOnly = readOnly;
        this.throwOnWrite = throwOnWrite;
        this.client.initialize(this);
    }

    /**
     * Returns the client.
     * @return the client
     */
    public BaseClient getClient() {
        return client;
    }

    /**
     * Returns the server url.
     * @return the server url.
     */
    public String getServerUrl() {
        return serverUrl;
    }

    /**
     * Returns whether this api is set to read-only-mode.
     * @return true/false
     */
    public boolean isReadOnly() {
        return readOnly;
    }

    /**
     * Returns whether exceptions are thrown on unexpected write-operations.
     * @return true/false
     */
    public boolean isThrowOnWrite() {
        return throwOnWrite;
    }

    /**
     * Returns the api key for internal purposes.
     * @return the api key.
     */
    protected String getApiKey() {
        return apiKey;
    }

    @Override
    public String toString() {
        return "Mailcow API SDK (" + VERSION + ") connected to " + serverUrl + ".";
    }
}
