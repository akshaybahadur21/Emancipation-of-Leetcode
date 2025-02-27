"""

746. Min Cost Climbing Stairs

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.

Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.

Constraints:

    2 <= cost.length <= 1000
    0 <= cost[i] <= 999

"""


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        @functools.lru_cache(maxsize = None)
        def dfs(n):
            if n >= len(cost): return 0
            return cost[n] + min(dfs(n + 1), dfs(n + 2))
        return min(dfs(0), dfs(1))


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        def dfs(n):
            if n >= len(cost): return 0
            if cache[n]: return cache[n]
            cache[n] = cost[n] + min(dfs(n + 1), dfs(n + 2))
            return cache[n]
        cache = [None] * len(cost)
        return min(dfs(0), dfs(1))
