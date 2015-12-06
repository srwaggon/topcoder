package com.srwaggon.topcoder;

/*
  Problem from Topcoder practice problems (http://www.topcoder.com)
  https://arena.topcoder.com/#/u/practiceCode/16319/46378/13642/1/325040

  Problem Statement
  You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:

  The string has exactly N characters, each of which is either 'A' or 'B'.
  The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
  If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
*/

public class AB {

  private static class Pattern {

    private char[] pattern;

    public Pattern(int length) {
      pattern = new char[length];
      for (int i = 0; i < length; i++) {
        pattern[i] = 'A';
      }
    }

    private int countPairs() {
      int numBs = 0;
      int sum = 0;
      for (int i = pattern.length - 1; i >= 0; i--) {
        if (pattern[i] == 'B') {
          numBs++;
        } else if (pattern[i] == 'A') {
          sum += numBs;
        }
      }
      return sum;
    }

    private void swapForward(int index) {
      if (index >= 0 && index < pattern.length-1) {
        char c = pattern[index];
        pattern[index] = pattern[index+1];
        pattern[index+1] = c;
      }
    }

    private void startB() {
      if (pattern.length > 0) {
        pattern[0] = 'B';
      }
    }

    private boolean allBs() {
      for (int i = 0; i < pattern.length; i++) {
        if (pattern[i] != 'B') {
          return false;
        }
      }
      return true;
    }

    public String toString() {
      return new String(pattern);
    }
  }

  public String createString(int length, int k) {
    Pattern pattern = new Pattern(length);

    while (!pattern.allBs()) {
      if (pattern.countPairs() == k) {
        return pattern.toString();
      }
      pattern.startB();
      for (int i = 0; i < length; i++) {
        pattern.swapForward(i);
        if (pattern.countPairs() == k) {
          return pattern.toString();
        }
      }
    }
    return "";
  }
}