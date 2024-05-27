"""

20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.

"""


class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mapper = {"(" : ")",
                  "[" : "]",
                  "{" : "}"};

        for i in range(len(s)):
            ch = s[i]
            if len(stack) == 0:
                if ch not in mapper.keys():
                    return False
                else:
                    stack.append(mapper[ch])
            else:
                if ch not in mapper.keys():
                    if stack.pop() != ch:
                        return False
                else:
                    stack.append(mapper[ch])

        return len(stack) is 0
        
