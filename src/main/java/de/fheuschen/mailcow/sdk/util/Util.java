package de.fheuschen.mailcow.sdk.util;

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

    public static boolean mB2b(String mailcowBool) {
        return mailcowBool.equalsIgnoreCase("1") || mailcowBool.strip().equalsIgnoreCase(UC_YES);
    }
}
