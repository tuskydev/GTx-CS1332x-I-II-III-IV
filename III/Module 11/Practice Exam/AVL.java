/**
 * Your implementation of an AVL.
 */
public class AVL<T extends Comparable<? super T>> {

  /*
   * Do not add new instance variables or modify existing ones.
   */
  private AVLNode<T> root;
  private int size;

  /*
   * Do not add a constructor.
   */

  /**
   * Adds the element to the tree.
   *
   * Start by adding it as a leaf like in a regular BST and then rotate the
   * tree as necessary.
   *
   * If the data is already in the tree, then nothing should be done (the
   * duplicate shouldn't get added, and size should not be incremented).
   *
   * Remember to recalculate heights and balance factors while going back
   * up the tree after adding the element, making sure to rebalance if
   * necessary. This is as simple as calling the balance() method on the
   * current node, before returning it (assuming that your balance method
   * is written correctly from part 1 of this assignment).
   *
   * You may assume that data is not null.
   *
   * @param data The data to add.
   */
  public void add(T data) {
      while (root != null) {
        if (root.getLeft().getData() < data) {
          
        }
      }
  }

  /**
   * Updates the height and balance factor of a node using its
   * setter methods.
   *
   * Recall that a null node has a height of -1. If a node is not
   * null, then the height of that node will be its height instance
   * data. The height of a node is the max of its left child's height
   * and right child's height, plus one.
   *
   * The balance factor of a node is the height of its left child
   * minus the height of its right child.
   *
   * This method should run in O(1).
   * You may assume that the passed in node is not null.
   *
   * This method should only be called in rotateLeft(), rotateRight(),
   * and balance().
   *
   * @param currentNode The node to update the height and balance factor of.
   */
  private void updateHeightAndBF(AVLNode<T> currentNode) {
      // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
  }

  /**
   * Method that rotates a current node to the left. After saving the
   * current's right node to a variable, the right node's left subtree will
   * become the current node's right subtree. The current node will become
   * the right node's left subtree.
   *
   * Don't forget to recalculate the height and balance factor of all
   * affected nodes, using updateHeightAndBF().
   *
   * This method should run in O(1).
   *
   * You may assume that the passed in node is not null and that the subtree
   * starting at that node is right heavy. Therefore, you do not need to
   * perform any preliminary checks, rather, you can immediately perform a
   * left rotation on the passed in node and return the new root of the subtree.
   *
   * This method should only be called in balance().
   *
   * @param currentNode The current node under inspection that will rotate.
   * @return The parent of the node passed in (after the rotation).
   */
  private AVLNode<T> rotateLeft(AVLNode<T> currentNode) {
      AVLNode rightChild = currentNode.getRight();

      rightChild.setLeft(currentNode);
      currentNode.setRight(rightChild.getLeft());

      updateHeightAndBF(currentNode);
      updateHeightAndBF(rightChild);

      return rightChild;
  }

  /**
   * Method that rotates a current node to the right. After saving the
   * current's left node to a variable, the left node's right subtree will
   * become the current node's left subtree. The current node will become
   * the left node's right subtree.
   *
   * Don't forget to recalculate the height and balance factor of all
   * affected nodes, using updateHeightAndBF().
   *
   * This method should run in O(1).
   *
   * You may assume that the passed in node is not null and that the subtree
   * starting at that node is left heavy. Therefore, you do not need to perform
   * any preliminary checks, rather, you can immediately perform a right
   * rotation on the passed in node and return the new root of the subtree.
   *
   * This method should only be called in balance().
   *
   * @param currentNode The current node under inspection that will rotate.
   * @return The parent of the node passed in (after the rotation).
   */
  private AVLNode<T> rotateRight(AVLNode<T> currentNode) {
    AVLNode leftChild = currentNode.getLeft();

    leftChild.setRight(currentNode);
    currentNode.setLeft(leftChild.getRight());

    updateHeightAndBF(currentNode);
    updateHeightAndBF(leftChild);

    return leftChild;
  }

  /**
   * Method that balances out the tree starting at the node passed in.
   * This method should be called in your add() and remove() methods to
   * facilitate rebalancing your tree after an operation.
   *
   * The height and balance factor of the current node is first recalculated.
   * Based on the balance factor, a no rotation, a single rotation, or a
   * double rotation takes place. The current node is returned.
   *
   * You may assume that the passed in node is not null. Therefore, you do
   * not need to perform any preliminary checks, rather, you can immediately
   * check to see if any rotations need to be performed.
   *
   * This method should run in O(1).
   *
   * @param currentNode The current node under inspection.
   * @return The AVLNode that the caller should return.
   */
  private AVLNode<T> balance(AVLNode<T> currentNode) {
      // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

      /* First, we update the height and balance factor of the current node. */
      updateHeightAndBF(currentNode);

      if ( /* Condition for a right heavy tree. */ ) {
          if ( /* Condition for a right-left rotation. */ ) {
              currentNode.setRight(rotateRight(currentNode.getRight()));
          }
          currentNode = rotateLeft(currentNode);
      } else if ( /* Condition for a left heavy tree. */ ) {
          if ( /* Condition for a left-right rotation. */ ) {
              currentNode.setLeft(rotateLeft(currentNode.getLeft()));
          }
          currentNode = rotateRight(currentNode);
      }

      return currentNode;
  }

  /**
   * Returns the root of the tree.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return The root of the tree.
   */
  public AVLNode<T> getRoot() {
      // DO NOT MODIFY THIS METHOD!
      return root;
  }

  /**
   * Returns the size of the tree.
   *
   * For grading purposes only. You shouldn't need to use this method since
   * you have direct access to the variable.
   *
   * @return The size of the tree.
   */
  public int size() {
      // DO NOT MODIFY THIS METHOD!
      return size;
  }
}