package de.fheuschen.mailcow.sdk.util;

/**
 * QuotaUnit
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public strictfp enum QuotaUnit {
    GiB(1024),
    GB(953.674),
    MiB(1),
    MB(.953674),
    KiB(.000976563),
    KB(.000953674);
    private final double factor;
    QuotaUnit(double factor) {
        this.factor = factor;
    }

    public double getFactor() {
        return factor;
    }

    /**
     * Converts the given number to MiB (the unit mailcow uses)
     * @param n a number
     * @return the result
     */
    public double toMiB(double n) {
        return factor * n;
    }

    /**
     * Converts the given number to MiB (the unit mailcow uses)
     * @param n a number
     * @return the result
     */
    public int toMiB(int n) {
        return (int) (factor * n);
    }

    /**
     * Converts the given number to MiB (the unit mailcow uses)
     * @param n a number
     * @return the result
     */
    public long toMiB(long n) {
        return (long) (factor * n);
    }
}
