"""

1213. Intersection of Three Sorted Arrays

Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.

Example 1:

Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]
Explanation: Only 1 and 5 appeared in the three arrays.

Example 2:

Input: arr1 = [197,418,523,876,1356], arr2 = [501,880,1593,1710,1870], arr3 = [521,682,1337,1395,1764]
Output: []

Constraints:

    1 <= arr1.length, arr2.length, arr3.length <= 1000
    1 <= arr1[i], arr2[i], arr3[i] <= 2000

"""

class Solution:
    def arraysIntersection(self, arr1: List[int], arr2: List[int], arr3: List[int]) -> List[int]:
        a, b, c = 0, 0, 0
        res = []
        while a < len(arr1) and b < len(arr2) and c < len(arr3):
            if arr1[a] == arr2[b] and arr1[a] == arr3[c]:  res.append(arr1[a])
            min_idx = min(arr1[a], arr2[b], arr3[c])
            if min_idx == arr1[a]: a += 1
            if min_idx == arr2[b]: b += 1
            if min_idx == arr3[c]: c += 1
        return res
