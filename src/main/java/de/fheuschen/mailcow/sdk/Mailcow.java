package de.fheuschen.mailcow.sdk;

/**
 * Mailcow
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class Mailcow {

    // Currently, the only supported authentication method is using an api key. In the future, it would be great to support OAuth authentication as well.

    private String apiKey, serverUrl;

    public Mailcow(String apiKey, String serverUrl) {
        this.apiKey = apiKey;
        this.serverUrl = serverUrl;
    }

}
