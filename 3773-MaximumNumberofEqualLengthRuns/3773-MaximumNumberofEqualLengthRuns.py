"""

3773. Maximum Number of Equal Length Runs

You are given a string s consisting of lowercase English letters.

A run in s is a

of equal letters that cannot be extended further. For example, the runs in "hello" are "h", "e", "ll", and "o".

You can select runs that have the same length in s.

Return an integer denoting the maximum number of runs you can select in s.

Example 1:

Input: s = "hello"

Output: 3

Explanation:

The runs in s are "h", "e", "ll", and "o". You can select "h", "e", and "o" because they have the same length 1.

Example 2:

Input: s = "aaabaaa"

Output: 2

Explanation:

The runs in s are "aaa", "b", and "aaa". You can select "aaa" and "aaa" because they have the same length 3.

Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters only.
"""

class Solution:
    def maxSameLengthRuns(self, s: str) -> int:
        i = 1
        s += " "
        mapp = defaultdict(int)
        while i < len(s):
            prev = i - 1
            if s[prev] == s[i]:
                while i < len(s) and s[i] == s[prev]:
                    i += 1
            mapp[i - prev] += 1
            prev = i
            i += 1
        return max(mapp.values())
