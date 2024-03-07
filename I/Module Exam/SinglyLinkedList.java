/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

  /*
   * Do not add new instance variables or modify existing ones.
   */
  private SinglyLinkedListNode<T> head;
  private SinglyLinkedListNode<T> tail;
  private int size;

  /*
   * Do not add a constructor.
   */

  /**
   * Adds the element to the specified index.
   *
   * Must be O(1) for indices 0 and size and O(n) for all other cases.
   *
   * ASSUMPTIONS:
   * - You may assume that the index will always be valid [0, size]
   * - You may assume that the data will not be null
   *
   * @param index the index to add the new element
   * @param data  the data to add
   */
  public void addAtIndex(int index, T data) {
    // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
    SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);

    // List is empty
    if (index == 0) {
      if (size == 0) {
        head = tail = newNode;
      } else {
        newNode.setNext(head);
        head = newNode;
      }
    } else if (index == size) {
      tail.setNext(newNode);
      tail = newNode;
    } else {
      SinglyLinkedListNode currNode = head;
      for (int i = 0; i < index - 1; i++) {
        currNode = currNode.getNext();
      }
      newNode.setNext(currNode.getNext());
      currNode.setNext(newNode);
    }

    size++;
  }

  /**
   * Returns the head node of the list.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return the node at the head of the list
   */
  public SinglyLinkedListNode<T> getHead() {
      // DO NOT MODIFY THIS METHOD!
      return head;
  }

  /**
   * Returns the tail node of the list.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return the node at the tail of the list
   */
  public SinglyLinkedListNode<T> getTail() {
      // DO NOT MODIFY THIS METHOD!
      return tail;
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
[Executed at: Thu Mar 7 10:36:52 PST 2024]

============================================================
SinglyLinkedList.java successfully compiled.
============================================================
Success: All Tests Passed.

Score: 10.0 / 10.0
============================================================
*/
