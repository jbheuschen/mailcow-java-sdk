package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.MailcowProvider;
import de.fheuschen.mailcow.sdk.builder.DomainBuilder;
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
        d = new DomainBuilder()
                .withId(MailcowProvider.TEST_DOMAIN)
                .fetch(m);
        if(d == null) {
            create();
        }
    }

    @Test
    void fetchFromId() throws MailcowException {
        d = new DomainBuilder()
                .withId(MailcowProvider.TEST_DOMAIN)
                .fetch(m);
        assertNotNull(d);
        System.out.println(d);
        assertEquals(d.getDescription(), "Test");
        assertNotEquals(d.getMaxQuotaForDomain(), 0L);
    }

    @Test
    void getId() {
    }

    @Test
    void delete() {
        d.delete(m);
        try {
            d = new DomainBuilder()
                    .withId(MailcowProvider.TEST_DOMAIN)
                    .fetch(m);
        } catch (MailcowException e) {
            e.printStackTrace(); //assertDoesNotThrow?
        }
        assertNull(d);
    }

    @Test
    void create() throws MailcowException {
        d = new DomainBuilder()
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
        assertEquals(d.getDescription(), "Test");
    }

    @Test
    void update() {
        d.setActiveInt(0);
        d.update(m);
        try {
            d = new DomainBuilder()
                    .withId(MailcowProvider.TEST_DOMAIN)
                    .fetch(m);
            assertEquals(d.getActiveInt(), 0);
        } catch (MailcowException e) {
            e.printStackTrace();
        }
    }
}