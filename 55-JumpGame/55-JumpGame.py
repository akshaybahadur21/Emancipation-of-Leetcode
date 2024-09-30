"""

55. Jump Game

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:

    1 <= nums.length <= 104
    0 <= nums[i] <= 105

"""

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        cache = [None] * len(nums)
        def dfs(idx):
            if idx >= len(nums) - 1 or idx + nums[idx] >= len(nums) - 1: return True
            if nums[idx] == 0: return False
            if cache[idx] is not None: return cache[idx]
            for i in range(idx + 1, idx + nums[idx] + 1):
                if dfs(i): 
                    cache[idx] = True
                    return True
            cache[idx] = False
            return False
        return dfs(0)
