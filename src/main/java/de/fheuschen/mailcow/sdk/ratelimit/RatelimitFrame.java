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
}
