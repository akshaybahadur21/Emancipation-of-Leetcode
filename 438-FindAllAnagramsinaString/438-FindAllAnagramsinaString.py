"""

438. Find All Anagrams in a String

Given two strings s and p, return an array of all the start indices of p's

in s. You may return the answer in any order.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Constraints:

    1 <= s.length, p.length <= 3 * 104
    s and p consist of lowercase English letters.
"""

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        mappp = defaultdict(int)
        for ch in p: mappp[ch] += 1
        res = []
        mapps = defaultdict(int)
        for hi in range(len(s)):
            ch = s[hi]
            if hi < len(p):
                mapps[ch] += 1
            else:
                lo = hi - len(p)
                if mapps == mappp: res.append(lo)
                mapps[s[lo]] -= 1
                if mapps[s[lo]] == 0: del mapps[s[lo]]
                mapps[s[hi]] += 1
        if mapps == mappp: res.append(len(s) - len(p))
        return res
