"""

2168. Unique Substrings With Equal Digit Frequency

Given a digit string s, return the number of unique substrings of s where every digit appears the same number of times.

Example 1:

Input: s = "1212"
Output: 5
Explanation: The substrings that meet the requirements are "1", "2", "12", "21", "1212".
Note that although the substring "12" appears twice, it is only counted once.

Example 2:

Input: s = "12321"
Output: 9
Explanation: The substrings that meet the requirements are "1", "2", "3", "12", "23", "32", "21", "123", "321".

Constraints:

    1 <= s.length <= 1000
    s consists of digits.

"""

class Solution:
    def equalDigitFrequency(self, s: str) -> int:
        root = TNode()
        res = 0
        for i in range(len(s)):
            node = root
            freq = [0] * 10
            unique, max_freq = 0, 0
            for j in range(i, len(s)):
                curr_digit = int(s[j])
                if freq[curr_digit] == 0: unique += 1
                freq[curr_digit] += 1
                max_freq = max(max_freq, freq[curr_digit])

                if not node.children[curr_digit]:
                    node.children[curr_digit] = TNode()
                node = node.children[curr_digit]

                if unique * max_freq == j - i + 1 and not node.vis:
                    res += 1
                    node.vis = True
        return res

class TNode:
    def __init__(self):
        self.children = [None] * 10
        self.vis = False
