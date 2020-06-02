package de.fheuschen.mailcow.sdk.builder.helper;

import static org.junit.jupiter.api.Assertions.*;

import de.fheuschen.mailcow.sdk.annotation.constraint.*;
import de.fheuschen.mailcow.sdk.validation.Validateable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidateableTest {

  static class A implements Validateable {

    @RequiredField private String test;

    private String notTest;

    @RequiredField public String pubTest;

    public String notPubTest;

    public boolean validate() { return this._selfValidate(); }

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
    @Min(min = 5D) int min;

    @Max(max = 10D) int max;

    public boolean validate() { return this._selfValidate(); }
  }

  A a;
  B b;
  C c;

  @BeforeEach
  void setUp() {
    a = new A();
    b = new B();
    c = new C();
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

  static class C implements Validateable {
    @Length(min = 3, max = 7) String a = "abcd";
    @Length(equals = 5) String c = "12345";
    @StringBool String b = "false";

    public boolean validate() { return this._selfValidate(); }
  }

  @Test
  void stringBool() {
    assertTrue(c.validate());
    c.b = "fdlsfjklsdfj";
    assertFalse(c.validate());
    c.b = "0";
    assertTrue(c.validate());
  }

  @Test
  void length() {
    assertTrue(c.validate());
    c.a = "one";
    assertFalse(c.validate());
    c.a = "onetwo";
    assertTrue(c.validate());
    c.a = "onetwothree";
    assertFalse(c.validate());
  }

  @Test
  void equals() {
    assertTrue(c.validate());
    c.c = "1";
    assertFalse(c.validate());
    c.c = "1234567";
    assertFalse(c.validate());
    c.c = "12345";
    assertTrue(c.validate());
  }
}
