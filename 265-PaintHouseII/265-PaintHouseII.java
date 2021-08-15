/*

265. Paint House II
Hard

There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by an n x k cost matrix costs.

    For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...

Return the minimum cost to paint all houses.

Example 1:

Input: costs = [[1,5,3],[2,9,4]]
Output: 5
Explanation:
Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.

Example 2:

Input: costs = [[1,3],[2,4]]
Output: 5

Constraints:

    costs.length == n
    costs[i].length == k
    1 <= n <= 100
    1 <= k <= 20
    1 <= costs[i][j] <= 20

Follow up: Could you solve it in O(nk) runtime?

*/

class Solution {
    public int minCostII(int[][] costs) {
        int min = Integer.MAX_VALUE;
        Integer[][] cache = new Integer[costs.length][costs[0].length];
        for(int i = 0; i < costs[0].length; i++)
            min = Math.min(min, dfs(costs, 0, i, cache));
        return min == Integer.MAX_VALUE ? costs[0][0] : min;
    }
    private int dfs(int[][] costs, int idx, int k, Integer[][] cache){
        if(idx >= costs.length) return 0;
        if(cache[idx][k] != null) return cache[idx][k];
        int curr = Integer.MAX_VALUE;
        for (int i = 0; i < costs[idx].length; i++) {
            if (i == k) continue;
            curr = Math.min(curr, costs[idx][i] + dfs(costs, idx + 1, i, cache));
        }
        return cache[idx][k] = curr;
    }
}
