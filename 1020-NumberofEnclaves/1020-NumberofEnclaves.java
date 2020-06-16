/*

1020. Number of Enclaves
Medium

Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)

A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.

Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.
 

Example 1:

Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: 
There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.

Example 2:

Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: 
All 1s are either on the boundary or can reach the boundary
 

Note:

    1 <= A.length <= 500
    1 <= A[i].length <= 500
    0 <= A[i][j] <= 1
    All rows have the same size.

*/
class Solution {
    public int numEnclaves(int[][] A) {
        //Start from boundary and check all the visitable ones using BFS
        //Sutract from total number of ones
        int res = 0;
        if(A == null || A.length == 0) return res;
        boolean[][] vis = new boolean[A.length][A[0].length];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] == 1){
                     if(i == 0 || i == A.length - 1 || j == 0 || j == A[0].length - 1){
                        q.add(new int[]{i,j});
                        vis[i][j] = true;
                        res--;
                     }
                    res++;
                }
            }
        }
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int[] temp = q.poll();
                for(int[] dir : dirs){
                    int x = temp[0] + dir[0];
                    int y = temp[1] + dir[1];
                    if(x < 0 || y < 0 || x >= A.length || y >= A[0].length || A[x][y] == 0 || vis[x][y]) continue;
                    vis[x][y] = true;
                    res--;
                    q.add(new int[]{x, y});
                }
            }
        }
        return res;
    }
}

class Solution {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numEnclaves(int[][] A) {
        int res = 0;
        if(A == null || A.length == 0) return res;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] == 1){
                     if(i == 0 || i == A.length - 1 || j == 0 || j == A[0].length - 1){
                        dfs(A, i ,j);
                     }
                }
            }
        }
        
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] == 1)
                    res++;
            }
        }
        return res;
    }
    
    private void dfs(int[][]A, int i, int j){
        if(i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] == 0) return;
        A[i][j] = 0;
        for(int[] dir : dirs)
            dfs(A, i + dir[0], j + dir[1]);
    }
}
