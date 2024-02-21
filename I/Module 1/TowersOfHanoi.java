public class TowersOfHanoi {
  public static void main(String[] args) {
    hanoi(3, 1, 3);
  }
  private static void hanoi(int n, int start, int end) {
    // Base case
    if (n == 1) {
      pm(start, end);
    }
    else {
      int other = 6 - (start + end);
      hanoi(n - 1, start, other);
      pm(start, end);
      hanoi(n - 1, other, end);
    }
  }

  private static void pm(int start, int end ) {
    System.out.println(start + "->" + end);
  }
}
