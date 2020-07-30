/*

45. Jump Game II
Hard

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.

Note:

You can assume that you can always reach the last index.

*/

class Solution {
    public int jump(int[] nums) {
        Integer[] cache = new Integer[nums.length];
        return dfs(cache, nums, 0);
    }
    private int dfs(Integer[] cache, int[]nums, int idx){
        if(idx == nums.length - 1) return 0;
        if(nums[idx] == 0) return Integer.MAX_VALUE;
        if(cache[idx] != null) return cache[idx];
        int total = Integer.MAX_VALUE;
        int start = idx + 1, end = idx + nums[idx];
        for(int i = start; i <= end && i < nums.length; i++){
            int min = dfs(cache, nums, i);
            total = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
            if(cache[idx] != null)
                cache[idx] = Math.min(cache[idx], total);
            else
                cache[idx] = total;
        }
        return cache[idx];
    }
}

class Solution {
    public int jump(int[] nums) {
        int[]dp = new int[nums.length];
        for(int i = 1; i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j <= i + nums[i] && j < nums.length; j++){
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }
        return dp[nums.length - 1];
    }
}
