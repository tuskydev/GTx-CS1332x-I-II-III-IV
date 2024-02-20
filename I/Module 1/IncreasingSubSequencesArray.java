import java.util.Arrays;

public class IncreasingSubSequencesArray {
  public static void main(String[] args) {
    int[] sampleList = {1, 7, 3, 5, 2, 8, 10, 24, -1, -5, 4};
    int[] inputList = {3, 2, -1, -5, 4};


    System.out.println("This is final result: " + recursiveArray(sampleList, inputList, 0));
  }

  private static int recursiveArray(int[] sample, int[] input, int highscore) {
      // Base case 1:
    if (sample.length == 0 | input.length == 0) {
      return highscore;
    }

    if (sample[0] == input[0]) {
      return recursiveArray(Arrays.copyOfRange(sample, 1, sample.length), Arrays.copyOfRange(input, 1, input.length), highscore + 1);
    } else {
      return recursiveArray(Arrays.copyOfRange(sample, 1, sample.length), Arrays.copyOfRange(input, 0, input.length), highscore);
    }
  }
}
