"""

560. Subarray Sum Equals K

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2

Example 2:

Input: nums = [1,2,3], k = 3
Output: 2

 

Constraints:

    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107

"""

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        mapp = {0: 1}
        res, summ = 0, 0
        for n in nums:
            summ += n
            if (summ - k) in mapp:
                res += mapp.get(summ - k)
            mapp[summ] = mapp.get(summ, 0) + 1
        return res
