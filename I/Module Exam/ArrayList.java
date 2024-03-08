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
   * Adds the data the front of the list.
   *
   * Method should run in O(n) time.
   *
   * ASSUMPTIONS:
   * - You may assume that the backingArray will not need to be resized.
   * - You may assume that the data will never be null.
   *
   * @param data  the data to add at the specified index
   */
  public void addToFront(T data) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    for (int i = size - 1; i >= 0; i--) {
      backingArray[i + 1] = backingArray[i];
    }

    backingArray[0] = data;
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