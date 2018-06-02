// 100 Remove Duplicates from Sorted Array
// http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-array/
//
// Given a sorted array, remove the duplicates in place such that each element appear
// only once and return the new length.
// Do not allocate extra space for another array, you must do this in place with constant memory.
//
// Example
// Given input array A = [1,1,2],
//
// Your function should return length = 2, and A is now [1,2].

package lintcode;

public class RemoveDuplicatesFromSortedArray {
    /**
     * @param nums a array of integers
     * @return the length of unique array
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[++len] = nums[i];
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(new int[] { 1, 1, 2 }));
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(new int[] {}));
    }
}
