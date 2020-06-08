package de.fheuschen.mailcow.sdk.util;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.builder.helper.FetchableBuilder;
import de.fheuschen.mailcow.sdk.exception.ItemNotFoundException;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.model.MailcowModel;

/**
 * Utilities
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class Util {

    public static final String UC_YES = "&#10004;";
    public static final String UC_NO = "&#10005;";

    private Util() {}

    /**
     * Returns if any of the given objects is null.
     * @param of array of objects
     * @return true/false
     */
    public static boolean isAnyNull(Object... of) {
        for(Object o : of)
            if(o == null)
                return true;
        return false;
    }

    public static String b2mB(boolean bool) {
        return bool ? "1" : "0";
    }

    public static String b2uB(boolean bool) { return bool ? UC_YES : UC_NO; }

    /**
     * Default implementation to check whether an item of any kind exists.
     * @param m the mailcow api object. Required to contact the api.
     * @param id the id to check. Refer to the model's documentation for further information.
     * @param builder a builder object to be used.
     * @param <T> the type of model to test for.
     * @param <I> the type of identifier used.
     * @param <B> the type of builder used.
     * @return true if the item exists, otherwise false.
     * @throws MailcowException Any exception occurring, except for ItemNotFoundException, is rethrown.
     */
    public static <T extends MailcowModel, I, B extends FetchableBuilder<T, I, B>> boolean existenceDefImplementation(Mailcow m, I id, B builder) throws MailcowException {
        T t;
        try {
            t = builder.withId(id).fetch(m);
        } catch (ItemNotFoundException e) {
            return false;
        }
        return t != null;
    }

    public static boolean mB2b(String mailcowBool) {
        return mailcowBool.equalsIgnoreCase("1") || mailcowBool.strip().equalsIgnoreCase(UC_YES);
    }
}
