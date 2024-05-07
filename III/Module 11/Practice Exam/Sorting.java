import java.util.Comparator;

/**
 * Your implementation of Merge Sort.
 */
public class Sorting {

  /**
   * Implement merge sort.
   *
   * It should be: out-of-place stable not adaptive
   *
   * Have a worst case running time of: O(n log n) And a best case running time
   * of: O(n log n)
   *
   * You can create more arrays to run merge sort, but at the end, everything
   * should be merged back into the original T[] which was passed in.
   *
   * When splitting the array, if there is an odd number of elements, put the
   * extra data on the right side.
   *
   * Hint: You may need to create a helper method that merges two arrays back into
   * the original T[] array. If two data are equal when merging, think about which
   * subarray you should pull from first.
   *
   * You may assume that the passed in array and comparator are both valid and
   * will not be null.
   *
   * @param <T>        Data type to sort.
   * @param arr        The array to be sorted.
   * @param comparator The Comparator used to compare the data in arr.
   */
  public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
    if (arr.length == 1) {
      return;
    }

    int length = arr.length;
    int midIndex = length / 2;
    T[] left = (T[]) new Object[midIndex];
    T[] right = (T[]) new Object[length - midIndex];
    for (int i = 0; i < midIndex; i++) {
      left[i] = arr[i];
    }
    for (int i = midIndex; i < length; i++) {
      right[i - midIndex] = arr[i];
    }

    mergeSort(left, comparator);
    mergeSort(right, comparator);

    int i = 0, j = 0;

    while (i != left.length && j != right.length) {
      if (comparator.compare(left[i], right[j]) <= 0) {
        arr[i + j] = left[i];
        ++i;
      } else {
        arr[i + j] = right[j];
        ++j;
      }
    }
  }
}