package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.MailcowProvider;
import de.fheuschen.mailcow.sdk.builder.DomainBuilder;
import de.fheuschen.mailcow.sdk.exception.ItemNotFoundException;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.util.QuotaUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DomainTest {

    private Domain d;
    private Mailcow m;

    @BeforeEach
    void setUp() throws MailcowException {
        m = MailcowProvider.getMailcowInstance();
        try {
            d = new DomainBuilder()
                    .withId(MailcowProvider.TEST_DOMAIN)
                    .fetch(m);
        } catch (ItemNotFoundException e) {
            /*
            Just in case the item we are testing with doesn't exist. Let's create it and try again.
             */
            create();
            setUp();
        }
    }

    @Test
    void fetchFromId() throws MailcowException {
        d = new DomainBuilder()
                .withId(MailcowProvider.TEST_DOMAIN)
                .fetch(m);
        assertNotNull(d);
        assertEquals("Test", d.getDescription());
        assertNotEquals(0L, d.getMaxQuotaForDomain());
    }

    @Test
    void getId() {
    }

    @Test
    void delete() throws MailcowException {
        assertTrue(d.delete(m));

        assertThrows(ItemNotFoundException.class, () -> d = new DomainBuilder()
                .withId(MailcowProvider.TEST_DOMAIN)
                .fetch(m));
    }

    @Test
    void create() throws MailcowException {
        d = new DomainBuilder()
                .setActive(true)
                .setDomainName(MailcowProvider.TEST_DOMAIN)
                .setDescription("Test")
                .setMaxAliases(260)
                .setMaxMailboxes(120)
                .setMaxMailboxQuota(QuotaUnit.MB.toMiB(400))
                .setDefaultMailboxQuota(QuotaUnit.MB.toMiB(300))
                .setDomainQuota(QuotaUnit.GB.toMiB(5))
                .create(m);

        assertNotNull(d);
        assertEquals("Test", d.getDescription());
    }

    @Test
    void update() throws MailcowException {
        d.setActiveInt(0);
        assertTrue(d.update(m));
        try {
            d = new DomainBuilder()
                    .withId(MailcowProvider.TEST_DOMAIN)
                    .fetch(m);
            assertEquals(0, d.getActiveInt());
        } catch (MailcowException e) {
            e.printStackTrace();
        }
    }

    @Test
    void exists() throws MailcowException {
        assertTrue(new DomainBuilder().exists(m, d.getId()));
        assertFalse(new DomainBuilder().exists(m, UUID.randomUUID().toString()));
    }
}