"""

3763. Maximum Total Sum with Threshold Constraints

You are given two integer arrays nums and threshold, both of length n.

Starting at step = 1, you perform the following repeatedly:

    Choose an unused index i such that threshold[i] <= step.
        If no such index exists, the process ends.
    Add nums[i] to your running total.
    Mark index i as used and increment step by 1.

Return the maximum total sum you can obtain by choosing indices optimally.

Example 1:

Input: nums = [1,10,4,2,1,6], threshold = [5,1,5,5,2,2]

Output: 17

Explanation:

    At step = 1, choose i = 1 since threshold[1] <= step. The total sum becomes 10. Mark index 1.
    At step = 2, choose i = 4 since threshold[4] <= step. The total sum becomes 11. Mark index 4.
    At step = 3, choose i = 5 since threshold[5] <= step. The total sum becomes 17. Mark index 5.
    At step = 4, we cannot choose indices 0, 2, or 3 because their thresholds are > 4, so we end the process.

Example 2:

Input: nums = [4,1,5,2,3], threshold = [3,3,2,3,3]

Output: 0

Explanation:

At step = 1 there is no index i with threshold[i] <= 1, so the process ends immediately. Thus, the total sum is 0.

Example 3:

Input: nums = [2,6,10,13], threshold = [2,1,1,1]

Output: 31

Explanation:

    At step = 1, choose i = 3 since threshold[3] <= step. The total sum becomes 13. Mark index 3.
    At step = 2, choose i = 2 since threshold[2] <= step. The total sum becomes 23. Mark index 2.
    At step = 3, choose i = 1 since threshold[1] <= step. The total sum becomes 29. Mark index 1.
    At step = 4, choose i = 0 since threshold[0] <= step. The total sum becomes 31. Mark index 0.
    After step = 4 all indices have been chosen, so the process ends.

Constraints:

    n == nums.length == threshold.length
    1 <= n <= 105
    1 <= nums[i] <= 109
    1 <= threshold[i] <= n

"""

class Solution:
    def maxSum(self, nums: List[int], threshold: List[int]) -> int:
        heap = []
        for n, t in zip(nums, threshold):
            heappush(heap, (t, n))
        step = 1
        res = 0
        while heap:
            t, n = heappop(heap)
            if t <= step: res += n
            else: break
            step += 1
        return res
