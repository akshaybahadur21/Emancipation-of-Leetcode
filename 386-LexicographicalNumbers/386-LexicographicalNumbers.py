"""

386. Lexicographical Numbers

Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

Example 2:

Input: n = 2
Output: [1,2]

Constraints:

    1 <= n <= 5 * 104

"""

class Solution:
    def lexicalOrder(self, n: int) -> List[int]:
        res = []
        def dfs(curr):
            if len(res) == n or curr > n: return
            res.append(curr)
            for next_num in range(10):
                curr = curr * 10 + next_num
                dfs(curr)
                curr = curr // 10
        for i in range(1, 10): dfs(i)
        return res
