/*

Problem Statement #
Given an array of positive numbers, where each element represents the max number of jumps that can be made forward from that element, write a program to find the minimum number of jumps needed to reach the end of the array (starting from the first element). If an element is 0, then we cannot move through that element.

Example 1:

Input = {2,1,1,1,4}
Output = 3
Explanation: Starting from index '0', we can reach the last index through: 0->2->3->4
Example 2:

Input = {1,1,3,6,9,3,0,1,3}
Output = 4
Explanation: Starting from index '0', we can reach the last index through: 0->1->2->3->8

*/

class ArrayJump {

  public int countMinJumps(int[] jumps) {
    return this.countMinJumpsRecursive(jumps, 0);
  }

  private int countMinJumpsRecursive(int[] jumps, int idx) {
    if(idx == jumps.length - 1) return 0;
    if(jumps[idx] == 0) return Integer.MAX_VALUE;
    int total = Integer.MAX_VALUE;
    int start = idx + 1, end = idx + jumps[idx];
    for(int i = start; i <= end && i < jumps.length; i++){
      int minJumps = countMinJumpsRecursive(jumps, i);
      total = minJumps == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(total, minJumps + 1);
    }
    return total;
  }

  public static void main(String[] args) {
    ArrayJump aj = new ArrayJump();
    int[] jumps = {2, 1, 1, 1, 4};
    System.out.println(aj.countMinJumps(jumps));
    jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
    System.out.println(aj.countMinJumps(jumps));
  }
}

class ArrayJump {

  public int countMinJumps(int[] jumps) {
    Integer dp[] = new Integer[jumps.length];
    return this.countMinJumpsRecursive(dp, jumps, 0);
  }

  private int countMinJumpsRecursive(Integer[] cache, int[] jumps, int idx) {
    if(idx == jumps.length - 1) return 0;
    if(jumps[idx] == 0) return Integer.MAX_VALUE;
    if(cache[idx] != null) return cache[idx];
    int total = Integer.MAX_VALUE;
    int start = idx + 1, end = idx + jumps[idx];
    for(int i = start; i <= end && i < jumps.length; i++){
      int min = countMinJumpsRecursive(cache, jumps, i);
      total = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(total, min + 1);
      cache[idx] = total;
    }
    return cache[idx];
  }

  public static void main(String[] args) {
    ArrayJump aj = new ArrayJump();
    int[] jumps = {2, 1, 1, 1, 4};
    System.out.println(aj.countMinJumps(jumps));
    jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
    System.out.println(aj.countMinJumps(jumps));
  }
}

class ArrayJump {

  public int countMinJumps(int[] jumps) {
    int[] dp = new int[jumps.length];
    for(int i = 1; i < dp.length; i++)
      dp[i] = Integer.MAX_VALUE;
    for(int i = 0; i < jumps.length; i++){
      for(int j = i + 1; j <= i + jumps[i] && j < jumps.length; j++){
        dp[j] = Math.min(dp[i] + 1, dp[j]);
      }
    }
    return dp[jumps.length - 1];
  }

  public static void main(String[] args) {
    ArrayJump aj = new ArrayJump();
    int[] jumps = {2, 1, 1, 1, 4};
    System.out.println(aj.countMinJumps(jumps));
    jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
    System.out.println(aj.countMinJumps(jumps));
  }
}
