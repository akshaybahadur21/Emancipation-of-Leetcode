"""

1971. Find if Path Exists in Graph

There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.

You want to determine if there is a valid path that exists from vertex source to vertex destination.

Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

Example 1:

Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
Output: true
Explanation: There are two paths from vertex 0 to vertex 2:
- 0 → 1 → 2
- 0 → 2

Example 2:

Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
Output: false
Explanation: There is no path from vertex 0 to vertex 5.

Constraints:

    1 <= n <= 2 * 105
    0 <= edges.length <= 2 * 105
    edges[i].length == 2
    0 <= ui, vi <= n - 1
    ui != vi
    0 <= source, destination <= n - 1
    There are no duplicate edges.
    There are no self edges.

"""

class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        def build_graph():
            graph = defaultdict(list)
            for e in edges:
                graph[e[0]].append(e[1])    
                graph[e[1]].append(e[0])  
            return graph  
        graph = build_graph()
        res = [False]
        vis = [False] * n
        def dfs(s, d):
            if s == d:
                res[0] = True
                return
            if vis[s]: return
            vis[s] = True
            for child in graph.get(s, []): dfs(child, d)
        dfs(source, destination)
        return res[0]
