"""

1653. Minimum Deletions to Make String Balanced

You are given a string s consisting only of characters 'a' and 'b'​​​​.

You can delete any number of characters in s to make s balanced. s is balanced if there is no pair of indices (i,j) such that i < j and s[i] = 'b' and s[j]= 'a'.

Return the minimum number of deletions needed to make s balanced.

Example 1:

Input: s = "aababbab"
Output: 2
Explanation: You can either:
Delete the characters at 0-indexed positions 2 and 6 ("aababbab" -> "aaabbb"), or
Delete the characters at 0-indexed positions 3 and 6 ("aababbab" -> "aabbbb").

Example 2:

Input: s = "bbaaaaabb"
Output: 2
Explanation: The only solution is to delete the first two characters.

Constraints:

    1 <= s.length <= 105
    s[i] is 'a' or 'b'​​.

"""

class Solution:
    def minimumDeletions(self, s: str) -> int:
        acount, res, bcount = 0, float("inf"), 0
        for ch in s:
            if ch == "a": acount += 1
        for ch in s:
            if ch == "a": acount -= 1
            res = min(res, acount + bcount)
            if ch == "b": bcount += 1
        return res

# Stack based approach

class Solution:
    def minimumDeletions(self, s: str) -> int:
        res = 0
        q = deque()
        for ch in s:
            if not q:
                q.append(ch)
                continue
            if q[-1] == 'b' and ch == 'a': 
                res += 1
                q.pop()
            else: q.append(ch)
        return res
