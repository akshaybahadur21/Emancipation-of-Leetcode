/*

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Link : https://leetcode.com/problems/climbing-stairs/

*/


class Solution {
    public int climbStairs(int n) {
        int []arr = new int[n+1];
        return helperClimbStairs(n,arr);
    }
    
    int helperClimbStairs(int n, int[]arr){
        
        if(arr[n]>0)
            return arr[n];
        else {
        
        if (n==0 || n==1)
            return 1;
        
        int res = helperClimbStairs(n-2, arr)+helperClimbStairs(n-1, arr);
        arr[n] = res;
        return res;
        }
    }
}
