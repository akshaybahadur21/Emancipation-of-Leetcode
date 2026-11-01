"""

531. Lonely Pixel I

Given an m x n picture consisting of black 'B' and white 'W' pixels, return the number of black lonely pixels.

A black lonely pixel is a character 'B' that located at a specific position where the same row and same column don't have any other black pixels.

Example 1:

Input: picture = [["W","W","B"],["W","B","W"],["B","W","W"]]
Output: 3
Explanation: All the three 'B's are black lonely pixels.

Example 2:

Input: picture = [["B","B","B"],["B","B","W"],["B","B","B"]]
Output: 0

Constraints:

    m == picture.length
    n == picture[i].length
    1 <= m, n <= 500
    picture[i][j] is 'W' or 'B'.

"""

class Solution:
    def findLonelyPixel(self, picture: List[List[str]]) -> int:
        rowdict, coldict = defaultdict(int), defaultdict(int)
        for i in range(len(picture)):
            for j in range(len(picture[0])):
                if picture[i][j] == 'B':
                    rowdict[i] += 1
                    coldict[j] += 1
        res = 0
        for r in range(len(picture)):
            for c in range(len(picture[0])):
                if picture[r][c] == 'B' and rowdict[r] == 1 and coldict[c] == 1:
                    res += 1
        return res
