"""

1162. As Far from Land as Possible

Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

Example 1:

Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.

Example 2:

Input: grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The cell (2, 2) is as far as possible from all the land with distance 4.

Constraints:

    n == grid.length
    n == grid[i].length
    1 <= n <= 100
    grid[i][j] is 0 or 1

"""

class Solution:
    def maxDistance(self, grid: List[List[int]]) -> int:
        q = deque()
        count = 0
        vis = [[False] * len(grid[0]) for _ in range(len(grid))]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    q.append([i, j])
                    count += 1
                    vis[i][j] = True
        if count == len(grid) * len(grid[0]): return -1
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        res = 1
        while q:
            lenn = len(q)
            for i in range(lenn):
                i, j = q.popleft()
                for d in dirs:
                    x = i + d[0]
                    y = j + d[1]
                    if count == len(grid) * len(grid[0]): return res
                    if x < 0 or y < 0 or x >= len(grid) or y >= len(grid[0]) or vis[x][y]: continue
                    vis[x][y] = True
                    count += 1
                    q.append([x, y])
            res += 1
        return -1
