"""

594. Longest Harmonious Subsequence

We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

Given an integer array nums, return the length of its longest harmonious

among all its possible subsequences.

Example 1:

Input: nums = [1,3,2,2,5,2,3,7]

Output: 5

Explanation:

The longest harmonious subsequence is [3,2,2,2,3].

Example 2:

Input: nums = [1,2,3,4]

Output: 2

Explanation:

The longest harmonious subsequences are [1,2], [2,3], and [3,4], all of which have a length of 2.

Example 3:

Input: nums = [1,1,1,1]

Output: 0

Explanation:

No harmonic subsequence exists.

Constraints:

    1 <= nums.length <= 2 * 104
    -109 <= nums[i] <= 109
"""

class Solution:
    def findLHS(self, nums: List[int]) -> int:
        lo, hi = 0, 1
        nums = sorted(nums, key = lambda x : x)
        res = 0
        while hi < len(nums):
            diff =  nums[hi] - nums[lo]
            if diff == 1:
                res = max(res, hi - lo + 1)
            if diff <= 1:
                hi += 1
            else:
                lo += 1
        return res
