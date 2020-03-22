/*

542. 01 Matrix
Medium

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Example 1:

Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Example 2:

Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]

Note:

    The number of elements of the given matrix will not exceed 10,000.
    There are at least one 0 in the given matrix.
    The cells are adjacent in only four directions: up, down, left and right.

*/

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        //Apprach BFS
        int[][] res = new int[matrix.length][matrix[0].length];
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i<row; i++){
            for (int j = 0; j<col; j++){
                if (matrix[i][j] == 0){
                    q.add(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        int dirs[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
                int temp[] = q.poll();
                for(int[]dir : dirs){
                    int x = temp[0] + dir[0];
                    int y = temp[1] + dir[1];
                    if (x < 0 || y < 0 || x >= row || y >= col || vis[x][y]) continue;
                    vis[x][y] = true;
                    res[x][y] = res[temp[0]][temp[1]] + 1;
                    q.add(new int[]{x, y});
                }
        }
        return res; 
    }
}
