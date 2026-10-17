"""

567. Permutation in String

Given two strings s1 and s2, return true if s2 contains a

of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

Constraints:

    1 <= s1.length, s2.length <= 104
    s1 and s2 consist of lowercase English letters.

"""

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        lo, hi = 0, 0
        mapps1 = [0] * 26
        mapps2 = [0] * 26
        for ch in s1: mapps1[ord(ch) - ord('a')] += 1
        for hi in range(len(s2)):
            mapps2[ord(s2[hi]) - ord('a')] += 1
            if hi - lo + 1 > len(s1):
                mapps2[ord(s2[lo]) - ord('a')] -= 1
                lo += 1
            if tuple(mapps1) == tuple(mapps2): return True
        return False
