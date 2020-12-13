/*

1245. Tree Diameter
Medium

Given an undirected tree, return its diameter: the number of edges in a longest path in that tree.

The tree is given as an array of edges where edges[i] = [u, v] is a bidirectional edge between nodes u and v.  Each node has labels in the set {0, 1, ..., edges.length}.

Example 1:

Input: edges = [[0,1],[0,2]]
Output: 2
Explanation: 
A longest path of the tree is the path 1 - 0 - 2.

Example 2:

Input: edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
Output: 4
Explanation: 
A longest path of the tree is the path 3 - 2 - 1 - 4 - 5.

Constraints:

    0 <= edges.length < 10^4
    edges[i][0] != edges[i][1]
    0 <= edges[i][j] <= edges.length
    The given edges form an undirected tree.

*/

class Solution {
    int max = 0;
    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> graph = getGraph(edges);
        int[] res = new int[]{0};
        dfs(graph, 0, res, new HashSet<Integer>());
        return res[0];
    }
    
    private int dfs(Map<Integer, List<Integer>> graph, int v, int[] res, Set<Integer> vis){
        int d1 = 0, d2 = 0;
        vis.add(v);
        for(int nextV : graph.get(v)){
            int dist = 0;
            if(vis.contains(nextV)) continue;
            dist = 1 + dfs(graph, nextV, res, vis);
            if(dist > d1){
                d2 = d1;
                d1 = dist;
            }
            else if(dist > d2)
                d2 = dist;
        }
        res[0] = Math.max(res[0], d1 + d2);
        return d1;
    }
    
    private Map<Integer, List<Integer>> getGraph(int[][] edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] e : edges){
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.putIfAbsent(e[1], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            max = Math.max(max, Math.max(e[0], e[1]));
        }
        return graph;
    }
}
