package de.fheuschen.mailcow.sdk.client;

import de.fheuschen.mailcow.sdk.model.MailcowModel;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Client
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public abstract class BaseClient {

    protected Client client = ClientBuilder.newClient();
    protected String apiKey;
    protected WebTarget server;

    public void initialize() {}

    /**
     * This method performs the neccessary authentication on the WebTarget object (i.e., adding api keys or similar)
     * @param t the target
     * @return the authenticated target
     */
    protected abstract WebTarget doAuthentication(WebTarget t);

    /**
     * Performs a request and returns the raw response
     * @param endpoint
     * @param params
     * @return
     */
    public Response performGetRequest(Endpoint<?> endpoint, Map<String, String> params) {
        WebTarget t = server.path(endpoint.getEndpointUrl());
        for(String key : params.keySet())
            t.queryParam(key, params.getOrDefault(key, ""));
        return this.doAuthentication(t).request(MediaType.APPLICATION_JSON).get();
    }

    /**
     * Performs a request
     * @param endpoint
     * @param params
     * @param clazz
     * @param <T>
     * @return
     */
    public <T extends MailcowModel> T performGetRequest(Endpoint<T> endpoint, Map<String, String> params, Class<T> clazz) {
        WebTarget t = server.path(endpoint.getEndpointUrl());
        for(String key : params.keySet())
            t.queryParam(key, params.getOrDefault(key, ""));
        return this.doAuthentication(t).request(MediaType.APPLICATION_JSON).get(clazz);
    }

    public interface Endpoint<T extends MailcowModel > {
        String getEndpointUrl();
        String getEditEndpointUrl();
        String getDeleteEndpointUrl();
        String getAddEndpointUrl();
    }



}
