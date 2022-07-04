/*

931. Minimum Falling Path Sum

Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100

*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        Integer[][] cache = new Integer[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++){
            res = Math.min(res, dfs(matrix, 0, i, cache));
        }
        return res;
    }
    private int dfs(int[][] matrix, int x, int y, Integer[][] cache){
        if(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) return Integer.MAX_VALUE;
        if(x == matrix.length - 1) return matrix[x][y];
        if(cache[x][y] != null) return cache[x][y];
        int val = matrix[x][y];
        int down = dfs(matrix, x + 1, y, cache);
        int left = dfs(matrix, x + 1, y + 1, cache);
        int right = dfs(matrix, x + 1, y - 1, cache);
        return cache[x][y] = matrix[x][y] + Math.min(left, Math.min(down, right));
    }
}
