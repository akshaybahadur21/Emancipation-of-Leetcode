/*

There are ‘n’ houses built in a line. A thief wants to steal maximum possible money from these houses. The only restriction the thief has is that he can’t steal from two consecutive houses, as that would alert the security system. How should the thief maximize his stealing?

Problem Statement #
Given a number array representing the wealth of ‘n’ houses, determine the maximum amount of money the thief can steal without alerting the security system.

Example 1:

Input: {2, 5, 1, 3, 6, 2, 4}
Output: 15
Explanation: The thief should steal from houses 5 + 6 + 4
Example 2:

Input: {2, 10, 14, 8, 1}
Output: 18
Explanation: The thief should steal from houses 10 + 8

Basic Solution #
For every house ‘i’, we have two options:

Steal from the current house (‘i’), skip one and steal from (‘i+2’).
Skip the current house (‘i’), and steal from the adjacent house (‘i+1’).

*/

class HouseThief {

  public int findMaxSteal(int[] wealth) {
    return findMaxStealRecursive(wealth, 0);
  }

  private int findMaxStealRecursive(int[] wealth, int idx) {
    if(idx >= wealth.length) return 0;
    int curr = wealth[idx] + findMaxStealRecursive(wealth, idx + 2);
    int next = findMaxStealRecursive(wealth, idx + 1);
    return Math.max(curr, next);
  }

  public static void main(String[] args) {
    HouseThief ht = new HouseThief();
    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(ht.findMaxSteal(wealth));
    wealth = new int[]{2, 10, 14, 8, 1};
    System.out.println(ht.findMaxSteal(wealth));
  }
}

class HouseThief {

  public int findMaxSteal(int[] wealth) {
    Integer dp[] = new Integer[wealth.length];
    return findMaxStealRecursive(dp, wealth, 0);
  }

  private int findMaxStealRecursive(Integer[] cache, int[] wealth, int idx) {
    if(idx >= wealth.length) return 0;
    if(cache[idx] != null) return cache[idx];
    int steal = wealth[idx] + findMaxStealRecursive(cache, wealth, idx + 2);
    int skip = findMaxStealRecursive(cache, wealth, idx + 1);
    cache[idx] = Math.max(steal, skip);
    return cache[idx];
  }

  public static void main(String[] args) {
    HouseThief ht = new HouseThief();
    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(ht.findMaxSteal(wealth));
    wealth = new int[]{2, 10, 14, 8, 1};
    System.out.println(ht.findMaxSteal(wealth));
  }
}

class HouseThief {

  public int findMaxSteal(int[] wealth) {
   int[] dp = new int[wealth.length + 1];
   dp[0] = 0;
   dp[1] = wealth[0];
   for(int i = 1; i < wealth.length; i++)
    dp[i + 1] = Math.max(wealth[i] + dp[i - 1], dp[i]);
  return dp[wealth.length];
  }

  public static void main(String[] args) {
    HouseThief ht = new HouseThief();
    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(ht.findMaxSteal(wealth));
    wealth = new int[]{2, 10, 14, 8, 1};
    System.out.println(ht.findMaxSteal(wealth));
  }
}
