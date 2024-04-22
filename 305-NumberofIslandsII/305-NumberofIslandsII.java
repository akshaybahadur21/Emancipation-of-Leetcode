/*

305. Number of Islands II

You are given an empty 2D binary grid grid of size m x n. The grid represents a map where 0's represent water and 1's represent land. Initially, all the cells of grid are water cells (i.e., all the cells are 0's).

We may perform an add land operation which turns the water at position into a land. You are given an array positions where positions[i] = [ri, ci] is the position (ri, ci) at which we should operate the ith operation.

Return an array of integers answer where answer[i] is the number of islands after turning the cell (ri, ci) into a land.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
Output: [1,1,2,3]
Explanation:
Initially, the 2d grid is filled with water.
- Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land. We have 1 island.
- Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land. We still have 1 island.
- Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land. We have 2 islands.
- Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land. We have 3 islands.

Example 2:

Input: m = 1, n = 1, positions = [[0,0]]
Output: [1]

Constraints:

    1 <= m, n, positions.length <= 104
    1 <= m * n <= 104
    positions[i].length == 2
    0 <= ri < m
    0 <= ci < n

 

Follow up: Could you solve it in time complexity O(k log(mn)), where k == positions.length?


*/

//TLE
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> resList = new ArrayList<>();
        int[][] grid = new int[m][n];
        for(int[] pos: positions){
            grid[pos[0]][pos[1]] = 1;
            int islands = findIslands(grid);
            resList.add(islands);
        }
        return resList;
    }

    private int findIslands(int[][] grid){
        int res = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1 && !vis[i][j]){
                    dfs(grid, i ,j, vis);
                    res++;
                }
            }
        }
        return res;
    }

        private void dfs(int[][] grid, int i, int j, boolean[][] vis) {
        if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1 && !vis[i][j]){
            vis[i][j] = true;
            dfs(grid, i + 1, j, vis);
            dfs(grid, i - 1, j, vis);
            dfs(grid, i, j + 1, vis);
            dfs(grid, i, j - 1, vis);
        }
    }
}
