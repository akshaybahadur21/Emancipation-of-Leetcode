/*

286. Walls and Gates
Medium
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example: 

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4

*/

class Solution {
    // BFS
    public void wallsAndGates(int[][] rooms) {
        int row = rooms.length;
        if (row == 0) return;
        int col = rooms[0].length;
        Queue<Pair> q = new LinkedList<>();
        int emptyRooms = 0;
        for (int i =0; i<row; i++){
            for (int j = 0; j<col; j++){
                if (rooms[i][j] == 0)
                    q.add(new Pair(i,j));
            }
        }
        List<Pair> allDirs = new ArrayList<>();
        allDirs.add(new Pair(0,1));
        allDirs.add(new Pair(0,-1));
        allDirs.add(new Pair(1,0));
        allDirs.add(new Pair(-1,0));
        int steps = 0;
        while(!q.isEmpty()){
            steps++;
            int len = q.size();
            for (int i = 0; i< len; i++){
                Pair p = q.poll();
                for (Pair dir : allDirs){
                    int x = p.getI() + dir.getI();
                    int y = p.getJ() + dir.getJ();
                    if (x < 0 || y < 0 || x >= row || y >= col || rooms[x][y] != Integer.MAX_VALUE ) continue;
                    rooms[x][y] = steps;
                    q.add(new Pair(x,y));
                }
            }
        }
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
        return this.i;
    }
    public int getJ(){
        return this.j;
    }
}
