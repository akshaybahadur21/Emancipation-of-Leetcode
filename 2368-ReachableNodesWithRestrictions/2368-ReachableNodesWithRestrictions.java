/*

2368. Reachable Nodes With Restrictions
Medium

There is an undirected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree. You are also given an integer array restricted which represents restricted nodes.

Return the maximum number of nodes you can reach from node 0 without visiting a restricted node.

Note that node 0 will not be a restricted node.

Example 1:

Input: n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
Output: 4
Explanation: The diagram above shows the tree.
We have that [0,1,2,3] are the only nodes that can be reached from node 0 without visiting a restricted node.

Example 2:

Input: n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
Output: 3
Explanation: The diagram above shows the tree.
We have that [0,5,6] are the only nodes that can be reached from node 0 without visiting a restricted node.

Constraints:

    2 <= n <= 105
    edges.length == n - 1
    edges[i].length == 2
    0 <= ai, bi < n
    ai != bi
    edges represents a valid tree.
    1 <= restricted.length < n
    1 <= restricted[i] < n
    All the values of restricted are unique.

*/

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Map<Integer, List<Integer>> graph = getGraph(n, edges);
        Set<Integer> set = new HashSet<>();
        for(int r : restricted) set.add(r);
        boolean[] vis = new boolean[n];
        int[] res = new int[]{0};
        dfs(graph, set, vis, 0, res);
        return res[0];
    }
    
    private void dfs(Map<Integer, List<Integer>> graph, Set<Integer> set, boolean[] vis, int curr, int[] res){
        if(!graph.containsKey(curr) || vis[curr] || set.contains(curr)) return;
        vis[curr] = true;
        res[0]++;
        for(int neighbor : graph.get(curr)){
            if(set.contains(neighbor) || vis[neighbor]) continue;
            dfs(graph, set, vis, neighbor, res);
        }
    }
    
    private Map<Integer, List<Integer>> getGraph(int n, int[][] edges){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) graph.putIfAbsent(i, new ArrayList<>());
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        return graph;
    }
}
