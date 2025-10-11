"""

128. Longest Consecutive Sequence

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:

Input: nums = [1,0,1,2]
Output: 3

Constraints:

    0 <= nums.length <= 105
    -109 <= nums[i] <= 109

"""

class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        sett = set(nums)
        streak, curr, res = 0, 0, 0
        for n in sett:
            if n - 1 not in sett:
                streak = 1
                curr = n
            while curr + 1 in sett:
                curr += 1
                streak += 1
            res = max(res, streak)
        return res
