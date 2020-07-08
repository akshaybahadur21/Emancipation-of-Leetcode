/*

15. 3Sum
Medium

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resSet = new HashSet<>();
        if(nums == null || nums.length == 0) return new ArrayList<>();
        for(int i = 0; i < nums.length - 1; i++){
            int target = -nums[i];
            Set<Integer> set = new HashSet<>();
            for(int j = i + 1; j < nums.length; j++){
                if(set.contains(target - nums[j])){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target - nums[j]);
                    Collections.sort(list);
                    resSet.add(list);
                    }
                else
                    set.add(nums[j]);
            }
        }
        return new ArrayList<>(resSet);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resList = new HashSet<>();
        if(!validateInput(nums)) return new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, resList, 0, new ArrayList<>(), 0);
        return new ArrayList<>(resList);
    }
    private void dfs(int[] nums, Set<List<Integer>> resList, int currSum, List<Integer> list, int idx){
        if(currSum == 0){
            if(list.size() == 3 && !resList.contains(list))
                resList.add(new ArrayList<>(list));
        }
        if(currSum > 0 || list.size() > 3) return;
        for(int i = idx; i < nums.length; i++){
            currSum += nums[i];
            list.add(nums[i]);
            dfs(nums, resList, currSum, list, ++idx);
            list.remove(list.size() - 1);
            currSum -= nums[i];
        }
    }
    private boolean validateInput(int[] nums){
        if(nums == null || nums.length < 3)
            return false;
        return true;
    }
}
