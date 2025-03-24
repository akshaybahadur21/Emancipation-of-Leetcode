"""

934. Shortest Bridge

You are given an n x n binary matrix grid where 1 represents land and 0 represents water.

An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.

You may change 0's to 1's to connect the two islands to form one island.

Return the smallest number of 0's you must flip to connect the two islands.

Example 1:

Input: grid = [[0,1],[1,0]]
Output: 1

Example 2:

Input: grid = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2

Example 3:

Input: grid = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1

Constraints:

    n == grid.length == grid[i].length
    2 <= n <= 100
    grid[i][j] is either 0 or 1.
    There are exactly two islands in grid.

"""


class Solution:
    def shortestBridge(self, grid: List[List[int]]) -> int:
        def dfs(i, j):
            if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]) or vis[i][j] or grid[i][j] == 0: return
            vis[i][j] = True
            q.append([i, j])
            dfs(i + 1, j)
            dfs(i - 1, j)
            dfs(i, j + 1)
            dfs(i, j - 1)

        found = False
        q = deque()
        vis = [[False] * len(grid[0]) for _ in range(len(grid))]
        for i in range(len(grid)):
            if found: break
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    dfs(i, j)
                    found = True
                    break
        res = 0
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        while q:
            lenn = len(q)
            for _ in range(lenn):
                curr = q.popleft()
                for d in dirs:
                    x = curr[0] + d[0]
                    y = curr[1] + d[1]
                    if x < 0 or y < 0 or x >= len(grid) or y >= len(grid[0]) or vis[x][y]: continue
                    if grid[x][y] == 1: return res
                    vis[x][y] = True
                    q.append([x, y])
            res += 1
                    
        return -1
