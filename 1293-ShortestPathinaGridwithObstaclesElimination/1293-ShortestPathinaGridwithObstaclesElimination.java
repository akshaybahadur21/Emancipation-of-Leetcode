/*

1293. Shortest Path in a Grid with Obstacles Elimination
Hard

Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle). In one step, you can move up, down, left or right from and to an empty cell.

Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m-1, n-1) given that you can eliminate at most k obstacles. If it is not possible to find such walk return -1.


Example 1:

Input: 
grid = 
[[0,0,0],
 [1,1,0],
 [0,0,0],
 [0,1,1],
 [0,0,0]], 
k = 1
Output: 6
Explanation: 
The shortest path without eliminating any obstacle is 10. 
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
 

Example 2:

Input: 
grid = 
[[0,1,1],
 [1,1,1],
 [1,0,0]], 
k = 1
Output: -1
Explanation: 
We need to eliminate at least two obstacles to find such a walk.


Constraints:

    grid.length == m
    grid[0].length == n
    1 <= m, n <= 40
    1 <= k <= m*n
    grid[i][j] == 0 or 1
    grid[0][0] == grid[m-1][n-1] == 0

*/

class Solution {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> q = new LinkedList();
        boolean[][][] vis = new boolean[grid.length][grid[0].length][k+1];
        vis[0][0][0] = true;
        q.offer(new int[]{0,0,0});
        int res = 0;
        while(!q.isEmpty()){
            res++;
            int len = q.size();
            for(int i=0; i < len; i++){
                int[] temp = q.poll();
                if(temp[0] == grid.length -1 && temp[1] == grid[0].length - 1) return res - 1;
                for(int[] dir : dirs){
                    int x = dir[0] + temp[0];
                    int y = dir[1] + temp[1];
                    int nextK = temp[2];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
                        if(grid[x][y] == 1) nextK++;
                        if(nextK <= k && !vis[x][y][nextK]){
                            vis[x][y][nextK] = true;
                            q.offer(new int[]{x, y, nextK});
                        }
                    }
                }                
            }
        }
        return -1;
    }
}
