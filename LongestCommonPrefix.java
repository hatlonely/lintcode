// 78 Longest Common Prefix
// http://www.lintcode.com/en/problem/longest-common-prefix/
//
// Given k strings, find the longest common prefix (LCP).
//
// Example
// For strings "ABCD", "ABEF" and "ACEF", the LCP is "A"
// For strings "ABCDEFG", "ABCEFG" and "ABCEFA", the LCP is "ABC"

package lintcode;

public class LongestCommonPrefix {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        int len = Integer.MAX_VALUE;
        for (String str : strs) {
            if (len > str.length()) {
                len = str.length();
            }
        }
        String str = strs[0];
        int idx = 0;
        while (idx < len) {
            char ch = str.charAt(idx);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(idx) != ch) {
                    return str.substring(0, idx);
                }
            }
            idx++;
        }

        return str.substring(0, idx);
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(
                new String[] { "ABCD", "ABEF", "ABCF" }).equals("AB"));
    }
}
