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
    
    //DP Tabulation
    
    class Solution {
    public int climbStairs(int n) {
        int []arr = new int[n+1];
        return helperClimbStairs(n,arr);
    }
    
    int helperClimbStairs(int n, int[]arr){
        
       if(n==0) return 0;
        arr[0]=1;
        arr[1]=1;
        for(int i =2;i<=n;i++){
            arr[i] = arr[i-2]+arr[i-1];  
        }
        return arr[n];
}
}
}

class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        return dfs(n);
    }
    private int dfs(int n){
        if(cache.containsKey(n)) return cache.get(n);
        if(n == 1) return 1;
        if(n == 2) return 2;
        int val = dfs(n - 1) + dfs(n - 2);
        cache.put(n, val);
        return val;
    }
}
