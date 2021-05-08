/*

562. Longest Line of Consecutive One in Matrix
Medium

Given an m x n binary matrix mat, return the length of the longest line of consecutive one in the matrix.

The line could be horizontal, vertical, diagonal, or anti-diagonal.

Example 1:

Input: mat = [[0,1,1,0],[0,1,1,0],[0,0,0,1]]
Output: 3

Example 2:

Input: mat = [[1,1,1,1],[0,1,1,0],[0,0,0,1]]
Output: 4

Constraints:

    m == mat.length
    n == mat[i].length
    1 <= m, n <= 104
    1 <= m * n <= 104
    mat[i][j] is either 0 or 1.

*/

class Solution {
    public int longestLine(int[][] mat) {
        int max = 0;
        char[] dir = new char[]{'D', 'R', 'X', 'A'};
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 1){
                    for(char d : dir){
                        int[] res = new int[]{0};
                        dfs(mat, i, j, res, d);
                        max = Math.max(max, res[0]);
                    }
                }
            }
        }
        return max;
    }
    private void dfs(int[][] mat, int i, int j, int[] res, char flag){
        if(i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 0) return;
        res[0]++;
        if(flag == 'D') dfs(mat, i + 1, j, res, 'D'); 
        if(flag == 'R') dfs(mat, i, j + 1, res, 'R');
        if(flag == 'X') dfs(mat, i + 1, j + 1, res, 'X'); 
        if(flag == 'A') dfs(mat, i + 1, j - 1, res, 'A'); 
    }
}
