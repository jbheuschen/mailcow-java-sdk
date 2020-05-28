package de.fheuschen.mailcow.sdk.client;

import javax.ws.rs.client.WebTarget;

/**
 * KeyClient
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class KeyClient extends Client {

    public static final String MAILCOW_AUTH_HEADER = "X-API-Key";

    public KeyClient(String server, String apiKey) {
        this.apiKey = apiKey;
        this.server = this.client.target(server);
    }

    protected WebTarget doAuthentication(WebTarget t) {
        return t.property(MAILCOW_AUTH_HEADER, this.apiKey);
    }
}
