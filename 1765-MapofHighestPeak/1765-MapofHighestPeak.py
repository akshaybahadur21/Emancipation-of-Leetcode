"""

1765. Map of Highest Peak

You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

    If isWater[i][j] == 0, cell (i, j) is a land cell.
    If isWater[i][j] == 1, cell (i, j) is a water cell.

You must assign each cell a height in a way that follows these rules:

    The height of each cell must be non-negative.
    If the cell is a water cell, its height must be 0.
    Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).

Find an assignment of heights such that the maximum height in the matrix is maximized.

Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.

Example 1:

Input: isWater = [[0,1],[0,0]]
Output: [[1,0],[2,1]]
Explanation: The image shows the assigned heights of each cell.
The blue cell is the water cell, and the green cells are the land cells.

Example 2:

Input: isWater = [[0,0,1],[1,0,0],[0,0,0]]
Output: [[1,1,0],[0,1,1],[1,2,2]]
Explanation: A height of 2 is the maximum possible height of any assignment.
Any height assignment that has a maximum height of 2 while still meeting the rules will also be accepted.

Constraints:

    m == isWater.length
    n == isWater[i].length
    1 <= m, n <= 1000
    isWater[i][j] is 0 or 1.
    There is at least one water cell.

Note: This question is the same as 542: https://leetcode.com/problems/01-matrix/

"""

class Solution:
    def highestPeak(self, isWater: List[List[int]]) -> List[List[int]]:
        q = deque()
        vis = [[False] * len(isWater[0]) for _ in range(len(isWater))]
        for i in range(len(isWater)):
            for j in range(len(isWater[0])):
                if isWater[i][j] == 1:
                    q.append([i, j])
                    vis[i][j] = True
                    isWater[i][j] = 0
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        res = 1
        while(q):
            lenn = len(q)
            for _ in range(lenn):
                curr = q.popleft()
                for d in dirs:
                    x = curr[0] + d[0]
                    y = curr[1] + d[1]
                    if x < 0 or y < 0 or x >= len(isWater) or y >= len(isWater[0]) or vis[x][y]: continue
                    vis[x][y] = True
                    isWater[x][y] = res
                    q.append([x, y])
            res += 1
        return isWater
