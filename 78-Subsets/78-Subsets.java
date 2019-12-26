/*

78. Subsets
Medium

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]



*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> resultList= new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(resultList,tempList,nums,0);
        return resultList;
    }
    
    void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] nums, int start){
        resultList.add(new ArrayList<>(tempList));
        for( int i= start;i<nums.length;i++){
            tempList.add(nums[i]);
            backtrack(resultList,tempList,nums,i+1);
            tempList.remove(tempList.size()-1);
            
        }
    }
}
