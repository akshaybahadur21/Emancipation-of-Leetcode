/*

1197. Minimum Knight Moves
Medium

1160

346

Add to List

Share
In an infinite chess board with coordinates from -infinity to +infinity, you have a knight at square [0, 0].

A knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.


Return the minimum number of steps needed to move the knight to the square [x, y]. It is guaranteed the answer exists.

 

Example 1:

Input: x = 2, y = 1
Output: 1
Explanation: [0, 0] → [2, 1]
Example 2:

Input: x = 5, y = 5
Output: 4
Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
 

Constraints:

-300 <= x, y <= 300
0 <= |x| + |y| <= 300

*/

class Solution {
    public int minKnightMoves(int x, int y) {
        int[][] dirs = new int[][]{{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int res = 0;
        boolean[][] visited = new boolean[601][601];
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int[] curr = q.poll();
                if(curr[0] == x && curr[1] == y) return res;
                if (visited[curr[0] + 300][curr[1] + 300])
                    continue;
                visited[curr[0] + 300][curr[1] + 300] = true;
                for(int[] dir : dirs){
                    int x_n = curr[0] + dir[0];
                    int y_n = curr[1] + dir[1];
                    q.add(new int[]{x_n, y_n});
                }
            }
            res++;
        }
        return -1;
    }
}
