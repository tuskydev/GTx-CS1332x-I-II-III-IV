import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

  /**
   * The initial capacity of the MinHeap.
   *
   * DO NOT MODIFY THIS VARIABLE!
   */
  public static final int INITIAL_CAPACITY = 13;

    /*
    * Do not add new instance variables or modify existing ones.
    */
  private T[] backingArray;
  private int size;

  private void checkIfNull(T data) {
    if (data == null) {
      throw new IllegalArgumentException("Data cannot be null!");
    }
  }

  private void resizeBackingArray() {
    if (size >= backingArray.length - 1) {
      T[] newBackingArray = (T[]) new Comparable[backingArray.length * 2];

      for (int i = 1; i <= size; i++) {
        newBackingArray[i] = backingArray[i];
      }

      backingArray = newBackingArray;
    }
  }

  private void upHeap(int index) {
    if (index > 1) {
      int parentIndex = index / 2;

      if (backingArray[parentIndex].compareTo(backingArray[index]) > 0) {
        // Swap them
        T dummyValue = backingArray[parentIndex];
        backingArray[parentIndex] = backingArray[index];
        backingArray[index] = dummyValue;

        upHeap(parentIndex);
      }
    }
  }

  private void downHeap(int index) {
    int currentSmallest = index;

    if (2 * index <= size && backingArray[2 * index].compareTo(backingArray[currentSmallest]) < 0) {
      currentSmallest = 2 * index;
    }

    if (2 * index + 1 <= size && backingArray[2 * index + 1].compareTo(backingArray[currentSmallest]) < 0) {
      currentSmallest = 2 * index + 1;
    }

    if (currentSmallest != index) {
      // Swap value with the smallest
      T dummyValue = backingArray[index];
      backingArray[index] = backingArray[currentSmallest];
      backingArray[currentSmallest] = dummyValue;

      // Heapify!!!
      downHeap(currentSmallest);
    }
  }

  /**
   * This is the constructor that constructs a new MinHeap.
   *
   * Recall that Java does not allow for regular generic array creation,
   * so instead we cast a Comparable[] to a T[] to get the generic typing.
   */
  public MinHeap() {
    //DO NOT MODIFY THIS METHOD!
    backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
  }

  /**
   * Adds an item to the heap. If the backing array is full (except for
   * index 0) and you're trying to add a new item, then double its capacity.
   *
   * Method should run in amortized O(log n) time.
   *
   * @param data The data to add.
   * @throws java.lang.IllegalArgumentException If the data is null.
   */
  public void add(T data) {
    checkIfNull(data);
    resizeBackingArray();

    // Add the data to the array
      backingArray[++size] = data;
      upHeap(size);
  }

  /**
   * Removes and returns the min item of the heap. As usual for array-backed
   * structures, be sure to null out spots as you remove. Do not decrease the
   * capacity of the backing array.
   *
   * Method should run in O(log n) time.
   *
   * @return The data that was removed.
   * @throws java.util.NoSuchElementException If the heap is empty.
   */
  public T remove() {
    // Heap is empty
    if (size == 0) {
      throw new NoSuchElementException("Heap is empty, cannot delete.");
    }

    // Save the removed item
    T dummyRemovedItem = backingArray[1];

    // Replace it with the last index item
    backingArray[1] = backingArray[size];
    backingArray[size--] = null;

    // Down-Heapify!
    downHeap(1);

    return dummyRemovedItem;
  }

  /**
   * Returns the backing array of the heap.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return The backing array of the list
   */
  public T[] getBackingArray() {
    // DO NOT MODIFY THIS METHOD!
    return backingArray;
  }

  /**
   * Returns the size of the heap.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return The size of the list
   */
  public int size() {
    // DO NOT MODIFY THIS METHOD!
    return size;
  }
}