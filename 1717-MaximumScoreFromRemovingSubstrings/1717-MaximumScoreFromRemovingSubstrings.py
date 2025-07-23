"""

1717. Maximum Score From Removing Substrings

You are given a string s and two integers x and y. You can perform two types of operations any number of times.

    Remove substring "ab" and gain x points.
        For example, when removing "ab" from "cabxbae" it becomes "cxbae".
    Remove substring "ba" and gain y points.
        For example, when removing "ba" from "cabxbae" it becomes "cabxe".

Return the maximum points you can gain after applying the above operations on s.

Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.

Example 2:

Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20

Constraints:

    1 <= s.length <= 105
    1 <= x, y <= 104
    s consists of lowercase English letters.

"""

class Solution:
    def maximumGain(self, s: str, x: int, y: int) -> int:
        stack = []
        if y > x:
            hi = "ba"
            hi_score = y
            lo = "ab"
            lo_score = x
        else:
            hi = "ab"
            hi_score = x
            lo = "ba"
            lo_score = y
        res = 0
        for ch in s:
            if stack and ch == hi[1] and stack[-1] == hi[0]:
                res += hi_score
                stack.pop()
            else: stack.append(ch)
        new_stack = []
        for ch in stack:
            if new_stack and ch == lo[1] and new_stack[-1] == lo[0]:
                res += lo_score
                new_stack.pop()
            else: new_stack.append(ch)
        return res
