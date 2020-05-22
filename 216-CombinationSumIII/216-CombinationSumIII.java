/*

216. Combination Sum III
Medium

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

    All numbers will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]

Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

*/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resList = new ArrayList<>();
        if(!validateInput(k, n)) return resList;
        int nums[] = new int[]{1,2,3,4,5,6,7,8,9};
        dfs(nums, k, n, new ArrayList<>(), 0, 0, resList);
        return resList;
    }
    private void dfs(int[]nums, int k, int n, List<Integer> list, int start, int sum, List<List<Integer>> resList){
        if(sum == n){
            if(list.size() == k)
                resList.add(new ArrayList<>(list));
            return;
        }
        if(sum > n) return;
        
        for(int i = start; i < nums.length; i++){
            list.add(nums[i]);
            sum = sum + nums[i];
            dfs(nums, k, n, list, i + 1, sum, resList);
            list.remove(list.size() - 1);
            sum = sum - nums[i];
        }
    }
    private boolean validateInput(int k, int n){
        if (k > 9)
            return false;
        return true;
    }
}
