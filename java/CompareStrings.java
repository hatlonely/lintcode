// 55 Compare Strings
// http://www.lintcode.com/en/problem/compare-strings/
//
// Compare two strings source and target, determine whether source contains all of the characters in target.
// The characters in string source and target are all Upper Case letters.
//
// Example
// For source = "ABCD", target = "ACD", return true.
// For source = "ABCD", target = "AABC", return false.
//
// Note
// The characters of target in source are not necessary continuous or ordered.

package lintcode;

import java.util.Arrays;

public class CompareStrings {
    private int[] sourceTimes = new int[256];
    private int[] targetTimes = new int[256];

    /**
     * @param source string includes Upper Case letters
     * @param target string includes Upper Case letter
     * @return if string source contains all of the characters in target
     */
    public boolean compareStrings(String source, String target) {
        Arrays.fill(sourceTimes, 0);
        Arrays.fill(targetTimes, 0);

        int sourceLength = source.length();
        int targetLength = target.length();
        if (sourceLength < targetLength) {
            return false;
        }

        for (int i = 0; i < sourceLength; i++) {
            sourceTimes[source.charAt(i)]++;
        }
        for (int i = 0; i < targetLength; i++) {
            targetTimes[target.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (sourceTimes[i] < targetTimes[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CompareStrings compareStrings = new CompareStrings();
        System.out.println(compareStrings.compareStrings("abcdef", "ab"));
    }
}
