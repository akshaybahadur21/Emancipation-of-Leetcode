"""

340. Longest Substring with At Most K Distinct Characters

Given a string s and an integer k, return the length of the longest
substring
of s that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.

Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.

Constraints:

    1 <= s.length <= 5 * 104
    0 <= k <= 50

"""

class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        mapp = defaultdict(int)
        lo, hi = 0, 0
        res = 0
        while hi < len(s):
            mapp[s[hi]] += 1
            hi += 1
            while k < len(mapp) and lo < len(s):
                mapp[s[lo]] -= 1
                if mapp[s[lo]] == 0: del mapp[s[lo]]
                lo += 1
            res = max(res, hi - lo)
        return res
