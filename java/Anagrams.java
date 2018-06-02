// Anagrams
// http://www.lintcode.com/en/problem/anagrams/
//
// Given an array of strings, return all groups of strings that are anagrams.
//
// Example
// Given ["lint", "intl", "inlt", "code"], return ["lint", "inlt", "intl"].
// Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
//
// Note
// All inputs will be in lower-case

package lintcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Anagrams {
    /**
     * @param strs 输入字符串
     * @return 有的颠倒字符串
     */
    public List<String> anagrams(String[] strs) {
        List<String> result = new LinkedList<String>();
        boolean[] flags = new boolean[strs.length];
        Arrays.fill(flags, false);

        int[] times1 = new int[26];
        int[] times2 = new int[26];

        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(times1, 0);
            for (int j = 0; j < strs[i].length(); j++) {
                times1[strs[i].charAt(j) - 'a']++;
            }

            for (int k = i + 1; k < strs.length; k++) {
                if (flags[k] || strs[i].length() != strs[k].length()) {
                    continue;
                }
                Arrays.fill(times2, 0);
                for (int j = 0; j < strs[k].length(); j++) {
                    times2[strs[k].charAt(j) - 'a']++;
                }

                if (Arrays.equals(times1, times2)) {
                    flags[i] = true;
                    flags[k] = true;
                }
            }
        }

        for (int i = 0; i < flags.length; i++) {
            if (flags[i]) {
                result.add(strs[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        System.out.println(anagrams.anagrams(new String[] { "lint", "intl", "inlt", "code" }));
        System.out.println(anagrams.anagrams(new String[] { "ab", "ba", "cd", "dc", "e" }));
        System.out.println(anagrams.anagrams(new String[] { "a", "b" }));
    }
}
