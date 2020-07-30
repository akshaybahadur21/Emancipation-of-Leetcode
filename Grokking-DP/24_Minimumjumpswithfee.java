/*

Problem Statement #
Given a staircase with ‘n’ steps and an array of ‘n’ numbers representing the fee that you have to pay if you take the step. Implement a method to calculate the minimum fee required to reach the top of the staircase (beyond the top-most step). At every step, you have an option to take either 1 step, 2 steps, or 3 steps. You should assume that you are standing at the first step.

Example 1:

Number of stairs (n) : 6
Fee: {1,2,5,2,1,2}
Output: 3
Explanation: Starting from index '0', we can reach the top through: 0->3->top
The total fee we have to pay will be (1+2).
Example 2:

Number of stairs (n): 4
Fee: {2,3,4,5}
Output: 5
Explanation: Starting from index '0', we can reach the top through: 0->1->top
The total fee we have to pay will be (2+3).

*/

class Staircase {

  public int findMinFee(int[] fee) {
    return findMinFeeRecursive(fee, 0);
  }
  
  private int findMinFeeRecursive(int[] fee, int idx) {
    if(idx >= fee.length) return 0;
    return Math.min(Math.min(findMinFeeRecursive(fee, idx + 1), findMinFeeRecursive(fee, idx + 2)), findMinFeeRecursive(fee, idx + 3)) + fee[idx];
  }

  public static void main(String[] args) {
    Staircase sc = new Staircase();
    int[] fee = {1,2,5,2,1,2};
    System.out.println(sc.findMinFee(fee));
    fee = new int[]{2,3,4,5};
    System.out.println(sc.findMinFee(fee));
  }
}

class Staircase {

  public int findMinFee(int[] fee) {
    Integer dp[] = new Integer[fee.length];
    return findMinFeeRecursive(dp, fee, 0);
  }
  
  private int findMinFeeRecursive(Integer[] cache, int[] fee, int idx) {
    if(idx >= fee.length) return 0;
    if(cache[idx] != null) return cache[idx];
    cache[idx] = Math.min(Math.min(findMinFeeRecursive(cache, fee, idx + 1), findMinFeeRecursive(cache, fee, idx + 2)), findMinFeeRecursive(cache, fee, idx + 3)) + fee[idx];
    return cache[idx];
  }

  public static void main(String[] args) {
    Staircase sc = new Staircase();
    int[] fee = {1,2,5,2,1,2};
    System.out.println(sc.findMinFee(fee));
    fee = new int[]{2,3,4,5};
    System.out.println(sc.findMinFee(fee));
  }
}

class Staircase {

  public int findMinFee(int[] fee) {
    int[] dp = new int[fee.length + 1];
    dp[0] = 0;
    dp[1] = fee[0];
    dp[2] = dp[3] = fee[0];
    for(int i = 3; i < fee.length; i++)
      dp[i + 1] = Math.min(dp[i] + fee[i], Math.min(dp[i - 1] + fee[i - 1], dp[i - 2] + fee[i -2]));
    return dp[fee.length];
  }

  public static void main(String[] args) {
    Staircase sc = new Staircase();
    int[] fee = { 1, 2, 5, 2, 1, 2 };
    System.out.println(sc.findMinFee(fee));
    fee = new int[] { 2, 3, 4, 5 };
    System.out.println(sc.findMinFee(fee));
  }
}
