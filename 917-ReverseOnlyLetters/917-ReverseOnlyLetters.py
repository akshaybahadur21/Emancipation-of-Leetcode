"""

917. Reverse Only Letters

Given a string s, reverse the string according to the following rules:

    All the characters that are not English letters remain in the same position.
    All the English letters (lowercase or uppercase) should be reversed.

Return s after reversing it.

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"

Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"

Constraints:

    1 <= s.length <= 100
    s consists of characters with ASCII values in the range [33, 122].
    s does not contain '\"' or '\\'.

"""

class Solution:
    def reverseOnlyLetters(self, s: str) -> str:
        lo, hi = 0, len(s) - 1
        s = list(s)
        while lo < hi:
            while lo < hi and (s[lo] not in string.ascii_lowercase and s[lo] not in string.ascii_uppercase): lo += 1
            while lo < hi and (s[hi] not in string.ascii_lowercase and s[hi] not in string.ascii_uppercase): hi -= 1
            temp = s[lo]
            s[lo] = s[hi]
            s[hi] = temp
            lo += 1
            hi -= 1
        return "".join(s)
