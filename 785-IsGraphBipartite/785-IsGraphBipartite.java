/*

785. Is Graph Bipartite?
Medium

Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split its set of nodes into two independent subsets A and B, such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists. Each node is an integer between 0 and graph.length - 1. There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:

Input: graph = [[1,3],[0,2],[1,3],[0,2]]
Output: true
Explanation: We can divide the vertices into two groups: {0, 2} and {1, 3}.

Example 2:

Input: graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
Output: false
Explanation: We cannot find a way to divide the set of nodes into two independent subsets.

Constraints:

    1 <= graph.length <= 100
    0 <= graph[i].length < 100
    0 <= graph[i][j] <= graph.length - 1
    graph[i][j] != i
    All the values of graph[i] are unique.
    The graph is guaranteed to be undirected. 

*/


class Solution {
    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0) return true;
        Map<Integer, List<Integer>> map = getMap(graph);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i < graph.length; i++){
            if(set1.contains(i) || set2.contains(i)) continue;
            set1.add(i);
            if(!dfs(map, i, set1, set2)) return false;
        }
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> map, int node, Set<Integer> set1, Set<Integer> set2){
        for(int n : map.get(node)){
            if(!set1.contains(n) && !set2.contains(n)){
                if(set1.contains(node)) set2.add(n);
                else set1.add(n);
                if(!dfs(map, n, set1, set2)) return false;
            }
            else{
                if(set1.contains(n) && set1.contains(node) || set2.contains(n) && set2.contains(node)) return false;
            }
        }
        return true;
        
    }
    
    private Map<Integer, List<Integer>> getMap(int[][] graph){
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < graph.length; i++) map.put(i, new ArrayList<Integer>());
        int count = 0;
        for(int[]g : graph) {
            List<Integer> list = new ArrayList<>();
            for(int i : g) list.add(i);
            map.get(count++).addAll(list);
        }
        return map;
    }
}
