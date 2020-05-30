package de.fheuschen.mailcow.sdk.builder;

import de.fheuschen.mailcow.sdk.Mailcow;

/**
 * APIBuilder
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class APIBuilder implements RawBuilder<Mailcow> {

    private String apiKey;
    private String serverUrl;
    private boolean readOnly = false, throwOnWrite = true;

    public APIBuilder setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public APIBuilder setServerURL(String serverUrl) {
        this.serverUrl = serverUrl;
        return this;
    }

    public APIBuilder setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
        return this;
    }

    /**
     * If set to false, no exceptions will be thrown when writing to a read-only api (instead, write-requests will simply be ignored and return null).
     * Defaults to true.
     * @see #setReadOnly(boolean)
     * @param throwOnWrite
     * @return
     */
    public APIBuilder setThrowOnWrite(boolean throwOnWrite) {
        this.throwOnWrite = throwOnWrite;
        return this;
    }

    public Mailcow build() {
        return new Mailcow(apiKey, serverUrl, readOnly, throwOnWrite);
    }
}
