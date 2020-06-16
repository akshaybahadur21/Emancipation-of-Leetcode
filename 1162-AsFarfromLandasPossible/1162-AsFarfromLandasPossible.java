/*

1162. As Far from Land as Possible
Medium

Given an N x N grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized and return the distance.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.

If no land or water exists in the grid, return -1.

Example 1:

Input: [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: 
The cell (1, 1) is as far as possible from all the land with distance 2.

Example 2:

Input: [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: 
The cell (2, 2) is as far as possible from all the land with distance 4.

Note:

    1 <= grid.length == grid[0].length <= 100
    grid[i][j] is 0 or 1

*/

class Solution {
    public int maxDistance(int[][] grid) {
        //simple bfs approach
        int res = 0;
        if(grid == null || grid.length == 0) return res;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    q.add(new int[]{i, j});
            }
        }
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()){
            res++;
            int len = q.size();
            for(int i = 0; i < len; i++){
              int[] temp = q.poll();
              for(int[] dir : dirs){
                  int x = temp[0] + dir[0];
                  int y = temp[1] + dir[1];
                  if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 1) continue;
                  grid[x][y] = 1;
                  q.add(new int[]{x,y});                  
              }
          }
      }
        return --res == 0 ? -1 : res;
    }
}
