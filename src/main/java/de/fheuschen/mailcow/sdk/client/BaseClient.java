package de.fheuschen.mailcow.sdk.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.builder.DomainBuilder;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.exception.UnsupportedAPIActionException;
import de.fheuschen.mailcow.sdk.model.Domain;
import de.fheuschen.mailcow.sdk.model.MailcowModel;
import de.fheuschen.mailcow.sdk.model.outward.ODeletePacket;
import de.fheuschen.mailcow.sdk.model.outward.OMailcowModel;
import de.fheuschen.mailcow.sdk.util.RequestType;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
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
    protected Mailcow m;
    protected static Gson g = new Gson();

    public static final int ERROR_THRESHOLD = 400;

    public void initialize(Mailcow m) {
        this.m = m;
    }

    /**
     * This method performs the necessary authentication on the WebTarget object (i.e., adding api keys or similar)
     * @param t the target
     * @return the authenticated target
     */
    protected abstract Invocation.Builder doAuthentication(Invocation.Builder t);

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
        return this.doAuthentication(t.request(MediaType.APPLICATION_JSON)).get();
    }

    /**
     * Performs a request
     * @param endpoint
     * @param params
     * @param clazz
     * @param <T>
     * @return
     */
    public <T extends MailcowModel> T performGetRequest(Endpoint<T> endpoint, Map<String, String> params, Class<T> clazz, String id) {
        WebTarget t = server.path(endpoint.getEndpointUrl() + ((id == null) ? "" : id));
        if(params != null)
            for(String key : params.keySet())
                t.queryParam(key, params.getOrDefault(key, ""));
        return this.doAuthentication(t.request(MediaType.APPLICATION_JSON)).get(clazz);
    }

    public <T extends MailcowModel> Response performPostRequest(Endpoint<T> endpoint, RequestType type, Map<String, String> params, OMailcowModel<T> om, String... items) {
        if(endpoint.writing(type) && !checkReadOnly()) return null;
        WebTarget t = server.path(endpoint.get(type));
        if(params != null)
            for(String key : params.keySet())
                t.queryParam(key, params.getOrDefault(key, ""));
            System.out.println(g.toJson(om.wrap(items)));
        return this.doAuthentication(t.request(MediaType.APPLICATION_JSON)).post(Entity.json(g.toJson(om.wrap(items))));
    }

    public <T extends MailcowModel> Collection<T> performMultiGetRequest(Endpoint<T> endpoint, Map<String, String> params, Class<T> clazz, String id) {
        WebTarget t = server.path(endpoint.getEndpointUrl() + ((id == null) ? "" : id));
        if(params != null)
            for(String key : params.keySet())
                t.queryParam(key, params.getOrDefault(key, ""));
        Response r = this.doAuthentication(t.request(MediaType.APPLICATION_JSON)).get();
        return g.fromJson(r.readEntity(String.class), new TypeToken<ArrayList<T>>() {}.getType());
    }

    public Response performDelete(MailcowModel m, Map<String, Object> params) {
        if(!checkReadOnly()) return null;
        WebTarget t = server.path(m.getEndpoint().getDeleteEndpointUrl());
        return this.doAuthentication(t.request(MediaType.APPLICATION_JSON)).post(Entity.entity(params, MediaType.APPLICATION_JSON));
    }

    public boolean performDelete(MailcowModel m, Map<String, Object> params, ODeletePacket p) {
        if(!checkReadOnly()) return false;
        WebTarget t = server.path(m.getEndpoint().get(RequestType.DELETE));
        return this.doAuthentication(t.request(MediaType.APPLICATION_JSON)).post(Entity.json(p.getObjectForSerialization())).getStatus() < ERROR_THRESHOLD;
    }

    public boolean checkReadOnly() throws UnsupportedAPIActionException {
        if(m.isReadOnly() && m.isThrowOnWrite())
            throw new UnsupportedAPIActionException("Cannot perform write action on read-only API!");
        return m.isReadOnly();
    }

    public boolean connectionSuccessful() {
        try {
            Collection<Domain> d = new DomainBuilder()
                    .fetchAll(m);
            return d != null;
        } catch (MailcowException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Contains the endpoint data
     * @param <T> the model whose data this endpoints contains
     */
    public interface Endpoint<T extends MailcowModel > {

        /**
         * Endpoint URL to fetch data.
         * @return
         */
        String getEndpointUrl();

        /**
         * Endpoint URL to edit/update data.
         * @return
         */
        String getEditEndpointUrl();

        /**
         * Endpoint URL to delete data.
         * @return
         */
        String getDeleteEndpointUrl();

        /**
         * Endpoint URL to create objects.
         * @return
         */
        String getAddEndpointUrl();

        /**
         * Returns the endpoint url for the given type.
         * @param type
         * @return
         */
        default String get(RequestType type) {
            switch(type) {
                case CREATE:
                    return getAddEndpointUrl();
                case DELETE:
                    return getDeleteEndpointUrl();
                case UPDATE:
                    return getEditEndpointUrl();
                default:
                    return getEndpointUrl();
            }
        }

        /**
         * Returns whether the given action is a writing action.
         * @param type
         * @return
         */
        default boolean writing(RequestType type) {
            switch(type) {
                case CREATE:
                case UPDATE:
                case DELETE:
                    return true;
                default:
                    return false;
            }
        }
    }



}
