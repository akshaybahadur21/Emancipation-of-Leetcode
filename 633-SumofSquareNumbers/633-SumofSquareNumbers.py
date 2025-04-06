"""

633. Sum of Square Numbers

Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5

Example 2:

Input: c = 3
Output: false

Constraints:

    0 <= c <= 231 - 1

"""

class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        if c <= 1: return True
        lo, hi = 0, int(math.sqrt(c))
        while lo <= hi:
            val = lo * lo + hi * hi
            if val == c:
                return True
            elif val > c: hi -= 1
            else: lo += 1
        return False
