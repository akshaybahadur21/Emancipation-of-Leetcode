/*

52. N-Queens II
Hard

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example 1:

Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

Example 2:

Input: n = 1
Output: 1

Constraints:

    1 <= n <= 9

*/

class Solution {
    public int totalNQueens(int n) {
         // perform nqueen for all positions in first row and see if it solves the nqueen
        int[] res = new int[]{0};
        int[][] board = new int[n][n];
        performNQueen(board, 0, 0, n, res);
        return res[0];
    }
    private void performNQueen(int[][] board, int i, int queens, int n, int[] res){
        if(queens == n) {
            res[0]++;
            return;
        }
        else{
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 1;
                if (isValidPosition(board, i, j)) {
                    performNQueen(board, i + 1, queens + 1, n, res);
                }
                board[i][j] = 0;
            }
        }
    }
    
   private boolean isValidPosition(int[][] matrix, int x, int y) {
        for (int row = 0; row < x; row++) { 
            for (int col = 0; col < matrix.length; col++) {  
                if ((y == col || Math.abs(x - row) == Math.abs(y - col)) && matrix[row][col] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
