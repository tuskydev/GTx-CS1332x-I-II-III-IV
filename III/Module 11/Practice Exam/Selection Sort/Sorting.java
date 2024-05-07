import java.util.Comparator;

/**
 * Your implementation of Selection Sort.
 */
public class Sorting {

    /**
     * Implement selection sort.
     *
     * It should be: in-place unstable not adaptive
     *
     * Have a worst case running time of: O(n^2) And a best case running time of:
     * O(n^2)
     *
     * You may assume that the passed in array and comparator are both valid and
     * will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int idx = i;

            for (int e = i - 1; e >= 0; e--) {
                if (comparator.compare(arr[e], arr[idx]) > 0) {
                    idx = e;
                }
            }

        T temp = arr[i];
        arr[i] = arr[idx];
        arr[idx] = temp;
        }
    }
}

/*
[Executed at: Tue May 7 14:04:29 PDT 2024]

============================================================
Sorting.java successfully compiled.
============================================================
Success: All Tests Passed.

Score: 10.0 / 10.0
============================================================
*/