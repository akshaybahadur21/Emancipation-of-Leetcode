"""

3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest
substring
without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.

"""

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        mapp = [0] * 128
        left, right, res = 0, 0, 0
        if not s or len(s) == 0: return res
        while right < len(s):
            if mapp[ord(s[right]) - ord('a')] == 0:
                mapp[ord(s[right]) - ord('a')] += 1
                right += 1
                res = max(res, right - left)
            else:
                while mapp[ord(s[right]) - ord('a')] != 0:
                    mapp[ord(s[left]) - ord('a')] -= 1
                    left += 1
        return res
