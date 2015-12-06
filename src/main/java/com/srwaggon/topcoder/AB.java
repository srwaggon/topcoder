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

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class AB {

  private static class Pattern implements Comparable<Pattern>{

    private char[] pattern;

    public Pattern(int length) {
      pattern = new char[length];
      for (int i = 0; i < length; i++) {
        pattern[i] = 'A';
      }
    }

    public Pattern(char[] pattern) {
      this.pattern = pattern;
    }

    private int countPairs() {
      int numAs = 0;
      int sum = 0;
      for (int i = 0; i < pattern.length; i++) {
        if (pattern[i] == 'A') {
          numAs++;
        } else if (pattern[i] == 'B') {
          sum += numAs;
        }
      }
      return sum;
    }

    public Collection<Pattern> permute() {
      LinkedList<Pattern> permutations = new LinkedList<Pattern>();
      for (int i = 0; i < pattern.length; i++) {
        if (pattern[i] != 'B') {
          char[] permutedPattern = Arrays.copyOf(this.pattern, pattern.length);
          permutedPattern[i] = 'B';
          permutations.add(new Pattern(permutedPattern));
        }
      }
      return permutations;
    }

    public String toString() {
      return new String(pattern);
    }

    public int compareTo(Pattern other) {
      return other.countPairs() - this.countPairs();
    }
  }


  private PriorityQueue<Pattern> searchSpace = new PriorityQueue<Pattern>();

  public String createString(int length, int k) {

    searchSpace.add(new Pattern(length));

    while (!searchSpace.isEmpty()) {
      Pattern head = searchSpace.poll();
      if (head.countPairs() == k) {
        return head.toString();
      }
      expandSearchSpace(k, head);
    }

    return "";
  }

  private void expandSearchSpace(int k, Pattern head) {
    Collection<Pattern> permutations = head.permute();
    for (Pattern pattern : permutations) {
      if (pattern.countPairs() <= k ) {
        searchSpace.addAll(permutations);
      }
    }
  }
}