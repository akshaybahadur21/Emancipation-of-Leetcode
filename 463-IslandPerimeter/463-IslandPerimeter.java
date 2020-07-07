/*

463. Island Perimeter
Easy

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:


*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        if(!validateInput(grid)) return res;
        int dirs[][] = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][] = new boolean[grid.length][grid[0].length];
        boolean foundStart = false;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && !foundStart){
                    foundStart = true;
                    q.add(new int[]{i, j});
                    vis[i][j] = true;
                    break;
                }
            }
            while(!q.isEmpty()){
                int[] temp = q.poll();
                for(int[] dir : dirs){
                    int x = temp[0] + dir[0];
                    int y = temp[1] + dir[1];
                    if(x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] == 0)
                        res++;
                    if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || vis[x][y]) continue;
                    vis[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
        }
        return res;
    }
    private boolean validateInput(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return false;
        return true;
    }
}
