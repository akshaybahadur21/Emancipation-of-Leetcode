"""

463. Island Perimeter

You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example 1:

Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.

Example 2:

Input: grid = [[1]]
Output: 4

Example 3:

Input: grid = [[1,0]]
Output: 4

Constraints:

    row == grid.length
    col == grid[i].length
    1 <= row, col <= 100
    grid[i][j] is 0 or 1.
    There is exactly one island in grid.

"""

class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        vis = [[False] * len(grid[0]) for _ in range(len(grid))]
        q = deque()
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        res = 0
        startFound = False
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1 and not startFound:
                    q.append([i, j])
                    vis[i][j] = True
                    startFound = True
                    break
        while q:
            i, j = q.popleft()
            for d in dirs:
                x = i + d[0]
                y = j + d[1]
                if x < 0 or y < 0 or x == len(grid) or y == len(grid[0]) or grid[x][y] == 0: res += 1
                if x < 0 or y < 0 or x == len(grid) or y == len(grid[0]) or grid[x][y] == 0 or vis[x][y]: continue
                vis[x][y] = True
                q.append([x, y])
        return res
