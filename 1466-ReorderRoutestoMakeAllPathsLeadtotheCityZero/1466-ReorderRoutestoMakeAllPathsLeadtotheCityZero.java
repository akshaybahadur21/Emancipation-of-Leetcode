/*

1466. Reorder Routes to Make All Paths Lead to the City Zero
Medium

There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.

Example 1:

Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 2:

Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 3:

Input: n = 3, connections = [[1,0],[2,0]]
Output: 0

Constraints:

    2 <= n <= 5 * 104
    connections.length == n - 1
    connections[i].length == 2
    0 <= ai, bi <= n - 1
    ai != bi

*/

class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = buildGraph(n, connections);
        Set<String> set = buildOrig(n, connections);
        boolean[] vis = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, -1});
        vis[0] = true;
        int res = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int[] temp = q.poll();
                int curr = temp[0];
                int parent = temp[1];
                if(curr != 0){
                    if(!set.contains(String.valueOf(curr) + "_" + String.valueOf(parent))) res++;
                }
                for(int child: graph.get(curr)){
                    if(!vis[child]) {
                        vis[child] = true;
                        q.add(new int[]{child, curr});
                    }
                }
                
            }
        }
        return res;
    }
    
    private Map<Integer, List<Integer>> buildGraph(int n, int[][] connections){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for(int c[] : connections){
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(c[0]);
        }
        return graph;
    }
    
    private Set<String> buildOrig(int n, int[][] connections){
        Set<String> set = new HashSet<>();
        for(int c[] : connections){
            set.add(String.valueOf(c[0]) + "_" + String.valueOf(c[1]));
        }
        return set;
    }
}
