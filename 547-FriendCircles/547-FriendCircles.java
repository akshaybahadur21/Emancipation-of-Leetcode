/*

547. Friend Circles
Medium

There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.

Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.

Example 1:

Input: 
[[1,1,0],
 [1,1,0],
 [0,0,1]]
Output: 2
Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. 
The 2nd student himself is in a friend circle. So return 2.

Example 2:

Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.

Constraints:

    1 <= N <= 200
    M[i][i] == 1
    M[i][j] == M[j][i]

*/

class Solution {
    public int findCircleNum(int[][] M) {
        if(!validateInput(M)) return M.length;
        Map<Integer, List<Integer>> graph = getGraph(M);
        boolean[] vis = new boolean[M.length];
        int circle = 0;
        for(int i = 0; i < M.length; i++){
            if(!vis[i]) {
                circle++;
                dfs(graph, vis, i);
                }
        }
        return circle;
    }
    
    private void dfs(Map<Integer, List<Integer>> graph, boolean[] vis, int v){
        if(vis[v] || !graph.containsKey(v)) return;
        vis[v] = true;
        for(int u : graph.get(v)) dfs(graph, vis, u);
    }
    
    private Map<Integer, List<Integer>> getGraph(int[][] M){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < M.length; i++) graph.put(i, new ArrayList<>());
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                if(i == j) continue;
                if(M[i][j] == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        return graph;
    }
    private boolean validateInput(int[][] M){
        if(M == null || M.length == 0) return false;
        return true;
    }
}
