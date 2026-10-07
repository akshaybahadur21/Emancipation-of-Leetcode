"""

5. Longest Palindromic Substring

Given a string s, return the longest palindromin substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters.

"""

class Solution:
    def longestPalindrome(self, s: str) -> str:
        maxlen, idx = 0, 0
        def dfs(lo, hi):
            nonlocal maxlen, idx
            if lo >= hi: return True
            if (lo, hi) in cache: return cache[(lo, hi)]
            is_palindrome = s[lo] == s[hi] and dfs(lo + 1, hi - 1)
            if is_palindrome:
                if (hi - lo) > maxlen:
                    maxlen = hi - lo
                    idx = lo
            else:
                dfs(lo, hi - 1)
                dfs(lo + 1, hi)
            cache[(lo, hi)] = is_palindrome
            return is_palindrome
        cache = {}
        dfs(0, len(s) - 1)
        return s[idx: idx + maxlen + 1]
