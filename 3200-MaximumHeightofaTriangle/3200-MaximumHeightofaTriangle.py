"""

3200. Maximum Height of a Triangle

You are given two integers red and blue representing the count of red and blue colored balls. You have to arrange these balls to form a triangle such that the 1st row will have 1 ball, the 2nd row will have 2 balls, the 3rd row will have 3 balls, and so on.

All the balls in a particular row should be the same color, and adjacent rows should have different colors.

Return the maximum height of the triangle that can be achieved.

Example 1:

Input: red = 2, blue = 4

Output: 3

Explanation:

The only possible arrangement is shown above.

Example 2:

Input: red = 2, blue = 1

Output: 2

Explanation:

The only possible arrangement is shown above.

Example 3:

Input: red = 1, blue = 1

Output: 1

Example 4:

Input: red = 10, blue = 1

Output: 2

Explanation:

The only possible arrangement is shown above.

Constraints:

    1 <= red, blue <= 100

"""

class Solution:
    def maxHeightOfTriangle(self, red: int, blue: int) -> int:
        def dfs(red, blue, curr, height):
            if curr == 0 and height > red or curr == 1 and height > blue: return 0
            r, b = 0, 0
            if curr == 0: r = 1 + dfs(red - height, blue, 1, height + 1)
            if curr == 1: b = 1 + dfs(red, blue - height, 0, height + 1)
            return max(r, b)
        return max(dfs(red, blue, 0, 1), dfs(red, blue, 1, 1))
        
