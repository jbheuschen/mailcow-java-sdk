package de.fheuschen.mailcow.sdk.exception;

import de.fheuschen.mailcow.sdk.Mailcow;
import de.fheuschen.mailcow.sdk.MailcowProvider;
import de.fheuschen.mailcow.sdk.builder.APIBuilder;
import de.fheuschen.mailcow.sdk.builder.DomainBuilder;
import de.fheuschen.mailcow.sdk.model.Domain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnsupportedAPIActionExceptionTest {

    @Test
    void testReadWriteRestriction() throws MailcowException {
        Mailcow m = new APIBuilder()
                .setApiKey(MailcowProvider.API_KEY)
                .setServerURL(MailcowProvider.API_URL)
                .setReadOnly(true)
                .setThrowOnWrite(true)
                .build();
        Domain d = new DomainBuilder()
                .withId(MailcowProvider.TEST_DOMAIN)
                .fetch(m);
        MailcowRuntimeException mr = assertThrows(UnsupportedAPIActionException.class, () -> d.delete(m), "Expected an exception whilst writing to a read-only api!");
        System.out.println("Successfully got exception: " + mr.getMessage());
    }

    @Test
    void testReadWriteRestrictionWithoutThrow() throws MailcowException {
        Mailcow m = new APIBuilder()
                .setApiKey(MailcowProvider.API_KEY)
                .setServerURL(MailcowProvider.API_URL)
                .setReadOnly(true)
                .setThrowOnWrite(false)
                .build();
        Domain d = new DomainBuilder()
                .withId(MailcowProvider.TEST_DOMAIN)
                .fetch(m);
        assertDoesNotThrow(() -> d.delete(m), "Got an exception whilst writing to read-only api though ThrowOnWrite was set to false!");
    }

}