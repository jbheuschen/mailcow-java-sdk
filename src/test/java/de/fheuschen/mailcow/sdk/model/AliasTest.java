package de.fheuschen.mailcow.sdk.model;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.MailcowProvider;
import de.fheuschen.mailcow.sdk.builder.AliasBuilder;
import de.fheuschen.mailcow.sdk.exception.MailcowException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AliasTest {

    Alias a;
    Domain d = MailcowProvider.createOrGetTestDomain();
    Mailcow m = MailcowProvider.getMailcowInstance();

    @BeforeEach
    void setUp() {
        assertNotNull(m);
        assertNotNull(d);
        try {
            a = new AliasBuilder()
                    .withId(MailcowProvider.TEST_ALIAS_ID)
                    .fetch(m);
        } catch (MailcowException e) {
            create();
            setUp();
        }
    }

    @Test
    void getEndpoint() {
        assertNotNull(a.getEndpoint());
    }

    @Test
    void create() {
        try {
            a = new AliasBuilder()
                    .setAddress(MailcowProvider.TEST_ALIAS)
                    .setGoTo(MailcowProvider.TEST_MAILBOX)
                    .setActive(true)
                    .create(m);
        } catch (MailcowException e) {
            e.printStackTrace();
        }
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void getDeletePacketById() {
        assertNotNull(a.getDeletePacketById());
    }

    @Test
    void toOModel() {
        assertNotNull(a.toOModel());
    }
}