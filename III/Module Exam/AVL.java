/**
 * Your implementation of the AVL tree rotations.
 */
public class AVL<T extends Comparable<? super T>> {

  /**
   * DO NOT ADD ANY GLOBAL VARIABLES!
   */

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
   * This method should be called in rotateLeft() and rotateRight().
   *
   * @param currentNode The node to update the height and balance factor of.
   */
  public void updateHeightAndBF(AVLNode<T> currentNode) {
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
   * @param currentNode The current node under inspection that will rotate.
   * @return The parent of the node passed in (after the rotation).
   */
  public AVLNode<T> rotateLeft(AVLNode<T> currentNode) {
      // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
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
   * @param currentNode The current node under inspection that will rotate.
   * @return The parent of the node passed in (after the rotation).
   */
  public AVLNode<T> rotateRight(AVLNode<T> currentNode) {
      // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
  }
}