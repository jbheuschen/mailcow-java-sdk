package de.fheuschen.mailcow.sdk;

import de.fheuschen.mailcow.sdk.client.Client;
import de.fheuschen.mailcow.sdk.client.KeyClient;

/**
 * Mailcow
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class Mailcow {

    // Currently, the only supported authentication method is using an api key. In the future, it would be great to support OAuth authentication as well.

    private String apiKey, serverUrl;
    private Client client;

    public Mailcow(String apiKey, String serverUrl) {
        this.apiKey = apiKey;
        this.serverUrl = serverUrl;
        this.client = new KeyClient(apiKey, serverUrl);
    }

}
