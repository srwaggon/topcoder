package com.srwaggon.topcoder;

import org.junit.Test;

import static org.junit.Assert.*;

public class ABTest {

  public void assertEmpty(String string) {
    assertEquals("", string);
  }


  @Test
  public void testBaseCase() {
    assertValid(2, new AB().createString(3, 2));
  }

  @Test
  public void testZeroCase() {
    assertValid(0, new AB().createString(2, 0));
  }

  @Test
  public void testCreateString_IsEmpty_WhenKTooHighForN() {
    assertEmpty(new AB().createString(5, 8));
  }

  @Test
  public void testLongerCase() {
    assertValid(12, new AB().createString(10, 12));
  }

  private void assertValid(int k, String pattern) {
    assertEquals(k, countPairs(pattern));
  }

  private static int countPairs(String pattern) {
    int numBs = 0;
    int sum = 0;
    for (int i = pattern.length() - 1; i >= 0; i--) {
      if (pattern.charAt(i) == 'B') {
        numBs++;
      } else if (pattern.charAt(i) == 'A') {
        sum += numBs;
      }
    }
    return sum;
  }


}