// 138 Subarray Sum
// http://www.lintcode.com/en/problem/subarray-sum/
//
// Given an integer array, find a subarray where the sum of numbers is zero.
// Your code should return the index of the first number and the index of the last number.
//
// Example
// Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
//
// Note
// There is at least one subarray that it's sum equals to zero.

package lintcode;

import java.util.ArrayList;

public class SubarraySum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and
     *          the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == 0) {
                result.add(i);
                result.add(i);
                return result;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(subarraySum.subarraySum(new int[] { -3, 1, 2, -3, 4 }));
    }
}
