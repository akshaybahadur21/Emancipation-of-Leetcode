"""

3775. Reverse Words With Same Vowel Count

You are given a string s consisting of lowercase English words, each separated by a single space.

Determine how many vowels appear in the first word. Then, reverse each following word that has the same vowel count. Leave all remaining words unchanged.

Return the resulting string.

Vowels are 'a', 'e', 'i', 'o', and 'u'.

Example 1:

Input: s = "cat and mice"

Output: "cat dna mice"

Explanation:​​​​​​​

    The first word "cat" has 1 vowel.
    "and" has 1 vowel, so it is reversed to form "dna".
    "mice" has 2 vowels, so it remains unchanged.
    Thus, the resulting string is "cat dna mice".

Example 2:

Input: s = "book is nice"

Output: "book is ecin"

Explanation:

    The first word "book" has 2 vowels.
    "is" has 1 vowel, so it remains unchanged.
    "nice" has 2 vowels, so it is reversed to form "ecin".
    Thus, the resulting string is "book is ecin".

Example 3:

Input: s = "banana healthy"

Output: "banana healthy"

Explanation:

    The first word "banana" has 3 vowels.
    "healthy" has 2 vowels, so it remains unchanged.
    Thus, the resulting string is "banana healthy".

Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters and spaces.
    Words in s are separated by a single space.
    s does not contain leading or trailing spaces.

"""

class Solution:
    def reverseWords(self, s: str) -> str:
        def count_vow(word):
            count = 0
            for ch in word:
                if ch in sett: count += 1
            return count
        sett = set(['a', 'e', 'i', 'o','u'])
        s = s.split(" ")
        countfi = 0
        for i, word in enumerate(s):
            if i == 0:
                countfi = count_vow(word)
            else:
                countcurr = count_vow(word)
                if countcurr == countfi:
                    s[i] = word[::-1]
        return " ".join(s)
