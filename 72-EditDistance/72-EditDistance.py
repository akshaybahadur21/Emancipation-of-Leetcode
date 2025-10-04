"""

72. Edit Distance

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

    Insert a character
    Delete a character
    Replace a character

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

Constraints:

    0 <= word1.length, word2.length <= 500
    word1 and word2 consist of lowercase English letters.

"""

class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        def dfs(i1, i2):
            if i1 == len(word1): return len(word2) - i2
            if i2 == len(word2): return len(word1) - i1
            if (i1, i2) in cache: return cache[(i1, i2)]
            if word1[i1] == word2[i2]: 
                cache[(i1, i2)] = dfs(i1 + 1, i2 + 1)
                return cache[(i1, i2)]
            cache[(i1, i2)] = 1 + min(dfs(i1 + 1, i2), dfs(i1, i2 + 1), dfs(i1 + 1, i2 + 1))
            return cache[(i1, i2)]
        cache = {}
        return dfs(0, 0)
