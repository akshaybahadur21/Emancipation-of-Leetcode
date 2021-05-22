/*

51. N-Queens
Hard

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Example 1:

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:

Input: n = 1
Output: [["Q"]]

Constraints:

    1 <= n <= 9

*/


class Solution {
    public List<List<String>> solveNQueens(int n) {
        // perform nqueen for all positions in first row and see if it solves the nqueen
        List<List<String>> resList = new ArrayList<>();
        int[][] board = new int[n][n];
        performNQueen(board, 0, 0, n, resList);
        return resList;
    }
    private void performNQueen(int[][] board, int i, int queens, int n, List<List<String>> resList){
        if(queens == n) {
            populateResList(resList, board);
            return;
        }
        else{
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = 1;
                if (isValidPosition(board, i, j)) {
                    performNQueen(board, i + 1, queens + 1, n, resList);
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
    
    private void populateResList(List<List<String>> resList, int[][] board){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 1) sb.append("Q");
                else sb.append(".");
            }
            list.add(sb.toString());
        }
        resList.add(list);
    }
}
