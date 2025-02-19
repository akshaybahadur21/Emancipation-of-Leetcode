"""

28. Find the Index of the First Occurrence in a String

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:

    1 <= haystack.length, needle.length <= 104
    haystack and needle consist of only lowercase English characters.

"""

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        i, j, start = 0, 0, 0
        while i < len(haystack):
            if haystack[i] != needle[j]:
                i+= 1
            else:
                start = i
                while i < len(haystack) and haystack[i] == needle[j]:
                    if j == len(needle) - 1: return start
                    i += 1
                    j += 1
                i = start + 1
                j = 0
        return -1
