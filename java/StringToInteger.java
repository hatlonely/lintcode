// 54 String to Integer(atoi)
// http://www.lintcode.com/en/problem/string-to-integeratoi/
//
// Implement function atoi to convert a string to an integer.
// If no valid conversion could be performed, a zero value is returned.
// If the correct value is out of the range of representable values,
// INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
//
// Example
// "10" => 10
// "-1" => -1
// "123123123123123" => 2147483647
// "1.0" => 1

package lintcode;

public class StringToInteger {
    /**
     * @param str A string
     * @return An integer
     */
    public int atoi(String str) {
        str = str.trim();
        long value = 0;
        int idx = 0;

        if (str.equals("")) {
            return 0;
        }

        if (str.charAt(0) == '-') {
            idx++;
            for (; idx < str.length(); idx++) {
                char ch = str.charAt(idx);
                if (Character.isDigit(ch)) {
                    value = value * 10 - str.charAt(idx) + '0';
                    if (value < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    break;
                }
            }
        } else {
            if (str.charAt(0) == '+') {
                idx++;
            }
            for (; idx < str.length(); idx++) {
                char ch = str.charAt(idx);
                if (Character.isDigit(ch)) {
                    value = value * 10 + str.charAt(idx) - '0';
                    if (value > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    break;
                }
            }
        }

        return (int) value;
    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.atoi("2147483647") == 2147483647);
        System.out.println(stringToInteger.atoi("-2147483648") == -2147483648);
        System.out.println(stringToInteger.atoi("2147483648") == 2147483647);
        System.out.println(stringToInteger.atoi("1.0") == 1);
        System.out.println(stringToInteger.atoi("-1") == -1);
        System.out.println(stringToInteger.atoi("   k") == 0);
        System.out.println(stringToInteger.atoi("  52lintcode") == 52);
        System.out.println(stringToInteger.atoi(" -00000012d121212121212121 ") == -12);
    }
}
