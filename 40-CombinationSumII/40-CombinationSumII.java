/*

40. Combination Sum II
Medium

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

*/

class Solution {
    List<List<Integer>> resList;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        resList = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<Integer>());
        return resList;
    }
    
    private void dfs(int[] candidates, int target, int start, List<Integer> list){
        if (target < 0) return;
        if (target == 0)
            resList.add(new ArrayList<Integer>(list));
        else{
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                list.add(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}

class Solution {
    Set<List<Integer>> resSet;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        resSet = new HashSet<>();
        dfs(candidates, target, 0, new ArrayList<Integer>());
        List<List<Integer>> resList = new ArrayList<>();
        resList.addAll(resSet);
        return resList;
    }
    
    private void dfs(int[] candidates, int target, int start, List<Integer> list){
        if (target < 0) return;
        if (target == 0)
            resSet.add(new ArrayList<Integer>(list));
        else{
            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
