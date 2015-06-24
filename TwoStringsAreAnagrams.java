// 158 Two Strings Are Anagrams
// http://www.lintcode.com/zh-cn/problem/two-strings-are-anagrams/
//
// Write a method anagram(s,t) to decide if two strings are anagrams or not.
//
// Example
// Given s="abcd", t="dcab", return true.
//
// Challenge
// O(n) time, O(1) extra space

package lintcode;

import java.util.Arrays;

public class TwoStringsAreAnagrams {
    private int[] sourceTimes = new int[256];
    private int[] targetTimes = new int[256];

    /**
     * @param source The first string
     * @param target The second string
     * @return true or false
     */
    public boolean anagram(String source, String target) {
        Arrays.fill(sourceTimes, 0);
        Arrays.fill(targetTimes, 0);

        int lens = source.length();
        int lent = target.length();
        if (lens != lent) {
            return false;
        }

        for (int i = 0; i < lens; i++) {
            sourceTimes[source.charAt(i)]++;
            targetTimes[target.charAt(i)]++;
        }

        return Arrays.equals(sourceTimes, targetTimes);
    }

    public static void main(String[] args) {
        TwoStringsAreAnagrams twoStringsAreAnagrams = new TwoStringsAreAnagrams();
        System.out.println(twoStringsAreAnagrams.anagram("abcd", "dcba"));
    }
}
