"""

3823. Reverse Letters Then Special Characters in a String

You are given a string s consisting of lowercase English letters and special characters.

Your task is to perform these in order:

    Reverse the lowercase letters and place them back into the positions originally occupied by letters.
    Reverse the special characters and place them back into the positions originally occupied by special characters.

Return the resulting string after performing the reversals.

Example 1:

Input: s = ")ebc#da@f("

Output: "(fad@cb#e)"

Explanation:

    The letters in the string are ['e', 'b', 'c', 'd', 'a', 'f']:
        Reversing them gives ['f', 'a', 'd', 'c', 'b', 'e']
        s becomes ")fad#cb@e("
    ​​​​​​​The special characters in the string are [')', '#', '@', '(']:
        Reversing them gives ['(', '@', '#', ')']
        s becomes "(fad@cb#e)"

Example 2:

Input: s = "z"

Output: "z"

Explanation:

The string contains only one letter, and reversing it does not change the string. There are no special characters.

Example 3:

Input: s = "!@#$%^&*()"

Output: ")(*&^%$#@!"

Explanation:

The string contains no letters. The string contains all special characters, so reversing the special characters reverses the whole string.

"""

class Solution:
    def reverseByType(self, s: str) -> str:
        s = list(s)
        lo, hi = 0, len(s) - 1
        while lo < hi:
            if not s[lo].isalpha():
                while lo < hi and not s[lo].isalpha(): lo += 1
            if not s[hi].isalpha():
                while lo < hi and not s[hi].isalpha(): hi -= 1
            s[lo], s[hi] = s[hi], s[lo]
            lo += 1
            hi -= 1
        
        lo, hi = 0, len(s) - 1
        while lo < hi:
            if s[lo].isalpha():
                while lo < hi and s[lo].isalpha(): lo += 1
            if s[hi].isalpha():
                while lo < hi and s[hi].isalpha(): hi -= 1
            s[lo], s[hi] = s[hi], s[lo]
            lo += 1
            hi -= 1
        return "".join(s)
