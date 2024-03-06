/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

  /*
   * The initial capacity of the ArrayList.
   *
   * DO NOT MODIFY THIS VARIABLE!
   */
  public static final int INITIAL_CAPACITY = 9;

  /*
   * Do not add new instance variables or modify existing ones.
   */
  private T[] backingArray;
  private int size;

  /**
   * This is the constructor that constructs a new ArrayList.
   * 
   * Recall that Java does not allow for regular generic array creation,
   * so instead we cast an Object[] to a T[] to get the generic typing.
   */
  public ArrayList() {
      //DO NOT MODIFY THIS METHOD!
      backingArray = (T[]) new Object[INITIAL_CAPACITY];
  }

  /**
   * Adds the data to the specified index.
   *
   * Must be O(1) for index size and O(n) for all other cases.
   *
   * ASSUMPTIONS:
   * - You may assume that the backingArray will not need to be resized.
   * - You may assume that the index is valid [0, size].
   * - You may assume that the data will never be null.
   *
   * @param index the index at which to add the new data
   * @param data  the data to add at the specified index
   */
  public void addAtIndex(int index, T data) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    // Reach destination and add data
    for (int i = size - 1; i >= index; i--) {
      // Shift values to the right
      backingArray[i + 1] = backingArray[i];
    }

    backingArray[index] = data;
    size++;
  }

  /**
   * Returns the backing array of the list.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return the backing array of the list
   */
  public T[] getBackingArray() {
      // DO NOT MODIFY THIS METHOD!
      return backingArray;
  }

  /**
   * Returns the size of the list.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return the size of the list
   */
  public int size() {
      // DO NOT MODIFY THIS METHOD!
      return size;
  }
}

/*
[Executed at: Wed Mar 6 7:55:50 PST 2024]

============================================================
ArrayList.java successfully compiled.
============================================================
Success: All Tests Passed.

Score: 10.0 / 10.0
============================================================
*/