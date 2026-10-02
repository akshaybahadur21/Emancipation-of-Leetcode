"""

22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:

Input: n = 1
Output: ["()"]

Constraints:

    1 <= n <= 8

"""

class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        def dfs(curr, openn, close):
            if len(curr) > n * 2: return
            if len(curr) == n * 2 and openn == close:
                res.append(curr[:])
            if openn < n:
                dfs(curr+"(", openn + 1, close)
            if openn > close:
                dfs(curr+")", openn, close + 1)
        res = []
        dfs("", 0, 0)
        return res
