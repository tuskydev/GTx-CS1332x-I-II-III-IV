public class TutorialAssignment {

  /**
   * This method should return the largest number in the passed-in array.
   *
   * Constraints:
   * 1 <= nums.length <= 100
   * -10000 <= nums[i] <= 10000
   *
   * @param nums An array containing integers.
   * @return The largest number in nums.
   */
  public static int tutorialAssignment(int[] nums) {
    // Write your solution here.
    int maxNum = Integer.MIN_VALUE;

    for (int i : nums) {
      if (i > maxNum) {
        maxNum = i;
      }
    }
    return maxNum;
  }

  public static void main(String[] args) {
    // Call the method on the instance
    int[] array = {1, 2, 3, 4, 5};

    // Print the result
    System.out.println(TutorialAssignment.tutorialAssignment(array));
  }
}
