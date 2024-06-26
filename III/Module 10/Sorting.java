import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

  /**
   * Implement bubble sort.
   *
   * It should be:
   * in-place
   * stable
   * adaptive
   *
   * Have a worst case running time of: O(n^2)
   * And a best case running time of: O(n)
   *
   * NOTE: You should implement bubble sort with the last swap optimization.
   *
   * You may assume that the passed in array and comparator
   * are both valid and will never be null.
   *
   * @param <T>        Data type to sort.
   * @param arr        The array that must be sorted after the method runs.
   * @param comparator The Comparator used to compare the data in arr.
   */
  public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
    int stopIndex = arr.length - 1;

    while (stopIndex != 0) {
      int lastSwapped = 0;

      for (int i = 0; i < stopIndex; i++) {
        if (comparator.compare(arr[i], arr[i + 1]) > 0) {
          T tempValue = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = tempValue;

          lastSwapped = i;
        }
      }

      stopIndex = lastSwapped;
    }
  }

  /**
   * Implement selection sort.
   *
   * It should be:
   * in-place
   * unstable
   * not adaptive
   *
   * Have a worst case running time of: O(n^2)
   * And a best case running time of: O(n^2)
   *
   * You may assume that the passed in array and comparator
   * are both valid and will never be null.
   *
   * @param <T>        Data type to sort.
   * @param arr        The array that must be sorted after the method runs.
   * @param comparator The Comparator used to compare the data in arr.
   */
  public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
    for (int i = arr.length - 1; i >= 1; i--) {
      int maxVal = i;

      for (int e = i - 1; e >= 0; e--) {
        if (comparator.compare(arr[e], arr[maxVal]) > 0) {
          maxVal = e;
        }
      }

      T tempVal = arr[i];
      arr[i] = arr[maxVal];
      arr[maxVal] = tempVal;
    }
  }

  /**
   * Implement insertion sort.
   *
   * It should be:
   * in-place
   * stable
   * adaptive
   *
   * Have a worst case running time of: O(n^2)
   * And a best case running time of: O(n)
   *
   * You may assume that the passed in array and comparator
   * are both valid and will never be null.
   *
   * @param <T>        Data type to sort.
   * @param arr        The array that must be sorted after the method runs.
   * @param comparator The Comparator used to compare the data in arr.
   */
  public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
    for (int i = 1; i < arr.length; i++) {
      int j = i;
      while (j > 0 && comparator.compare(arr[j], arr[j - 1]) < 0) {
        T tempVal = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = tempVal;

        --j;
      }
    }
  }
}

/*
[Executed at: Tue Apr 23 7:53:23 PDT 2024]

============================================================
Sorting.java successfully compiled.
============================================================
Success: All Tests Passed.

Score: 10.0 / 10.0
============================================================
*/