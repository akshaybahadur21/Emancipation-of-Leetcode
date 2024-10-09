"""

322. Coin Change

You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
 
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:

Input: coins = [2], amount = 3
Output: -1

Example 3:

Input: coins = [1], amount = 0
Output: 0

Constraints:

    1 <= coins.length <= 12
    1 <= coins[i] <= 231 - 1
    0 <= amount <= 104

"""

class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        cache = [[None] * (amount + 1) for _ in range(len(coins))]
        def dfs(idx, curr):
            if idx < 0 or idx >= len(coins) or curr > amount: return float("inf")
            if curr == amount: return 0
            if cache[idx][curr]: return cache[idx][curr]
            take, leave = float("inf"), float("inf")
            if curr + coins[idx] <= amount:
                take = dfs(idx, curr + coins[idx])
                take = take + 1 if take != float("inf") else float("inf")
            leave = dfs(idx + 1, curr)
            min_val = min(take, leave)
            cache[idx][curr] = min_val if min_val != float("inf") else float("inf")
            return cache[idx][curr]
        val = dfs(0, 0)
        return -1 if val == float("inf") else val
