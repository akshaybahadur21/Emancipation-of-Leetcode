"""

694. Number of Distinct Islands

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Return the number of distinct islands.

Example 1:

Input: grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
Output: 1

Example 2:

Input: grid = [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]
Output: 3

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    grid[i][j] is either 0 or 1.

"""

class Solution:
    def numDistinctIslands(self, grid: List[List[int]]) -> int:
        def dfs(i, j, _dir):
            if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]) or grid[i][j] == 0: return
            grid[i][j] = 0
            temp.append(_dir)
            dfs(i + 1, j, "D")
            dfs(i, j + 1, "R")
            dfs(i, j - 1, "L")
            dfs(i - 1, j, "U")
            temp.append("0")
        _set = set()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    temp = []
                    dfs(i, j, "0")
                    if temp: _set.add("".join(temp))
        return len(_set)
