/*

994. Rotting Oranges
Easy

In a given grid, each cell can have one of three values:

    the value 0 representing an empty cell;
    the value 1 representing a fresh orange;
    the value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 
Example 1:

Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.

 

Note:

    1 <= grid.length <= 10
    1 <= grid[0].length <= 10
    grid[i][j] is only 0, 1, or 2.

*/

class Solution {
    public int orangesRotting(int[][] grid) {
    //Used a BFS approach
        if (grid == null || grid.length == 0)
            return 0;
        Queue<Pair> q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;
        for (int i = 0; i<row; i++){
            for (int j =0; j<col; j++){
                if (grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }
                else if (grid[i][j] == 1)
                    fresh++;
            }
            
        }
        if (fresh == 0)
            return 0;
        int days = 0;
        List<Pair> dirsList = new ArrayList<>();
        dirsList.add(new Pair(1,0)); //move right
        dirsList.add(new Pair(-1,0)); //move left
        dirsList.add(new Pair(0,1)); // move up
        dirsList.add(new Pair(0,-1)); //move down
        
        while(!q.isEmpty() && fresh>0){
            days++;
            int len = q.size();
            for (int i =0; i<len; i++){
                Pair p =q.poll();
                for(Pair dirPair : dirsList) {
                    int x = p.getI() + dirPair.getI();
                    int y = p.getJ() + dirPair.getJ();
                    if (x<0 || y<0 || x>=row || y>=col || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;
                    grid[x][y] = 2;
                    fresh--;
                    q.add(new Pair(x,y));
                    }
            }
        }
        return fresh == 0 ? days : -1;
    }
}
class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
    public int getI(){
        return i;
    }
    public int getJ(){
        return j;
    }
}
