/*

323. Number of Connected Components in an Undirected Graph
Medium

Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:

Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

     0          3
     |          |
     1 --- 2    4 

Output: 2

Example 2:

Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]

     0           4
     |           |
     1 --- 2 --- 3

Output:  1

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

*/

class Solution {
    public int countComponents(int n, int[][] edges) {
        // create graph
    // start from one node and visit all the neighbours.
    // pickup the next node from unvisited
    if(!validateInput(n, edges)) return n;
    Map<Integer, List<Integer>> graph = getGraph(n, edges);
    boolean[] vis = new boolean[n];
    int res = 0;
    for(int i = 0; i < n; i++){
        if(!vis[i]) {
        dfs(graph, vis, i);
        res++;
        }
    }
    return res;
    }

    private void dfs(Map<Integer, List<Integer>> graph, boolean[] vis, int v){
        if(vis[v] || !graph.containsKey(v)) return;
        vis[v] = true;
        for(int u : graph.get(v)) dfs(graph, vis, u);
    }

    private Map<Integer, List<Integer>> getGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i  = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        return graph;
    }

private boolean validateInput(int n, int[][] edges) {
    if(edges == null || edges.length == 0 || n == 0) return false;
    return true;
    }
}
