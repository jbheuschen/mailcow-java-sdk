package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.MailcowProvider;
import de.fheuschen.mailcow.sdk.builder.DomainBuilder;
import de.fheuschen.mailcow.sdk.builder.MailboxBuilder;
import de.fheuschen.mailcow.sdk.exception.ItemNotFoundException;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import de.fheuschen.mailcow.sdk.util.QuotaUnit;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    @Test
    @Order(1)
    void create() throws MailcowException {
        mb = new MailboxBuilder()
                .setDomain(MailcowProvider.TEST_DOMAIN)
                .setLocalPart(MailcowProvider.TEST_MAILBOX_LOCAL)
                .setPassword(MailcowProvider.TEST_MAILBOX_PASSWORD)
                .setQuota(QuotaUnit.MB.toMiB(500))
                .setActive(true)
                .create(m);
        assertNotNull(mb);
    }

    @Test
    @Order(2)
    void update() throws MailcowException {
        mb.setActiveInt(0);
        assertTrue(mb.update(m));
        assertDoesNotThrow(() -> mb = new MailboxBuilder().withId(MailcowProvider.TEST_MAILBOX).fetch(m));
        assertEquals(0, mb.getActiveInt());
    }

    @Test
    @Order(3)
    void getEndpoint() {
        assertNotNull(mb.getEndpoint());
    }

    @Test
    @Order(7)
    void delete() throws MailcowException {
        assertTrue(mb.delete(m));
        assertThrows(ItemNotFoundException.class, () -> mb = new MailboxBuilder()
        .withId(MailcowProvider.TEST_MAILBOX)
        .fetch(m));
    }

    @Test
    @Order(4)
    void getDeletePacketById() {
        assertNotNull(mb.getDeletePacketById());
    }

    @Test
    @Order(5)
    void getId() {
        assertEquals(MailcowProvider.TEST_MAILBOX, mb.getId());
    }

    @Test
    @Order(6)
    void toOModel() {
        assertNotNull(mb.toOModel());
    }
}