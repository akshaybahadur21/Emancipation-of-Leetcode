/*

64. Minimum Path Sum
Medium

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

*/


class Solution {
    public int minPathSum(int[][] grid) {
        Integer[][] cache = new Integer[grid.length][grid[0].length];
        return dfs(cache, grid, 0, 0);
    }
    private int dfs(Integer[][] cache, int[][] grid, int i, int j){
        if(i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
        if(cache[i][j] != null) return cache[i][j];
        if(i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        cache[i][j] = grid[i][j] + Math.min(dfs(cache, grid, i + 1, j), dfs(cache, grid, i, j + 1));
        return cache[i][j];
    }
}

