"""

3392. Count Subarrays of Length Three With a Condition

Given an integer array nums, return the number of

of length 3 such that the sum of the first and third numbers equals exactly half of the second number.

Example 1:

Input: nums = [1,2,1,4,1]

Output: 1

Explanation:

Only the subarray [1,4,1] contains exactly 3 elements where the sum of the first and third numbers equals half the middle number.

Example 2:

Input: nums = [1,1,1]

Output: 0

Explanation:

[1,1,1] is the only subarray of length 3. However, its first and third numbers do not add to half the middle number.

Constraints:

    3 <= nums.length <= 100
    -100 <= nums[i] <= 100
"""

class Solution:
    def countSubarrays(self, nums: List[int]) -> int:
        res = 0
        for i in range(0, len(nums) - 2):
            lo = nums[i]
            mid = nums[i + 1]
            hi = nums[i + 2]
            if 2 * (lo + hi) == mid: res += 1
        return res
