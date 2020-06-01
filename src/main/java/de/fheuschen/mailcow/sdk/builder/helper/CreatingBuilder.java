package de.fheuschen.mailcow.sdk.builder.helper;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.client.BaseClient;
import de.fheuschen.mailcow.sdk.exception.BuilderException;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.util.RequestType;
import de.fheuschen.mailcow.sdk.util.Util;

import java.util.Map;

/**
 * CreatingBuilder
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public interface CreatingBuilder<P> extends RawBuilder<P> {
    /**
     * Saves the object and returns the retrieved object.
     * @return
     * @param m
     */
    P create(Mailcow m) throws MailcowException;

    /**
     * Returns the values of all required fields. Used to check for requirement fulfillment.
     * @return
     */
    Object[] getRequiredFields();

    /**
     * Parses this builders values to a map with all key-value pairs that have to be sent to the server.
     * @return a map.
     */
    Map<String, Object> getCreationMap();

    BaseClient.Endpoint<?> getEndpoint();

    /**
     * Returns whether all required fields have non-null values.
     * @return
     */
    default boolean requirementsFulfilled() {
        return !Util.isAnyNull(getRequiredFields());
    }

    /**
     * Same as requirementsFulfilled() but throws a runtime exception if the requirements are not fulfilled.
     * @see #requirementsFulfilled()
     * @return true if fulfilled
     */
    default boolean hardRequirementsFulfilled() {
        if(!requirementsFulfilled())
            throw new BuilderException("Not all required fields have non-null values! To check which fields are required, please refer to the documentation.");
        return true;
    }

    /**
     * Checks for requirements and posts the request to the server.
     * @return whether the creation returned a non-error status code.
     */
    default boolean _doCreation(Mailcow m) throws MailcowException {
        hardRequirementsFulfilled();
        return m.getClient().performPostRequest(this.getEndpoint(), RequestType.CREATE, null, this.getCreationMap()).getStatus() < BaseClient.ERROR_THRESHOLD;
    }
}
