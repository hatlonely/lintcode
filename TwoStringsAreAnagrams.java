// 两个字符串是变位词
// http://www.lintcode.com/zh-cn/problem/two-strings-are-anagrams/
// 写出一个函数 anagram(source, target) 去判断两个字符串是否是颠倒字母顺序构成的

package lintcode;

import java.util.Arrays;

public class TwoStringsAreAnagrams {
    private int[] sourceTimes = new int[256];
    private int[] targetTimes = new int[256];

    /**
     * @param source
     *            : The first string
     * @param target
     *            : The second string
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
        for (int i = 0; i < 256; i++) {
            if (sourceTimes[i] != targetTimes[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TwoStringsAreAnagrams twoStringsAreAnagrams = new TwoStringsAreAnagrams();
        System.out.println(twoStringsAreAnagrams.anagram("abcd", "dcba"));
    }
}
