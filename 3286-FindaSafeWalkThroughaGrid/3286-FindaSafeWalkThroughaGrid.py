"""

3286. Find a Safe Walk Through a Grid

You are given an m x n binary matrix grid and an integer health.

You start on the upper-left corner (0, 0) and would like to get to the lower-right corner (m - 1, n - 1).

You can move up, down, left, or right from one cell to another adjacent cell as long as your health remains positive.

Cells (i, j) with grid[i][j] = 1 are considered unsafe and reduce your health by 1.

Return true if you can reach the final cell with a health value of 1 or more, and false otherwise.

Example 1:

Input: grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]], health = 1

Output: true

Explanation:

The final cell can be reached safely by walking along the gray cells below.

Example 2:

Input: grid = [[0,1,1,0,0,0],[1,0,1,0,0,0],[0,1,1,1,0,1],[0,0,1,0,1,0]], health = 3

Output: false

Explanation:

A minimum of 4 health points is needed to reach the final cell safely.

Example 3:

Input: grid = [[1,1,1],[1,0,1],[1,1,1]], health = 5

Output: true

Explanation:

The final cell can be reached safely by walking along the gray cells below.

Any path that does not go through the cell (1, 1) is unsafe since your health will drop to 0 when reaching the final cell.

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    2 <= m * n
    1 <= health <= m + n
    grid[i][j] is either 0 or 1.

"""

class Solution:
    def findSafeWalk(self, grid: List[List[int]], health: int) -> bool:
        q = deque()
        q.append((0, 0, health  - grid[0][0]))
        vis = set()
        vis.add((0, 0))
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        while q:
            lenn = len(q)
            for _ in range(lenn):
                i, j, h = q.popleft()
                for d in dirs:
                    x = i + d[0]
                    y = j + d[1]
                    if x < 0 or y < 0 or x >= len(grid) or y >= len(grid[0]) or (x, y) in vis or h < 1: continue
                    if x == len(grid) - 1 and y == len(grid[0]) - 1 and h >= 1: return True
                    if h < 1: continue
                    vis.add((x, y))
                    q.append((x, y, h - grid[x][y]))
        return False
