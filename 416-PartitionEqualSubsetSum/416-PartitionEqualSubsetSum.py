"""

416. Partition Equal Subset Sum

Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

Constraints:

    1 <= nums.length <= 200
    1 <= nums[i] <= 100

"""

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        def dfs(idx, summ):
            if summ == 0: return True
            if summ < 0 or idx >= len(nums): return False
            if (idx, summ) in cache: return cache[(idx, summ)]
            if nums[idx] <= summ:
                if dfs(idx + 1, summ - nums[idx]):
                    cache[(idx, summ)] = True
                    return True
            cache[(idx, summ)] =  dfs(idx + 1, summ)
            return cache[(idx, summ)]
        total = sum(nums)
        if total % 2 != 0: return False
        cache = {}
        return dfs(0, total // 2)
