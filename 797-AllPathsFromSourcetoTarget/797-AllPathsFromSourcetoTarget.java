/*

797. All Paths From Source to Target
Medium

Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

Note:

    The number of nodes in the graph will be in the range [2, 15].
    You can print different paths in any order, but you should keep the order of nodes inside one path.

*/

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> resList = new ArrayList<>();
        if(!validateInput(graph)) return resList;
        Map<Integer, int[]> map = getMapfromGrapth(graph);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(map, list, resList, 0, graph.length - 1);
        return resList;
    }

    private void dfs(Map<Integer, int[]> map, List<Integer> list, List<List<Integer>> resList, int curr, int N){
        if(curr == N){
            resList.add(new ArrayList<>(list));
            return;
        }
        for(int n : map.get(curr)){
            list.add(n);
            dfs(map, list, resList, n, N);
            list.remove(list.size() - 1);
        }
    }

    private  Map<Integer, int[]> getMapfromGrapth(int[][] graph) {
        Map<Integer, int[]> map = new HashMap<>();
        int count = 0;
        for(int[] g : graph){
                map.put(count++, g);
        }
        return map;
    }

    private boolean validateInput(int[][] graph) {
        if(graph == null || graph.length == 0) return false;
        return true;
    }
}
