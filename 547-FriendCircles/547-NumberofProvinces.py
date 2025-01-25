"""

547. Number of Provinces

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.

Example 1:

Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Example 2:

Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3

Constraints:

    1 <= n <= 200
    n == isConnected.length
    n == isConnected[i].length
    isConnected[i][j] is 1 or 0.
    isConnected[i][i] == 1
    isConnected[i][j] == isConnected[j][i]

"""

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        def get_graph():
            graph = defaultdict(list)
            for i, conn in enumerate(isConnected):
                for idx, c in enumerate(conn):
                    if c == 0: continue
                    else: graph[i].append(idx)
            return graph
            
        graph = get_graph()
        vis = [False] * len(graph)
        res = 0

        def dfs(node):
            if vis[node]: return
            vis[node] = True
            for child in graph[node]:
                dfs(child)

        for k in graph.keys():
            if vis[k]: continue
            res += 1
            dfs(k)
        return res
