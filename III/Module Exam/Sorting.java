import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of LSD Radix Sort.
 */
public class Sorting {

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be: out-of-place stable not adaptive
     *
     * Have a worst case running time of: O(kn) And a best case running time of:
     * O(kn)
     *
     * For this question, you are given k: the number of digits in the greatest
     * magnitude number in arr. Because of this, you do not need to make an initial
     * O(n) pass through to determine this number.
     *
     * At no point should you find yourself needing a way to exponentiate a number;
     * any such method would be non-O(1). Think about how how you can get each power
     * of BASE naturally and efficiently as the algorithm progresses through each
     * digit.
     *
     * You may use an ArrayList or LinkedList if you wish. Be sure the List
     * implementation you choose allows for stability while being as efficient as
     * possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     * @param k   The number of digits in the greatest magnitude number in arr.
     */
    public static void lsdRadixSort(int[] arr, int k) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    }
}