/*

1791. Find Center of Star Graph

There is an undirected star graph consisting of n nodes labeled from 1 to n. A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.

You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi. Return the center of the given star graph.

Example 1:

Input: edges = [[1,2],[2,3],[4,2]]
Output: 2
Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.

Example 2:

Input: edges = [[1,2],[5,1],[1,3],[1,4]]
Output: 1

 

Constraints:

    3 <= n <= 105
    edges.length == n - 1
    edges[i].length == 2
    1 <= ui, vi <= n
    ui != vi
    The given edges represent a valid star graph.

*/

class Solution {
    public int findCenter(int[][] edges) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> graph = buildGraph(edges, set);
        for(int key : graph.keySet()){
            if(graph.get(key).size() == set.size() - 1) return key;
        }
        return -1;
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges, Set<Integer> set){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] e : edges){
            set.add(e[0]);
            set.add(e[1]);

            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.putIfAbsent(e[1], new ArrayList<>());

            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        return graph;
    }
}
