/*

47. Permutations II
Medium

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        List<String> visited = new ArrayList<>();
        dfs(nums, resList, visited, new ArrayList<>());
        return resList;
    }
    private void dfs(int[] nums, List<List<Integer>> resList, List<String> visited, List<Integer> list){
        if(list.size() == nums.length){
            if(resList.contains(list)) return;
            resList.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited.contains(String.valueOf(nums[i]) + String.valueOf(i))) continue;
            visited.add(String.valueOf(nums[i]) + String.valueOf(i));
            list.add(nums[i]);
            dfs(nums, resList, visited, list);
            list.remove(list.size() - 1);
            visited.remove(visited.size() - 1);
        }
    }
}
