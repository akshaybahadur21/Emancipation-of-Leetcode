/*

63. Unique Paths II
Medium

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(!validateInput(obstacleGrid)) return 0;
        Integer[][] cache = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return dfs(obstacleGrid, cache, 0, 0);
    }
    private int dfs(int[][] grid, Integer[][] cache, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 0) return 0;
        if(i == grid.length - 1 && j == grid[0].length - 1) return 1;
        if(cache[i][j] != null) return cache[i][j];
        cache[i][j] = dfs(grid, cache, i + 1, j) + dfs(grid, cache, i, j + 1);
        return cache[i][j];
    }
    private boolean validateInput(int[][] grid) {
        if(grid == null || grid.length == 0 ||  grid.length == 1 && grid[0].length == 1 && grid[0][0] != 0) return false;
        return true;
    }
}

class Solution {
    int res = 0;
    int row;
    int col;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        row = obstacleGrid.length;
        col = obstacleGrid[0].length;
        dfs(obstacleGrid, 0 , 0);
        return res;
    }
    private void dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 1) return;
        if(i == row - 1 && j == col - 1)
            res++;
        grid[i][j] = 1;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        grid[i][j] = 0;
    }
}
