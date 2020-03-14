/*

200. Number of Islands
Medium

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3

*/

class Solution {
    private int row;
    private int col;
    private char[][] g;  
    
    public int numIslands(char[][] grid) {
        // Approach 1 
        // DFS
        g = grid;
        int res = 0;
        int row = g.length;
        if(row == 0) return res;
        int col = g[0].length;
        for (int i =0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (g[i][j] == '1'){
                    //check if it is an island
                    dfs(i ,j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void dfs(int i, int j) {
        if(i >= 0 && j >= 0 && i < g.length && j < g[0].length && g[i][j] == '1'){
            g[i][j]='0';
            dfs(i + 1, j);
            dfs(i - 1, j);
            dfs(i, j + 1);
            dfs(i, j - 1);
        }
    }
}

class Solution {
    private int row;
    private int col;
    private char[][] g;
    Queue<int[]> q;
    
    public int numIslands(char[][] grid) {
        // Approach 2
        // BFS
        g = grid;
        int res = 0;
        int row = g.length;
        if(row == 0) return res;
        int col = g[0].length;
        q = new LinkedList<>();
        
        for (int i =0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (g[i][j] == '1'){
                    //check if it is an island
                    q.add(new int[]{i, j});
                    bfs(i ,j);
                    res++;
                }
            }
        }
        return res;
    }
    
    private void bfs(int i, int j) {
        int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1, 0}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            for (int[] dir : dirs){
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
               if(x >= 0 && y >= 0 && x < g.length && y < g[0].length && g[x][y] == '1'){
                    g[x][y] = '0';
                    q.add(new int[]{x,y});
               }
            }
        }
        
    }
}
