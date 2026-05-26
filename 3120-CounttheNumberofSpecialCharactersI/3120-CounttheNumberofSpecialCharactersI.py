"""

3120. Count the Number of Special Characters I

You are given a string word. A letter is called special if it appears both in lowercase and uppercase in word.

Return the number of special letters in word.

Example 1:

Input: word = "aaAbcBC"

Output: 3

Explanation:

The special characters in word are 'a', 'b', and 'c'.

Example 2:

Input: word = "abc"

Output: 0

Explanation:

No character in word appears in uppercase.

Example 3:

Input: word = "abBCab"

Output: 1

Explanation:

The only special character in word is 'b'.

Constraints:

    1 <= word.length <= 50
    word consists of only lowercase and uppercase English letters.

"""

class Solution:
    def numberOfSpecialChars(self, word: str) -> int:
        upper = set()
        lower = set()
        res = set()
        for ch in word:
            if ch.isupper():
                if ch.lower() in lower: 
                    res.add(ch.lower())
                upper.add(ch)
            if ch.islower():
                if ch.upper() in upper:
                    res.add(ch)
                lower.add(ch)
        return len(res)
