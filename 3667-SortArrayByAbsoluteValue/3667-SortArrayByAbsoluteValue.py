"""

3667. Sort Array By Absolute Value

You are given an integer array nums.

Rearrange elements of nums in non-decreasing order of their absolute value.

Return any rearranged array that satisfies this condition.

Note: The absolute value of an integer x is defined as:

    x if x >= 0
    -x if x < 0

Example 1:

Input: nums = [3,-1,-4,1,5]

Output: [-1,1,3,-4,5]

Explanation:

    The absolute values of elements in nums are 3, 1, 4, 1, 5 respectively.
    Rearranging them in increasing order, we get 1, 1, 3, 4, 5.
    This corresponds to [-1, 1, 3, -4, 5]. Another possible rearrangement is [1, -1, 3, -4, 5].

Example 2:

Input: nums = [-100,100]

Output: [-100,100]

Explanation:

    The absolute values of elements in nums are 100, 100 respectively.
    Rearranging them in increasing order, we get 100, 100.
    This corresponds to [-100, 100]. Another possible rearrangement is [100, -100].

Constraints:

    1 <= nums.length <= 100
    -100 <= nums[i] <= 100

"""

class Solution:
    def sortByAbsoluteValue(self, nums: List[int]) -> List[int]:
        return sorted(nums, key = lambda x: abs(x))
