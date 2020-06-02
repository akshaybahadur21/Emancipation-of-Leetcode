/*

934. Shortest Bridge
Medium

In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

Example 1:

Input: A = [[0,1],[1,0]]
Output: 1

Example 2:

Input: A = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2

Example 3:

Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1

Constraints:

    2 <= A.length == A[0].length <= 100
    A[i][j] == 0 or A[i][j] == 1

*/

class Solution {
    public int shortestBridge(int[][] A) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[A.length][A[0].length];
        boolean found = false;
        for(int i = 0; i < A.length && !found; i++){
            for(int j = 0; j < A[0].length && !found; j++){
                if(A[i][j] == 1){
                    dfs(vis, i, j, q, A);
					found = true;
                    }
            }
        }
        
        int depth = 0;
        int dirs[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int temp[] = q.poll();
                for(int[] dir : dirs){
                    int x = temp[0] + dir[0];
                    int y = temp[1] + dir[1];
                    if(x < 0 || x >= A.length || y < 0 || y >= A[0].length || vis[x][y]) continue;
                    if(A[x][y] == 1)
                        return depth;
                    vis[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
            depth++;
        }
        return depth;
    }
    private void dfs(boolean[][] visited, int i, int j, Queue<int[]> q, int[][] grid ) {
		if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j] || grid[i][j] == 0) return;
        int dirs[][] = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		visited[i][j] = true;
		q.add(new int[] { i, j });
		dfs(visited, i - 1, j, q, grid);
        dfs(visited, i + 1, j, q, grid);
        dfs(visited, i, j - 1, q, grid);
        dfs(visited, i, j + 1, q, grid);
	}
}
