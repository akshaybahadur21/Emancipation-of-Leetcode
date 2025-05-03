"""

3517. Smallest Palindromic Rearrangement I

You are given a string s.
Return the palindromic of s.

Example 1:

Input: s = "z"

Output: "z"

Explanation:

A string of only one character is already the lexicographically smallest palindrome.

Example 2:

Input: s = "babab"

Output: "abbba"

Explanation:

Rearranging "babab" → "abbba" gives the smallest lexicographic palindrome.

Example 3:

Input: s = "daccad"

Output: "acddca"

Explanation:

Rearranging "daccad" → "acddca" gives the smallest lexicographic palindrome.

Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters.
    s is guaranteed to be palindromic.

"""

class Solution:
    def smallestPalindrome(self, s: str) -> str:
        mapp = Counter(s)
        odd, oddch = 0, ''
        res = []
        for ch, count in mapp.items():
            if count % 2 != 0:
                odd += 1
                oddch = ch
            res.append(ch * (count // 2))
        if odd > 1: return ""
        res = "".join(sorted(res))
        return res + oddch + res[::-1]
