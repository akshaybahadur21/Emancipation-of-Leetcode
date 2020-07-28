/*

Introduction #

Given an infinite supply of ‘n’ coin denominations and a total money amount, we are asked to find the total number of distinct ways to make up that amount.

Example:

Denominations: {1,2,3}
Total amount: 5
Output: 5
Explanation: There are five ways to make the change for '5', here are those ways:
  1. {1,1,1,1,1} 
  2. {1,1,1,2} 
  3. {1,2,2}
  4. {1,1,3}
  5. {2,3}

Problem Statement #

Given a number array to represent different coin denominations and a total amount ‘T’, we need to find all the different ways to make a change for ‘T’ with the given coin denominations. We can assume an infinite supply of coins, therefore, each coin can be chosen multiple times.

This problem follows the Unbounded Knapsack pattern.
Basic Solution #

A basic brute-force solution could be to try all combinations of the given coins to select the ones that give a total sum of ‘T’. This is what our algorithm will look like:
    for each coin 'c' 
      create a new set which includes one quantity of coin 'c' if it does not exceed 'T', and 
         recursively call to process all coins 
      create a new set without coin 'c', and recursively call to process the remaining coins 
    return the count of sets who have a sum equal to 'T'

This problem is quite similar to Count of Subset Sum. The only difference here is that after including the item (i.e. coin), we recursively call to process all the items (including the current coin). In ‘Count of Subset Sum’, however, we were recursively calling to process only the remaining items.

*/

class CoinChange {

  public int countChange(int[] denominations, int total) {
    return this.countChangeRecursive(denominations, total, 0);
  }
  private int countChangeRecursive(int[] denominations, int total, int idx) {
    if(total == 0) return 1;
    if(idx >= denominations.length || denominations[idx] > total || total < 0) return 0;
    int sum1 = 0;
    if(total >= denominations[idx])
      sum1 = countChangeRecursive(denominations, total - denominations[idx], idx);
    int sum2 = countChangeRecursive(denominations, total, idx + 1);
    return sum1 + sum2;
  }
  public static void main(String[] args) {
    CoinChange cc = new CoinChange();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));
  }
}

class CoinChange {

  public int countChange(int[] denominations, int total)
  {
    Integer[][] dp = new Integer[denominations.length][total + 1];
    return this.countChangeRecursive(dp, denominations, total, 0);
  }

  private int countChangeRecursive(Integer[][] cache, int[] denominations, int total, int idx)
  {
    if(idx >= denominations.length || total < 0 || denominations.length == 0) return 0;
    if(total == 0) return 1;
    if (cache[idx][total] != null) return cache[idx][total];
    int sum1 = 0;
    if (cache[idx][total] == null){
      if(total >= denominations[idx])
        sum1 = countChangeRecursive(cache, denominations, total - denominations[idx], idx);
    }
    int sum2 = countChangeRecursive(cache, denominations, total , idx + 1);
    cache[idx][total] = sum1 + sum2;
    return cache[idx][total];
  }

  public static void main(String[] args) {
    CoinChange cc = new CoinChange();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));
  }
}

/*

Bottom-up Dynamic Programming #
We will try to find if we can make all possible sums, with every combination of coins, to populate the array dp[TotalDenominations][Total+1].

So for every possible total ‘t’ (0<= t <= Total) and for every possible coin index (0 <= index < denominations.length), we have two options:

Exclude the coin. Count all the coin combinations without the given coin up to the total ‘t’ => dp[index-1][t]
Include the coin if its value is not more than ‘t’. In this case, we will count all the coin combinations to get the remaining total: dp[index][t-denominations[index]]
Finally, to find the total combinations, we will add both the above two values:

    dp[index][t] = dp[index-1][t] + dp[index][t-denominations[index]]

*/

class CoinChange {

  public int countChange(int[] denominations, int total) {
    int[][] dp = new int[denominations.length][total + 1];
    for(int i = 0; i < denominations.length; i++)
      dp[i][0] = 1;
    for(int i = 0; i < denominations.length; i++){
      for(int t = 1; t <= total; t++){
        if(i > 0)
          dp[i][t] = dp[i - 1][t];
        if(t >= denominations[i])
          dp[i][t] += dp[i][t - denominations[i]];
      }
    }
    return dp[denominations.length - 1][total];
  }

  public static void main(String[] args) {
    CoinChange cc = new CoinChange();
    int[] denominations = {1, 2, 3};
    System.out.println(cc.countChange(denominations, 5));
  }
}
