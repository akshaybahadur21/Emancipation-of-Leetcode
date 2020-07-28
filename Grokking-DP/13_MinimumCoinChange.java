/*

Introduction #
Given an infinite supply of ‘n’ coin denominations and a total money amount, we are asked to find the minimum number of coins needed to make up that amount.

Example 1:

Denominations: {1,2,3}
Total amount: 5
Output: 2
Explanation: We need minimum of two coins {2,3} to make a total of '5'
Example 2:

Denominations: {1,2,3}
Total amount: 11
Output: 4
Explanation: We need minimum four coins {2,3,3,3} to make a total of '11'
Problem Statement #
Given a number array to represent different coin denominations and a total amount ‘T’, we need to find the minimum number of coins needed to make change for ‘T’. We can assume an infinite supply of coins, therefore, each coin can be chosen multiple times.

This problem follows the Unbounded Knapsack pattern.

Basic Solution #
A basic brute-force solution could be to try all combinations of the given coins to select the ones that give a total sum of ‘T’. This is what our algorithm will look like:

  for each coin 'c' 
    create a new set which includes one quantity of coin 'c' if it does not exceed 'T', and 
       recursively call to process all coins 
    create a new set without coin 'c', and recursively call to process the remaining coins 
  return the count of coins from the above two sets with a smaller number of coins

*/

class CoinChange {

  public int countChange(int[] denominations, int total) {
    int result = this.countChangeRecursive(denominations, total, 0);
    return (result == Integer.MAX_VALUE ? -1 : result);
  }

  private int countChangeRecursive(int[] denominations, int total, int idx) {
    if(total == 0) return 0;
    if(denominations.length == 0 || total < 0 || idx >= denominations.length) return Integer.MAX_VALUE;
    int count1 = Integer.MAX_VALUE;
    if(total >= denominations[idx]){
      int res = countChangeRecursive(denominations, total - denominations[idx], idx);
      if(res != Integer.MAX_VALUE)
        count1 = res + 1;
    }
    int count2 = countChangeRecursive(denominations, total, idx + 1);
    return Math.min(count1, count2);
  }

  public static void main(String[] args) {
    CoinChange cc = new CoinChange();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));
    System.out.println(cc.countChange(denominations, 11));
    System.out.println(cc.countChange(denominations, 7));
    denominations = new int[]{3, 5};
    System.out.println(cc.countChange(denominations, 7));
  }
}

class CoinChange {

  public int countChange(int[] denominations, int total) {
    Integer[][] dp = new Integer[denominations.length][total + 1];
    int result = this.countChangeRecursive(dp, denominations, total, 0);
    return (result == Integer.MAX_VALUE ? -1 : result);
  }
  private int countChangeRecursive(Integer[][] cache, int[] denominations, int total, int idx) {
    if(total == 0) return 0;
    if(idx >= denominations.length || denominations.length == 0 || total < 0) return Integer.MAX_VALUE;
    if (cache[idx][total] != null) return cache[idx][total];
    int count1 = Integer.MAX_VALUE;
    if (cache[idx][total] == null){
      if(total >= denominations[idx]){
        int res = countChangeRecursive(cache, denominations, total - denominations[idx], idx);
        count1 = res == Integer.MAX_VALUE ? Integer.MAX_VALUE : res + 1;
      }
    }
    int count2 = countChangeRecursive(cache, denominations, total, idx + 1);
    cache[idx][total] = Math.min(count1, count2);
    return cache[idx][total];
  }
  public static void main(String[] args) {
    CoinChange cc = new CoinChange();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));
    System.out.println(cc.countChange(denominations, 11));
    System.out.println(cc.countChange(denominations, 7));
    denominations = new int[]{3, 5};
    System.out.println(cc.countChange(denominations, 7));
  }
}

import java.util.Arrays;

class CoinChange {

  public int countChange(int[] denominations, int total)
  {
    int[][] dp = new int[denominations.length][total + 1];
    for(int i = 0; i < denominations.length; i++)
      for(int t = 0; t <= total; t++)
        dp[i][t] = Integer.MAX_VALUE;
    for(int i=0; i < denominations.length; i++)
      dp[i][0] = 0;
    for(int i = 0; i < denominations.length; i++){
      for(int t = 1; t <= total; t++){
        if(i > 0)
          dp[i][t] = dp[i - 1][t];
        if(t >= denominations[i]){
          if(dp[i][t - denominations[i]] != Integer.MAX_VALUE)
            dp[i][t] = Math.min(dp[i][t], dp[i][t - denominations[i]] + 1);
        }
      }
    }
    return dp[denominations.length - 1][total] == Integer.MAX_VALUE ? -1 : dp[denominations.length - 1][total];
  }

  public static void main(String[] args) {
    CoinChange cc = new CoinChange();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));
    System.out.println(cc.countChange(denominations, 11));
    System.out.println(cc.countChange(denominations, 7));
    denominations = new int[]{3, 5};
    System.out.println(cc.countChange(denominations, 7));
  }
}
