/*

312. Burst Balloons
Hard

Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

    You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
    0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

*/

class Solution {
    public int maxCoins(int[] nums) {
        Integer[][] cache = new Integer[nums.length][nums.length];
        return nums.length == 0 ? 0 : dfs(nums, cache, 0, nums.length - 1);
    }
    private int dfs(int[] nums, Integer[][] cache, int lo, int hi){
        if(lo > hi) return 0;
        if(cache[lo][hi] != null) return cache[lo][hi];
        if(lo == hi) return cache[lo][hi] = nums[lo] * get(lo - 1, nums) * get(lo + 1, nums);
        int res=0;
        for(int i = lo ; i <= hi ; i++){
            res = Math.max(res, nums[i] * get(hi + 1, nums) * get(lo - 1, nums) + dfs(nums, cache , lo, i - 1) + dfs(nums, cache , i + 1 ,hi));
        }
        return cache[lo][hi] = res;
        
    }
    public int get(int i, int[] nums){
        if(i < 0 || i >= nums.length) return 1;
        return nums[i];
    }
}
