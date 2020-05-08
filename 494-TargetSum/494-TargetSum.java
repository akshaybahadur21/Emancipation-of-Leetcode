/*

494. Target Sum
Medium

You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

Note:

    The length of the given array is positive and will not exceed 20.
    The sum of elements in the given array will not exceed 1000.
    Your output answer is guaranteed to be fitted in a 32-bit integer.

*/

class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return count;
    }
    private void dfs(int[] nums, int S, int curr, int idx){
        if(idx == nums.length){
            if(curr == S)
                count++;
             return;
        }
        dfs(nums, S, curr + nums[idx], idx + 1);
        dfs(nums, S, curr - nums[idx], idx + 1);
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(nums, S, 0, 0);
    }
    private int dfs(int[] nums, int S, int curr, int idx){
        if(idx == nums.length){
            if(curr == S)
               return 1;
             else 
                 return 0;
        }
        return dfs(nums, S, curr + nums[idx], idx + 1) + 
        dfs(nums, S, curr - nums[idx], idx + 1);
    }
}

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        //DP with memoization
        int sum = 0;
        for (int num : nums) 
            sum += num;
        Integer[][] cache = new Integer[nums.length + 1][2 * sum + 1];
        
        return dfs(nums, sum, S + sum, 0, cache);
    }
    
    private int dfs(int[] nums, int cur, int target, int idx, Integer[][] cache) {
        if (idx == nums.length) {
            return cur == target ? 1 : 0;
        }
        if (cache[idx][cur] != null) {
            return cache[idx][cur];
        }
        
        int res = 0;
        res = dfs(nums, cur + nums[idx], target, idx + 1, cache)
            + dfs(nums, cur - nums[idx], target, idx + 1, cache);
        
        cache[idx][cur] = res;
        return res;
    }
}
