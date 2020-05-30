package de.fheuschen.mailcow.sdk.util;

/**
 * Utilities
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class Util {
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
}
