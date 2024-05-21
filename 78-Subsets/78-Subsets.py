"""

78. Subsets

Given an integer array nums of unique elements, return all possible
subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

    1 <= nums.length <= 10
    -10 <= nums[i] <= 10
    All the numbers of nums are unique.

"""

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def dfs(idx, temp_list):
            res_list.append(temp_list[:])
            for i in range(idx, len(nums)):
                temp_list.append(nums[i])
                dfs(i + 1, temp_list)
                temp_list.pop()
        res_list = []
        dfs(0, [])

        return res_list
        
