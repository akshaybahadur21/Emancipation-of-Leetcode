"""

1091. Shortest Path in Binary Matrix

Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).

The length of a clear path is the number of visited cells of this path.

Example 1:

Input: grid = [[0,1],[1,0]]
Output: 2

Example 2:

Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4

Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1

Constraints:

    n == grid.length
    n == grid[i].length
    1 <= n <= 100
    grid[i][j] is 0 or 1

"""

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        q = deque()
        if grid[0][0] == 1: return -1
        q.append((0, 0))
        vis = [[False] * len(grid) for _ in range(len(grid[0]))]
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0], [1, 1], [-1, 1], [1, -1], [-1, -1]]
        res = 0
        while q:
            length = len(q)
            res += 1
            for i in range(length):
                curr = q.popleft()
                if curr[0] == len(grid) - 1 and curr[1] == len(grid[0]) - 1: return res
                for d in dirs:
                    x = d[0] + curr[0]
                    y = d[1] + curr[1]
                    if x < 0 or y < 0 or x >= len(grid) or y >= len(grid[0]) or grid[x][y] == 1 or vis[x][y]: continue
                    vis[x][y] = True
                    q.append((x, y))
        return -1
