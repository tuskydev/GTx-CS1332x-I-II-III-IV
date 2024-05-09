import java.util.Comparator;

/**
 * Your implementation of Bubble Sort.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be: in-place stable adaptive
     *
     * Have a worst case running time of: O(n^2) And a best case running time of:
     * O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator are both valid and
     * will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        int stopIndex = arr.length - 1;

        while (stopIndex != 0) {
          int i = 0;
          int lastSwapped = 0;

          while (i < stopIndex) {
            if (comparator.compare(arr[i], arr[i + 1]) > 0) {
              T temp = arr[i];
              arr[i] = arr[i + 1];
              arr[i + 1] = temp;

              lastSwapped = i;
            }
            ++i;
          }
          stopIndex = lastSwapped;
        }
    }
}

/*
[Executed at: Wed May 8 17:49:35 PDT 2024]

============================================================
Sorting.java successfully compiled.
============================================================
Success: All Tests Passed.

Score: 10.0 / 10.0
============================================================
*/