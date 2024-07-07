"""

3211. Generate Binary Strings Without Adjacent Zeros

You are given a positive integer n.

A binary string x is valid if all
substrings
of x of length 2 contain at least one "1".

Return all valid strings with length n, in any order.

Example 1:

Input: n = 3

Output: ["010","011","101","110","111"]

Explanation:

The valid strings of length 3 are: "010", "011", "101", "110", and "111".

Example 2:

Input: n = 1

Output: ["0","1"]

Explanation:

The valid strings of length 1 are: "0" and "1".

Constraints:

    1 <= n <= 18

"""

class Solution:
    def validStrings(self, n: int) -> List[str]:
        def dfs(sb, last):
            if len(sb) == n:
                resList.append(''.join(sb))
                return
            sb.append('1')
            dfs(sb, 1)
            sb.pop()

            if last != 0:
                sb.append('0')
                dfs(sb, 0)
                sb.pop()
            
        resList = []
        dfs([], -1)
        return resList
