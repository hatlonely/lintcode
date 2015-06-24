// 79 Longest Common Substring
// http://www.lintcode.com/en/problem/longest-common-substring/
//
// Given two strings, find the longest common substring.
// Return the length of it.
//
// Example
// Given A = "ABCD", B = "CBCE", return 2.

package lintcode;

public class LongestCommonSubstring {
    /**
     *
     * @param str1 first string
     * @param str2 second string
     * @return the length of the longest common substring.
     */
    public int longestCommonSubstring(String str1, String str2) {
        int len = 0;
        for (int i = 0; i < str1.length(); i++) {
            int idx2 = 0;
            while (idx2 < str2.length()) {
                int idx1 = i;
                while (idx2 < str2.length() && str1.charAt(idx1) != str2.charAt(idx2)) {
                    idx2++;
                }
                while (idx1 < str1.length() && idx2 < str2.length()
                        && str1.charAt(idx1) == str2.charAt(idx2)) {
                    idx1++;
                    idx2++;
                }
                if (len < idx1 - i) {
                    len = idx1 - i;
                }
            }
        }

        return len;
    }

    public static void main(String[] args) {
        LongestCommonSubstring longestCommonSubstring = new LongestCommonSubstring();
        System.out.println(longestCommonSubstring.longestCommonSubstring("ABCD", "CBCE"));
    }
}
