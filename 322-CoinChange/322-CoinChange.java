/*

322. Coin Change
Medium

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Note:
You may assume that you have an infinite number of each kind of coin.

*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(!validateInput(coins, amount)) return -1;
        int res = dfs(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int dfs(int[] coins, int amount, int idx){
        if(amount == 0) return 0;
        if(coins.length == 0 || idx >= coins.length || amount < 0) return Integer.MAX_VALUE;
        int count1 = Integer.MAX_VALUE;
        if(amount >= coins[idx]){
            int res = dfs(coins, amount - coins[idx], idx);
            if(res != Integer.MAX_VALUE)  
                count1 = res + 1;
        }
        int count2 = dfs(coins, amount, idx + 1);
        return Math.min(count1, count2);
    }
    private boolean validateInput(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return false;
        return true;
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        if(!validateInput(coins, amount)) return -1;
        Integer[][] cache = new Integer[coins.length][amount + 1];
        int res = dfs(coins, amount, 0, cache);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private int dfs(int[] coins, int amount, int idx, Integer[][] cache){
        if(amount == 0) return 0;
        if(coins.length == 0 || idx >= coins.length || amount < 0) return Integer.MAX_VALUE;
        if(cache[idx][amount] != null) return cache[idx][amount];
        int count1 = Integer.MAX_VALUE;
        if(cache[idx][amount] == null) {
            if(amount >= coins[idx]){
                int res = dfs(coins, amount - coins[idx], idx, cache);
                if(res != Integer.MAX_VALUE) {
                    count1 = res + 1;
                    cache[idx][amount] = count1;
                }
            }
        }
        int count2 = dfs(coins, amount, idx + 1, cache);
        cache[idx][amount] = Math.min(count1, count2);
        return cache[idx][amount];
    }
    private boolean validateInput(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return false;
        return true;
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int i = 0; i < coins.length; i++)
            for(int a = 0; a <= amount; a++)
                dp[i][a] = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++)
            dp[i][0] = 0;
        for(int i = 0; i < coins.length; i++){
            for(int a = 1; a <= amount; a++){
                if(i > 0)
                    dp[i][a] = dp[i - 1][a];
                if(a >= coins[i]){
                    if(dp[i][a - coins[i]] != Integer.MAX_VALUE)
                        dp[i][a] = Math.min(dp[i][a], dp[i][a - coins[i]] + 1);
                }
            }
        }
        return dp[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][amount];
    }
}
