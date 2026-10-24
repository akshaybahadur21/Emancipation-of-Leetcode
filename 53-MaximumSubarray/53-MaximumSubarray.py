"""

53. Maximum Subarray

Given an integer array nums, find the

with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

"""


# Memoization
class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        def dfs(idx, takeit):
            if idx >= len(nums): 
                return 0 if takeit else -inf
            if (idx, takeit) in cache: return cache[(idx, takeit)]
            take, skip = -inf, -inf
            if takeit:
                take = max(0, nums[idx] + dfs(idx + 1, True))
            else:
                skip = max(dfs(idx + 1, False), nums[idx] + dfs(idx + 1, True))
            cache[(idx, takeit)] = max(take, skip)
            return cache[(idx, takeit)]
        cache = {}
        return dfs(0, False)

# Kadane's Algorithm
class Solution:
    def maxSubArray(self, nums: list[int]) -> int:
        maxx = nums[0]
        curr = nums[0]
        for i in range(1, len(nums)):
            curr = max(nums[i], curr + nums[i])
            maxx = max(maxx, curr)
        return maxx
