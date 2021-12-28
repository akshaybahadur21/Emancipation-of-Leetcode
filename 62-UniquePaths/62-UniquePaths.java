/*

62. Unique Paths
Medium

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?
 

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:

Input: m = 7, n = 3
Output: 28
 

Constraints:

    1 <= m, n <= 100
    It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.

*/

class Solution {
    public int uniquePaths(int m, int n) {
        int res[] = new int[]{0};
        boolean[][] vis = new boolean[m][n];
        dfs(0, 0, m, n, res, vis);
        return res[0];
    }
    private void dfs(int i, int j, int m, int n, int res[], boolean[][] vis){
        if(i == m - 1 && j == n - 1){
            res[0]++;
            vis[i][j] = false;
            return;
        }
        if(i < 0 || i >= m || j < 0 || j >= n || vis[i][j]) return;
        vis[i][j] = true;
        dfs(i + 1, j, m, n, res, vis);
        dfs(i, j + 1, m, n, res, vis);
        vis[i][j] = false;
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(0, 0, m, n, new Integer[m][n]);
    }
    private int dfs(int i, int j, int m, int n, Integer[][] cache){
        if(i == m - 1 && j == n - 1) return 1;
        if(i == -1 || j == -1 || i >= m || j >= n) return 0;
        if(cache[i][j] != null) return cache[i][j];
        int right = dfs(i, j + 1, m, n, cache);
        int down = dfs(i + 1, j, m, n, cache);
        return cache[i][j] = down + right;
    }
}
