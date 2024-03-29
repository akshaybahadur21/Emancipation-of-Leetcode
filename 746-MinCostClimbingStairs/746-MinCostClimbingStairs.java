/*

746. Min Cost Climbing Stairs
Easy

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:

Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.

Example 2:

Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].

Note:

    cost will have a length in the range [2, 1000].
    Every cost[i] will be an integer in the range [0, 999].
    
Link : https://leetcode.com/problems/min-cost-climbing-stairs/

*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        if (cost.length==1)
            return 0;
        if (cost.length==2)
            return Math.min(cost[0],cost[1]);
        
        int res[]=new int [cost.length];
        res[0]=cost[0];
        res[1]=cost[1];
        for (int i=2;i<cost.length;i++)
            res[i]=Math.min(res[i-1]+cost[i],res[i-2]+cost[i]);
        return Math.min(res[cost.length-1], res[cost.length-2]);
    }
}

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] cache = new Integer[cost.length];
        return Math.min(dfs(cache, cost, 0), dfs(cache, cost,1));
    }
    private int dfs(Integer[] cache, int[] cost, int idx){
        if(idx > cost.length - 1) return 0;
        if(cache[idx] != null) return cache[idx];
        int OneStep = dfs(cache, cost, idx + 1);
        int twoStep = dfs(cache, cost, idx + 2);
        cache[idx] = Math.min(OneStep, twoStep) + cost[idx];
        return cache[idx];
    }
}
