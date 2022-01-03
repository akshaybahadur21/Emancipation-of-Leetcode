/*

90. Subsets II
Medium

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:

Input: nums = [0]
Output: [[],[0]]

Constraints:

    1 <= nums.length <= 10
    -10 <= nums[i] <= 10

*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> resSet = new HashSet<>();
        dfs(nums, 0, resSet, new ArrayList<>());
        return new ArrayList<>(resSet);
    }
    private void dfs(int[] nums, int idx, Set<List<Integer>> resSet, List<Integer> list){
        if(list.size() > nums.length) return;
        resSet.add(new ArrayList<>(list));
        for(int i = idx; i < nums.length; i++){
            list.add(nums[i]);
            dfs(nums, i + 1, resSet, list);
            list.remove(list.size() - 1);
        }
    }
}
