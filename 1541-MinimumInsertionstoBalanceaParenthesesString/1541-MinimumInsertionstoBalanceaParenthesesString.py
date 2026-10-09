"""

1541. Minimum Insertions to Balance a Parentheses String

Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:

    Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
    Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.

In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.

    For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.

You can insert the characters '(' and ')' at any position of the string to balance it if needed.

Return the minimum number of insertions needed to make s balanced.

Example 1:

Input: s = "(()))"
Output: 1
Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching. We need to add one more ')' at the end of the string to be "(())))" which is balanced.

Example 2:

Input: s = "())"
Output: 0
Explanation: The string is already balanced.

Example 3:

Input: s = "))())("
Output: 3
Explanation: Add '(' to match the first '))', Add '))' to match the last '('.

Constraints:

    1 <= s.length <= 105
    s consists of '(' and ')' only.

"""

class Solution:
    def minInsertions(self, s: str) -> int:
        stack = []
        res = 0
        i = 0
        while i < len(s):
            if s[i] == "(":
                stack.append(")")
                stack.append(")")
                i += 1
            else:
                if i + 1 < len(s) and s[i + 1] == ")": #both ))
                    if len(stack) >= 2:
                        #found balance
                        stack.pop()
                        stack.pop()
                    elif len(stack) == 1:
                        stack.pop()
                        res += 1
                    else:
                        res += 1
                    i += 2

                else:
                    #case when there's only ")"
                    if len(stack) >= 2:
                        stack.pop()
                        stack.pop()
                        res += 1 # Used the stack to cover 1, need to insert 1 more ")"
                    elif len(stack) == 1:
                        stack.pop()
                        res += 1
                    else:
                        res += 2 # Stack is empty! Need to insert 1 "(" AND 1 ")"
                    i += 1
        return len(stack) + res
