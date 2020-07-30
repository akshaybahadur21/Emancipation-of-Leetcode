/*

55. Jump Game
Medium

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

    1 <= nums.length <= 3 * 10^4
    0 <= nums[i][j] <= 10^5

*/

class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] cache = new Boolean[nums.length];
        return dfs(nums, 0, cache);
    }
    private boolean dfs(int[]nums, int idx, Boolean[] cache){
        if(idx >= nums.length - 1 || idx + nums[idx] >= nums.length - 1) return true;
        if(nums[idx] == 0) return false;
        if(cache[idx] != null) return cache[idx];
        int start = idx + 1, end = idx + nums[idx];
        boolean ans = false;
        for(int i = start; i <= end; i++){
            ans = dfs(nums, i, cache);
            if(ans == true) {
                cache[idx] = ans;
                return cache[idx];
            }
        }
        cache[idx] = false;
        return cache[idx];
    }
}
