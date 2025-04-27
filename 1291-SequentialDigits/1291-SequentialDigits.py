"""

1291. Sequential Digits

An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

Example 1:

Input: low = 100, high = 300
Output: [123,234]

Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]

Constraints:

    10 <= low <= high <= 10^9

"""

class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        res = []
        def dfs(idx, curr):
            if curr > high: return
            if curr >= low and curr <= high:
                arr = str(curr)
                for i, dig in enumerate(arr):
                    if i == 0: continue
                    if int(arr[i]) - int(arr[i - 1]) != 1: 
                        return
                res.append(curr)
            dfs(idx + 1, curr * 10 + idx)
        for i in range(1, 9): dfs(i, 0)
        return sorted(res)
