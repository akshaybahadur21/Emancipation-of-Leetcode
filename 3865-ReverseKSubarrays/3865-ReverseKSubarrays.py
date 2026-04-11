"""

3865. Reverse K Subarrays

You are given an integer array nums of length n and an integer k.

You must partition the array into k contiguous subarrays of equal length and reverse each subarray.

It is guaranteed that n is divisible by k.

Return the resulting array after performing the above operation.

Example 1:

Input: nums = [1,2,4,3,5,6], k = 3

Output: [2,1,3,4,6,5]

Explanation:

    The array is partitioned into k = 3 subarrays: [1, 2], [4, 3], and [5, 6].
    After reversing each subarray: [2, 1], [3, 4], and [6, 5].
    Combining them gives the final array [2, 1, 3, 4, 6, 5].

Example 2:

Input: nums = [5,4,4,2], k = 1

Output: [2,4,4,5]

Explanation:

    The array is partitioned into k = 1 subarray: [5, 4, 4, 2].
    Reversing it produces [2, 4, 4, 5], which is the final array.

Constraints:

    1 <= n == nums.length <= 1000
    1 <= nums[i] <= 1000
    1 <= k <= n
    n is divisible by k.

"""

class Solution:
    def reverseSubarrays(self, nums: list[int], k: int) -> list[int]:
        n = len(nums) // k
        res = []
        for i in range(0, len(nums), n):
            res.extend(nums[i: i + n][::-1])
        return res
