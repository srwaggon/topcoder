package com.srwaggon.topcoder;

import org.junit.Test;

import static org.junit.Assert.*;

public class ABTest {

  public void assertEmpty(String string) {
    assertEquals("", string);
  }

  public void assertNotEmpty(String string) {
    assertNotEquals("", string);
  }

  @Test
  public void testBaseCase() {
    assertNotEmpty(new AB().createString(3, 2));
  }

  @Test
  public void testZeroCase() {
    assertNotEmpty(new AB().createString(2, 0));
  }

  @Test
  public void testCreateString_IsEmpty_WhenKTooHighForN() {
    assertEmpty(new AB().createString(5, 8));
  }

  @Test
  public void testLongerCase() {
    assertNotEmpty(new AB().createString(10, 12));
  }



}