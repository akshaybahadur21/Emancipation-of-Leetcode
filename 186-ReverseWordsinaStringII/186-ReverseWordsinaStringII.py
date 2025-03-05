"""

186. Reverse Words in a String II

Given a character array s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.

Your code must solve the problem in-place, i.e. without allocating extra space.

Example 1:

Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

Example 2:

Input: s = ["a"]
Output: ["a"]

Constraints:

    1 <= s.length <= 105
    s[i] is an English letter (uppercase or lowercase), digit, or space ' '.
    There is at least one word in s.
    s does not contain leading or trailing spaces.
    All the words in s are guaranteed to be separated by a single space.

"""

class Solution:
    def reverseWords(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        def reverse(lo, hi):
            while lo < hi:
                temp = s[lo]
                s[lo] = s[hi]
                s[hi] = temp
                lo += 1
                hi -= 1
        reverse(0, len(s) - 1)
        start = 0
        for i in range(len(s)):
            if s[i] == " ":
                reverse(start, i - 1)
                start = i + 1
        reverse(start, len(s) - 1)
