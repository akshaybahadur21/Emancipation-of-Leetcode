/*

Problem Statement #

Given a rod of length ‘n’, we are asked to cut the rod and sell the pieces in a way that will maximize the profit. We are also given the price of every piece of length ‘i’ where ‘1 <= i <= n’.

Example:

Lengths: [1, 2, 3, 4, 5]
Prices: [2, 6, 7, 10, 13]
Rod Length: 5

Let’s try different combinations of cutting the rod:

Five pieces of length 1 => 10 price
Two pieces of length 2 and one piece of length 1 => 14 price
One piece of length 3 and two pieces of length 1 => 11 price
One piece of length 3 and one piece of length 2 => 13 price
One piece of length 4 and one piece of length 1 => 12 price
One piece of length 5 => 13 price

This shows that we get the maximum price (14) by cutting the rod into two pieces of length ‘2’ and one piece of length ‘1’.

*/

class RodCutting {
  public int solveRodCutting(int[] lengths, int[] prices, int n, int idx) {
    if(idx >= prices.length || n < lengths[idx] || n < 0) return 0;
    int l1 = 0;
    if(n >= lengths[idx])
      l1 = prices[idx] + solveRodCutting(lengths, prices, n - lengths[idx], idx);
    int l2 = solveRodCutting(lengths, prices, n , idx + 1);
    return Math.max(l1, l2);
  }
  public static void main(String[] args) {
    RodCutting rc = new RodCutting();
    int[] lengths = {1, 2, 3, 4, 5};
    int[] prices = {2, 6, 7, 10, 13};
    int maxProfit = rc.solveRodCutting(lengths, prices, 5, 0);
    System.out.println(maxProfit);
  }
}

class RodCutting {
  public int solveRodCutting(int[] lengths, int[] prices, int n, int idx, Integer[][] cache) {
    if(idx >= prices.length || n < lengths[idx] || n < 0) return 0;
    if(cache[idx][n] != null) return cache[idx][n];
    int l1 = 0;
    if(cache[idx][n] == null){
      if(n >= lengths[idx])
        l1 = prices[idx] + solveRodCutting(lengths, prices, n - lengths[idx], idx, cache);
    }
    int l2 = solveRodCutting(lengths, prices, n , idx + 1, cache);
    cache[idx][n] = Math.max(l1, l2);
    return cache[idx][n];
  }
  public static void main(String[] args) {
    RodCutting rc = new RodCutting();
    int[] lengths = {1, 2, 3, 4, 5};
    int[] prices = {2, 6, 7, 10, 13};
    int rodLength = 5;
    Integer[][] cache = new Integer[prices.length][rodLength + 1];
    int maxProfit = rc.solveRodCutting(lengths, prices, rodLength, 0, cache);
    System.out.println(maxProfit);
  }
}

/*

Bottom-up Dynamic Programming #

Let’s try to populate our dp[][] array in a bottom-up fashion. Essentially, what we want to achieve is: “Find the maximum sales price for every rod length and for every possible sales price”.

So for every possible rod length ‘len’ (0<= len <= n), we have two options:

    Exclude the piece. In this case, we will take whatever price we get from the rod length excluding this piece => dp[index-1][len]
    Include the piece if its length is not more than ‘len’. In this case, we include its price plus whatever price we get from the remaining rod length => prices[index] + dp[index][len-lengths[index]]

Finally, we have to take the maximum of the above two values:

    dp[index][len] = max (dp[index-1][len], prices[index] + dp[index][len-lengths[index]]) 

*/

class RodCutting {
  public int solveRodCutting(int[] lengths, int[] prices, int n) {
    if (n <= 0 || prices.length == 0 || prices.length != lengths.length)
      return 0;
    int[][] dp = new int[prices.length][n + 1];
    for(int i = 0; i < prices.length; i++)
      dp[0][i] = 0;
    for(int i = 0; i < prices.length; i++){
      for (int c = 1; c <= n; c++){
        if(i > 0)
          dp[i][c] = dp[i - 1][c];
        if(c >= lengths[i])
          dp[i][c] = Math.max(dp[i][c], prices[i] + dp[i][c - lengths[i]]);
      }
    }
    return dp[prices.length - 1][n];
   }
  public static void main(String[] args) {
    RodCutting rc = new RodCutting();
    int[] lengths = {1, 2, 3, 4, 5};
    int[] prices = {2, 6, 7, 10, 13};
    int maxProfit = rc.solveRodCutting(lengths, prices, 5);
    System.out.println(maxProfit);
  }
}
