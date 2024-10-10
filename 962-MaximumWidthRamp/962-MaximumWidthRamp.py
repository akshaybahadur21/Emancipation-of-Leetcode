"""

962. Maximum Width Ramp

A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.

Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.

Example 1:

Input: nums = [6,0,8,2,1,5]
Output: 4
Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.

Example 2:

Input: nums = [9,8,1,0,1,9,4,0,4,1]
Output: 7
Explanation: The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] = 1 and nums[9] = 1.

Constraints:

    2 <= nums.length <= 5 * 104
    0 <= nums[i] <= 5 * 104

"""

class Solution:
    def maxWidthRamp(self, nums: List[int]) -> int:
        #build monotonic decreasing stack
        stack = []
        for i, num in enumerate(nums):
            if not stack or num < nums[stack[-1]]:
                stack.append(i)
        res = 0
        for j in range(len(nums) - 1, -1, -1):
            num = nums[j]
            while stack and num >= nums[stack[-1]]:
                i = stack.pop()
                res = max(res, j - i)
        return res
