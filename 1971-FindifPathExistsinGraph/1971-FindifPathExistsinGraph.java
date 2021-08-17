/*

1971. Find if Path Exists in Graph
Easy

There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex start to vertex end.

Given edges and the integers n, start, and end, return true if there is a valid path from start to end, or false otherwise.

Example 1:

Input: n = 3, edges = [[0,1],[1,2],[2,0]], start = 0, end = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2

Example 2:

Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], start = 0, end = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.

Constraints:

    1 <= n <= 2 * 105
    0 <= edges.length <= 2 * 105
    edges[i].length == 2
    1 <= ui, vi <= n - 1
    ui != vi
    1 <= start, end <= n - 1
    There are no duplicate edges.
    There are no self edges.

*/

class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(edges == null || edges.length == 0) return true;
        Map<Integer, List<Integer>> graph = getGraph(n, edges);
        boolean res[] = new boolean[]{false};
        dfs(start, end, graph, new boolean[n], res);
        return res[0];
    }
    
    private void dfs(int s, int e, Map<Integer, List<Integer>> graph, boolean[] vis, boolean res[]){
        if(vis[s] || !graph.containsKey(s)) return;
        vis[s] = true;
        for(int i : graph.get(s)){
            if(i == e) {
                res[0] = true;
                return;
            }
            dfs(i, e, graph, vis, res);
        }
    }
    
    private Map<Integer, List<Integer>> getGraph(int n, int[][] edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        return graph;
    }
}
