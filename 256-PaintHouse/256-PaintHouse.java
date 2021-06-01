/*

256. Paint House
Medium

There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

    For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...

Return the minimum cost to paint all houses.

Example 1:

Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
Minimum cost: 2 + 5 + 3 = 10.

Example 2:

Input: costs = [[7,6,2]]
Output: 2

Constraints:

    costs.length == n
    costs[i].length == 3
    1 <= n <= 100
    1 <= costs[i][j] <= 20

*/

class Solution {
    public int minCost(int[][] costs) {
        Integer[][] cache = new Integer[costs.length][costs[0].length];
        int ans = Math.min(dfs(costs, 0, 0, cache), Math.min(dfs(costs, 0, 1, cache), dfs(costs, 0, 2, cache)));
        return ans;
    }
    private int dfs(int[][] costs, int idx, int color, Integer[][] cache){
        if(idx >= costs.length || color >= 3 || color <= -1) return 0;
        if(cache[idx][color] != null) return cache[idx][color];
        int red = Integer.MAX_VALUE, blue = Integer.MAX_VALUE, green = Integer.MAX_VALUE;
        if(color == 0){
            red = costs[idx][color];
            int temp = Math.min(dfs(costs, idx + 1, color + 1, cache), dfs(costs, idx + 1, color + 2, cache));
            red = temp == Integer.MAX_VALUE ? Integer.MAX_VALUE : red + temp;
        }
        else if(color == 1){
            blue = costs[idx][color];
            int temp = Math.min(dfs(costs, idx + 1, color - 1, cache), dfs(costs, idx + 1, color + 1, cache));
            blue = temp == Integer.MAX_VALUE ? Integer.MAX_VALUE : blue + temp;
        }
        else{
            green = costs[idx][color];
            int temp = Math.min(dfs(costs, idx + 1, color - 1, cache), dfs(costs, idx + 1, color - 2, cache));
            green = temp == Integer.MAX_VALUE ? Integer.MAX_VALUE : green + temp;
        }
        
        return cache[idx][color] = Math.min(red, Math.min(blue, green));
    }
}


class Solution {
    public int minCost(int[][] costs) {
        int ans = Math.min(dfs(costs, 0, 0), Math.min(dfs(costs, 0, 1), dfs(costs, 0, 2)));
        return ans;
    }
    private int dfs(int[][] costs, int idx, int color){
        if(idx >= costs.length || color >= 3 || color <= -1) return 0;
        int red = Integer.MAX_VALUE, blue = Integer.MAX_VALUE, green = Integer.MAX_VALUE;
        if(color == 0){
            red = costs[idx][color];
            int temp = Math.min(dfs(costs, idx + 1, color + 1), dfs(costs, idx + 1, color + 2));
            red = temp == Integer.MAX_VALUE ? Integer.MAX_VALUE : red + temp;
        }
        else if(color == 1){
            blue = costs[idx][color];
            int temp = Math.min(dfs(costs, idx + 1, color - 1), dfs(costs, idx + 1, color + 1));
            blue = temp == Integer.MAX_VALUE ? Integer.MAX_VALUE : blue + temp;
        }
        else{
            green = costs[idx][color];
            int temp = Math.min(dfs(costs, idx + 1, color - 1), dfs(costs, idx + 1, color - 2));
            green = temp == Integer.MAX_VALUE ? Integer.MAX_VALUE : green + temp;
        }
        
        return Math.min(red, Math.min(blue, green));
    }
}
