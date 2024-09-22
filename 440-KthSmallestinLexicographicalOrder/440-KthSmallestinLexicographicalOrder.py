"""

440. K-th Smallest in Lexicographical Order

Given two integers n and k, return the kth lexicographically smallest integer in the range [1, n].

Example 1:

Input: n = 13, k = 2
Output: 10
Explanation: The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.

Example 2:

Input: n = 1, k = 1
Output: 1

Constraints:

    1 <= k <= n <= 109


"""

class Solution:
    def findKthNumber(self, n: int, k: int) -> int:
        res = []
        def dfs(curr):
            if len(res) == k or curr > n: return
            res.append(curr)
            for next_num in range(10):
                curr = curr * 10 + next_num
                dfs(curr)
                curr = curr // 10
        for i in range(1, 10):
            dfs(i)
        return res[-1]
