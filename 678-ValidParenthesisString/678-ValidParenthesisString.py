"""

678. Valid Parenthesis String

Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    Any right parenthesis ')' must have a corresponding left parenthesis '('.
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "(*)"
Output: true

Example 3:

Input: s = "(*))"
Output: true

Example 4:

Input: s = "("
Output: false

Constraints:

    1 <= s.length <= 100
    s[i] is '(', ')' or '*'.

"""

class Solution:
    # Use memoization to DP on every possible move at every possible step.
    def checkValidString(self, s: str) -> bool:
        def dfs(idx, openn):
            if openn < 0: return False
            if idx == len(s): 
                return openn == 0
            if (idx, openn) in cache: return cache[(idx, openn)]
            if s[idx] == "*":
                res = (dfs(idx + 1, openn + 1) # treat as (
                      or dfs(idx + 1, openn - 1) # treat as )
                      or dfs(idx + 1, openn) )# treat as ""
            else:
                if s[idx] == "(":
                    res = dfs(idx + 1, openn + 1)
                elif s[idx] == ")":
                    res = dfs(idx + 1, openn - 1)
            cache[(idx, openn)] = res
            return cache[(idx, openn)]
        cache = {}
        return dfs(0, 0)


class Solution:
    # Use 2 pointers to traverse from both side of string
    # Keep count of open and close from both sends to see if there is any imbalance
    def checkValidString(self, s: str) -> bool:
        openn, close, n = 0, 0, len(s) - 1
        for i in range(n + 1):
            if s[i] == "(" or s[i] == "*": openn += 1
            else: openn -= 1

            if s[n - i] == ")" or s[n - i] == "*": close += 1
            else: close -= 1

            if openn < 0 or close < 0: return False
        return True
