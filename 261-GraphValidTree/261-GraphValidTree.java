/*

261. Graph Valid Tree
Medium

Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true

Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false

Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.

*/

class Solution {
    public boolean validTree(int n, int[][] edges) {
        // 2 pass
        // 1 - check cycle
        // 2 - check if all the nodes are connected
        if(n < 2 ) return true;
        if(edges == null || edges.length == 0) return false;
        Map<Integer, List<Integer>> graph = getGraph(n, edges);
        boolean[] vis = new boolean[n];
        if (dfs(vis, graph, 0, -1))
            return false;
        for (int i = 0; i < n; i++) 
            if (!vis[i]) return false;
        return true;
    }
    private boolean dfs(boolean[] vis, Map<Integer, List<Integer>> graph , int e, int parent){
        vis[e] = true;
        for(int n : graph.get(e)) 
            if ((vis[n] && parent != n) || (!vis[n] && dfs(vis, graph, n, e)))
                return true;
        return false;
    }
    private Map<Integer, List<Integer>> getGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }        
        return graph;
    }
}
