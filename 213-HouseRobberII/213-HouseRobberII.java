/*

213. House Robber II
Medium

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.

Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.


*/

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(dfs(nums, 0, nums.length - 1), dfs(nums, 1, nums.length));
    }
    private int dfs(int[] nums, int idx, int end){
        if(idx >= end) return 0;
        int steal = nums[idx] + dfs(nums, idx + 2, end);
        int skip = dfs(nums, idx + 1, end);
        return Math.max(steal, skip);
    }
}

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(dfs(new Integer[nums.length], nums, 0, nums.length - 1), dfs(new Integer[nums.length], nums, 1, nums.length));
    }
    private int dfs(Integer[] cache, int[] nums, int idx, int end){
        if(idx >= end) return 0;
        if(cache[idx] != null) return cache[idx];
        int steal = nums[idx] + dfs(cache, nums, idx + 2, end);
        int skip = dfs(cache, nums, idx + 1, end);
        cache[idx] = Math.max(steal, skip);
        return cache[idx];
    }
}
