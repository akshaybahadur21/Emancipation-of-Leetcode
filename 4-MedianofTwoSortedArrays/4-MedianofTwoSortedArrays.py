"""

4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:

    nums1.length == m
    nums2.length == n
    0 <= m <= 1000
    0 <= n <= 1000
    1 <= m + n <= 2000
    -106 <= nums1[i], nums2[i] <= 106

"""

class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        i, j = 0, 0
        n, m = len(nums1), len(nums2)
        total = n + m
        m1, m2 = 0, 0
        for idx in range(0, (m + n) // 2 + 1):
            m2 = m1 # store previous for even length arr
            if i < n and j < m:
                if nums1[i] < nums2[j]:
                    m1 = nums1[i]
                    i+= 1
                else:
                    m1 = nums2[j]
                    j += 1
            elif i < n:
                m1 = nums1[i]
                i += 1
            else:
                m1 = nums2[j]
                j += 1
        if (n + m) % 2 == 0:
            return (m1 + m2) / 2.0
        else:
            return m1 * 1.0
