package de.fheuschen.mailcow.sdk.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.builder.DomainBuilder;
import de.fheuschen.mailcow.sdk.exception.*;
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
    public Response performGetRequest(Endpoint<?> endpoint, Map<String, String> params) throws MailcowException {
        WebTarget t = server.path(endpoint.getEndpointUrl());
        for(String key : params.keySet())
            t.queryParam(key, params.getOrDefault(key, ""));
        return throughout(this.doAuthentication(t.request(MediaType.APPLICATION_JSON)).get());
    }

    /**
     * Performs a request
     * @param endpoint
     * @param params
     * @param clazz
     * @param <T>
     * @return
     */
    public <T extends MailcowModel> T performGetRequest(Endpoint<T> endpoint, Map<String, String> params, Class<T> clazz, String id) throws MailcowException {
        WebTarget t = server.path(endpoint.getEndpointUrl() + ((id == null) ? "" : id));
        if(params != null)
            for(String key : params.keySet())
                t.queryParam(key, params.getOrDefault(key, ""));
        return parseToItem(throughout(this.doAuthentication(t.request(MediaType.APPLICATION_JSON)).get()).readEntity(String.class), clazz);
    }

    /**
     * Performs a post request.
     * @param endpoint
     * @param type
     * @param params
     * @param om
     * @param items
     * @param <T>
     * @return
     */
    public <T extends MailcowModel> Response performPostRequest(Endpoint<T> endpoint, RequestType type, Map<String, String> params, OMailcowModel<T> om, String... items) throws MailcowException {
        if(endpoint.writing(type) && !checkReadOnly()) return null;
        WebTarget t = server.path(endpoint.get(type));
        if(params != null)
            for(String key : params.keySet())
                t.queryParam(key, params.getOrDefault(key, ""));
        return throughout(this.doAuthentication(t.request(MediaType.APPLICATION_JSON)).post(Entity.json(g.toJson(om.wrap(items)))));
    }

    /**
     * Performs a post request.
     * @param endpoint
     * @param type
     * @param params
     * @param body
     * @return
     */
    public Response performPostRequest(Endpoint<?> endpoint, RequestType type, Map<String, String> params, Map<String, Object> body) throws MailcowException {
        if(endpoint.writing(type) && !checkReadOnly()) return null;
        WebTarget t = server.path(endpoint.get(type));
        if(params != null)
            for(String key: params.keySet())
                t.queryParam(key, params.getOrDefault(key, ""));
        return throughout(this.doAuthentication(t.request(MediaType.APPLICATION_JSON)).post(Entity.json(g.toJson(body))));
    }

    /**
     * Performs a get request with multiple items returned.
     * @param endpoint
     * @param params
     * @param clazz
     * @param id
     * @param <T>
     * @return
     */
    public <T extends MailcowModel> Collection<T> performMultiGetRequest(Endpoint<T> endpoint, Map<String, String> params, Class<T> clazz, String id) throws MailcowException {
        WebTarget t = server.path(endpoint.getEndpointUrl() + ((id == null) ? "" : id));
        if(params != null)
            for(String key : params.keySet())
                t.queryParam(key, params.getOrDefault(key, ""));
        Response r = throughout(this.doAuthentication(t.request(MediaType.APPLICATION_JSON)).get());
        return g.fromJson(r.readEntity(String.class), new TypeToken<ArrayList<T>>() {}.getType());
    }

    /**
     * Performs a post request intended to delete items.
     * @param m
     * @param params
     * @return
     */
    public Response performDelete(MailcowModel m, Map<String, Object> params) throws MailcowException {
        if(!checkReadOnly()) return null;
        WebTarget t = server.path(m.getEndpoint().getDeleteEndpointUrl());
        return throughout(this.doAuthentication(t.request(MediaType.APPLICATION_JSON)).post(Entity.entity(params, MediaType.APPLICATION_JSON)));
    }

    /**
     * Performs a post request intended to delete items.
     * @param m
     * @param params
     * @param p
     * @return
     */
    public boolean performDelete(MailcowModel m, Map<String, Object> params, ODeletePacket p) throws MailcowException {
        if(!checkReadOnly()) return false;
        WebTarget t = server.path(m.getEndpoint().get(RequestType.DELETE));
        return throughout(this.doAuthentication(t.request(MediaType.APPLICATION_JSON)).post(Entity.json(p.getObjectForSerialization()))).getStatus() < ERROR_THRESHOLD;
    }

    /**
     * Performs a check whether the API is set to read-only. If throwOnWrite is set to true and the api is ro, this will throw an UnsupportedAPIActionException!
     * @return true if everything is okay.
     * @throws UnsupportedAPIActionException if throwOnWrite and readOnly is true
     */
    public boolean checkReadOnly() throws UnsupportedAPIActionException {
        if(m.isReadOnly() && m.isThrowOnWrite())
            throw new UnsupportedAPIActionException("Cannot perform write action on read-only API!");
        return !m.isReadOnly();
    }

    /**
     * Checks for a successful by trying to fetch a list of domains (as most servers will have at least one domain configured and - even if that's not the case - there will always be an empty list of domain that's returned).
     * @return true/false
     */
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
     * Checks for a successful by trying to fetch a list of domains (as most servers will have at least one domain configured and - even if that's not the case - there will always be an empty list of domain that's returned).
     * @param throwException if set to true and an exception occurs, it will be rethrown (i.e., you can handle it yourself).
     * @throws MailcowException if throwException is true
     * @return true/false
     */
    public boolean connectionSuccessful(boolean throwException) throws MailcowException {
        try {
            Collection<Domain> d = new DomainBuilder()
                    .fetchAll(m);
            return d != null;
        } catch (MailcowException e) {
            e.printStackTrace();
            if(throwException)
                throw e;
            return false;
        }
    }

    private static final String EMPTY_RESULT = "{}";

    /**
     * Parses json to an item.
     * @param json the json
     * @param clazz the class
     * @param <T> the type
     * @return the item
     * @throws ItemNotFoundException if the json does not contain an item of that class; thus, it is likely that there was no item found.
     */
    protected <T extends MailcowModel> T parseToItem(String json, Class<T> clazz) throws ItemNotFoundException {
        T t = g.fromJson(json, clazz);
        if(t == null || json.trim().equalsIgnoreCase(EMPTY_RESULT) || json.isBlank())
            throw new ItemNotFoundException("Item not found");
        return t;
    }

    /**
     * Reads the status code and throws an exception for error codes.
     * @param statusCode
     */
    protected void handleStatusCode(int statusCode) throws MailcowException {
        switch (statusCode) {
            case 401: throw new AuthenticationFailedException("Got 401 Authentication failed!");
            case 403: throw new AuthenticationFailedException("Got 403 Authentication failed!");
            case 404: throw new UnsupportedAPIActionException("Got 404 Not found!");
            case 500: throw new MailcowException("Got 500 Internal Server Error!");
            default:
        }
    }

    //Pass'n throw
    private Response throughout(Response r) throws MailcowException {
        handleStatusCode(r.getStatus());
        return r;
    }

    /**
     * Reads the status code and throws an exception for error codes.
     * @param response
     */
    protected void handleStatusCode(Response response) throws MailcowException {
        handleStatusCode(response.getStatus());
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
