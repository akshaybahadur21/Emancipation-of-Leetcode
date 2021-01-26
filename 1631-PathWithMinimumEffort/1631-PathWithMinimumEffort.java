/*

1631. Path With Minimum Effort
Medium

You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.

Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

Example 1:

Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

Example 2:

Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].

Example 3:

Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.

Constraints:

    rows == heights.length
    columns == heights[i].length
    1 <= rows, columns <= 100
    1 <= heights[i][j] <= 106

*/

class Solution {
    public int minimumEffortPath(int[][] heights)
        {
            int rows = heights.length;
            int cols = heights[0].length;
            int[][] dp = new int[rows][cols];
            int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
            for (int[] row: dp)
            Arrays.fill(row, Integer.MAX_VALUE);
            dp[0][0] = 0;
            boolean relaxAtleastOneEdge = true;
            for (int e = 0; e < (rows * cols) - 1 && relaxAtleastOneEdge; e++){
                relaxAtleastOneEdge = false;
                for (int i = 0; i < rows; i++){
                    for (int j = 0; j < cols; j++){
                        for (int k = 0; k < 4; k++){
                             int newI = i+dir[k][0];
							 int newJ = j+dir[k][1];
							if(newI < 0 || newI >= rows || newJ < 0 || newJ >= cols || dp[i][j] >= dp[newI][newJ]) continue;
                            int absDiff = Math.abs(heights[newI][newJ] - heights[i][j]);
                            //Relax a node
                            if (dp[newI][newJ] > Math.max(dp[i][j], absDiff)){
                                dp[newI][newJ] = Math.max(dp[i][j], absDiff);
                                relaxAtleastOneEdge = true;
                            }
                        }
                    }
                }
            }
            return dp[rows - 1][cols - 1];
        }
}
