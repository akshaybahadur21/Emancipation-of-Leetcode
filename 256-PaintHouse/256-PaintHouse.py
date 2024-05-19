256. Paint House

There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

    For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...

Return the minimum cost to paint all houses.

Example 1:

Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
Minimum cost: 2 + 5 + 3 = 10.

Example 2:

Input: costs = [[7,6,2]]
Output: 2

 

Constraints:

    costs.length == n
    costs[i].length == 3
    1 <= n <= 100
    1 <= costs[i][j] <= 20

from functools import lru_cache

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:

        @lru_cache(maxsize=None)
        def dfs(idx, color):
            total_cost = costs[idx][color]
            if idx >= len(costs) - 1:
                pass
            elif color == 0:
                total_cost += min(dfs(idx + 1, 1), dfs(idx + 1, 2))
            elif color == 1:
                total_cost += min(dfs(idx + 1, 0), dfs(idx + 1, 2))
            elif color == 2:
                total_cost += min(dfs(idx + 1, 0), dfs(idx + 1, 1))
            return total_cost

        if costs == [] or costs is None:
            return 0
        red = dfs(0, 0)
        blue = dfs(0, 1)
        green = dfs(0, 2)
        return min(red, blue, green)

    

        
