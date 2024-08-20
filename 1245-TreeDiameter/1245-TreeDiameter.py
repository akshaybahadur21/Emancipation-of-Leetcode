"""

1245. Tree Diameter

The diameter of a tree is the number of edges in the longest path in that tree.

There is an undirected tree of n nodes labeled from 0 to n - 1. You are given a 2D array edges where edges.length == n - 1 and edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the tree.

Return the diameter of the tree.

Example 1:

Input: edges = [[0,1],[0,2]]
Output: 2
Explanation: The longest path of the tree is the path 1 - 0 - 2.

Example 2:

Input: edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
Output: 4
Explanation: The longest path of the tree is the path 3 - 2 - 1 - 4 - 5.

Constraints:

    n == edges.length + 1
    1 <= n <= 104
    0 <= ai, bi < n
    ai != bi

"""

class Solution:
    def treeDiameter(self, edges: List[List[int]]) -> int:
        def create_graph():
            graph = defaultdict(list)
            for u, v in edges:
                graph[u].append(v)
                graph[v].append(u)
            return graph
        def dfs(node):
            d1, d2 = 0, 0
            for c in graph[node]:
                if c not in vis:
                    vis.add(c)
                    depth = 1 + dfs(c)
                    if depth > d1:
                        d2 = d1
                        d1 = depth
                    elif depth > d2:
                        d2 = depth
            res[0] = max(res[0], d1 + d2)
            return d1
        res = [0]
        graph = create_graph()
        vis = set()
        vis.add(0)
        dfs(0)
        return res[0]
