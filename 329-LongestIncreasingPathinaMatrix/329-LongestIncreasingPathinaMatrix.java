/*

329. Longest Increasing Path in a Matrix
Hard

Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

*/

class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        if(!validateInput(matrix)) return 0;
        Integer[][] cache = new Integer[matrix.length][matrix[0].length];
        int res = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                res = Math.max(dfs(matrix, cache, i ,j), res);
            }
        }
        return res+1;
    }
    private int dfs(int[][] matrix, Integer[][] cache, int i, int j){
        if(cache[i][j] != null) return cache[i][j];
        int max = 0;
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) continue;
            max = Math.max(max, 1 + dfs(matrix, cache, x, y));
        }
        return cache[i][j] = max;
    }
    
    private boolean validateInput(int[][] matrix){
        if(matrix == null || matrix.length == 0) return false;
        return true;
    }
}
