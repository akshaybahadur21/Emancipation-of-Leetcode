/*

77. Combinations
Medium

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i = 0; i < nums.length; i++)
            nums[i] = i + 1;
        List<List<Integer>> resList = new ArrayList<>();
        dfs(k, nums, 0, resList, new ArrayList<>());
        return resList;
    }
    private void dfs(int k, int[]nums,int start, List<List<Integer>> resList, List<Integer> list){
        if(list.size() == k){
            resList.add(new ArrayList<>(list));
        }
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            dfs(k, nums, i + 1, resList, list);
            list.remove(list.size() - 1);
        }
    }
}
