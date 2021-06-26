/*

419. Battleships in a Board
Medium

Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.

Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).

Example 1:

Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
Output: 2

Example 2:

Input: board = [["."]]
Output: 0

Constraints:

    m == board.length
    n == board[i].length
    1 <= m, n <= 200
    board[i][j] is either '.' or 'X'.

Follow up: Could you do it in one-pass, using only O(1) extra memory and without modifying the values board?

*/


class Solution {
    public int countBattleships(char[][] board) {
        //simple dfs similar to number of islands
        int res = 0;
        Map<String, int[]> map = new HashMap<>();
        map.put("left", new int[]{0, -1});
        map.put("right", new int[]{0, 1});
        map.put("up", new int[]{-1, 0});
        map.put("down", new int[]{1, 0});
        int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    String temp = checkSingle(board, i, j, dirs);
                    if(temp.equals("single")){
                        board[i][j] = '.';
                        res++;
                    }
                    else{
                        dfs(temp, board, i, j, dirs, map);
                        res++;
                    }
                }
            }
        }
        return res;
    }
    
    private void dfs(String temp, char[][] board, int i, int j, int[][] dirs, Map<String, int[]> map){
        int[] dir = map.get(temp);
        int x = dir[0] + i;
        int y = dir[1] + j;
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '.') return;
        board[x][y] = '.';
        dfs(temp, board, x, y, dirs, map);
    }
    
    private String checkSingle(char[][] board, int i, int j, int[][] dirs){
        for(int[] dir : dirs){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == '.') continue;
            if(dir[0] == 0 && dir[1] == -1) return "left";
            if(dir[0] == 0 && dir[1] == 1) return "right";
            if(dir[0] == -1 && dir[1] == 0) return "up";
            if(dir[0] == 1 && dir[1] == 0) return "down";
            
        }
        return "single";
    }
}
