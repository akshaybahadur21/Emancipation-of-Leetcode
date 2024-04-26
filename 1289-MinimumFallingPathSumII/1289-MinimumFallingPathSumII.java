/*

1289. Minimum Falling Path Sum II

Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.

A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no two elements chosen in adjacent rows are in the same column.

Example 1:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: 13
Explanation: 
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is [1,5,7], so the answer is 13.

Example 2:

Input: grid = [[7]]
Output: 7

Constraints:

    n == grid.length == grid[i].length
    1 <= n <= 200
    -99 <= grid[i][j] <= 99

*/

class Solution {
    public int minFallingPathSum(int[][] grid) {
        Integer[][] cache = new Integer[grid.length][grid[0].length];
        int res = Integer.MAX_VALUE;
        for(int j = 0; j < grid.length; j++){
            res = Math.min(res, dfs(grid, 0, j, cache));
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j,  Integer[][] cache){
        if(i == grid.length - 1) return grid[i][j];
        if(cache[i][j] != null) return cache[i][j];
        int next = Integer.MAX_VALUE;
        for(int nextCol = 0; nextCol < grid.length; nextCol++){
            if(nextCol != j) next = Math.min(next, dfs(grid, i + 1, nextCol, cache));
        }
        cache[i][j] = grid[i][j] + next;
        return cache[i][j];
    } 
}
