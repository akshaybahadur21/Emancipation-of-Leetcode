"""

1957. Delete Characters to Make Fancy String

A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.

Example 1:

Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".

Example 2:

Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".

Example 3:

Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".

Constraints:

    1 <= s.length <= 105
    s consists only of lowercase English letters.

"""

class Solution:
    def makeFancyString(self, s: str) -> str:
        if len(s) < 3: return s
        lo, hi = 0, 1
        res = []
        while hi < len(s):
            if s[lo] != s[hi]:
                res.append(s[lo])
                lo += 1
                hi += 1
            else:
                while hi < len(s) and s[lo] == s[hi]:
                    hi += 1
                res += s[lo] * min(2, hi - lo)
                lo = hi
                hi += 1
        if s[-1] != s[-2]: res.append(s[-1])
        return "".join(res)
                
