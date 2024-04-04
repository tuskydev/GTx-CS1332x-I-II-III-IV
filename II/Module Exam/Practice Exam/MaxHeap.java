/**
 * Your implementation of a MaxHeap.
 */
public class MaxHeap<T extends Comparable<? super T>> {

  /*
   * The initial capacity of the MaxHeap when created with the default
   * constructor.
   *
   * DO NOT MODIFY THIS VARIABLE!
   */
  public static final int INITIAL_CAPACITY = 13;

  /*
   * Do not add new instance variables or modify existing ones.
   */
  private T[] backingArray;
  private int size;

  /**
   * This is the constructor that constructs a new MaxHeap.
   *
   * Recall that Java does not allow for regular generic array creation,
   * so instead we cast a Comparable[] to a T[] to get the generic typing.
   */
  public MaxHeap() {
      //DO NOT MODIFY THIS METHOD!
      backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
  }

  /**
   * Removes and returns the max item of the heap. As usual for array-backed
   * structures, be sure to null out spots as you remove. Do not decrease the
   * capacity of the backing array.
   *
   * Method should run in O(log n) time.
   *
   * You may assume that the heap is not empty.
   *
   * @return The data that was removed.
   */
  public T remove() {
    T removedValue = backingArray[1];
    backingArray[1] = backingArray[size];
    backingArray[size--] = null;
    heapify(1);

    return removedValue;
  }

  private void heapify(int index) {
    int currBiggest = index;

    if (index * 2 <= size && backingArray[index * 2].compareTo(backingArray[currBiggest]) > 0) {
      // LEFT side is bigger than currBiggest
      currBiggest = index * 2;
    }

    if ((index * 2) + 1 <= size && backingArray[(index * 2) + 1].compareTo(backingArray[currBiggest]) > 0) {
      // RIGHT side is bigger than currBiggest
      currBiggest = (index * 2) + 1;
    }

    // Swap if there's a bigger value
    if (currBiggest != index) {
      T savedSwappedValue = backingArray[index];
      backingArray[index] = backingArray[currBiggest];
      backingArray[currBiggest] = savedSwappedValue;

      heapify(currBiggest);
    }
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