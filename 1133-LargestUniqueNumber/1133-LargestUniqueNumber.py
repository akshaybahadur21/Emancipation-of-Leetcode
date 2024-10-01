"""

1133. Largest Unique Number

Given an integer array nums, return the largest integer that only occurs once. If no integer occurs once, return -1.

Example 1:

Input: nums = [5,7,3,9,4,9,8,3,1]
Output: 8
Explanation: The maximum integer in the array is 9 but it is repeated. The number 8 occurs only once, so it is the answer.

Example 2:

Input: nums = [9,9,8,8]
Output: -1
Explanation: There is no number that occurs only once.

Constraints:

    1 <= nums.length <= 2000
    0 <= nums[i] <= 1000

"""

class Solution:
    def largestUniqueNumber(self, nums: List[int]) -> int:
        mapp = {}
        heap = []
        for n in nums: mapp[n] = mapp.get(n, 0) + 1
        for k, v in mapp.items(): heappush(heap, (-k, k, v))
        while heap:
            _, curr, count = heappop(heap)
            if count == 1: return curr
            else: continue
        return -1
