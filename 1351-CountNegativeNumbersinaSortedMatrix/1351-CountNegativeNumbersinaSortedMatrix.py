"""

1351. Count Negative Numbers in a Sorted Matrix

Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

Example 1:

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:

Input: grid = [[3,2],[1,0]]
Output: 0

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 100
    -100 <= grid[i][j] <= 100
 
"""

class Solution:
    def countNegatives(self, grid: List[List[int]]) -> int:
        res = 0
        for g in grid:
            lo, hi = 0, len(g) - 1
            while lo <= hi:
                mid = lo + (hi - lo) // 2
                if g[mid] < 0: hi = mid - 1
                else: lo = mid + 1
            res += len(g) - lo
        return res
