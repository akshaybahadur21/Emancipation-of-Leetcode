/*

198. House Robber
Easy

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.

Link : https://leetcode.com/problems/house-robber/

*/

class Solution {
    public int rob(int[] nums) {
        if (nums.length==0)
            return 0;
        if (nums.length==1)
            return nums[0];
        int[] res = new int[nums.length];
        res[1]= Math.max(nums[0],nums[1]);
        res[0]=nums[0];
        for (int i=2;i<nums.length;i++){
            res[i]=helperRob(res[i-2],nums[i],res[i-1]);
        }
        
        return res[nums.length-1];
    }
    
    int helperRob(int a, int b, int c)
    {
        return (Math.max(a+b,c));
        
    }
}

class Solution {
    public int rob(int[] nums) {
        return dfs(nums, 0);
    }
    private int dfs(int[] nums, int idx){
        if(idx >= nums.length) return 0;
        int steal = nums[idx] + dfs(nums, idx + 2);
        int skip = dfs(nums, idx + 1);
        return Math.max(steal, skip);
    }
}

class Solution {
    public int rob(int[] nums) {
        Integer[] cache = new Integer[nums.length];
        return dfs(nums, 0, cache);
    }
    private int dfs(int[] nums, int idx, Integer[] cache){
        if(idx >= nums.length) return 0;
        if(cache[idx] != null) return cache[idx];
        int steal = nums[idx] + dfs(nums, idx + 2, cache);
        int skip = dfs(nums, idx + 1, cache);
        cache[idx] = Math.max(steal, skip);
        return cache[idx];
    }
}
