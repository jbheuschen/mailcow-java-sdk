package de.fheuschen.mailcow.sdk.ratelimit;

/**
 * RatelimitFrame
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public enum RatelimitFrame {
    PER_SECOND('s'),
    PER_MINUTE('m'),
    PER_HOUR('h'),
    PER_DAY('d');
    private char sign;
    RatelimitFrame(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }

    /**
     * Returns a rate limit object with the given value.
     * @param value the value. E.g., {@code RatelimitFramge.PER_MINUTE.with(3)} means 3 msgs/min.
     * @return the rate limit
     */
    public Ratelimit with(long value) {
        return new Ratelimit(value, this);
    }

    @Override
    public String toString() {
        return String.valueOf(sign);
    }
}
