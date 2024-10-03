"""

345. Reverse Vowels of a String

Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

Constraints:

    1 <= s.length <= 3 * 105
    s consist of printable ASCII characters.

"""

class Solution:
    def reverseVowels(self, s: str) -> str:
        sett = set(['a', 'e', 'i', 'o','u', 'A', 'E', 'I', 'O', 'U'])
        lo, hi = 0, len(s) - 1
        arr = [ch for ch in s]
        while lo < hi:
            while lo < len(s) and arr[lo] not in sett: lo += 1
            while hi >= 0 and arr[hi] not in sett: hi -= 1
            if lo > hi: break
            temp = arr[lo]
            arr[lo] = arr[hi]
            arr[hi] = temp
            lo += 1
            hi -= 1
        return "".join(arr)
