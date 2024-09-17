"""

261. Graph Valid Tree

You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.

Return true if the edges of the given graph make up a valid tree, and false otherwise.

Example 1:

Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
Output: true

Example 2:

Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
Output: false

Constraints:

    1 <= n <= 2000
    0 <= edges.length <= 5000
    edges[i].length == 2
    0 <= ai, bi < n
    ai != bi
    There are no self-loops or repeated edges.

"""

class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        def build_graph():
            graph = {}
            for i in range(n): graph[i]  = []
            for e in edges: 
                graph[e[0]].append(e[1])
                graph[e[1]].append(e[0])
            return graph
        graph = build_graph()
        def dfs(e, parent):
            vis[e] = True
            for n in graph.get(e):
                if (vis[n] and parent != n) or (not vis[n] and dfs(n, e)):
                    return True
            return False
        vis = [False] * n
        if dfs(0, -1): return False
        for v in vis: 
            if not v: return False
        return True
        return False
