/*

416. Partition Equal Subset Sum
Medium

Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Note:

    Each of the array element will not exceed 100.
    The array size will not exceed 200.

Example 1:

Input: [1, 5, 11, 5]

Output: true

Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

Input: [1, 2, 3, 5]

Output: false

Explanation: The array cannot be partitioned into equal sum subsets.

*/

//recursive backtracking
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum % 2 != 0) return false;
        boolean[] res = new boolean[]{false};
        dfs(nums, sum / 2, 0, res);
        return res[0];
    }
    
    private void dfs(int[] nums, int sum, int idx, boolean[] res){
        if(sum == 0) {
            res[0] = true;
            return;
        }
        if(nums.length == 0 || idx >= nums.length || sum < 0) return;
        for(int i = idx; i < nums.length; i++)
            dfs(nums, sum - nums[idx], i + 1, res);
    }
}

//recursive dfs
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum % 2 != 0) return false;
        return dfs(nums, sum / 2, 0);
    }
    
    private boolean dfs(int[] nums, int sum, int idx){
        if(sum == 0) return true;
        if(nums.length == 0 || idx >= nums.length || sum < 0) return false;
        if(nums[idx] <= sum){
            if(dfs(nums, sum - nums[idx], idx + 1))
                return true;
        }
        return dfs(nums, sum, idx + 1);
    }
}

// recursion + memoization
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum % 2 != 0) return false;
        Boolean[][] cache = new Boolean[nums.length][sum/2 + 1];
        return dfs(nums, sum / 2, 0, cache);
    }

    private boolean dfs(int[] nums, int sum, int idx, Boolean[][] cache){
        if(sum == 0) return true;
        if(nums.length == 0 || idx >= nums.length || sum < 0) return false;
        if(cache[idx][sum] == null){
            if(nums[idx] <= sum){
                if(dfs(nums, sum - nums[idx], idx + 1, cache)){
                    cache[idx][sum] = true;
                    return true;
                }
            }
        }
        cache[idx][sum] = dfs(nums, sum, idx + 1, cache);
        return cache[idx][sum];
    }
}

// dp top down tabular

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) sum += n;
        if(sum % 2 != 0) return false;
        boolean[][] dp = new boolean[nums.length][sum / 2 + 1];
        sum = sum / 2;
        for(int i = 0; i < nums.length; i++)
            dp[i][0] = true;
        for(int s = 1; s <= sum; s++)
            dp[0][s] = (nums[0] == s ? true : false);
        for(int i = 1; i < nums.length; i++) {
          for(int s = 1; s <= sum; s++) {
            if(dp[i - 1][s])
                dp[i][s] = dp[i-1][s];
              else if (s >= nums[i])
                dp[i][s] = dp[i-1][s-nums[i]];
          }
        }
        return dp[nums.length - 1][sum];
    }
}
