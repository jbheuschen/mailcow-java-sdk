package de.fheuschen.mailcow.sdk.ratelimit;

/**
 * Ratelimit
 *
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public class Ratelimit {

    public static final Ratelimit INFINITE = RatelimitFrame.PER_SECOND.with(-1);

    public long value;
    public RatelimitFrame frame;

    public Ratelimit(long value, RatelimitFrame frame) {
        this.value = value;
        this.frame = frame;
    }
}
