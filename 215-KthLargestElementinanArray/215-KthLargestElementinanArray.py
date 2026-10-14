"""

215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:

    1 <= k <= nums.length <= 105
    -104 <= nums[i] <= 104

"""

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = []
        for n in nums:
            heapq.heappush(heap, n)
            if len(heap) > k: heapq.heappop(heap)
        if len(heap) == 0: return -1
        return heapq.heappop(heap)


class Solution:
    #quick select
    def findKthLargest(self, nums: list[int], k: int) -> int:
        def quickselect(nums, k):
            pivot_val = random.choice(nums)
            left, mid, right = [], [], []
            for n in nums:
                if n < pivot_val: right.append(n)
                elif n > pivot_val: left.append(n)
                else: mid.append(n)
            
            if k <= len(left): # k is in left side [large elements]
                return quickselect(left, k)
            if k > len(left) + len(mid):# k is in right side [small elements]
                return quickselect(right, k - (len(left) + len(mid)))
            return pivot_val
        return quickselect(nums, k)
