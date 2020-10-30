/*

300. Longest Increasing Subsequence
Medium

Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

Note:

    There may be more than one LIS combination, it is only necessary for you to return the length.
    Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] cache = new Integer[nums.length + 1][nums.length];
        return dfs(cache, nums, -1, 0);
    }
    private int dfs(Integer[][] cache, int[] nums, int prev, int idx){
        if(idx >= nums.length) return 0;
        if(cache[prev + 1][idx] != null) return cache[prev + 1][idx];
        int take = 0;
        if(prev < 0 || nums[idx] > nums[prev])
            take = 1 + dfs(cache, nums, idx, idx + 1);
        int skip = dfs(cache, nums, prev, idx + 1);
        return cache[prev + 1][idx] = Math.max(take, skip);
        
    }
}
