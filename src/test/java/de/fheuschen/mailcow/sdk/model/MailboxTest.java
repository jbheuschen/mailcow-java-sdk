package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.MailcowProvider;
import de.fheuschen.mailcow.sdk.builder.DomainBuilder;
import de.fheuschen.mailcow.sdk.builder.MailboxBuilder;
import de.fheuschen.mailcow.sdk.exception.ItemNotFoundException;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailboxTest {

    Mailbox mb;
    Mailcow m;

    @BeforeEach
    void setUp() throws MailcowException {
        m = MailcowProvider.getMailcowInstance();
        try {
            mb = new MailboxBuilder()
                    .withId(MailcowProvider.TEST_MAILBOX)
                    .fetch(m);
        } catch(ItemNotFoundException e) {
            create();
            setUp();
        }
    }

    void create() {
        throw new UnsupportedOperationException();
    }

    @Test
    void getEndpoint() {
        assertNotNull(mb.getEndpoint());
    }

    @Test
    void delete() {
        assertTrue(mb.delete(m));
        assertThrows(ItemNotFoundException.class, () -> mb = new MailboxBuilder()
        .withId(MailcowProvider.TEST_MAILBOX)
        .fetch(m));
    }

    @Test
    void update() {
        mb.setActiveInt(0);
        assertTrue(mb.update(m));
        try {
            mb = new MailboxBuilder()
                    .withId(MailcowProvider.TEST_DOMAIN)
                    .fetch(m);
            assertEquals(0, mb.getActiveInt());
        } catch (MailcowException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getDeletePacketById() {
        assertNotNull(mb.getDeletePacketById());
    }

    @Test
    void getId() {
        assertEquals(MailcowProvider.TEST_MAILBOX, mb.getId());
    }

    @Test
    void toOModel() {
        assertNotNull(mb.toOModel());
    }
}