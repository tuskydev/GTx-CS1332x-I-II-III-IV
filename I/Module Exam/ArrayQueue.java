/**
 * Your implementation of an ArrayQueue.
 */
public class ArrayQueue<T> {

  /*
   * The initial capacity of the ArrayQueue.
   *
   * DO NOT MODIFY THIS VARIABLE.
   */
  public static final int INITIAL_CAPACITY = 9;

  /*
   * Do not add new instance variables or modify existing ones.
   */
  private T[] backingArray;
  private int front;
  private int size;

  /**
   * This is the constructor that constructs a new ArrayQueue.
   *
   * Recall that Java does not allow for regular generic array creation,
   * so instead we cast an Object[] to a T[] to get the generic typing.
   */
  public ArrayQueue() {
      // DO NOT MODIFY THIS METHOD!
      backingArray = (T[]) new Object[INITIAL_CAPACITY];
  }

  /**
   * Adds the data to the back of the queue.
   *
   * Method should run in O(1) time.
   *
   * ASSUMPTIONS:
   * - You may assume that the backingArray does not need to be resized.
   * - You may assume that the data is not null.
   *
   * @param data the data to add to the back of the queue
   */
  public void enqueue(T data) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    backingArray[(size + front) % backingArray.length] = data;
    size++;
  }

  /**
   * Returns the backing array of the queue.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return the backing array of the queue
   */
  public T[] getBackingArray() {
      // DO NOT MODIFY THIS METHOD!
      return backingArray;
  }

  /**
   * Returns the size of the queue.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return the size of the queue
   */
  public int size() {
      // DO NOT MODIFY THIS METHOD!
      return size;
  }
}