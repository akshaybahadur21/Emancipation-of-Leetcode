/*

130. Surrounded Regions
Medium

Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

*/

class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        char[][] xBoard = new char[board.length][board[0].length];
        for (char[] row: xBoard)
            Arrays.fill(row, 'X');
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
                    if(board[i][j] == 'O')
                        q.add(new int[]{i , j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] temp = q.poll();
            xBoard[temp[0]][temp[1]] = 'O';
            int dirs[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for(int[] dir : dirs){
                int x = temp[0] + dir[0];
                int y = temp[1] + dir[1];
                if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 'X') continue;
                xBoard[x][y] = 'O';
                board[x][y]= 'X';
                q.add(new int[]{x, y});
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = xBoard[i][j];
            }
        }
        
    }
}
