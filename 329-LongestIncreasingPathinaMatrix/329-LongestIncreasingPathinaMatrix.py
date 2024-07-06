"""

329. Longest Increasing Path in a Matrix

Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

Example 1:

Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:

Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

Example 3:

Input: matrix = [[1]]
Output: 1

Constraints:

    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 200
    0 <= matrix[i][j] <= 231 - 1

"""


class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        def dfs(i, j):
            if cache[i][j]: return cache[i][j]
            _max = 1
            for _dir in dirs:
                x = _dir[0] + i
                y = _dir[1] + j
                if x < 0 or y < 0 or x >= len(matrix) or y >= len(matrix[0]) or matrix[x][y] <= matrix[i][j]: continue
                _max = max(_max, 1 + dfs(x, y))
            cache[i][j] = _max
            return _max
        
        res = 0
        cache = [[0]*len(matrix[0]) for _ in range(len(matrix))]
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                res = max(res, dfs(i, j))
        return res
