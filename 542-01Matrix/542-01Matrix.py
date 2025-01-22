"""

542. 01 Matrix

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two cells sharing a common edge is 1.

Example 1:

Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:

Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

Constraints:

    m == mat.length
    n == mat[i].length
    1 <= m, n <= 104
    1 <= m * n <= 104
    mat[i][j] is either 0 or 1.
    There is at least one 0 in mat.

Note: This question is the same as 1765: https://leetcode.com/problems/map-of-highest-peak/

"""

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q = deque()
        vis = [[False] * len(mat[0]) for _ in range(len(mat))]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    q.append([i, j])
                    vis[i][j] = True
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        res = 1
        while q:
            lenn = len(q)
            for i in range(lenn):
                curr = q.popleft()
                for d in dirs:
                    x = curr[0] + d[0]
                    y = curr[1] + d[1]
                    if x < 0 or y < 0 or x >= len(mat) or y >= len(mat[0]) or vis[x][y]: continue
                    mat[x][y] = res
                    vis[x][y] = True
                    q.append([x, y])
            res += 1
        return mat
