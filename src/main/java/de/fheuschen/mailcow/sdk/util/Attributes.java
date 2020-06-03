package de.fheuschen.mailcow.sdk.util;

/**
 * Attributes
 *
 * @see de.fheuschen.mailcow.sdk.marker.Attributable
 * @author Julian B. Heuschen <julian@fheuschen.de>
 */
public final class Attributes {

    /**
     * Attribute specifying whether the user has to change his password upon his next login attempt.
     */
    public static final String MB_FORCE_PW_UPDATE = "force_pw_update";

    /**
     * Attribute specifying whether tls is enforced for incoming mails to this mailbox.
     */
    public static final String MB_TLS_ENFORCE_IN = "tls_enforce_in";

    /**
     * Attribute specifying whether tls is enforced for outgoing mails from this mailbox.
     */
    public static final String MB_TLS_ENFORCE_OUT = "tls_enforce_out";

    /**
     * Attribute specifying whether the user may log in to SOGO (webmail).
     */
    public static final String MB_SOGO_ACCESS = "sogo_access";

    /**
     * Attribute specifying the mailbox format used internally.
     */
    public static final String MB_MAILBOX_FORMAT = "mailbox_format";

    /**
     * Attribute specifying the quarantine notification setting.
     */
    public static final String MB_QUARANTINE_NOTIFICATION = "quarantine_notification";



    private Attributes() {}

}
