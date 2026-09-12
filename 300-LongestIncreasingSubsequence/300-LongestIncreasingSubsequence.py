"""

300. Longest Increasing Subsequence

Given an integer array nums, return the length of the longest strictly increasing

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

 

Constraints:

    1 <= nums.length <= 2500
    -104 <= nums[i] <= 104

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?

"""

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        def dfs(idx, prev):
            if idx >= len(nums): return 0
            if (idx, prev) in cache: return cache[(idx, prev)]
            take, skip = 0, 0
            if prev == -1 or nums[idx] > nums[prev]:
                take = 1 + dfs(idx + 1, idx)
            skip = dfs(idx + 1, prev)
            cache[(idx, prev)] = max(take, skip)
            return cache[(idx, prev)]
        cache = {}
        return dfs(0, -1)
