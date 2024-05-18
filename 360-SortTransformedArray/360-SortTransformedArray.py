"""

360. Sort Transformed Array

Given a sorted integer array nums and three integers a, b and c, apply a quadratic function of the form f(x) = ax2 + bx + c to each element nums[i] in the array, and return the array in a sorted order.

Example 1:

Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
Output: [3,9,15,33]

Example 2:

Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
Output: [-23,-5,1,7]

Constraints:

    1 <= nums.length <= 200
    -100 <= nums[i], a, b, c <= 100
    nums is sorted in ascending order.

Follow up: Could you solve it in O(n) time?

"""

class Solution:
    def sortTransformedArray(self, nums: List[int], a: int, b: int, c: int) -> List[int]:
        res = [a * n * n + b * n + c for n in nums]
        res.sort()
        return res

class Solution:
    def sortTransformedArray(self, nums: List[int], a: int, b: int, c: int) -> List[int]:
        lo, hi = 0, len(nums) - 1
        res = [0] * len(nums)
        if(a < 0):
            counter = 0
            while lo <= hi:
                t_lo = self.transform(nums[lo], a, b, c)
                t_hi = self.transform(nums[hi], a, b, c)
                if t_lo < t_hi:
                    res[counter] = t_lo
                    lo += 1
                else:
                    res[counter] = t_hi
                    hi -= 1
                counter += 1
        else:
            counter = len(nums) - 1
            while lo <= hi:
                t_lo = self.transform(nums[lo], a, b, c)
                t_hi = self.transform(nums[hi], a, b, c)
                if t_lo > t_hi:
                    res[counter] = t_lo
                    lo += 1
                else:
                    res[counter] = t_hi
                    hi -= 1
                counter -= 1
        return res

    def transform(self, x: int, a: int, b: int, c: int) -> int:
        return a*x*x + b*x + c;
