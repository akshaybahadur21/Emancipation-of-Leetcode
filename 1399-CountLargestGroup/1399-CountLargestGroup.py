"""

1399. Count Largest Group

You are given an integer n.

Each number from 1 to n is grouped according to the sum of its digits.

Return the number of groups that have the largest size.

Example 1:

Input: n = 13
Output: 4
Explanation: There are 9 groups in total, they are grouped according sum of its digits of numbers from 1 to 13:
[1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9].
There are 4 groups with largest size.

Example 2:

Input: n = 2
Output: 2
Explanation: There are 2 groups [1], [2] of size 1.

Constraints:

    1 <= n <= 104

"""

class Solution:
    def countLargestGroup(self, n: int) -> int:
        mapp = defaultdict(int)
        def get_dig_sum(n):
            summ = 0
            while n != 0:
                mod = n % 10
                summ += mod
                n = n // 10
            return summ
        for i in range(1, n + 1):
            key = get_dig_sum(i)
            mapp[key] += 1
        maxx = max(mapp.values())
        res = 0
        for k, v in mapp.items():
            if v == maxx:
                res += 1
        return res
