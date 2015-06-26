// 172 Remove Element
// http://www.lintcode.com/en/problem/remove-element/
//
// Given an array and a value, remove all occurrences of that value in place
// and return the new length.
// The order of elements can be changed, and the elements after the new length don't matter.
//
// Example
// Given an array [0,4,4,0,0,2,4,4], value=4
//
// return 4 and front four elements of the array is [0,0,0,2]

package lintcode;

public class RemoveElement {
    /**
     * @param numbers: numbers list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    public int removeElement(int[] numbers, int elem) {
        int len = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != elem) {
                numbers[len++] = numbers[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(new int[] { 0, 4, 4, 0, 0, 2, 4, 4 }, 4));
    }

}
