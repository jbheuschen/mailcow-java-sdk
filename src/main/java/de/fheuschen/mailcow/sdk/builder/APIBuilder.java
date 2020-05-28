package de.fheuschen.mailcow.sdk.builder;

import de.fheuschen.mailcow.sdk.Mailcow;

/**
 * APIBuilder
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class APIBuilder implements Builder<Mailcow> {

    private String apiKey;
    private String serverUrl;

    public APIBuilder setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public APIBuilder setServerURL(String serverUrl) {
        this.serverUrl = serverUrl;
        return this;
    }

    public Mailcow build() {
        return new Mailcow();
    }
}
