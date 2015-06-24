// 13 strStr
// http://www.lintcode.com/en/problem/strstr/

// strstr (a.k.a find sub string), is a useful function in string operation.
// Your task is to implement this function.
// For a given source string and a target string, you should output the first index(from 0)
// of target string in source string.
// If target does not exist in source, just return -1.
//
// Example
// If source = "source" and target = "target", return -1.
// If source = "abcdabcdefg" and target = "bcd", return 1.
//
// Challenge
// O(n2) is acceptable. Can you implement an O(n) algorithm? (hint: KMP)
//
// Clarification
// Do I need to implement KMP Algorithm in a real interview?
//
// Not necessary. When you meet this problem in a real interview,
// the interviewer may just want to test your basic implementation ability.
// But make sure your confirm with the interviewer first.

package lintcode;

public class StrStr {
    /**
     * unday 字符串匹配算法
     *
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     * @return a index to the first occurrence of target in source, or -1 if
     *         target is not part of source.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        if (target.equals("")) {
            return 0;
        }

        int pos = 0;
        while (source.length() - pos >= target.length()) {
            int idx1 = pos;
            int idx2 = 0;
            while (source.charAt(idx1++) == target.charAt(idx2++)) {
                if (idx2 == target.length()) {
                    return idx1 - idx2;
                }
                if (idx1 == source.length()) {
                    return -1;
                }
            }

            idx1 = pos + target.length();
            if (idx1 >= source.length()) {
                return -1;
            }
            idx2 = target.length() - 1;
            while (idx2 >= 0) {
                if (target.charAt(idx2) == source.charAt(idx1)) {
                    break;
                }
                idx2--;
            }

            pos = idx1 - idx2;
        }

        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        System.out.println(strStr.strStr("abcdefghijklmn", "def") == 3);
        System.out.println(strStr.strStr("abcdddeedefghijklmn", "def") == 8);
        System.out.println(strStr.strStr("aaa", "aaaa") == -1);
        System.out.println(strStr.strStr("mississippi", "a") == -1);
        System.out.println(strStr.strStr("", "") == 0);
        System.out.println(strStr.strStr("a", "a") == 0);
    }
}
