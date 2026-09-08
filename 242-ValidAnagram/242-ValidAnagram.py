"""

242. Valid Anagram

Given two strings s and t, return true if t is an
anagram
of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

"""

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        mapps = {}
        mappt = {}
        for ch in s: mapps[ch] = mapps.get(ch, 0) + 1
        for ch in t: mappt[ch] = mappt.get(ch, 0) + 1
        return mapps == mappt

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        mapp = defaultdict(int)
        for ch in s: mapp[ch] += 1
        for ch in t: mapp[ch] -= 1
        for k, v in mapp.items():
            if v != 0: return False
        return True

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return sorted(s) == sorted(t)
