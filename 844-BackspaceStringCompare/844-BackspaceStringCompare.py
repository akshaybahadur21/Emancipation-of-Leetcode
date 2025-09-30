"""

844. Backspace String Compare

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".

Constraints:

    1 <= s.length, t.length <= 200
    s and t only contain lowercase letters and '#' characters.

 

Follow up: Can you solve it in O(n) time and O(1) space?

"""

class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:
        s1, s2 = [], []
        def fill_stack(stack, string):
            for ch in string:
                if ch == "#":
                    if not stack: continue
                    stack.pop()
                else: stack.append(ch)
            return stack
        s1 = fill_stack(s1, s)
        s2 = fill_stack(s2, t)
        return True if s1 == s2 else False
