"""

1189. Maximum Number of Balloons

Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

Example 1:

Input: text = "nlaebolko"
Output: 1

Example 2:

Input: text = "loonbalxballpoon"
Output: 2

Example 3:

Input: text = "leetcode"
Output: 0

Constraints:

    1 <= text.length <= 104
    text consists of lower case English letters only.

Note: This question is the same as 2287: Rearrange Characters to Make Target String.

"""

class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        mapp = {
            'b':1,
            'a':1,
            'l':2,
            'o':2,
            'n':1,
        }
        counter = Counter(text)
        res = inf
        for k, v in mapp.items():
            if k not in counter: return 0
            res = min(res, counter[k] // v)
        return res
