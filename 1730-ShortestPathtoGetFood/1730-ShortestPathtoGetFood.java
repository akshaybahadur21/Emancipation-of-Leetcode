/*

1730. Shortest Path to Get Food
Medium

You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at a food cell.

You are given an m x n character matrix, grid, of these different types of cells:

    '*' is your location. There is exactly one '*' cell.
    '#' is a food cell. There may be multiple food cells.
    'O' is free space, and you can travel through these cells.
    'X' is an obstacle, and you cannot travel through these cells.

Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.

Example 1:

Input: grid = [["X","X","X","X","X","X"],["X","*","O","O","O","X"],["X","O","O","#","O","X"],["X","X","X","X","X","X"]]
Output: 3
Explanation: It takes 3 steps to reach the food.

Example 2:

Input: grid = [["X","X","X","X","X"],["X","*","X","O","X"],["X","O","X","#","X"],["X","X","X","X","X"]]
Output: -1
Explanation: It is not possible to reach the food.

Example 3:

Input: grid = [["X","X","X","X","X","X","X","X"],["X","*","O","X","O","#","O","X"],["X","O","O","X","O","O","X","X"],["X","O","O","O","O","#","O","X"],["X","X","X","X","X","X","X","X"]]
Output: 6
Explanation: There can be multiple food cells. It only takes 6 steps to reach the bottom food.

Example 4:

Input: grid = [["O","*"],["#","O"]]
Output: 2

Example 5:

Input: grid = [["X","*"],["#","X"]]
Output: -1

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 200
    grid[row][col] is '*', 'X', 'O', or '#'.
    The grid contains exactly one '*'.

*/

class Solution {
    public int getFood(char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '*'){
                    q.add(new int[]{i,j});
                    break;
                }
            }
        }
        int res = 0;
        while(!q.isEmpty()){
            res++;
            int len = q.size();
            for(int i = 0; i < len; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || vis[x][y] || grid[x][y] == 'X') continue;
                    if(grid[x][y] == '#') return res;
                    vis[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
        }
        return -1;
    }
}
