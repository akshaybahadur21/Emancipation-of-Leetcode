/*

2684. Maximum Number of Moves in a Grid
Medium

You are given a 0-indexed m x n matrix grid consisting of positive integers.

You can start at any cell in the first column of the matrix, and traverse the grid in the following way:

    From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move to, should be strictly bigger than the value of the current cell.

Return the maximum number of moves that you can perform.

Example 1:

Input: grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
Output: 3
Explanation: We can start at the cell (0, 0) and make the following moves:
- (0, 0) -> (0, 1).
- (0, 1) -> (1, 2).
- (1, 2) -> (2, 3).
It can be shown that it is the maximum number of moves that can be made.

Example 2:


Input: grid = [[3,2,4],[2,1,9],[1,1,7]]
Output: 0
Explanation: Starting from any cell in the first column we cannot perform any moves.

Constraints:

    m == grid.length
    n == grid[i].length
    2 <= m, n <= 1000
    4 <= m * n <= 105
    1 <= grid[i][j] <= 106

*/

class Solution {
    public int maxMoves(int[][] grid) {
        int res = Integer.MIN_VALUE;
        Integer[][] cache = new Integer[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            res = Math.max(res, dfs(grid, i, 0, cache, 0, new boolean[grid.length][grid[0].length]));
        }
        return res - 1;
    }
    
    private int dfs(int[][] grid, int i, int j, Integer[][] cache, int prev, boolean[][] vis){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] <= prev) return 0;
        if(cache[i][j] != null) return cache[i][j];
        vis[i][j] = true;
        cache[i][j] = 1 + Math.max(Math.max(dfs(grid, i - 1, j + 1, cache, grid[i][j], vis), dfs(grid, i, j + 1, cache, grid[i][j], vis)) 
                               , dfs(grid, i + 1, j + 1, cache, grid[i][j], vis));
        return cache[i][j];
        
    }
}
