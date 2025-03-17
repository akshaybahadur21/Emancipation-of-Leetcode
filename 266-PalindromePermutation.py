"""

266. Palindrome Permutation

Given a string s, return true if a permutation of the string could form a

and false otherwise.

Example 1:

Input: s = "code"
Output: false

Example 2:

Input: s = "aab"
Output: true

Example 3:

Input: s = "carerac"
Output: true

Constraints:

    1 <= s.length <= 5000
    s consists of only lowercase English letters.
"""

class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        mapp = Counter(s)
        count = 0
        for k, v in mapp.items():
            if v % 2 == 0: continue
            else: count += 1
            if count == 2: return False
        return True
