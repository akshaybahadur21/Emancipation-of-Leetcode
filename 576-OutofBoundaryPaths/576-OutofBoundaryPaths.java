/*

576. Out of Boundary Paths
Medium

There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after mod 109 + 7.

Example 1:

Input: m = 2, n = 2, N = 2, i = 0, j = 0
Output: 6
Explanation:

Example 2:

Input: m = 1, n = 3, N = 3, i = 0, j = 1
Output: 12
Explanation:

Note:

    Once you move the ball out of boundary, you cannot move it back.
    The length and height of the grid is in range [1,50].
    N is in range [0,50].

*/

class Solution {
    int mod = 1_000_000_000 + 7;
    public int findPaths(int m, int n, int N, int i, int j) {
        return dfs(m, n, N, i, j);
    }
    private int dfs(int m, int n, int N, int i, int j){
        if(N < 0) return 0;
        if(i < 0 || j < 0 || i >= m || j >= n) return 1;
        return  (dfs(m, n, N - 1, i + 1, j) % mod + 
                dfs(m, n, N - 1, i, j + 1) % mod+
                dfs(m, n, N - 1, i - 1, j) % mod+
                dfs(m, n, N - 1, i, j - 1)% mod)% mod ;
    }
}

class Solution {
    int M = 1000000007;
    public int findPaths(int m, int n, int N, int i, int j) {
        return dfs(m, n, N, i, j, new Integer[m][n][N+1]);
    }
    private int dfs(int m, int n, int N, int i, int j, Integer[][][] cache){
        if(i < 0 || j < 0 || i >= m || j >= n) return 1;
        if(N == 0) return 0;

        if(cache[i][j][N] != null) return cache[i][j][N];
         cache[i][j][N] = (
                        (dfs(m, n, N - 1, i - 1, j, cache) + dfs(m, n, N - 1, i + 1, j, cache)) % M +
                        (dfs(m, n, N - 1, i, j - 1, cache) + dfs(m, n, N - 1, i, j + 1, cache)) % M
                    ) % M;
        return cache[i][j][N];
    }
}
