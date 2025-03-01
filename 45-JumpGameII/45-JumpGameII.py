"""

45. Jump Game II

You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

    0 <= j <= nums[i] and
    i + j < n

Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [2,3,0,1,4]
Output: 2

Constraints:

    1 <= nums.length <= 104
    0 <= nums[i] <= 1000
    It's guaranteed that you can reach nums[n - 1].

"""

class Solution:
    def jump(self, nums: List[int]) -> int:
        max_val = 100_000
        cache = [None] * len(nums)
        def dfs(idx):
            if idx == len(nums) - 1: return 0
            if idx >= len(nums) or nums[idx] == 0: return max_val
            if cache[idx] is not None: return cache[idx]
            val = max_val
            for i in range(idx + 1, idx + nums[idx] + 1):
                val = min(val, dfs(i))
                val = 1 + val if val != max_val else val
                if cache[idx] is not None: cache[idx] = min(cache[idx], val)
                else: cache[idx] = val
            return cache[idx] 
        return dfs(0)
