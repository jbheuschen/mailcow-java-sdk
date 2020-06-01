package de.fheuschen.mailcow.sdk.builder.helper;

import de.fheuschen.mailcow.sdk.annotation.constraint.Max;
import de.fheuschen.mailcow.sdk.annotation.constraint.Min;
import de.fheuschen.mailcow.sdk.annotation.constraint.RequiredField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateableTest {

    static class A implements Validateable {

        @RequiredField
        private String test;

        private String notTest;

        @RequiredField
        public String pubTest;

        public String notPubTest;

        public boolean validate() {
            return this._selfValidate();
        }

        public A setTest(String test) {
            this.test = test;
            return this;
        }

        public A setNotTest(String notTest) {
            this.notTest = notTest;
            return this;
        }

        public A setPubTest(String pubTest) {
            this.pubTest = pubTest;
            return this;
        }

        public A setNotPubTest(String notPubTest) {
            this.notPubTest = notPubTest;
            return this;
        }
    }

    static class B implements Validateable {
        @Min(min = 5D)
        int min;

        @Max(max = 10D)
        int max;

        public boolean validate() {
            return this._selfValidate();
        }
    }

    A a;
    B b;

    @BeforeEach
    void setUp() {
        a = new A();
        b = new B();
    }

    @Test
    void testValidationFail() {
        a.setPubTest(null)
                .setNotPubTest("not null")
                .setTest(null)
                .setNotTest("not null again");
        assertFalse(a.validate());
    }

    @Test
    void testValidation() {
        a.setNotPubTest(null)
                .setPubTest("not null")
                .setNotTest(null)
                .setTest("not null again");
        assertTrue(a.validate());
    }

    @Test
    void testMin() {
        b.max = 6;
        b.min = 3;
        assertFalse(b.validate());
        b.min = 6;
        b.max = 3;
        assertTrue(b.validate());
    }


}