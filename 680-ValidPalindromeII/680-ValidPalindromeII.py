"""

680. Valid Palindrome II

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:

Input: s = "aba"
Output: true

Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:

Input: s = "abc"
Output: false

Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters.

"""

class Solution:
    def validPalindrome(self, s: str) -> bool:
        def checkPalin(lo, hi):
            while lo < hi: 
                if s[lo] != s[hi]: return False
                lo += 1
                hi -= 1
            return True

        lo, hi, count = 0, len(s) - 1, 0
        while lo < hi:
            if s[lo] == s[hi]:
                lo += 1
                hi -= 1
                continue
            else : return checkPalin(lo + 1, hi) or checkPalin(lo, hi - 1)
        return True
