/*

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

Link : https://leetcode.com/problems/combination-sum/

*/

// Backtracking

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> resultList=new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        sumHelper(resultList,res,candidates,target,0);
        return resultList;
        
        
        
    }
    public void sumHelper(List<List<Integer>> resultList,List<Integer> res, int candidates[],int target, int start)
    {
        
        if(target<0)
            return;
        if (target==0)
            resultList.add(new ArrayList<>(res));
        else{
            for (int i = start; i < candidates.length; i++) {
			res.add(candidates[i]);
			sumHelper(resultList, res, candidates, target-candidates[i], i);
			res.remove(res.size() - 1);
		}
        }
            
        
    }
}
