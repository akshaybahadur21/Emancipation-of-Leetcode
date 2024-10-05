"""

64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:

Input: grid = [[1,2,3],[4,5,6]]
Output: 12

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 200
    0 <= grid[i][j] <= 200

"""

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        cache = [[None] * len(grid[0]) for _ in range(len(grid))]
        def dfs(i, j):
            if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]): return 100_000_000
            if i == len(grid)- 1 and j == len(grid[0]) - 1: return grid[i][j]
            if cache[i][j] is not None: return cache[i][j]
            cache[i][j] = grid[i][j] + min(dfs(i + 1, j), dfs(i, j + 1))
            return cache[i][j]
        return dfs(0, 0)
