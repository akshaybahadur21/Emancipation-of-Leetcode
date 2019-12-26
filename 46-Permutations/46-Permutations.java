/*

46. Permutations
Medium

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

//Useful backtracking technique

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backtrack(resultList,tempList,nums);
        return resultList;
    }
    
    void backtrack(List<List<Integer>> resultList, List<Integer> tempList, int[] nums){
        if (nums.length == tempList.size())
            resultList.add(new ArrayList<>(tempList));
        else{
            for (int i =0;i<nums.length;i++){
                if(tempList.contains(nums[i])) 
                    continue;
                tempList.add(nums[i]);
                backtrack(resultList,tempList,nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
