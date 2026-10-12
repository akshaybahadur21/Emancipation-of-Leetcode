"""

17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = "2"
Output: ["a","b","c"]

Constraints:

    1 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].

"""

class Solution:
    def letterCombinations(self, digits: str) -> list[str]:
        mapp = {
            "2": "abc", "3": "def", "4": "ghi", "5": "jkl",
            "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"
        }
        def dfs(idx, curr):
            if len(curr) == len(digits):
                res.append("".join(curr))
                return
            letters = mapp[digits[idx]]
            for letter in letters:
                dfs(idx + 1, curr + [letter])

        res = []
        dfs(0, [])
        return res
