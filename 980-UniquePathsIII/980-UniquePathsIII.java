/*

980. Unique Paths III
Hard

On a 2-dimensional grid, there are 4 types of squares:

    1 represents the starting square.  There is exactly one starting square.
    2 represents the ending square.  There is exactly one ending square.
    0 represents empty squares we can walk over.
    -1 represents obstacles that we cannot walk over.

Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Example 1:

Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
Explanation: We have the following two paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Example 2:

Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
Explanation: We have the following four paths: 
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

Example 3:

Input: [[0,1],[2,0]]
Output: 0
Explanation: 
There is no path that walks over every empty square exactly once.
Note that the starting and ending square can be anywhere in the grid.

 

Note:

    1 <= grid.length * grid[0].length <= 20

*/

class Solution {
    int res;
    int row;
    int col;
    int ex;
    int ey;
    int x;
    int y;
    public int uniquePathsIII(int[][] grid) {
        res = 0;
        int empty = 1;
        row = grid.length;
        col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0)//count all empty cells
                    empty++;
                else if(grid[i][j] == 1){//starting point
                    x = i;
                    y = j;
                }
                else if(grid[i][j] == 2){ //ending
                    ex = i;
                    ey = j;
                }
            }
        }
        dfs(grid, x, y, empty);
        return res;
    }
    
    private void dfs(int[][] grid, int i, int j, int empty){
        if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] == -1) return;
        if(i == ex && j == ey){
            if (empty == 0)
                res++;
            return;
        }
        grid[i][j] = -1;
        empty--;
        dfs(grid, i + 1, j, empty);
        dfs(grid, i - 1, j, empty);
        dfs(grid, i, j + 1, empty);
        dfs(grid, i, j - 1, empty);
        grid[i][j] = 0;
        empty++;
    }
}
