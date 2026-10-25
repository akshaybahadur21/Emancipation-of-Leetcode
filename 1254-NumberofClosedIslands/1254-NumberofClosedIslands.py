"""

1254. Number of Closed Islands

Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

Return the number of closed islands.

Example 1:

Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
Explanation: 
Islands in gray are closed because they are completely surrounded by water (group of 1s).

Example 2:

Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
Output: 1

Example 3:

Input: grid = [[1,1,1,1,1,1,1],
               [1,0,0,0,0,0,1],
               [1,0,1,1,1,0,1],
               [1,0,1,0,1,0,1],
               [1,0,1,1,1,0,1],
               [1,0,0,0,0,0,1],
               [1,1,1,1,1,1,1]]
Output: 2

Constraints:

    1 <= grid.length, grid[0].length <= 100
    0 <= grid[i][j] <=1

"""

class Solution:
    def closedIsland(self, grid: list[list[int]]) -> int:
        def dfs(i, j, is_closed):
            if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]):
                is_closed[0] = False
                return
            if grid[i][j] == 1: return
            grid[i][j] = 1
            dfs(i + 1, j, is_closed)
            dfs(i - 1, j, is_closed)
            dfs(i, j + 1, is_closed)
            dfs(i, j - 1, is_closed)

        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0:
                    is_closed = [True]
                    dfs(i, j, is_closed)
                    if is_closed[0]: res += 1
        return res
