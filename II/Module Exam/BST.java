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
     * Returns the data from the tree matching the given parameter.
     *
     * This should be done recursively.
     *
     * Do not return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to search for. You may assume data is never null.
     * @return The data in the tree equal to the parameter.
     * @throws java.util.NoSuchElementException If the data is not in the tree.
     */
    public T get(T data) {
        return getHelper(root, data);

    }

    private T getHelper(BSTNode<T> curr, T data) {
        if (curr == null) {
            throw new NoSuchElementException("Data not found!");
        }
        int comparison = data.compareTo(curr.getData());
        if (comparison < 0) {
            // Data is smaller, go left
            return getHelper(curr.getLeft(), data);
        } else if (comparison > 0) {
            // Data is bigger, go right
            return getHelper(curr.getRight(), data);
        } else {
            // Found the data
            return curr.getData();
        }
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
     * 3: The node containing the data has 2 children. Use the PREDECESSOR to
     * replace the data. You should use recursion to find and remove the
     * predecessor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove. You may assume that data is never null.
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the data is not in the tree.
     */
    public T remove(T data) {
        BSTNode<T> dummyNode = new BSTNode<>(null);
    
        root = removeHelper(root, data, dummyNode);
    
        return dummyNode.getData();
      }
    
      private BSTNode<T> removeHelper(BSTNode<T>curr, T data, BSTNode<T> dummy) {
        if (curr == null) {
          throw new NoSuchElementException("Data not found!");
        }
        else if (data.compareTo(curr.getData()) < 0) {
          // Data is smaller
          curr.setLeft(removeHelper(curr.getLeft(), data, dummy));
        }
        else if (data.compareTo(curr.getData()) > 0) {
        // Data is bigger
          curr.setRight(removeHelper(curr.getRight(), data, dummy));
        }
    
        else {
          // Data found
          dummy.setData(curr.getData());
          --size;
    
          // 0 Children
          if (curr.getLeft() == null && curr.getRight() == null) {
            return null;
          }
    
          // 1 Children
          else if (curr.getLeft() != null && curr.getRight() == null) {
            return curr.getLeft();
          }
          else if (curr.getLeft() == null && curr.getRight() != null) {
            return curr.getRight();
          }
    
          // 2 Children
          else {
            BSTNode<T> tempDummyNode = new BSTNode<>(null);
    
            curr.setRight(findPredecessorNode(curr.getRight(), tempDummyNode));
            curr.setData(tempDummyNode.getData());
          }
        }
    
        return curr;
      }

      private BSTNode<T> findPredecessorNode(BSTNode<T> curr, BSTNode<T> tempNode) {
        if (curr.getLeft() == null) {
            tempNode.setData(curr.getData());
            return curr.getRight();
        } else {
            curr.setLeft(findPredecessorNode(curr.getLeft(), tempNode));
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