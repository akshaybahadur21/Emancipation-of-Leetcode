"""

115. Distinct Subsequences

Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit

Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag

Constraints:

    1 <= s.length, t.length <= 1000
    s and t consist of English letters.

"""

class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        def dfs(si, ti):
            if ti == len(t): return 1
            if si == len(s): return 0
            if (si, ti) in cache: return cache[(si, ti)]
            res = 0
            if s[si] == t[ti]: res += dfs(si + 1, ti + 1)
            res += dfs(si + 1, ti)
            cache[(si, ti)] = res
            return res
        cache = {}
        return dfs(0, 0)
