package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.MailcowProvider;
import de.fheuschen.mailcow.sdk.builder.DomainBuilder;
import de.fheuschen.mailcow.sdk.exception.ItemNotFoundException;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.util.QuotaUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void delete() {
        assertTrue(d.delete(m));

        assertThrows(ItemNotFoundException.class, () -> d = new DomainBuilder()
                .withId(MailcowProvider.TEST_DOMAIN)
                .fetch(m));
    }

    @Test
    void create() throws MailcowException {
        /*d = new DomainBuilder()
                .setActiveInt(1)
                .setDomainName(MailcowProvider.TEST_DOMAIN)
                .setDescription("Test")
                .setMaxNumAliasesForDomain(400)
                .setMaxNumMboxesForDomain(200)
                .setMaxQuotaForDomain(QuotaUnit.GB.toMiB(10))
                .setDefQuotaForMbox(QuotaUnit.GB.toMiB(1))
                .setMaxQuotaForMbox(QuotaUnit.GB.toMiB(1))
                .create(m);
        assertNotNull(d);
        assertEquals("Test", d.getDescription());*/
    }

    @Test
    void update() {
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
}