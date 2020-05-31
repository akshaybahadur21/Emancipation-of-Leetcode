/*

1091. Shortest Path in Binary Matrix
Medium

In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

    Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
    C_1 is at location (0, 0) (ie. has value grid[0][0])
    C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
    If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).

Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.

Example 1:

Input: [[0,1],[1,0]]


Output: 2

Example 2:

Input: [[0,0,0],[1,1,0],[1,1,0]]

Output: 4
 

Note:

    1 <= grid.length == grid[0].length <= 100
    grid[r][c] is 0 or 1

*/

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        if(grid[0][0] == 1) return -1;
        if(grid[grid.length - 1][grid[0].length - 1] == 1) return -1;
        q.add(new int[]{0, 0});
        int count = 1;
        int[][] dirs = new int[][]{{0, 0},{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        while(!q.isEmpty()){
            count++;
            int len = q.size();
            for(int i = 0; i < len; i++){
                int[] temp = q.poll();
                for(int[] dir : dirs){
                    int x = temp[0] + dir[0];
                    int y = temp[1] + dir[1];
                    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 1) continue;
                    if(x == grid.length - 1 && y == grid[0].length - 1) return grid.length == 1 ? count - 1 : count;
                    grid[x][y] = 1;
                    q.add(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}
