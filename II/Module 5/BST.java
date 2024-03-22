import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
      // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      if (data == null) {
        throw new IllegalArgumentException("Data cannot be null!");
      }

      root = addHelper(root, data);
    }

    private BSTNode<T> addHelper(BSTNode<T> curr, T data) {
      if (curr == null) {
        size++;
        return new BSTNode<>(data);
      }
      else if (data.compareTo(curr.getData()) == 0) {
        // Data is same
        return curr;
      }
      else if (data.compareTo(curr.getData()) < 0) {
        // Data is smaller
        curr.setLeft(addHelper(curr.getLeft(), data));
      }
      else if (data.compareTo(curr.getData()) > 0) {
        // Data is bigger
        curr.setRight(addHelper(curr.getRight(), data));
      }

      return curr;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
      // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
      if (data == null) {
        throw new IllegalArgumentException("Data cannot be null!");
      }

      BSTNode<T> dummy = new BSTNode<>(null);
      root = removeHelper(root, data, dummy);

      return dummy.getData();
    }

    private BSTNode<T> removeHelper(BSTNode<T> curr, T data, BSTNode<T> dummy) {
      if (curr == null) {
        // Data not found
        throw new NoSuchElementException("Error: data not found");
      }
      else if (data.compareTo(curr.getData()) < 0) {
        curr.setLeft(removeHelper(curr.getLeft(), data, dummy));
      }
      else if (data.compareTo(curr.getData()) > 0) {
        curr.setRight(removeHelper(curr.getRight(), data, dummy));
      }
      else {
        // Data found
        dummy.setData(curr.getData());
        size--;

        // 0 Children
        if (curr.getLeft() == null & curr.getRight() == null) {
          return null;
        }

        // 1 Children
        else if (curr.getLeft() != null & curr.getRight() == null) {
          return curr.getLeft();
        }
        else if (curr.getLeft() == null & curr.getRight() != null) {
          return curr.getRight();
        }

        // 2 Children
        else {
          BSTNode<T> dummyTwo = new BSTNode<>(null);
          curr.setRight(findSuccessor(curr.getRight(), dummyTwo));
          curr.setData(dummyTwo.getData());
        }
      }

      return curr;
    }

    private BSTNode<T> findSuccessor(BSTNode<T> curr, BSTNode<T> dummyTwo) {
      if (curr.getLeft() == null) {
        dummyTwo.setData(curr.getData());
        return curr.getRight();
      } else {
        curr.setLeft(findSuccessor(curr.getLeft(), dummyTwo));
      }

      return curr;
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}

/*
[Executed at: Fri Mar 22 8:35:53 PDT 2024]

============================================================
BST.java successfully compiled.
============================================================
Success: All Tests Passed.

Score: 10.0 / 10.0
============================================================
*/
