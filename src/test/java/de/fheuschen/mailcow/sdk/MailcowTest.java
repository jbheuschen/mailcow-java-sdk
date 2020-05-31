package de.fheuschen.mailcow.sdk;

import de.fheuschen.mailcow.sdk.builder.APIBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailcowTest {

    private Mailcow m;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        m = new APIBuilder()
                .setApiKey(MailcowProvider.API_KEY)
                .setServerURL(MailcowProvider.API_URL)
                .build();
    }

    @Test
    void testInitialization() {
        assertNotNull(m);
        assertNotNull(m.getClient());
        assertNotNull(m.getServerUrl());
    }

    @Test
    void testConnection() {
        System.out.println("Note: for this test to complete successfully, you need to have a development server up and running!");
        assertTrue(m.getClient().connectionSuccessful());
    }
}