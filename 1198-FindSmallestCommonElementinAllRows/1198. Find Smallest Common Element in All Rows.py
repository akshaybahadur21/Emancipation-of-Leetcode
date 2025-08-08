"""

1198. Find Smallest Common Element in All Rows

Given an m x n matrix mat where every row is sorted in strictly increasing order, return the smallest common element in all rows.

If there is no common element, return -1.

Example 1:

Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
Output: 5

Example 2:

Input: mat = [[1,2,3],[2,3,4],[2,3,5]]
Output: 2

Constraints:

    m == mat.length
    n == mat[i].length
    1 <= m, n <= 500
    1 <= mat[i][j] <= 104
    mat[i] is sorted in strictly increasing order.

"""

class Solution:
    def smallestCommonElement(self, mat: List[List[int]]) -> int:
        mapp = defaultdict(int)
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                mapp[mat[i][j]] += 1
        res = inf
        for k, v in mapp.items():
            if v == len(mat):
                res = min(res, k)
        return res if res != inf else -1
