package de.fheuschen.mailcow.sdk.client;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

/**
 * KeyClient
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class KeyClient extends BaseClient {

    public static final String MAILCOW_AUTH_HEADER = "X-API-Key";

    public KeyClient(String server, String apiKey) {
        this.apiKey = apiKey;
        this.server = this.client.target(server + "/api/v1/");
    }

    @Deprecated
    protected WebTarget doAuthentication(WebTarget t) {
        return t.property(MAILCOW_AUTH_HEADER, this.apiKey);
    }

    @Override
    protected Invocation.Builder doAuthentication(Invocation.Builder t) {
        return t.header(MAILCOW_AUTH_HEADER, this.apiKey);
    }
}
